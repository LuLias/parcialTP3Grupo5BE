package com.example.parcialtp3grupo5be.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.parcialtp3grupo5be.R
import com.example.parcialtp3grupo5be.entities.OfferModel
import com.example.parcialtp3grupo5be.viewHolders.OfferViewHolder
import com.example.parcialtp3grupo5be.viewHolders.TrendingDestinationViewHolder

class OfferAdapter (var offerList: List <OfferModel>) : RecyclerView.Adapter<OfferViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OfferViewHolder {

        val layoutInflater = LayoutInflater.from(parent.context)
        return OfferViewHolder(layoutInflater.inflate(R.layout.offers_item, parent,false))

    }

    override fun getItemCount(): Int {
        return offerList.size

    }

    override fun onBindViewHolder(holder: OfferViewHolder, position: Int) {
        var item = offerList[position]

        holder.render(item)
    }
}