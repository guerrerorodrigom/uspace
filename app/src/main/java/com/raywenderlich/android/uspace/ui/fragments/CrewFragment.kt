package com.raywenderlich.android.uspace.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.raywenderlich.android.uspace.R

class CrewFragment : Fragment() {

  companion object {
    fun createInstance() = CrewFragment()
  }

  override fun onCreateView(
      inflater: LayoutInflater, container: ViewGroup?,
      savedInstanceState: Bundle?
  ): View? {
    // Inflate the layout for this fragment
    return inflater.inflate(R.layout.fragment_crew, container, false)
  }
}