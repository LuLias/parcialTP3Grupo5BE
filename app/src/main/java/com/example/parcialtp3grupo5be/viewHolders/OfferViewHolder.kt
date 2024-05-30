package com.example.parcialtp3grupo5be.viewHolders

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.parcialtp3grupo5be.R
import com.example.parcialtp3grupo5be.entities.OfferModel

class OfferViewHolder (view: View) : RecyclerView.ViewHolder (view) {

    val title = view.findViewById<TextView>(R.id.txtOfferTitle)
    val description = view.findViewById<TextView>(R.id.txtOfferDescription)
    val image = view.findViewById<ImageView>(R.id.imgCreditCard)

    fun render(model: OfferModel) {
        title.text = model.title
        description.text = model.description
        Glide.with(image.context).load(model.card_image).into(image)


    }
}