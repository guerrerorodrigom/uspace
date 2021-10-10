package com.raywenderlich.android.uspace.bindingadapters

import android.view.View
import android.widget.TextView
import androidx.databinding.BindingAdapter
import androidx.databinding.BindingConversion
import com.raywenderlich.android.uspace.R
import com.raywenderlich.android.uspace.ui.models.Measurement
import com.raywenderlich.android.uspace.ui.models.Weight
import java.text.NumberFormat

@BindingAdapter("rocketWeight")
fun TextView.addRocketWeight(weight: Weight) {
  val formattedWeight = NumberFormat.getInstance().format(weight.kg)
  text = context.getString(R.string.rocket_weight_kg, formattedWeight)
}

@BindingAdapter("rocketHeight")
fun TextView.addRocketHeight(height: Measurement) {
  text = context.getString(R.string.rocket_height_m, height.meters)
}

@BindingConversion
fun convertStringToTextAppearance(style: String): Int {
  return when (style) {
    "title" -> R.style.TextAppearance_MaterialComponents_Headline6
    "height" -> R.style.TextAppearance_MaterialComponents_Subtitle1
    "weight" -> R.style.TextAppearance_MaterialComponents_Subtitle2
    else -> R.style.TextAppearance_AppCompat_Body1
  }
}