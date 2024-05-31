package com.example.parcialtp3grupo5be.services

import com.example.parcialtp3grupo5be.entities.PaginateResponse
import retrofit2.Call
import retrofit2.http.GET

interface SearchResultsService {

    @GET("search?engine=google_flights&api_key=123&departure_id=EZE&arrival_id=MIA&outbound_date=2024-05-31&return_date=2024-06-10")
    fun getSearchResult () : Call<PaginateResponse<Result>>

}