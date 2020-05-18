package com.example.testmovieapp.ui.detail

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.testmovieapp.ui.adapter.SimilarMoviesAdapter
import com.bumptech.glide.Glide
import com.example.testmovieapp.databinding.ActivityDetailBinding
import com.example.testmovieapp.App
import com.example.testmovieapp.R
import com.example.testmovieapp.di.component.DaggerApplicationComponent
import com.example.testmovieapp.ui.home.HomeActivity
import com.example.testmovieapp.util.api_key
import com.example.testmovieapp.util.image_path
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_detail.*
import javax.inject.Inject


@Suppress("NULLABILITY_MISMATCH_BASED_ON_JAVA_ANNOTATIONS")
class DetailActivity : AppCompatActivity() {
    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    private lateinit var binding: ActivityDetailBinding
    private val similarAdapter by lazy { SimilarMoviesAdapter() }

    /**
     * to perform the initialization of activity
     */
    @SuppressLint("CheckResult", "SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        DaggerApplicationComponent.factory().create(this.application as App).inject(this)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_detail)
        val viewModel = ViewModelProvider(this, viewModelFactory).get(DetailViewModel::class.java)
        val movieId = intent.getStringExtra("id")
        val poster = intent.getStringExtra("poster")
        val release_date = intent.getStringExtra("release_date")
        val overview = intent.getStringExtra("overview")
        viewModel.similarMovies(movieId)

        viewModel.similarMovie.observe(this, Observer { movies ->
            similar_recycler.apply {
                setHasFixedSize(true)
                layoutManager = LinearLayoutManager(
                    this@DetailActivity,
                    LinearLayoutManager.HORIZONTAL,
                    false
                )
                if (movies.isEmpty()) {
                    binding.textS.visibility = View.GONE
                }
                similarAdapter.addItems(movies)
                adapter = similarAdapter
            }
        })
        Glide.with(this@DetailActivity)
            .load("$image_path${poster}")
            .into(poster_image)
        text_release_date.text = "Release Date: $release_date"
        text_overview.text = "Overview\n$overview"
    }

    /**
     * to handle the back pressed
     */
    override fun onBackPressed() {
        super.onBackPressed()
        val intent = Intent(this, HomeActivity::class.java)
        intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK
        startActivity(intent)
    }
}
