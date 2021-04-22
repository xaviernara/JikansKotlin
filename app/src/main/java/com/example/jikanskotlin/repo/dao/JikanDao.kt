package com.example.jikanskotlin.repo.dao

import androidx.room.*
import com.example.jikanskotlin.model.JikanResponse
import kotlinx.coroutines.flow.Flow


@Dao
interface JikanDao {

    @Query("SELECT * FROM Jikan_Response_Table")
    fun selectAllAnime(): Flow<List<JikanResponse>>

    /*
        Varargs help us avoid writing boilerplate code by introducing the new syntax that
        can handle an arbitrary number of parameters automatically – using an array under the hood.

        varags == public String formatWithVarArgs(String... values) {
                    // ...
              }

     */



    //INSERTS jikan responses and ignores duplicate entries
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertAnime(vararg jikanResponse: JikanResponse)

    @Delete
    suspend fun deleteFavoriteAnime(jikanResponse: JikanResponse)


}

