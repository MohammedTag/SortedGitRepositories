package com.task.remote.di.services.sortedGitRepositories.models

import com.task.domain.domain_module.sortedGitRepositories.models.License

data class LicenseResponse(
    val key: String,
    val name: String,
    val nodeId: String,
    val spdxId: String,
    val url: String
){
    fun toDomain()=License(key, name, nodeId, spdxId, url)
}