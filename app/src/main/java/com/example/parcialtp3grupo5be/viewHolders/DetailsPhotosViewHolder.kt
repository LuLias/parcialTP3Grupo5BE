package com.example.parcialtp3grupo5be.viewHolders

import android.view.View
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.parcialtp3grupo5be.R
import com.example.parcialtp3grupo5be.entities.DetailsPhotosModel

class DetailsPhotosViewHolder (view: View) : RecyclerView.ViewHolder(view){
    val photo = view.findViewById<ImageView>(R.id.imgDetailPhoto)

    fun render (model: DetailsPhotosModel){
        Glide.with(photo.context).load(model.photo).into(photo)
    }



}