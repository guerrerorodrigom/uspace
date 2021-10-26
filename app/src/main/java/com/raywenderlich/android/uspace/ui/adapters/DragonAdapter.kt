package com.raywenderlich.android.uspace.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.raywenderlich.android.uspace.BR
import com.raywenderlich.android.uspace.databinding.ItemDragonBinding
import com.raywenderlich.android.uspace.ui.models.Dragon
import javax.inject.Inject

class DragonAdapter @Inject constructor() : RecyclerView.Adapter<DragonAdapter.DragonViewHolder>() {

  private val dragon: MutableList<Dragon> = mutableListOf()

  inner class DragonViewHolder(private val binding: ItemDragonBinding) : RecyclerView.ViewHolder(binding.root) {
    fun bind(dragon: Dragon) {
      binding.setVariable(BR.dragon, dragon)
    }
  }

  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DragonViewHolder {
    val binding = ItemDragonBinding.inflate(LayoutInflater.from(parent.context))
    return DragonViewHolder(binding)
  }

  override fun onBindViewHolder(holder: DragonViewHolder, position: Int) {
    val person = dragon[position]
    holder.bind(person)
  }

  override fun getItemCount() = dragon.size

  fun addItems(dragon: List<Dragon>) {
    this.dragon.addAll(dragon)
    notifyDataSetChanged()
  }
}
