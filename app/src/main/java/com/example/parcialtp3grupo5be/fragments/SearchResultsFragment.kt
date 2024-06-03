package com.example.parcialtp3grupo5be.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import android.widget.ScrollView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.parcialtp3grupo5be.R
import com.example.parcialtp3grupo5be.adapters.SearchResultsAdapter
import com.example.parcialtp3grupo5be.entities.Flight
import com.example.parcialtp3grupo5be.entities.SearchResponse
import com.example.parcialtp3grupo5be.providers.SearchResultsProvider
import com.example.parcialtp3grupo5be.services.ActivityServiceApiBuilder
import com.google.android.material.appbar.MaterialToolbar
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [SearchResultsFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class SearchResultsFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    lateinit var adapter:SearchResultsAdapter
    lateinit var recyclerView : RecyclerView
    lateinit var progressBar: ProgressBar
    lateinit var txtResultsFound: TextView
    lateinit var containerFlightsResults : ScrollView


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initSearchResultsRV(view)
        fetchData()

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_search_results, container, false)

        txtResultsFound = view.findViewById(R.id.txtResultsFound)
        containerFlightsResults = view.findViewById(R.id.containerFlightsResults)

        // Agrego funcion de volver al searchFragment al icono de la toolbar
        val toolbar = view.findViewById<MaterialToolbar>(R.id.materialToolbar)
        toolbar.setNavigationOnClickListener {
            // Volver a search
            findNavController().navigate(R.id.action_searchResultsFragment_to_searchFragment)
        }

        return view

    }

    private fun initSearchResultsRV(view : View){
        recyclerView = view.findViewById<RecyclerView>(R.id.searchResultRecyclerView)
        recyclerView.layoutManager = LinearLayoutManager (context, LinearLayoutManager.VERTICAL,false)
        progressBar = view.findViewById(R.id.progressBar)
    }


    private fun fetchData() {
        progressBar.visibility = View.VISIBLE
        containerFlightsResults.visibility = View.GONE
        val call = ActivityServiceApiBuilder.create().getSearchResult()
        call.enqueue(object : Callback<SearchResponse> {
            override fun onResponse(call: Call<SearchResponse>, response: Response<SearchResponse>) {
                if (response.isSuccessful) {
                    response.body()?.let { searchResponse ->
                        val flights: List<Flight> = searchResponse.best_flights
                        SearchResultsProvider.searchResultsList = flights
                        adapter = SearchResultsAdapter(SearchResultsProvider.searchResultsList)
                        recyclerView.adapter = adapter
                        txtResultsFound.text = "${flights.size} results found"
                        progressBar.visibility = View.GONE
                        containerFlightsResults.visibility = View.VISIBLE
                    }
                }
            }

            override fun onFailure(call: Call<SearchResponse>, t: Throwable) {
                Toast.makeText(activity, "Error de conexion", Toast.LENGTH_SHORT).show()
                progressBar.visibility = View.GONE
            }
        })
    }



    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment SearchResultsFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            SearchResultsFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}


