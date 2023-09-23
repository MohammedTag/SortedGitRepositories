package com.task.domain.domain_module.sortedGitRepositories.models

data class GithubRepositoriesDomain(
    val incompleteResults: Boolean,
    val items: List<Item>,
    val totalCount: Int
)