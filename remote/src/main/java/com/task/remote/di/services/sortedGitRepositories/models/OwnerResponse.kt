package com.task.remote.di.services.sortedGitRepositories.models

import com.task.domain.domain_module.sortedGitRepositories.models.Owner

data class OwnerResponse(
    val avatarUrl: String,
    val eventsUrl: String,
    val followersUrl: String,
    val followingUrl: String,
    val gistsUrl: String,
    val gravatarId: String,
    val htmlUrl: String,
    val id: Int,
    val login: String,
    val nodeId: String,
    val organizationsUrl: String,
    val receivedEventsUrl: String,
    val reposUrl: String,
    val siteAdmin: Boolean,
    val starredUrl: String,
    val subscriptionsUrl: String,
    val type: String,
    val url: String
) {
    fun toDomain() = Owner(
        avatarUrl,
        eventsUrl,
        followersUrl,
        followingUrl,
        gistsUrl,
        gravatarId,
        htmlUrl,
        id,
        login,
        nodeId,
        organizationsUrl,
        receivedEventsUrl,
        reposUrl,
        siteAdmin,
        starredUrl,
        subscriptionsUrl,
        type,
        url
    )
}