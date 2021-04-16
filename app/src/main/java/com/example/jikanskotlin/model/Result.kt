package com.example.jikanskotlin.model

import android.os.Parcelable
import androidx.room.Entity
import com.squareup.moshi.JsonClass
import kotlinx.android.parcel.Parcelize

@JsonClass(generateAdapter = true)
@Parcelize
data class Result(

    //To avoid null value error add ? to String val from parsed JSON created data classes

    val airing: Boolean, // false
    val end_date: String?, // 2007-02-08T00:00:00+00:000
    val episodes: Int, // 220
    val image_url: String?, // https://cdn.myanimelist.net/images/anime/13/17405.jpg?s=59241469eb470604a792add6fbe7cce6
    val mal_id: Int, // 20
    val members: Int, // 1859595
    val rated: String?, // PG-13
    val score: Double, // 7.91
    val start_date: String?, // 2002-10-03T00:00:00+00:00
    val synopsis: String?, // Moments prior to Naruto Uzumaki's birth, a huge demon known as the Kyuubi, the Nine-Tailed Fox, attacked Konohagakure, the Hidden Leaf Village, and wreaked havoc. In order to put an end to the Kyuubi'...
    val title: String?, // Naruto
    val type: String?, // TV
    val url: String? // https://myanimelist.net/anime/20/Naruto

):Parcelable