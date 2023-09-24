package com.task.task.presentation_module.sortedGithubRepositories.events

import com.task.task.presentation_module.sortedGithubRepositories.models.GithubRepoUi


/**
 * Created by Mohammed Taguldeen on 13/07/2023.
 */
sealed class RepositoriesListEvents {
    object LoadingState : RepositoriesListEvents()

    class ErrorState(val err: Throwable) : RepositoriesListEvents()

    class RetrievedSortedReposListSuccessfully(val list: List<GithubRepoUi>) : RepositoriesListEvents()

    companion object {

        fun loading(): RepositoriesListEvents = LoadingState

        fun error(err: Throwable): RepositoriesListEvents =
            ErrorState(err)

        fun retrievedSortedReposListSuccessfully(list: List<GithubRepoUi>): RepositoriesListEvents =
            RetrievedSortedReposListSuccessfully(list)

    }
}