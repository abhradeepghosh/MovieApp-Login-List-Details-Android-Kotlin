package com.example.testmovieapp.ui.home

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.testmovieapp.App
import com.example.testmovieapp.R
import com.example.testmovieapp.databinding.ActivityHomeBinding
import com.example.testmovieapp.di.component.DaggerApplicationComponent
import com.example.testmovieapp.ui.adapter.HomeRecylerAdapter
import com.example.testmovieapp.ui.detail.DetailActivity
import com.example.testmovieapp.util.hide
import com.example.testmovieapp.util.show
import com.example.testmovieapp.util.snackbar
import javax.inject.Inject

class HomeActivity : AppCompatActivity(), MovieListener {
    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    private lateinit var binding: ActivityHomeBinding
    private val homeAdapter by lazy {
        HomeRecylerAdapter()
    }

    /**
     * Perform the initialization of activity
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        DaggerApplicationComponent.factory().create(this.application as App).inject(this)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_home)
        val viewModel = ViewModelProvider(this, viewModelFactory).get(HomeViewModel::class.java)
        binding.viewModel = viewModel
        viewModel.getMovie()
        viewModel.movies.observe(this, Observer { movies ->
            binding.movieRecyclerView.apply {
                setHasFixedSize(true)
                layoutManager =
                    LinearLayoutManager(this@HomeActivity)
                adapter = homeAdapter
                homeAdapter.addItems(movies)
                homeAdapter.listener = { _, item, _ ->
                    val id = item.id.toString()
                    val intent = Intent(context, DetailActivity::class.java)
                    intent.putExtra("id", id)
                    intent.putExtra("poster", item.poster_path)
                    intent.putExtra("release_date", item.release_date)
                    intent.putExtra("language", item.original_language)
                    intent.putExtra("overview", item.overview)
                    intent.putExtra("title", item.title)
                    context.startActivity(intent)
                }
            }
        })
    }

    /**
     * Initiates the showing of progress bar
     */
    override fun onFetchStarted() {
        binding.progressBar.show()
    }

    /**
     * Hides the progress bar
     */
    override fun onFetchFinished() {
        binding.progressBar.visibility = View.GONE
        binding.progressBar.hide()
    }

    /**
     * handles the failure
     */
    override fun onFailure(message: String) {
        binding.progressBar.hide()
        binding.root.snackbar(message)
    }
}