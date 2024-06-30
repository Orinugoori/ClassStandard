package com.example.spotifyclonecoding

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
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

        val radioArtistCircle = findViewById<ImageView>(R.id.iv_radio_artist_circle)

        radioArtistCircle.clipToOutline = true

        val navigateBar = findViewById<BottomNavigationView>(R.id.bottom_navigation_bar)

        navigateBar.setOnNavigationItemSelectedListener{item ->
            when (item.itemId) {
                R.id.home -> {
                    val intent = Intent(this,MainActivity::class.java)
                    startActivity(intent)
                    true
                }
                R.id.search -> {
                    intent = Intent(this,SearchActivity::class.java)
                    startActivity(intent)
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
}