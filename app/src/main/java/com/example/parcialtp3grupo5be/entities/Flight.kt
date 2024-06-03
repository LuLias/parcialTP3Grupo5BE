package com.example.parcialtp3grupo5be.entities

data class Flight(

        val airline_logo: String,
        val flights: List<FlightX>,
        val price: Int,
        val total_duration: Int,
    )

