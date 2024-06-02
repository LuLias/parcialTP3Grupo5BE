package com.example.parcialtp3grupo5be.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.parcialtp3grupo5be.R
import com.example.parcialtp3grupo5be.adapters.SearchResultsAdapter
import com.example.parcialtp3grupo5be.entities.Flight
import com.example.parcialtp3grupo5be.entities.PaginateResponse
import com.example.parcialtp3grupo5be.providers.SearchResultsProvider
import com.example.parcialtp3grupo5be.services.ActivityServiceApiBuilder.create
import com.google.gson.GsonBuilder
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.http.Tag

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


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        fetchData()
        initSearchResultsRV(view)

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }



          /*
              val api = create()
              lifecycleScope.launch {
                  val response = api.getSearchResult()

                      val gson = GsonBuilder().setPrettyPrinting().create()
                      val jsonData = gson.toJson(response)
                      println("**Resultado de la API:**")
                      println(jsonData)






            val result = api.getSearchResult()
        println(result)
        Log.d("hola", result.toString())
        }



        } */

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_search_results, container, false)
    }

    private fun initSearchResultsRV(view : View){
        val recyclerView = view.findViewById<RecyclerView>(R.id.searchResultRecyclerView)
        recyclerView.layoutManager = LinearLayoutManager (context, LinearLayoutManager.VERTICAL,false)
        adapter = SearchResultsAdapter(SearchResultsProvider.searchResultsList)
        recyclerView.adapter = adapter
    }

    private fun fetchData() {
        SearchResultsProvider.fetchSearchResults{ searchResults ->
            adapter.searchResultsList = searchResults
            adapter.notifyDataSetChanged()
        }
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


