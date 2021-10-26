package com.raywenderlich.android.uspace.bindingadapters

import androidx.databinding.BindingConversion
import com.raywenderlich.android.uspace.R
import com.raywenderlich.android.uspace.ui.models.Crew

@BindingConversion
fun crewToName(crew: Crew): String = crew.name

@BindingConversion
fun convertStringToTextAppearance(style: String): Int {
  return when (style) {
    "title" -> R.style.TextAppearance_MaterialComponents_Headline6
    "height" -> R.style.TextAppearance_MaterialComponents_Subtitle1
    "weight" -> R.style.TextAppearance_MaterialComponents_Subtitle2
    else -> R.style.TextAppearance_AppCompat_Body1
  }
}