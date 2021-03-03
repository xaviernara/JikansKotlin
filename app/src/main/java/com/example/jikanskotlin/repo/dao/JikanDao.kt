package com.example.jikanskotlin.repo.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.example.jikanskotlin.model.JikanResponse
import kotlinx.coroutines.flow.Flow


@Dao
interface JikanDao {

    @Query("SELECT * FROM Jikan_Response_Table")
    fun selectAllFavoriteAnime(): Flow<List<JikanResponse>>

    /*
        Varargs help us avoid writing boilerplate code by introducing the new syntax that
        can handle an arbitrary number of parameters automatically – using an array under the hood.

        varags == public String formatWithVarArgs(String... values) {
                    // ...
              }

     */

    @Insert
    suspend fun insertFavoriteAnime(vararg jikanResponse: JikanResponse)

    @Delete
    suspend fun deleteFavoriteAnime(jikanResponse: JikanResponse)


}

