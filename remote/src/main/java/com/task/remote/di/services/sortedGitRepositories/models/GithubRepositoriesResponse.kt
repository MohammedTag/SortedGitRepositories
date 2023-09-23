package com.task.remote.di.services.sortedGitRepositories.models

import com.task.domain.domain_module.sortedGitRepositories.models.GithubRepositoriesDomain


data class GithubRepositoriesResponse(
    val incompleteResults: Boolean,
    val items: List<ItemResponse>,
    val totalCount: Int
) {

    fun toDomain(): GithubRepositoriesDomain = GithubRepositoriesDomain(
        incompleteResults,
        items.map { item -> item.toDomain() },
        totalCount
    )
}