package com.example.parcialtp3grupo5be.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.parcialtp3grupo5be.R
import com.example.parcialtp3grupo5be.entities.TrendingDestinationModel
import com.example.parcialtp3grupo5be.viewHolders.TrendingDestinationViewHolder

class TrendingDestinationAdapter(var trendingDestinationsList: List<TrendingDestinationModel>) : RecyclerView.Adapter<TrendingDestinationViewHolder>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): TrendingDestinationViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return TrendingDestinationViewHolder(
            layoutInflater.inflate(
                R.layout.trending_destinations_item,
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int = trendingDestinationsList.size

    override fun onBindViewHolder(holder: TrendingDestinationViewHolder, position: Int) {
        val item = trendingDestinationsList[position]

        holder.render(item)
    }
}

