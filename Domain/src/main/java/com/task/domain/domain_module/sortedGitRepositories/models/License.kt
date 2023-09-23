package com.task.domain.domain_module.sortedGitRepositories.models

data class License(
    val key: String,
    val name: String,
    val nodeId: String,
    val spdxId: String,
    val url: String?
)