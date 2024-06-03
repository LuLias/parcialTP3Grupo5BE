package com.example.parcialtp3grupo5be.activities

import android.os.Bundle
import android.widget.Switch
import android.widget.Toolbar
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.setupWithNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.parcialtp3grupo5be.R
import com.example.parcialtp3grupo5be.adapters.TrendingDestinationAdapter
import com.example.parcialtp3grupo5be.providers.TrendingDestinationsProvider
import com.google.android.material.appbar.MaterialToolbar
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.navigation.NavigationView


class MainActivity : AppCompatActivity() {


    private lateinit var drawerLayout: DrawerLayout
    private lateinit var navigationView: NavigationView
    private lateinit var navHostFrag: NavHostFragment
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)



        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())


            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }


        drawerLayout =  findViewById(R.id.drawerLayout)
        navigationView = findViewById(R.id.navigationDrawer)


        navHostFrag = supportFragmentManager.findFragmentById(R.id.navHostFragment) as NavHostFragment
        val bottomNavView = findViewById<BottomNavigationView>(R.id.bottomNavigation)
        NavigationUI.setupWithNavController(bottomNavView,navHostFrag.navController)

        setupDrawerLayout()

    }




    private fun setupDrawerLayout(){
        val navController = navHostFrag.navController

        navigationView.setupWithNavController(navController)

    }

}