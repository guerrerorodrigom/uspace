package com.raywenderlich.android.uspace.bindingadapters

import androidx.databinding.BindingConversion
import com.raywenderlich.android.uspace.ui.models.Crew

@BindingConversion
fun crewToName(crew: Crew): String = crew.name