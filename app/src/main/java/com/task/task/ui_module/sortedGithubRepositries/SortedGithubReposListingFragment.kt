package com.task.task.ui_module.sortedGithubRepositries

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.View.GONE
import android.view.View.VISIBLE
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import com.google.android.material.snackbar.Snackbar
import com.task.task.R
import com.task.task.databinding.FragmentReposListingBinding
import com.task.task.presentation_module.sortedGithubRepositories.RepositoriesListViewModel
import com.task.task.presentation_module.sortedGithubRepositories.events.RepositoriesListEvents
import com.task.task.ui_module.sortedGithubRepositries.adapter.SortedRepositoriesListingAdapter
import dagger.android.support.DaggerFragment
import javax.inject.Inject

class SortedGithubReposListingFragment :
    DaggerFragment()/*, sortedRepositoriesListingAdapter.Action*/ {


    @Inject
    lateinit var factory: ViewModelProvider.Factory
    private val viewModel: RepositoriesListViewModel by viewModels { factory }

    private val adapter = SortedRepositoriesListingAdapter()

    private var _binding: FragmentReposListingBinding? = null
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentReposListingBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun bindViews() {
        with(binding) {
            reposListingRv.adapter = adapter
        }
    }


    private fun hideLoading() {
        with(binding) {
            shimmerLayout.apply {
                isVisible = false
                showShimmer(false)
                stopShimmer()
            }
        }
    }

    private fun showLoading() {
        with(binding) {
            shimmerLayout.apply {
                isVisible = true
                showShimmer(true)
                startShimmer()
            }
        }
    }

    private fun pullData() {
        with(viewModel) {
            getSortedRepos()
            sortedRepositories.observe(viewLifecycleOwner) { event ->
                when (event) {
                    is RepositoriesListEvents.ErrorState -> {
                        hideLoading()
                        Snackbar.make(
                            binding.paretCl,
                            "${getString(R.string.something_went_wrong)}${event.err}",
                            Snackbar.LENGTH_SHORT
                        ).show()
                    }

                    is RepositoriesListEvents.LoadingState -> {
                        showLoading()
                    }

                    is RepositoriesListEvents.RetrievedMoviesListSuccessfully -> {
                        hideLoading()
                        with(event.list) {
                            if (isEmpty()) {
                                binding.emptyStateView.visibility = VISIBLE
                            } else {
                                binding.reposListingRv.isVisible = true
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
}