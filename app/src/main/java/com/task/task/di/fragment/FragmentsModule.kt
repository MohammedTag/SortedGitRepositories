package com.task.task.di.fragment

import com.task.task.di.scope.FragmentScope
import com.task.task.ui_module.sortedGithubRepositries.SortedGithubReposListingFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class FragmentsModule{
    @FragmentScope
    @ContributesAndroidInjector
    abstract  fun contributeReposListingFragment(): SortedGithubReposListingFragment
}