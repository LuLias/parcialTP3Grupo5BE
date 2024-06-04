package com.example.parcialtp3grupo5be.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Button
import androidx.recyclerview.widget.RecyclerView
import com.example.parcialtp3grupo5be.R
import com.example.parcialtp3grupo5be.entities.Flight
import com.example.parcialtp3grupo5be.viewHolders.SearchResultsViewHolder

class SearchResultsAdapter (var searchResultsList : List<Flight>,private val onDetailsClick: (Flight) -> Unit) : RecyclerView.Adapter<SearchResultsViewHolder>() {

    lateinit var btnToDetails: Button
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SearchResultsViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return SearchResultsViewHolder(layoutInflater.inflate(R.layout.search_results_item, parent, false),onDetailsClick)
    }

    override fun getItemCount(): Int = searchResultsList.size



    override fun onBindViewHolder(holder: SearchResultsViewHolder, position: Int) {
        var item = searchResultsList[position]

        holder.render(item)
        }


    }


