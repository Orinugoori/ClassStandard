package com.example.spotifyclonecoding

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.recyclerview.widget.GridLayoutManager
import com.example.spotifyclonecoding.databinding.ActivityMainBinding
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        supportFragmentManager.beginTransaction().add(R.id.fragment_container,Home()).commit()


        val navigateBar = findViewById<BottomNavigationView>(R.id.bottom_navigation_bar)

        navigateBar.setOnNavigationItemSelectedListener{item ->
            when (item.itemId) {
                R.id.home -> {
                    setFragment(Home())
                    true
                }
                R.id.search -> {
                    setFragment(Search())
                    true
                }
                R.id.library -> {
                    intent = Intent(this,LibraryActivity::class.java)
                    startActivity(intent)
                    true
                }
                else -> false

            }
        }

    }

    private fun setFragment(fragment : Fragment) {
        supportFragmentManager.beginTransaction().replace(R.id.fragment_container,fragment).commit()
        }
    }



