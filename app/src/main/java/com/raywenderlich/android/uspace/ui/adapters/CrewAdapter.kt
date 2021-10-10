package com.raywenderlich.android.uspace.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.raywenderlich.android.uspace.BR
import com.raywenderlich.android.uspace.databinding.ItemCrewBinding
import com.raywenderlich.android.uspace.ui.models.Crew
import javax.inject.Inject

class CrewAdapter @Inject constructor(): RecyclerView.Adapter<CrewAdapter.CrewViewHolder>() {

  private val crew: MutableList<Crew> = mutableListOf()

  inner class CrewViewHolder(private val binding: ItemCrewBinding) : RecyclerView.ViewHolder(binding.root) {
    fun bind(crew: Crew) {
      binding.setVariable(BR.crew, crew)
    }
  }

  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CrewViewHolder {
    val binding = ItemCrewBinding.inflate(LayoutInflater.from(parent.context))
    return CrewViewHolder(binding)
  }

  override fun onBindViewHolder(holder: CrewViewHolder, position: Int) {
    val person = crew[position]
    holder.bind(person)
  }

  override fun getItemCount() = crew.size

  fun addItems(crew: List<Crew>) {
    this.crew.clear()
    this.crew.addAll(crew)
    notifyDataSetChanged()
  }
}
