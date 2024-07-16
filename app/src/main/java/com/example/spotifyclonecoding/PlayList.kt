package com.example.spotifyclonecoding

enum class MultiViewEnum(val viewType: Int) {
    SONG(0),
    RECOMMEND(1)
}

data class PlaySongList(
    val viewType : MultiViewEnum,
    val playList : MutableList<PlayList>,
    val SongList : MutableList<Song>,
    val anotherPlayList : MutableList<PlayList>
)


data class PlayList(
    val song: MutableList<Song>,
    val textColor: Int?,
    val decoPhoto: Int?,
    val logo: Int?,
    val cover: Int,
    val playlistName: String?,
    val desc: String?
)

data class Song(
    val cover: Int,
    val song: String,
    val artist: String
)


object MyPlayListObject {
    val myPlayList = initPlayList("MyPlayList")
    val recommendStation = initPlayList("RecommendStation")
    val mixForUser = initPlayList("MixForUser")
    val favoriteMix = initPlayList("FavoriteMix")
}

fun initPlayList(listName: String): MutableList<PlayList> {

    return when (listName) {
        "MyPlayList" -> {
            mutableListOf(
                PlayList(
                    SongListObject.hyang,
                    null,
                    null,
                    null,
                    R.drawable.iv_cover_playlist_rihanna,
                    "This is\nRihanna",
                    null
                ),
                PlayList(
                    SongListObject.hyang,
                    null,
                    null,
                    null,
                    R.drawable.iv_cover_playlist_equal,
                    "EQUAL\nK-POP",
                    null
                ),
                PlayList(
                    SongListObject.hyang,
                    null,
                    null,
                    null,
                    R.drawable.iv_cover_playlist_brunomars,
                    "Bruno Mars",
                    null
                ),
                PlayList(
                    SongListObject.hyang,
                    null,
                    null,
                    null,
                    R.drawable.iv_cover_playlist_sunwoojunga,
                    "It's Okay\nDear",
                    null
                ),
                PlayList(
                    SongListObject.hyang,
                    null,
                    null,
                    null,
                    R.drawable.iv_cover_playlist_hyang,
                    "Hyang",
                    null
                ),
                PlayList(
                    SongListObject.hyang,
                    null,
                    null,
                    null,
                    R.drawable.iv_cover_playlist_hemeets,
                    "내배캠\n추천 노래",
                    null
                ),
                PlayList(
                    SongListObject.hyang,
                    null,
                    null,
                    null,
                    R.drawable.iv_cover_playlist_rollthemoon,
                    "앨범아트\n작업한 곡들",
                    null
                ),
                PlayList(
                    SongListObject.hyang,
                    null,
                    null,
                    null,
                    R.drawable.iv_playlist_cover_ewf,
                    "This is Earth\nWind&Fire",
                    null
                )
            )
        }

        "RecommendStation" -> {
            mutableListOf(
                PlayList(
                    SongListObject.hyang,
                    null,
                    null,
                    null,
                    R.drawable.iv_recommend_station_hyang,
                    null,
                    "Hyang,Wave To Earth,\nThe 1975 등"
                ),
                PlayList(
                    SongListObject.aespa,
                    null,
                    null,
                    null,
                    R.drawable.iv_recommend_station_aespa,
                    null,
                    "Aespa, f(x), Red Velvet\n등"
                ),
                PlayList(
                    SongListObject.zionT,
                    null,
                    null,
                    null,
                    R.drawable.recommend_station_zion,
                    null,
                    "Zion T, DEAN, Loco,Sam\nKim, ZICO 등"
                ),
            )
        }

        "MixForUser" -> {
            mutableListOf(
                PlayList(
                    SongListObject.hyang,
                    1,
                    R.drawable.iv_frame_dailymix_green,
                    R.drawable.iv_logo_black,
                    R.drawable.iv_photo_artist_rihanna,
                    "데일리 믹스1",
                    "Rihanna, Bruno Mars,\nAaliyah 등"
                ),
                PlayList(
                    SongListObject.aespa,
                    1,
                    R.drawable.iv_frame_dailymix_pink,
                    R.drawable.iv_logo_black,
                    R.drawable.iv_photo_artist_tom,
                    "데일리 믹스2",
                    "Tom Misch, Earth Wind\n and Fire, Emily King 등"
                ),
                PlayList(
                    SongListObject.zionT,
                    1,
                    R.drawable.iv_frame_dailymix_green,
                    R.drawable.iv_logo_black,
                    R.drawable.iv_cover_playlist_hyang,
                    "데일리 믹스3",
                    "Hyang, The 1975,\n 10cm 등"
                )

            )
        }

        "FavoriteMix" -> {
            mutableListOf(
                PlayList(
                    SongListObject.hyang,
                    2,
                    R.drawable.iv_frame_user_mix,
                    R.drawable.iv_logo_white,
                    R.drawable.iv_photo_artist_rihanna,
                    "R&B 믹스",
                    "Rihanna, JUNNY, SZA 등"
                ),
                PlayList(
                    SongListObject.hyang,
                    2,
                    R.drawable.iv_frame_user_mix,
                    R.drawable.iv_logo_white,
                    R.drawable.iv_photo_artist_doja,
                    "업비트 믹스",
                    "Doja Cat, BORNS, Justin\nBeiber 등"
                ),
                PlayList(
                    SongListObject.hyang,
                    2,
                    R.drawable.iv_frame_user_mix,
                    R.drawable.iv_logo_white,
                    R.drawable.iv_photo_artist_aespa,
                    "K-pop 믹스",
                    "Aespa, f(x), Le Sserafim\n등"
                )
            )
        }

        else -> mutableListOf()
    }

}

object SongListObject {
    val hyang = initSong("Hyang")
    val aespa = initSong("Aespa")
    val zionT = initSong("ZionT")

    val songList = mutableListOf(hyang, aespa, zionT)

}


fun initSong(listName: String): MutableList<Song> {
    return when (listName) {
        "Hyang" -> {
            mutableListOf(
                Song(R.drawable.iv_cover_recommend_hyang, "Summer", "Hyang"),
                Song(R.drawable.hyang_2, "Waiting", "Hyang"),
                Song(R.drawable.hyang_3, "정체", "정체"),
                Song(R.drawable.hyang_4, "Beside you", "Hyang"),
                Song(R.drawable.wavetoearth_1, "seasons", "Wave to earth"),
                Song(R.drawable.wavetoearth_1, "summer flows", "Wave to earth"),
                Song(R.drawable.wavetoearth_1, "ocean floor", "Wave to earth"),
                Song(R.drawable.the1975_3, "About You", "The 1975"),
                Song(R.drawable.the1975_2, "Somebody Else", "The 1975"),
                Song(R.drawable.the1975_1, "Robbers", "The 1975"),
                Song(R.drawable.the1975_1, "Chocolate", "The 1975")
            )
        }

        "Aespa" -> {
            mutableListOf(
                Song(R.drawable.aespa_1, "SuperNova", "Aespa"),
                Song(R.drawable.aespa_1, "Armageddon", "Aespa"),
                Song(R.drawable.aespa_2, "Spicy", "Aespa"),
                Song(R.drawable.aespa_3, "Drama", "Aespa"),
                Song(R.drawable.fx_3, "첫 사랑니(Rum Pum Pum Pum)", "f(x)"),
                Song(R.drawable.fx_1, "Red Light", "f(x)"),
                Song(R.drawable.fx_2, "4 Walls", "f(x)"),
                Song(R.drawable.redvelvet_2, "빨간 맛", "Red Velvet"),
                Song(R.drawable.redvelvet_1, "Oh Boy", "Red Velvet"),
                Song(R.drawable.redvelvet_3, "러시안 룰렛", "Red Velvet")
            )
        }

        "ZionT" -> {
            mutableListOf(
                Song(R.drawable.ziont_1, "미안해(feat. Beenzino)", "Zion.T"),
                Song(R.drawable.ziont_1, "Comedian", "Zion.T"),
                Song(R.drawable.ziont_2, "멋지게 인사하는 법(feat. 슬기 of Red Velvet)", "Zion.T"),
                Song(R.drawable.ziont_3, "No Make Up", "Zion.T"),
                Song(R.drawable.crush_1, "With You", "Crush"),
                Song(R.drawable.crush_1, "From Midnight To Sunrise", "Crush"),
                Song(R.drawable.crush_1, "Wonderlust(feat. Band Wonderlust)", "Crush"),
                Song(R.drawable.crush_1, "잘자(feat. Zion.T)", "Crush"),
                Song(R.drawable.samkim_1, "Love me like that", "Sam Kim"),
                Song(R.drawable.samkim_2, "Make Up", "Sam Kim")
            )
        }

        else -> {
            mutableListOf()
        }
    }

}




