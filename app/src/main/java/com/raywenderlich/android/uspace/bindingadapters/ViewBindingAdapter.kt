package com.raywenderlich.android.uspace.bindingadapters

import android.view.View
import androidx.databinding.BindingAdapter

@BindingAdapter("android:visibility")
fun View.setVisibility(visible: Boolean) {
  if (visible) {
    visibility = View.VISIBLE
  } else {
    visibility = View.GONE
  }
}