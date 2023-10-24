package com.example.recyclerview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class PetAdapter (private val petList: MutableList<String>) :
    RecyclerView.Adapter<PetAdapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val petImage: ImageView
        var toast: Toast? = null

        init {
            petImage = view.findViewById(R.id.pet_image)
        }
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.pet_item, viewGroup, false)

        return ViewHolder(view)
    }
    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        Glide.with(viewHolder.itemView)
            .load(petList[position])
            .placeholder(R.drawable.cutedogs_placeholder)
            .centerCrop()
            .into(viewHolder.petImage)

        viewHolder.petImage.setOnClickListener {
            if (viewHolder.toast != null) { viewHolder.toast?.cancel() }
            viewHolder.toast = Toast.makeText(viewHolder.itemView.context, "Doggo at position $position clicked", Toast.LENGTH_SHORT)
            viewHolder.toast?.show()
        }
    }

    override fun getItemCount() = petList.size

}
