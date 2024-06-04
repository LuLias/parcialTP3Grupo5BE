package com.example.parcialtp3grupo5be.viewHolders

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.parcialtp3grupo5be.R
import com.example.parcialtp3grupo5be.entities.TrendingDestinationModel

class TrendingDestinationViewHolder (view:View):RecyclerView.ViewHolder(view) {

    val title = view.findViewById<TextView>(R.id.txtDestinationItemTitle)
    val subtitle = view.findViewById<TextView>(R.id.txtDestinationItemSubtitle)
    val code = view.findViewById<TextView>(R.id.txtDestinationItemCode)
    val image = view.findViewById<ImageView>(R.id.imgDestinationItem)

    fun render(model: TrendingDestinationModel){
        title.text = model.title
        subtitle.text = model.subtitle
        code.text = model.code
        Glide.with(image.context).load(model.image).into(image)
    }
}