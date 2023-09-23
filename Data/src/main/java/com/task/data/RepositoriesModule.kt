package com.task.data

import com.task.data.sortedGitRepositories.SortedGithubReposDatasource
import com.task.domain.domain_module.sortedGitRepositories.repository.SortedGithubReposRepository
import com.task.remote.di.retrofit.service.ServicesModule
import com.task.remote.di.services.sortedGitRepositories.GithubReposService
import dagger.Module
import dagger.Provides
import javax.inject.Singleton


@Module(
    includes = [
        ServicesModule::class
    ]
)
class RepositoriesModule {

    @Provides
    @Singleton
    fun providesSortedGitReposRepository(
        service: GithubReposService
    ): SortedGithubReposRepository =
        SortedGithubReposDatasource(
            service
        )
}