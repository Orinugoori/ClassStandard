package com.example.spotifyclonecoding

data class PlayList(
    val textColor : Int?,
    val decoPhoto : Int?,
    val logo : Int?,
    val cover : Int,
    val playlistName : String?,
    val desc : String?
)

object MyPlayListObject {
    val myPlayList = initPlayList("MyPlayList")
    val recommendStation = initPlayList("RecommendStation")
    val mixForUser = initPlayList("MixForUser")
    val favoriteMix = initPlayList("FavoriteMix")
}

    fun initPlayList(listName : String) : MutableList<PlayList>{

        return when(listName){
            "MyPlayList" -> {
                mutableListOf(
                    PlayList(null,null,null,R.drawable.iv_cover_playlist_rihanna,"This is\nRihanna",null),
                    PlayList(null,null,null,R.drawable.iv_cover_playlist_equal,"EQUAL\nK-POP",null),
                    PlayList(null,null,null,R.drawable.iv_cover_playlist_brunomars,"Bruno Mars",null),
                    PlayList(null,null,null,R.drawable.iv_cover_playlist_sunwoojunga,"It's Okay\nDear",null),
                    PlayList(null,null,null,R.drawable.iv_cover_playlist_hyang,"Hyang",null),
                    PlayList(null,null,null,R.drawable.iv_cover_playlist_hemeets,"내배캠\n추천 노래",null),
                    PlayList(null,null,null,R.drawable.iv_cover_playlist_rollthemoon,"앨범아트\n작업한 곡들",null),
                    PlayList(null,null,null,R.drawable.iv_playlist_cover_ewf,"This is Earth\nWind&Fire",null)
                )
            }
            "RecommendStation" -> {
                mutableListOf(
                    PlayList(null,null,null,R.drawable.iv_recommend_station_hyang,null,"Hyang,Wave To Earth,\nThe 1975 등"),
                    PlayList(null,null,null,R.drawable.iv_recommend_station_aespa,null,"Aespa, f(x), Red Velvet\n등"),
                    PlayList(null,null,null,R.drawable.recommend_station_zion,null,"Zion T, DEAN, Loco,Sam\nKim, ZICO 등"),
                )
            }

            "MixForUser" -> {
                mutableListOf(
                    PlayList(1,R.drawable.iv_frame_dailymix_green,R.drawable.iv_logo_black,R.drawable.iv_photo_artist_rihanna,"데일리 믹스1","Rihanna, Bruno Mars,\nAaliyah 등"),
                    PlayList(1,R.drawable.iv_frame_dailymix_pink,R.drawable.iv_logo_black,R.drawable.iv_photo_artist_tom,"데일리 믹스2","Tom Misch, Earth Wind\n and Fire, Emily King 등"),
                    PlayList(1,R.drawable.iv_frame_dailymix_green,R.drawable.iv_logo_black,R.drawable.iv_cover_playlist_hyang,"데일리 믹스3","Hyang, The 1975,\n 10cm 등")

                )
            }
            "FavoriteMix" -> {
                mutableListOf(
                    PlayList(2,R.drawable.iv_frame_user_mix,R.drawable.iv_logo_white,R.drawable.iv_photo_artist_rihanna,"R&B 믹스","Rihanna, JUNNY, SZA 등"),
                    PlayList(2,R.drawable.iv_frame_user_mix,R.drawable.iv_logo_white,R.drawable.iv_photo_artist_doja,"업비트 믹스","Doja Cat, BORNS, Justin\nBeiber 등"),
                    PlayList(2,R.drawable.iv_frame_user_mix,R.drawable.iv_logo_white,R.drawable.iv_photo_artist_aespa,"K-pop 믹스","Aespa, f(x), Le Sserafim\n등")
                )
            }
            else -> mutableListOf()
        }

    }


