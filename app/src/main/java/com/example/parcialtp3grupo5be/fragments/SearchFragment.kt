package com.example.parcialtp3grupo5be.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.parcialtp3grupo5be.R
import com.example.parcialtp3grupo5be.adapters.OfferPreviewAdapter
import com.example.parcialtp3grupo5be.providers.OffersProvider

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [SearchFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class SearchFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    lateinit var view1 : View
    lateinit var btnToResults : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initHorizontalOffersRV(view)
    }




    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        view1 = inflater.inflate(R.layout.fragment_search, container, false)
        btnToResults = view1.findViewById(R.id.btnToSearchResults)

        btnToResults.setOnClickListener {
            val action = SearchFragmentDirections.actionSearchFragmentToSearchResultsFragment()
            view1.findNavController().navigate(action)
        }


        return view1
    }

    private fun initHorizontalOffersRV (view : View){
        val recyclerView  = view.findViewById<RecyclerView>(R.id.offersSearchRecyclerView)
        recyclerView.layoutManager = LinearLayoutManager( context, LinearLayoutManager.HORIZONTAL, false )
        recyclerView.adapter = OfferPreviewAdapter(OffersProvider.offersList)
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment search.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            SearchFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}