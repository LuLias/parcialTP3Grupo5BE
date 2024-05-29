package com.example.parcialtp3grupo5be.activities

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import com.example.parcialtp3grupo5be.R
import com.google.android.material.bottomnavigation.BottomNavigationView



class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val navHostFrag = supportFragmentManager.findFragmentById(R.id.navHostFragment) as NavHostFragment
        val bottomNavView = findViewById<BottomNavigationView>(R.id.bottomNavigation)
        NavigationUI.setupWithNavController(bottomNavView,navHostFrag.navController)
    }
}