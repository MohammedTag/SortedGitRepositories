package com.task.domain.domain_module.sortedGitRepositories.useCase

import com.task.domain.domain_module.abstract_usecases.SingleUseCase
import com.task.domain.domain_module.qualifires.Background
import com.task.domain.domain_module.qualifires.Foreground
import com.task.domain.domain_module.sortedGitRepositories.models.GithubRepositoriesDomain
import com.task.domain.domain_module.sortedGitRepositories.repository.SortedGithubReposRepository
import io.reactivex.Scheduler
import io.reactivex.Single
import javax.inject.Inject

/**
 * Created by Mohammed Taguldeen on 23/09/2023.
 */
class GetSortedReposUseCase @Inject constructor(
    private val repo: SortedGithubReposRepository,
    @Background private val backgroundScheduler: Scheduler,
    @Foreground private val foregroundScheduler: Scheduler
) : SingleUseCase<GithubRepositoriesDomain, Unit>(
    backgroundScheduler,
    foregroundScheduler
) {
    override fun createSingle(input: Unit?): Single<GithubRepositoriesDomain> =
        repo.getGithubRepositories()

}