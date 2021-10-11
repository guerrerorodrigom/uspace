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
import com.raywenderlich.android.uspace.databinding.FragmentDragonsBinding
import com.raywenderlich.android.uspace.repository.SpaceResult
import com.raywenderlich.android.uspace.ui.adapters.DragonAdapter
import com.raywenderlich.android.uspace.ui.viewmodels.DragonViewModel
import com.raywenderlich.android.uspace.utils.showSnackbar
import dagger.android.support.AndroidSupportInjection
import javax.inject.Inject

class DragonsFragment : Fragment() {

  companion object {
    fun createInstance() = DragonsFragment()
  }

  @Inject
  lateinit var viewModelFactory: ViewModelProvider.Factory

  @Inject
  lateinit var adapter: DragonAdapter
  private val viewModel: DragonViewModel by viewModels { viewModelFactory }
  private var binding: FragmentDragonsBinding? = null

  override fun onCreate(savedInstanceState: Bundle?) {
    AndroidSupportInjection.inject(this)
    super.onCreate(savedInstanceState)
  }

  override fun onCreateView(
      inflater: LayoutInflater, container: ViewGroup?,
      savedInstanceState: Bundle?
  ): View? {
    binding = FragmentDragonsBinding.inflate(inflater)
    return binding?.root
  }

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)

    binding?.apply {
      dragonsList.layoutManager = LinearLayoutManager(requireContext())
      dragonsList.adapter = adapter
      dragonsList.addItemDecoration(DividerItemDecoration(requireContext(), DividerItemDecoration.VERTICAL))
    }

    viewModel.dragons.observe(viewLifecycleOwner) { result ->
      binding?.loading = false
      when (result) {
        SpaceResult.Error -> binding?.root.showSnackbar(R.string.error_loading_data, R.string.try_again) {
          viewModel.getDragons()
        }
        is SpaceResult.DragonResult -> {
          adapter.addItems(result.dragons)
        }
      }
    }
    binding?.loading = true
    viewModel.getDragons()
  }

  override fun onDestroyView() {
    super.onDestroyView()
    binding = null
  }
}