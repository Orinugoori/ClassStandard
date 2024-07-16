package com.example.spotifyclonecoding

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import com.example.spotifyclonecoding.databinding.FragmentDetailBinding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"


class Detail : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: Int? = null

    private var _binding : FragmentDetailBinding? = null
    //custom getter
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getInt(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentDetailBinding.inflate(inflater,container,false)

        val category = param1
        val index = param2 ?: 0

        binding.ivCoverMain.setImageResource(MyPlayListObject.recommendStation[index].cover)
        binding.tvDescPlayList.text = MyPlayListObject.recommendStation[index].desc

        println(param1)

        val playList = MyPlayListObject.recommendStation.getOrNull(index)
        val songData = playList?.song ?: mutableListOf()

        val songListData = PlaySongList(MultiViewEnum.SONG, MyPlayListObject.recommendStation,songData,MyPlayListObject.mixForUser)
        val recommendData = PlaySongList(MultiViewEnum.RECOMMEND, MyPlayListObject.recommendStation,SongListObject.hyang,MyPlayListObject.mixForUser)



        binding.rvSongList.adapter = SongAdapter(songListData)
        binding.rvSongList.addItemDecoration(RecyclerDecoration(16,16,16,16))

        binding.rvRecommend.adapter = SongAdapter(recommendData)
        binding.rvRecommend.layoutManager = GridLayoutManager(this.context,2)
        binding.rvRecommend.addItemDecoration(RecyclerDecoration(16,16,16,16))


        return binding.root
    }

    companion object {
        @JvmStatic
        fun newInstance(param1: String, param2 : Int) =
            Detail().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putInt(ARG_PARAM2, param2)
                }
            }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}