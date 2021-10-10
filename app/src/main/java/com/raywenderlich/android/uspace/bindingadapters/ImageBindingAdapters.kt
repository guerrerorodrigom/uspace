package com.raywenderlich.android.uspace.bindingadapters

import android.graphics.drawable.Drawable
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.databinding.BindingMethod
import androidx.databinding.BindingMethods
import com.squareup.picasso.Picasso

@BindingAdapter("imageUrl", "placeholder")
fun ImageView.loadImage(url: String, placeholder: Drawable) {
  Picasso.get().load(url).placeholder(placeholder).into(this)
}

@BindingMethods(value = [
  BindingMethod(
      type = ImageView::class,
      attribute = "app:srcCompat",
      method = "setImageResource")])
class ImageBindingAdapters

