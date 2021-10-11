package com.raywenderlich.android.uspace.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.raywenderlich.android.uspace.R
import com.raywenderlich.android.uspace.databinding.FragmentCapsulesBinding
import com.raywenderlich.android.uspace.databinding.FragmentDragonsBinding
import com.raywenderlich.android.uspace.repository.SpaceResult
import com.raywenderlich.android.uspace.ui.adapters.CapsuleAdapter
import com.raywenderlich.android.uspace.ui.adapters.DragonAdapter
import com.raywenderlich.android.uspace.ui.viewmodels.CapsuleViewModel
import com.raywenderlich.android.uspace.ui.viewmodels.DragonViewModel
import com.raywenderlich.android.uspace.utils.showSnackbar
import dagger.android.support.AndroidSupportInjection
import javax.inject.Inject

class CapsulesFragment : Fragment() {
  companion object {
    fun createInstance() = CapsulesFragment()
  }

  @Inject
  lateinit var viewModelFactory: ViewModelProvider.Factory

  @Inject
  lateinit var adapter: CapsuleAdapter
  private val viewModel: CapsuleViewModel by viewModels { viewModelFactory }
  private var binding: FragmentCapsulesBinding? = null

  override fun onCreate(savedInstanceState: Bundle?) {
    AndroidSupportInjection.inject(this)
    super.onCreate(savedInstanceState)
  }

  override fun onCreateView(
      inflater: LayoutInflater, container: ViewGroup?,
      savedInstanceState: Bundle?
  ): View? {
    binding = FragmentCapsulesBinding.inflate(inflater)
    return binding?.root
  }

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)

    binding?.apply {
      capsulesList.layoutManager = LinearLayoutManager(requireContext())
      capsulesList.adapter = adapter
      capsulesList.addItemDecoration(DividerItemDecoration(requireContext(), DividerItemDecoration.VERTICAL))
    }

    viewModel.capsules.observe(viewLifecycleOwner) { result ->
      binding?.loading = false
      when (result) {
        SpaceResult.Error -> binding?.root.showSnackbar(R.string.error_loading_data, R.string.try_again) {
          viewModel.getCapsules()
        }
        is SpaceResult.CapsuleResult -> {
          adapter.addItems(result.capsules)
        }
      }
    }
    binding?.loading = true
    viewModel.getCapsules()
  }

  override fun onDestroyView() {
    super.onDestroyView()
    binding = null
  }
}