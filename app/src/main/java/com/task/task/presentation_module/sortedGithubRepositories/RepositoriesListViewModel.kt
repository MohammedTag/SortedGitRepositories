package com.task.task.presentation_module.sortedGithubRepositories

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.task.domain.domain_module.sortedGitRepositories.useCase.GetSortedReposUseCase
import com.task.task.presentation_module.BaseViewModel
import com.task.task.presentation_module.sortedGithubRepositories.events.RepositoriesListEvents
import com.task.task.presentation_module.sortedGithubRepositories.mappers.GithubRepositoriesUiMapper
import javax.inject.Inject

/**
 * Created by Mohammed Taguldeen on 13/07/2023.
 */
class RepositoriesListViewModel @Inject constructor(
    private val getSortedReposUseCase: GetSortedReposUseCase,
    private val mapper: GithubRepositoriesUiMapper
) : BaseViewModel() {

    private val _sortedRepositories = MutableLiveData<RepositoriesListEvents>()
    val sortedRepositories: LiveData<RepositoriesListEvents>
        get() = _sortedRepositories

    fun getSortedRepos() {
        executeSingle(useCase = getSortedReposUseCase.run(null),
            successConsumer = { data ->
                _sortedRepositories.value = RepositoriesListEvents.retrievedMoviesListSuccessfully(
                    mapper.fromListOfRepositoriesDomainToListOfRepositoriesUiModel(data.items)
                )
            },
            loadingConsumer = {
                _sortedRepositories.value = RepositoriesListEvents.loading()
            },
            throwableConsumer = { error ->
                _sortedRepositories.value = RepositoriesListEvents.error(error)
            }
        )
    }
}