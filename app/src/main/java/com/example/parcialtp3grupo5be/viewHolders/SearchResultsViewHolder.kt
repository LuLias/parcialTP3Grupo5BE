package com.example.parcialtp3grupo5be.viewHolders

import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.parcialtp3grupo5be.R
import com.example.parcialtp3grupo5be.entities.Flight

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
    val btnDetails = view.findViewById<Button>(R.id.btnDetails)


    fun render (model: Flight){

        Glide.with(logo_airline.context).load(model.airline_logo).into(logo_airline)

        airline.text = model.flights[0].airline
        duration.text = formatDuration(model.total_duration)
        departure_airport_id.text = model.flights[0].departure_airport.id
        arrival_airport_id.text = model.flights.last().arrival_airport.id
        departure_airport_name.text = model.flights[0].departure_airport.name.split(" ")[0]
        arrival_airport_name.text = model.flights.last().arrival_airport.name.split(" ")[0]
        travel_class.text = model.flights[0].travel_class
        price.text = String.format("$%02d",model.price)

        btnDetails.setOnClickListener(){
            val action = R.id.action_searchResultsFragment_to_detailsFragment
          //  findNavController().navigate(action)
        }

    }

    private fun formatDuration(totalDuration: Int): String {
        val hours = totalDuration / 60
        val minutes = totalDuration % 60
        return String.format("%02d hr %02dmin", hours, minutes)
    }

}