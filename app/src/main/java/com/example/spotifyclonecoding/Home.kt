package com.example.spotifyclonecoding

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import com.example.spotifyclonecoding.databinding.FragmentHomeBinding

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class Home : Fragment() {
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
        val binding = FragmentHomeBinding.inflate(inflater, container, false)

        binding.ivRadioArtistCircle.clipToOutline = true

        //recycler view
        val recentPlayList = MyPlayListObject.myPlayList
        val adapterRecent = RecentPlayAdapter(recentPlayList)
        val recentPlayDecoration = RecyclerDecoration(16,16,16,16)
        val horizontalDecoration = RecyclerDecoration(0,0,40,0)

        binding.rvRecentPlaylist.adapter = adapterRecent
        binding.rvRecentPlaylist.layoutManager = GridLayoutManager(this.context,2)
        binding.rvRecentPlaylist.addItemDecoration(recentPlayDecoration)

        val recommendStation = MyPlayListObject.recommendStation
        val adapterRecommend = HorizontalAdapter(recommendStation)

        binding.rvRecommendStation.adapter = adapterRecommend
        binding.rvRecommendStation.addItemDecoration(horizontalDecoration)

        val mixForUser = MyPlayListObject.mixForUser
        val adapterMixForUser = HorizontalAdapter(mixForUser)

        binding.rvMixForUser.adapter = adapterMixForUser
        binding.rvMixForUser.addItemDecoration(horizontalDecoration)

        val userMix = MyPlayListObject.favoriteMix
        val adapterUserMix = HorizontalAdapter(userMix)

        binding.rvUserMix.adapter = adapterUserMix
        binding.rvUserMix.addItemDecoration(horizontalDecoration)

        return binding.root
    }

    companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            Home().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}