package com.task.remote.di.services.sortedGitRepositories.model

import com.task.domain.domain_module.sortedGitRepositories.models.GithubRepositoriesDomain

data class GithubRepositoriesResponse(
    val incomplete_results: Boolean,
    val items: List<ItemResponse>,
    val total_count: Int
) {

    fun toDomain(): GithubRepositoriesDomain = GithubRepositoriesDomain(
        incomplete_results,
        items.map { item -> item.toDomain() },
        total_count
    )
}