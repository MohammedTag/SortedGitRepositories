package com.task.remote.di.services.sortedGitRepositories.model

import com.task.domain.domain_module.sortedGitRepositories.models.License

data class LicenseResponse(
    val key: String,
    val name: String,
    val node_id: String,
    val spdx_id: String,
    val url: String?
){
    fun toDomain()= License(
        key = key,
        name = name,
        nodeId = node_id,
        spdxId = spdx_id,
        url = url?:""
    )
}