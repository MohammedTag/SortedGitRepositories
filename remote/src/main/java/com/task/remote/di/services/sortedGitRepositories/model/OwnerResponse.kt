package com.task.remote.di.services.sortedGitRepositories.model

import com.task.domain.domain_module.sortedGitRepositories.models.Owner

data class OwnerResponse(
    val avatar_url: String,
    val events_url: String,
    val followers_url: String,
    val following_url: String,
    val gists_url: String,
    val gravatar_id: String,
    val html_url: String,
    val id: Int,
    val login: String,
    val node_id: String,
    val organizations_url: String,
    val received_events_url: String,
    val repos_url: String,
    val site_admin: Boolean,
    val starred_url: String,
    val subscriptions_url: String,
    val type: String,
    val url: String
) {
    fun toDomain() = Owner(
        avatarUrl = avatar_url,
        eventsUrl = events_url,
        followersUrl = followers_url,
        followingUrl = following_url,
        gistsUrl = gists_url,
        gravatarId = gravatar_id,
        htmlUrl = html_url,
        id = id,
        login = login,
        nodeId = node_id,
        organizationsUrl = organizations_url,
        receivedEventsUrl = received_events_url,
        reposUrl = repos_url,
        siteAdmin = site_admin,
        starredUrl = starred_url,
        subscriptionsUrl = subscriptions_url,
        type = type,
        url = url
    )
}