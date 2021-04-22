package com.example.jikanskotlin.model

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.example.jikanskotlin.repo.local.Converters
import com.squareup.moshi.JsonClass
import kotlinx.android.parcel.Parcelize
import kotlinx.android.parcel.RawValue


@Entity(tableName = "Jikan_Response_Table")
@JsonClass(generateAdapter = true)
@Parcelize
data class JikanResponse(

    //To avoid null value error add ? to String val from parsed JSON created data classes
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val last_page: Int, // 20
    val request_cache_expiry: Int, // 431065
    val request_cached: Boolean, // true
    val request_hash: String?, // request:search:9b9d315dd05e8f0690bfa02ec0c1855cbf87210a

    @TypeConverters(Converters::class)
    //val results: @RawValue List<Result>
    val results: List<Result>

): Parcelable