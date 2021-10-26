package com.raywenderlich.android.uspace.bindingadapters

import android.widget.TextView
import androidx.databinding.BindingAdapter
import com.raywenderlich.android.uspace.R
import com.raywenderlich.android.uspace.ui.models.Crew
import com.raywenderlich.android.uspace.ui.models.Measurement
import com.raywenderlich.android.uspace.ui.models.Weight
import java.text.NumberFormat
import java.text.SimpleDateFormat
import java.util.*

@BindingAdapter("rocketWeight")
fun TextView.addRocketWeight(weight: Weight) {
  val formattedWeight = NumberFormat.getInstance().format(weight.kg)
  text = context.getString(R.string.rocket_weight_kg, formattedWeight)
}

@BindingAdapter("rocketHeight")
fun TextView.addRocketHeight(height: Measurement) {
  text = context.getString(R.string.rocket_height_m, height.meters)
}

@BindingAdapter("launches")
fun TextView.numberOfLaunches(crew: Crew) {
  val numberOfLaunches = crew.launches.count()
  text = context.getString(R.string.launches, numberOfLaunches)
}

@BindingAdapter("date")
fun TextView.formatDate(date: String) {
  val formatter = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault())
  formatter.parse(date)?.also {
    val finalFormatter = SimpleDateFormat("MMMM dd, yyyy", Locale.getDefault())
    text = finalFormatter.format(it)
  }
}

@BindingAdapter("capitalizeFirst")
fun TextView.capitalizeFirst(value: String) {
  text = value.replaceFirstChar { if (it.isLowerCase()) it.titlecase(Locale.getDefault()) else it.toString() }
}
