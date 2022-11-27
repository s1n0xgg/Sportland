package com.example.sportlandapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.widget.Toolbar
import androidx.core.view.isVisible
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.appbar.MaterialToolbar
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.nav_host_fragment_container) as NavHostFragment
        val navController = navHostFragment.navController
        val appBarConfiguration =
            AppBarConfiguration(setOf(R.id.mainScreen, R.id.profileScreen))
        findViewById<BottomNavigationView>(R.id.nav_menu)
            .setupWithNavController(navController)
        findViewById<MaterialToolbar>(R.id.toolbar)
            .setupWithNavController(navController, appBarConfiguration)
        navController.addOnDestinationChangedListener { _, destination, _ ->
            when (destination.id) {
                R.id.firstProfile -> {
                    findViewById<BottomNavigationView>(R.id.nav_menu).isVisible =
                        false
                    findViewById<Toolbar>(R.id.toolbar).isVisible =
                        false
                }
                R.id.registerScreen -> {
                    findViewById<BottomNavigationView>(R.id.nav_menu).isVisible =
                        false
                    findViewById<Toolbar>(R.id.toolbar).isVisible =
                        false
                }
                R.id.sigInScreen -> {
                    findViewById<BottomNavigationView>(R.id.nav_menu).isVisible =
                        false
                    findViewById<Toolbar>(R.id.toolbar).isVisible =
                        false
                }
                else -> {
                    findViewById<BottomNavigationView>(R.id.nav_menu).isVisible = true
                    findViewById<Toolbar>(R.id.toolbar).isVisible = true
                }
            }
        }
    }
}