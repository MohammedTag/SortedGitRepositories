package com.task.remote.di.services.sortedGitRepositories

import com.task.remote.di.EndPoints
import com.task.remote.di.services.sortedGitRepositories.models.GithubRepositoriesResponse
import io.reactivex.Single
import retrofit2.http.GET


interface GithubReposService {
    @GET(EndPoints.sortedReposEndpoint)
    fun getSortedRepositories():Single<GithubRepositoriesResponse>
}