package com.task.data.sortedGitRepositories


import com.task.domain.domain_module.sortedGitRepositories.models.GithubRepositoriesDomain
import com.task.domain.domain_module.sortedGitRepositories.repository.SortedGithubReposRepository
import com.task.remote.di.services.sortedGitRepositories.GithubReposService
import io.reactivex.Single
import javax.inject.Inject

/**
 * Created by Mohammed Taguldeen on 23/09/2023.
 */
class SortedGithubReposDatasource @Inject constructor(private val service: GithubReposService) :
    SortedGithubReposRepository {
    override fun getGithubRepositories(): Single<GithubRepositoriesDomain> =
        service.getSortedRepositories().map { response -> response.toDomain() }
}