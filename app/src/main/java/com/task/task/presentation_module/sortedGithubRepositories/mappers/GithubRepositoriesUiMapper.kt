package com.task.task.presentation_module.sortedGithubRepositories.mappers

import com.task.domain.domain_module.sortedGitRepositories.models.Item
import com.task.task.presentation_module.sortedGithubRepositories.models.GithubRepoUi

object GithubRepositoriesUiMapper {
    fun fromRepositoriesDomainItemToItemUiModel(item: Item): GithubRepoUi {
        return GithubRepoUi(
            item.id,
            item.fullName,
            item.owner.avatarUrl,
            item.name,
            item.description,
            item.language,
            item.stargazersCount
        )
    }

    fun fromListOfRepositoriesDomainToListOfRepositoriesUiModel(domainList: List<Item>): List<GithubRepoUi> =
        domainList.map { domainItem-> fromRepositoriesDomainItemToItemUiModel(domainItem) }
}