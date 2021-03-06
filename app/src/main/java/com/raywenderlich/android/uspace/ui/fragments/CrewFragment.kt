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
import com.raywenderlich.android.uspace.databinding.FragmentCrewBinding
import com.raywenderlich.android.uspace.repository.SpaceResult
import com.raywenderlich.android.uspace.ui.adapters.CrewAdapter
import com.raywenderlich.android.uspace.ui.viewmodels.CrewViewModel
import com.raywenderlich.android.uspace.utils.showSnackbar
import dagger.android.support.AndroidSupportInjection
import javax.inject.Inject

class CrewFragment : Fragment() {

  companion object {
    fun createInstance() = CrewFragment()
  }

  @Inject
  lateinit var viewModelFactory: ViewModelProvider.Factory

  @Inject
  lateinit var adapter: CrewAdapter
  private val viewModel: CrewViewModel by viewModels { viewModelFactory }
  private var binding: FragmentCrewBinding? = null

  override fun onCreate(savedInstanceState: Bundle?) {
    AndroidSupportInjection.inject(this)
    super.onCreate(savedInstanceState)
  }

  override fun onCreateView(
      inflater: LayoutInflater, container: ViewGroup?,
      savedInstanceState: Bundle?
  ): View? {
    binding = FragmentCrewBinding.inflate(inflater)
    return binding?.root
  }

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)

    binding?.apply {
      crewList.layoutManager = LinearLayoutManager(requireContext())
      crewList.adapter = adapter
      crewList.addItemDecoration(DividerItemDecoration(requireContext(), DividerItemDecoration.VERTICAL))
    }

    binding?.lifecycleOwner = viewLifecycleOwner
    binding?.viewModel = viewModel

    viewModel.result.observe(viewLifecycleOwner) { result ->
      viewModel.isLoading(false)
      when (result) {
        SpaceResult.Error -> binding?.root.showSnackbar(R.string.error_loading_data, R.string.try_again) {
          viewModel.getCrew()
        }
        is SpaceResult.CrewResult -> {
          adapter.addItems(result.crew)
        }
      }
    }

    viewModel.crewAgency.observe(viewLifecycleOwner) {
      adapter.addItems(viewModel.getFilteredCrew())
    }
    viewModel.isLoading(true)
    viewModel.getCrew()
  }

  override fun onDestroyView() {
    super.onDestroyView()
    binding = null
  }
}