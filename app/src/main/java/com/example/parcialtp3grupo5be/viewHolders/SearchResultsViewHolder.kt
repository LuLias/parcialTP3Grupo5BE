package com.example.parcialtp3grupo5be.viewHolders

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.parcialtp3grupo5be.R
import com.example.parcialtp3grupo5be.entities.SearchResultsModel

class SearchResultsViewHolder (view: View) : RecyclerView.ViewHolder(view) {
    val logo_airline = view.findViewById<ImageView>(R.id.imgLogoAirline)
    val airline = view.findViewById<TextView>(R.id.txtAirlineName)
    val duration = view.findViewById<TextView>(R.id.txtDuration)
    val departure_airport_id = view.findViewById<TextView>(R.id.txtDepartureAirportID)
    val arrival_airport_id = view.findViewById<TextView>(R.id.txtArrivalAirportID)
    val departure_airport_name = view.findViewById<TextView>(R.id.txtDepartureAirportName)
    val arrival_airport_name = view.findViewById<TextView>(R.id.txtArrivalAirportName)
    val travel_class = view.findViewById<TextView>(R.id.txtTravelClass)
    val price = view.findViewById<TextView>(R.id.txtPrice)

    fun render (model: SearchResultsModel){

        Glide.with(logo_airline.context).load(model.logo_airline).into(logo_airline)

        airline.text = model.airline
        duration.text = model.duration.toString()
        departure_airport_id.text = model.departure_airport_id
        arrival_airport_id.text = model.arrival_airport_id
        departure_airport_name.text = model.departure_airport_name
        arrival_airport_name.text = model.arrival_airport_name
        travel_class.text = model.travel_class
        price.text = model.price.toString()



    }

}