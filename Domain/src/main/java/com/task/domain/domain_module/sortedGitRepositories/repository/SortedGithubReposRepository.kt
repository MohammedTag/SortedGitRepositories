package com.task.domain.domain_module.sortedGitRepositories.repository

import com.task.domain.domain_module.sortedGitRepositories.models.GithubRepositoriesDomain
import io.reactivex.Single

/**
 * Created by Mohammed Taguldeen on 23/09/2023.
 */
interface SortedGithubReposRepository {

    fun getGithubRepositories():Single<GithubRepositoriesDomain>
}