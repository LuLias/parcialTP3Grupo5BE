package com.example.parcialtp3grupo5be.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.parcialtp3grupo5be.R
import com.example.parcialtp3grupo5be.entities.DetailsPhotosModel
import com.example.parcialtp3grupo5be.viewHolders.DetailsPhotosViewHolder

class DetailsPhotosAdapter (var detailsPhotosList: List <DetailsPhotosModel>) : RecyclerView.Adapter<DetailsPhotosViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DetailsPhotosViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return DetailsPhotosViewHolder(
            layoutInflater.inflate(
                R.layout.details_photos_item, parent, false
            )
        )
    }

    override fun getItemCount(): Int = detailsPhotosList.size


    override fun onBindViewHolder(holder: DetailsPhotosViewHolder, position: Int) {
        val item = detailsPhotosList[position]
        holder.render(item)
    }


}