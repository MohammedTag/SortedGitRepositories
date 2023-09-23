package com.task.task.ui_module.sortedGithubRepositries.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.task.task.databinding.ItemLayoutBinding
import com.task.task.presentation_module.sortedGithubRepositories.models.GithubRepoUi


class SortedRepositoriesListingAdapter : ListAdapter<GithubRepoUi, RepositoryItemViewHolder>(
    MoviesListingDiffCallback()
) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RepositoryItemViewHolder {
        val binding = ItemLayoutBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return RepositoryItemViewHolder(binding)
    }

    override fun onBindViewHolder(holder: RepositoryItemViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
    class MoviesListingDiffCallback : DiffUtil.ItemCallback<GithubRepoUi>() {
        override fun areItemsTheSame(oldItem: GithubRepoUi, newItem: GithubRepoUi): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: GithubRepoUi, newItem: GithubRepoUi): Boolean {
            return oldItem.id == newItem.id
        }

    }

    interface Action{
        fun onItemClicked(id:Int)
    }
}