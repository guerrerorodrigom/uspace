package com.raywenderlich.android.uspace.bindingadapters

import android.widget.TextView
import androidx.databinding.BindingAdapter
import com.raywenderlich.android.uspace.R
import com.raywenderlich.android.uspace.ui.models.Measurement
import com.raywenderlich.android.uspace.ui.models.Weight

@BindingAdapter("rocketWeight")
fun TextView.addRocketWeight(weight: Weight) {
  text = context.getString(R.string.rocket_weight_kg, weight.kg)
}

@BindingAdapter("rocketHeight")
fun TextView.addRocketHeight(height: Measurement) {
  text = context.getString(R.string.rocket_height_m, height.meters)
}