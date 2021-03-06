package com.example.jikanskotlin.model

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize


@Entity(tableName = "Jikan_Response_Table")
@Parcelize
data class JikanResponse(

    @PrimaryKey(autoGenerate = true)
    val id : Int,
    val last_page: Int, // 20
    val request_cache_expiry: Int, // 431065
    val request_cached: Boolean, // true
    val request_hash: String, // request:search:9b9d315dd05e8f0690bfa02ec0c1855cbf87210a
    val results: List<Result>

): Parcelable