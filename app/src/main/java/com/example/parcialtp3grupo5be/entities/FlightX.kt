package com.example.parcialtp3grupo5be.entities

data class FlightX(
    val airline: String,
    val airline_logo: String,
    val arrival_airport: Airport,
    val departure_airport: Airport,
    val travel_class: String
)
