package com.raywenderlich.android.uspace.bindingadapters

import android.widget.RadioGroup
import androidx.databinding.BindingAdapter
import androidx.databinding.InverseBindingAdapter
import androidx.databinding.InverseBindingListener
import androidx.lifecycle.MutableLiveData
import com.raywenderlich.android.uspace.R
import com.raywenderlich.android.uspace.ui.models.CrewAgency

@BindingAdapter("crewFilter")
fun setCheckedButton(radioGroup: RadioGroup, crewAgency: MutableLiveData<CrewAgency>?) {
  val selectedId = when (crewAgency?.value) {
    CrewAgency.SPACEX -> R.id.spacex
    CrewAgency.NASA -> R.id.nasa
    CrewAgency.JAXA -> R.id.jaxa
    CrewAgency.ESA -> R.id.esa
    else -> null
  }

  if (selectedId != null && selectedId != radioGroup.checkedRadioButtonId) {
    radioGroup.check(selectedId)
  }
}

@InverseBindingAdapter(attribute = "crewFilter")
fun getCheckedButton(radioGroup: RadioGroup): CrewAgency? {
  return when (radioGroup.checkedRadioButtonId) {
    R.id.spacex -> CrewAgency.SPACEX
    R.id.nasa -> CrewAgency.NASA
    R.id.jaxa -> CrewAgency.JAXA
    R.id.esa -> CrewAgency.ESA
    else -> null
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
