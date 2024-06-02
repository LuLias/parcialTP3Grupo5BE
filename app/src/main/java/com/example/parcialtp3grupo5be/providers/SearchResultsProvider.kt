package com.example.parcialtp3grupo5be.providers

import android.util.Log
import com.example.parcialtp3grupo5be.entities.Flight
import com.example.parcialtp3grupo5be.entities.SearchResultsModel
import com.example.parcialtp3grupo5be.services.ActivityServiceApiBuilder
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SearchResultsProvider {

   companion object {
       var searchResultsList: List<Flight> = listOf()

       fun fetchSearchResults(onResult: (List<Flight>) -> Unit) {
           ActivityServiceApiBuilder.create().getSearchResult().enqueue(object :
               Callback<List<Flight>> {
               override fun onResponse(call: Call<List<Flight>>, response: Response<List<Flight>>) {
                   if (response.isSuccessful) {
                       response.body()?.let {

                           searchResultsList = it
                           onResult(it)
                           println("funciona")
                           Log.d("response: ", searchResultsList.get(0)?.price.toString())
                       }


                   }
               }
               override fun onFailure(call: Call<List<Flight>>, t: Throwable) {
                   // Handle the error
               }
           })
       }
   }



                        /*
                           companion object {
                               val SearchResultsList = listOf<Flight>(
                                 SearchResultsModel(
                                       "https://www.gstatic.com/flights/airline_logos/70px/AA.png",
                                       "American",
                                       180,
                                       "EZE",
                                       "VVI",
                                       "Ezeiza International Airport",
                                       "Viru Viru International Airport (VVI)",
                                       "Economy",
                                       3423
                                   ),
                                   SearchResultsModel(
                                       "https://www.gstatic.com/flights/airline_logos/70px/AA.png",
                                       "American",
                                       180,
                                       "EZE",
                                       "VVI",
                                       "Ezeiza International Airport",
                                       "Viru Viru International Airport (VVI)",
                                       "Economy",
                                       3423
                                   ),
                                   SearchResultsModel(
                                       "https://www.gstatic.com/flights/airline_logos/70px/AA.png",
                                       "American",
                                       180,
                                       "EZE",
                                       "VVI",
                                       "Ezeiza International Airport",
                                       "Viru Viru International Airport (VVI)",
                                       "Economy",
                                       3423
                                   ),  SearchResultsModel(
                                       "https://www.gstatic.com/flights/airline_logos/70px/AA.png",
                                       "American",
                                       180,
                                       "EZE",
                                       "VVI",
                                       "Ezeiza International Airport",
                                       "Viru Viru International Airport (VVI)",
                                       "Economy",
                                       3423
                                   ),  SearchResultsModel(
                                       "https://www.gstatic.com/flights/airline_logos/70px/AA.png",
                                       "American",
                                       180,
                                       "EZE",
                                       "VVI",
                                       "Ezeiza International Airport",
                                       "Viru Viru International Airport (VVI)",
                                       "Economy",
                                       3423
                                   ),  SearchResultsModel(
                                       "https://www.gstatic.com/flights/airline_logos/70px/AA.png",
                                       "American",
                                       180,
                                       "EZE",
                                       "VVI",
                                       "Ezeiza International Airport",
                                       "Viru Viru International Airport (VVI)",
                                       "Economy",
                                       3423
                                   ),  SearchResultsModel(
                                       "https://www.gstatic.com/flights/airline_logos/70px/AA.png",
                                       "American",
                                       180,
                                       "EZE",
                                       "VVI",
                                       "Ezeiza International Airport",
                                       "Viru Viru International Airport (VVI)",
                                       "Economy",
                                       3423
                                   ),  SearchResultsModel(
                                       "https://www.gstatic.com/flights/airline_logos/70px/AA.png",
                                       "American",
                                       180,
                                       "EZE",
                                       "VVI",
                                       "Ezeiza International Airport",
                                       "Viru Viru International Airport (VVI)",
                                       "Economy",
                                       3423
                                   )







        )

    }   */


}