package com.example.perfumeryscores.ui.histories

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.lifecycle.LifecycleOwner
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.perfumeryscores.databinding.FragmentHistoryBinding
import com.example.perfumeryscores.db.HistoryWithScores

class HistoryRecyclerViewAdapter(
    private val viewModel: HistoriesViewModel,
    private val viewLifecycleOwner: LifecycleOwner
) : ListAdapter<HistoryWithScores, HistoryRecyclerViewAdapter.ViewHolder>(DiffCallback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = FragmentHistoryBinding.inflate(LayoutInflater.from(parent.context))
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position), viewLifecycleOwner, viewModel)
    }

    override fun getItemCount(): Int = viewModel.histories.value?.size ?: 0

    class ViewHolder(private val binding: FragmentHistoryBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(
            item: HistoryWithScores,
            viewLifecycleOwner: LifecycleOwner,
            viewModel: HistoriesViewModel
        ) {
            binding.run {
                lifecycleOwner = viewLifecycleOwner
                history = item
                vm = viewModel
                executePendingBindings()
            }
        }
    }
}

object DiffCallback : DiffUtil.ItemCallback<HistoryWithScores>() {
    override fun areItemsTheSame(oldItem: HistoryWithScores, newItem: HistoryWithScores): Boolean {
        return oldItem.history.id == newItem.history.id
    }

    override fun areContentsTheSame(
        oldItem: HistoryWithScores,
        newItem: HistoryWithScores
    ): Boolean {
        return oldItem == newItem
    }
}