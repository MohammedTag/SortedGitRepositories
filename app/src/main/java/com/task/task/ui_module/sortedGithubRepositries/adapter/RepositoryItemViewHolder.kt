package com.task.task.ui_module.sortedGithubRepositries.adapter

import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.task.task.databinding.ItemLayoutBinding
import com.task.task.presentation_module.sortedGithubRepositories.models.GithubRepoUi
import com.task.task.ui_module.utils.toggleVisibility

class RepositoryItemViewHolder(private val binding: ItemLayoutBinding) :
    RecyclerView.ViewHolder(binding.root) {

    fun bind(item: GithubRepoUi) {
        itemView.apply {
            with(item) {
                binding.avatarIv.load(avatar)
                binding.repoOwnerNameTv.text = userName
                binding.repoNameTv.text = repositoryName
                binding.repoDescTv.text = repoDesc
                binding.starsCountTv.text = stars.toString()
                binding.repoLanguageTv.text = language
                setOnClickListener {
                    binding.starsCountTv.toggleVisibility()
                    binding.repoDescTv.toggleVisibility()
                    binding.repoLanguageTv.toggleVisibility()
                }

            }
        }
    }
}