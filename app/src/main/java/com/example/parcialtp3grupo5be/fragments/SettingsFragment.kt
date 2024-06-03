package com.example.parcialtp3grupo5be.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.CompoundButton
import android.widget.CompoundButton.OnCheckedChangeListener
import android.widget.ImageView
import android.widget.Switch
import android.widget.TextView
import androidx.appcompat.app.AppCompatDelegate
import androidx.appcompat.widget.SwitchCompat
import androidx.navigation.findNavController
import com.example.parcialtp3grupo5be.R
import com.google.android.material.appbar.MaterialToolbar


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [SettingsFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class SettingsFragment : Fragment() {

    lateinit var settingsFragmentView : View
    lateinit var btnBackToProfile : MaterialToolbar
    lateinit var swDarkMode : SwitchCompat



    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

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
        settingsFragmentView = inflater.inflate(R.layout.fragment_settings, container, false)
        btnBackToProfile = settingsFragmentView.findViewById(R.id.materialToolbar)
        swDarkMode = settingsFragmentView.findViewById(R.id.switchDarkMode)

            btnBackToProfile.setOnClickListener{
            val action = SettingsFragmentDirections.actionSettingsFragmentToProfileFragment()
            settingsFragmentView.findNavController().navigate(action)
        }

        swDarkMode.setOnCheckedChangeListener { buttonView, isChecked ->
            if (isChecked) {
                goInDarkMode()
            } else {
                goInNormalMode()
            }
        }

        return settingsFragmentView
    }

    private fun goInNormalMode() {
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
    }

    private fun goInDarkMode() {
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
    }

    override fun onStart() {
        super.onStart()



    }



    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment SettingsFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            SettingsFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}