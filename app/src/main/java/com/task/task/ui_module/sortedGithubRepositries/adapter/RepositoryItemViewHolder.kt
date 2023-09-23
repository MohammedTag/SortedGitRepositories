package com.task.task.ui_module.sortedGithubRepositries.adapter

import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.task.task.databinding.ItemLayoutBinding
import com.task.task.presentation_module.sortedGithubRepositories.models.GithubRepoUi

class RepositoryItemViewHolder(private val binding: ItemLayoutBinding) : RecyclerView.ViewHolder(binding.root) {

    fun bind(item: GithubRepoUi) {
        itemView.apply {
            with(item) {
                setOnClickListener {
                }
                binding.flagIv.load(avatar)
                binding.countryNameTv.text = repositoryName
            }
        }
    }
}