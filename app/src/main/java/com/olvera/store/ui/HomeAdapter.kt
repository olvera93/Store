package com.olvera.store.ui

import com.olvera.store.model.Store
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.olvera.store.databinding.ItemStoreBinding

class HomeAdapter(private val viewModel: HomeViewModel) :
        ListAdapter<Store, HomeAdapter.ViewHolder>(StoreDiffCallback()) {


    class ViewHolder private constructor(val binding: ItemStoreBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(viewModel: HomeViewModel, item: Store) {

            binding.viewModel = viewModel
            binding.store = item
            binding.executePendingBindings()
        }

        companion object {
            fun from(parent: ViewGroup): ViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = ItemStoreBinding.inflate(layoutInflater, parent, false)
                return ViewHolder(binding)
            }

        }

        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = getItem(position)
        holder.bind(viewModel, item)
    }
}


class StoreDiffCallback : DiffUtil.ItemCallback<Store>() {
    override fun areItemsTheSame(oldItem: Store, newItem: Store): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Store, newItem: Store): Boolean {
        return oldItem == newItem
    }

}