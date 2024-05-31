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

    val previewTitle = view.findViewById<TextView>(R.id.txtOfferPreviewTitle)
    val offerType = view.findViewById<TextView>(R.id.txtOfferType)
    val imagePreview = view.findViewById<ImageView>(R.id.imgOfferPreviewCard)

    fun render(model: OfferModel) {
        title.text = model.title
        description.text = model.description
        Glide.with(image.context).load(model.card_image).into(image)
    }

    fun renderPreview(model:OfferModel){
        previewTitle.text = model.previewTitle
        offerType.text = model.offerType
        Glide.with(imagePreview.context).load(model.card_image).into(imagePreview)
    }

}