package com.raywenderlich.android.uspace.bindingadapters

import android.view.View
import android.widget.RadioGroup
import androidx.databinding.BindingAdapter
import androidx.databinding.InverseBindingAdapter
import androidx.databinding.InverseBindingListener
import androidx.lifecycle.MutableLiveData
import com.raywenderlich.android.uspace.R
import com.raywenderlich.android.uspace.ui.models.CrewAgency

@BindingAdapter("android:visibility")
fun View.setVisibility(visible: Boolean) {
  if (visible) {
    visibility = View.VISIBLE
  } else {
    visibility = View.GONE
  }
}

@BindingAdapter("crewFilter")
fun setCheckedButton(radioGroup: RadioGroup, crewAgency: MutableLiveData<CrewAgency>?) {
  val selectedId = when (crewAgency?.value) {
    CrewAgency.SPACEX -> R.id.spacex
    CrewAgency.NASA -> R.id.nasa
    CrewAgency.JAXA -> R.id.jaxa
    CrewAgency.ESA -> R.id.esa
    else -> R.id.nasa
  }

  if (selectedId != radioGroup.checkedRadioButtonId) {
    radioGroup.check(selectedId)
  }
}

@InverseBindingAdapter(attribute = "crewFilter")
fun getCheckedButton(radioGroup: RadioGroup): CrewAgency {
  return when (radioGroup.checkedRadioButtonId) {
    R.id.spacex -> CrewAgency.SPACEX
    R.id.nasa -> CrewAgency.NASA
    R.id.jaxa -> CrewAgency.JAXA
    R.id.esa -> CrewAgency.ESA
    else -> CrewAgency.NASA
  }
}

@BindingAdapter("app:crewFilterAttrChanged")
fun setListeners(radioGroup: RadioGroup, listener: InverseBindingListener?) {
  listener?.let {
    radioGroup.setOnCheckedChangeListener { radioGroup, id ->
      listener.onChange()
    }
  }
}

