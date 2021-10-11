package com.raywenderlich.android.uspace.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.raywenderlich.android.uspace.R
import com.raywenderlich.android.uspace.databinding.FragmentRocketsBinding
import com.raywenderlich.android.uspace.repository.SpaceResult
import com.raywenderlich.android.uspace.ui.adapters.RocketsAdapter
import com.raywenderlich.android.uspace.ui.viewmodels.RocketsViewModel
import com.raywenderlich.android.uspace.utils.showSnackbar
import dagger.android.support.AndroidSupportInjection
import javax.inject.Inject


class RocketsFragment : Fragment() {

  companion object {
    fun createInstance() = RocketsFragment()
  }

  @Inject
  lateinit var viewModelFactory: ViewModelProvider.Factory
  @Inject
  lateinit var adapter: RocketsAdapter
  private val viewModel: RocketsViewModel by viewModels { viewModelFactory }
  private var binding: FragmentRocketsBinding? = null

  override fun onCreate(savedInstanceState: Bundle?) {
    AndroidSupportInjection.inject(this)
    super.onCreate(savedInstanceState)
  }

  override fun onCreateView(
      inflater: LayoutInflater, container: ViewGroup?,
      savedInstanceState: Bundle?
  ): View? {
    binding = FragmentRocketsBinding.inflate(inflater)
    return binding?.root
  }

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)

    binding?.apply {
      rocketsList.layoutManager = LinearLayoutManager(requireContext())
      rocketsList.adapter = adapter
      rocketsList.addItemDecoration(DividerItemDecoration(requireContext(), DividerItemDecoration.VERTICAL))
    }

    viewModel.rockets.observe(viewLifecycleOwner) { result ->
      when (result) {
        SpaceResult.Error -> binding?.root.showSnackbar(R.string.error_loading_data, R.string.try_again) {
          viewModel.getRockets()
        }
        is SpaceResult.RocketResult -> {
          adapter.addItems(result.rockets)
        }
      }
    }
    viewModel.getRockets()
  }

  override fun onDestroyView() {
    super.onDestroyView()
    binding = null
  }
}