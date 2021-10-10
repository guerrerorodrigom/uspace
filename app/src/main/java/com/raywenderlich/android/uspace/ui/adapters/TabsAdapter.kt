package com.raywenderlich.android.uspace.ui.adapters

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.raywenderlich.android.uspace.ui.fragments.CapsulesFragment
import com.raywenderlich.android.uspace.ui.fragments.CrewFragment
import com.raywenderlich.android.uspace.ui.fragments.RocketsFragment

class TabsAdapter(activity: AppCompatActivity) : FragmentStateAdapter(activity) {
  private val numberOfTabs = 3

  override fun getItemCount() = numberOfTabs

  override fun createFragment(position: Int): Fragment {
    return when (position) {
      0 -> RocketsFragment.createInstance()
      1 -> CrewFragment.createInstance()
      else -> CapsulesFragment.createInstance()
    }
  }
}