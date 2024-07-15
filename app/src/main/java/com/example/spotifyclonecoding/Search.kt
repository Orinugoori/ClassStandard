package com.example.spotifyclonecoding

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import android.widget.ImageView
import android.widget.ScrollView
import androidx.constraintlayout.widget.ConstraintLayout
import com.bumptech.glide.Glide
import com.example.spotifyclonecoding.databinding.FragmentSearchBinding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"


/**
 * A simple [Fragment] subclass.
 * Use the [Search.newInstance] factory method to
 * create an instance of this fragment.
 */
class Search : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    private lateinit var scrollView: ScrollView
    private lateinit var stickyHeader: FrameLayout
    private lateinit var topContents: ConstraintLayout


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
        val binding = FragmentSearchBinding.inflate(inflater,container,false)

        val iconPlay = binding.ivContentForMeIconPlay
        iconPlay.setOnClickListener {
            val playIntent = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/watch?v=Md2-v5Vh4ec"))
            startActivity(playIntent)
        }


        scrollView = binding.scrollSearchPage2
        stickyHeader = binding.layoutSearchTab
        topContents = binding.layoutTopContents


        scrollView.viewTreeObserver.addOnScrollChangedListener {
            val scrollY = scrollView.scrollY
            val topContentBottom = topContents.bottom
            Log.d("sticky","scollY : $scrollY , topContentBottom : $topContentBottom")
            if (scrollY > topContentBottom) {
                stickyHeader.translationY = (scrollY - topContentBottom).toFloat()
            } else {
                stickyHeader.translationY = 0f
            }
        }


        var gif1 = binding.ivGifGenreExploration1
        gif1.clipToOutline = true
        Glide.with(this).load(R.raw.citypop).into(gif1)

        val gif2 = binding.ivGifGenreExploration2
        gif2.clipToOutline = true
        Glide.with(this).load(R.raw.ive).into(gif2)

        val gif3 = binding.ivGifGenreExploration3
        gif3.clipToOutline = true
        Glide.with(this).load(R.raw.citypop2).into(gif3)

        return binding.root
    }

    companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            Search().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}