package com.example.ourapplication.ui.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import com.example.ourapplication.R
import com.example.ourapplication.ui.activities.contracts.INavigatableActivity

class HostActivity : AppCompatActivity(), INavigatableActivity {
    private lateinit var navController: NavController
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.host_activity)
        val navHostFragment = supportFragmentManager.findFragmentById(R.id.nav_host_fragment_activity_main) as NavHostFragment
        navController = navHostFragment.navController

    }

    override fun navigateTo(dest: Int) {
        navController.navigate(dest)
    }
}