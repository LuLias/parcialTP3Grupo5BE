package com.example.parcialtp3grupo5be.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.parcialtp3grupo5be.R
import com.example.parcialtp3grupo5be.entities.SearchResultsModel
import com.example.parcialtp3grupo5be.viewHolders.SearchResultsViewHolder

class SearchResultsAdapter (var searchResultsList : List<SearchResultsModel>) : RecyclerView.Adapter<SearchResultsViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SearchResultsViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return SearchResultsViewHolder(layoutInflater.inflate(R.layout.search_results_item, parent, false))
    }

    override fun getItemCount(): Int = searchResultsList.size



    override fun onBindViewHolder(holder: SearchResultsViewHolder, position: Int) {
        var item = searchResultsList[position]
        holder.render(item)
    }
}