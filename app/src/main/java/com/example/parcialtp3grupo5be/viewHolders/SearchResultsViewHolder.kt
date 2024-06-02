package com.example.parcialtp3grupo5be.viewHolders

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.parcialtp3grupo5be.R
import com.example.parcialtp3grupo5be.entities.Flight
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

    fun render (model: Flight){

        Glide.with(logo_airline.context).load(model.airline_logo).into(logo_airline)

        airline.text = model.flights[0].airline
        duration.text = model.total_duration.toString()
        departure_airport_id.text = model.flights[0].departure_airport.id
        arrival_airport_id.text = model.flights[0].arrival_airport.id
        departure_airport_name.text = model.flights[0].departure_airport.name
        arrival_airport_name.text = model.flights[0].arrival_airport.name
        travel_class.text = model.flights[0].travel_class
        price.text = model.price.toString()



    }

}