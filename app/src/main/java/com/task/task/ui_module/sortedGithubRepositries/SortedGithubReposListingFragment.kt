package com.task.task.ui_module.sortedGithubRepositries

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.View.GONE
import android.view.View.VISIBLE
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.google.android.material.snackbar.Snackbar
import com.task.task.R
import com.task.task.databinding.FragmentMoviesListingBinding
import com.task.task.presentation_module.sortedGithubRepositories.RepositoriesListViewModel
import com.task.task.presentation_module.sortedGithubRepositories.events.RepositoriesListEvents
import com.task.task.ui_module.sortedGithubRepositries.adapter.SortedRepositoriesListingAdapter
import dagger.android.support.DaggerFragment
import javax.inject.Inject

class SortedGithubReposListingFragment : DaggerFragment()/*, sortedRepositoriesListingAdapter.Action*/ {


    @Inject
    lateinit var factory: ViewModelProvider.Factory
    private val viewModel: RepositoriesListViewModel by viewModels { factory }

    private val adapter = SortedRepositoriesListingAdapter()

    private lateinit var binding: FragmentMoviesListingBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentMoviesListingBinding.inflate(layoutInflater)
        return binding.root
    }

    private fun bindViews() {
        binding.localeSimsRv.adapter = adapter
    }

    private fun pullData() {
        with(viewModel) {
            getSortedRepos()
            sortedRepositories.observe(viewLifecycleOwner) { event ->
                when (event) {
                    is RepositoriesListEvents.ErrorState -> {
                        Snackbar.make(
                            binding.paretCl,
                            "${getString(R.string.something_went_wrong)}${event.err}",
                            Snackbar.LENGTH_SHORT
                        ).show()
                    }

                    is RepositoriesListEvents.LoadingState -> {
                        binding.progressBar.visibility = VISIBLE
                    }

                    is RepositoriesListEvents.RetrievedMoviesListSuccessfully -> {
                        binding.progressBar.visibility = GONE
                        with(event.list) {
                            if (isEmpty()) {
                                binding.emptyStateView.visibility = VISIBLE
                            } else {
                                adapter.submitList(event.list)
                                binding.emptyStateView.visibility = GONE
                            }
                        }
                    }
                }
            }
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        bindViews()
        pullData()
    }
//
//    override fun onItemClicked(id: Int) {
//        findNavController().navigate(
//            MoviesListingFragmentDirections.actionLocaleSimsListingFragmentToCountriesPackagesListingFragment(
//                id
//            )
//        )
//    }
}