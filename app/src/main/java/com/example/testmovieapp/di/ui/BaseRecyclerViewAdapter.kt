package com.example.testmovieapp.di.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView

abstract class BaseRecyclerViewAdapter<T : Any, VB : ViewDataBinding>
    : RecyclerView.Adapter<BaseRecyclerViewAdapter.Companion.BaseViewHolder<VB>>() {
    var items = mutableListOf<T>()

    /**
     * to add the items
     */
    fun addItems(items: List<T>) {
        this.items = items as MutableList<T>
        notifyDataSetChanged()
    }

    /**
     * to get the layout
     */
    abstract fun getLayout(): Int

    /**
     * to get the item count
     */
    override fun getItemCount(): Int {
        return items.size
    }

    /**
     * to handle the creation of the view holder
     */
    var listener: ((view: View, item: T, position: Int) -> Unit)? = null
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<VB> {
        return BaseViewHolder<VB>(
            DataBindingUtil.inflate(
                LayoutInflater.from(parent.context),
                getLayout(),
                parent,
                false
            )
        )
    }

    companion object {
        class BaseViewHolder<VB : ViewDataBinding>(val binding: VB) :
            RecyclerView.ViewHolder(binding.root)
    }
}