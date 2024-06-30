package com.example.spotifyclonecoding

import android.content.Intent
import android.content.pm.PackageManager
import android.os.Bundle
import android.provider.MediaStore
import android.widget.FrameLayout
import android.widget.ImageView
import android.widget.ScrollView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.bumptech.glide.Glide
import android.Manifest
import com.google.android.material.bottomnavigation.BottomNavigationView

class SearchActivity : AppCompatActivity() {

    private lateinit var scrollView: ScrollView
    private lateinit var stickyHeader: FrameLayout
    private lateinit var topContents: ConstraintLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_search)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        scrollView = findViewById(R.id.scroll_search_page2)
        stickyHeader = findViewById(R.id.layout_search_tab)
        topContents = findViewById(R.id.layout_top_contents)


        scrollView.viewTreeObserver.addOnScrollChangedListener {
            val scrollY = scrollView.scrollY
            val topContentBottom = topContents.bottom
            if (scrollY > topContentBottom) {
                stickyHeader.translationY = (scrollY - topContentBottom).toFloat()
            } else {
                stickyHeader.translationY = 0f
            }
        }


        var gif1 = findViewById<ImageView>(R.id.iv_gif_genre_exploration1)
        gif1.clipToOutline = true
        Glide.with(this).load(R.raw.citypop).into(gif1)

        val gif2 = findViewById<ImageView>(R.id.iv_gif_genre_exploration2)
        gif2.clipToOutline = true
        Glide.with(this).load(R.raw.ive).into(gif2)

        val gif3 = findViewById<ImageView>(R.id.iv_gif_genre_exploration3)
        gif3.clipToOutline = true
        Glide.with(this).load(R.raw.citypop2).into(gif3)

        val navigateBar = findViewById<BottomNavigationView>(R.id.bottom_navigation_bar)

        navigateBar.selectedItemId = R.id.search

        navigateBar.setOnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.home -> {
                    val intent = Intent(this, MainActivity::class.java)
                    startActivity(intent)
                    true
                }

                R.id.search -> {
                    intent = Intent(this, SearchActivity::class.java)
                    startActivity(intent)
                    true
                }

                R.id.library -> {
                    intent = Intent(this, LibraryActivity::class.java)
                    startActivity(intent)
                    true
                }

                else -> false

            }
        }


    }

}