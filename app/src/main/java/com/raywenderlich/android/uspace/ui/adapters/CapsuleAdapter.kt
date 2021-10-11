package com.raywenderlich.android.uspace.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.raywenderlich.android.uspace.BR
import com.raywenderlich.android.uspace.databinding.ItemCapsuleBinding
import com.raywenderlich.android.uspace.ui.models.Capsule
import javax.inject.Inject

class CapsuleAdapter @Inject constructor() : RecyclerView.Adapter<CapsuleAdapter.CapsuleViewHolder>() {

  private val capsules: MutableList<Capsule> = mutableListOf()

  inner class CapsuleViewHolder(private val binding: ItemCapsuleBinding) : RecyclerView.ViewHolder(binding.root) {
    fun bind(capsule: Capsule) {
      binding.setVariable(BR.capsule, capsule)
    }
  }

  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CapsuleViewHolder {
    val binding = ItemCapsuleBinding.inflate(LayoutInflater.from(parent.context))
    return CapsuleViewHolder(binding)
  }

  override fun onBindViewHolder(holder: CapsuleViewHolder, position: Int) {
    val capsule = capsules[position]
    holder.bind(capsule)
  }

  override fun getItemCount() = capsules.size

  fun addItems(capsules: List<Capsule>) {
    this.capsules.addAll(capsules)
    notifyDataSetChanged()
  }
}
