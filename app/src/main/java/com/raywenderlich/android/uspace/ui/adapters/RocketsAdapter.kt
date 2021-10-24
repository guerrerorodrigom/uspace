package com.raywenderlich.android.uspace.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.raywenderlich.android.uspace.databinding.ItemRocketBinding
import com.raywenderlich.android.uspace.ui.models.Rocket
import javax.inject.Inject

class RocketsAdapter @Inject constructor(): RecyclerView.Adapter<RocketsAdapter.RocketViewHolder>() {

  private val rockets: MutableList<Rocket> = mutableListOf()

  inner class RocketViewHolder(private val binding: ItemRocketBinding) : RecyclerView.ViewHolder(binding.root) {
    fun bind(rocket: Rocket) {
    }
  }

  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RocketViewHolder {
    val binding = ItemRocketBinding.inflate(LayoutInflater.from(parent.context))
    return RocketViewHolder(binding)
  }

  override fun onBindViewHolder(holder: RocketViewHolder, position: Int) {
    val rocket = rockets[position]
    holder.bind(rocket)
  }

  override fun getItemCount() = rockets.size

  fun addItems(rockets: List<Rocket>) {
    this.rockets.addAll(rockets)
    notifyDataSetChanged()
  }
}
