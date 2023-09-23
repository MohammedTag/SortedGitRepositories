package com.task.task.presentation_module.sortedGithubRepositories.models

data class GithubRepoUi(
    val id:Int,
    val userName: String,
    val avatar: String,
    val repositoryName: String,
    val repoDesc: String,
    val language: String,
    val stars: Int
)
