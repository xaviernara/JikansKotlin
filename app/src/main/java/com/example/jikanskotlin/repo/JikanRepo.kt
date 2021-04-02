package com.example.jikanskotlin.repo

import com.example.jikanskotlin.model.JikanResponse
import com.example.jikanskotlin.remote.RetrofitInstance
import com.example.jikanskotlin.repo.dao.JikanDao
import javax.inject.Inject

class JikanRepo  @Inject constructor(private val jikanDao: JikanDao, private val retrofit: RetrofitInstance) {

    val jikanFlow = jikanDao.selectAllFavoriteAnime()

    suspend fun insertFavoriteAnime(jikanResponse: JikanResponse) = jikanDao.insertFavoriteAnime(jikanResponse)

    suspend fun deleteFavoriteAnime(jikanResponse: JikanResponse) = jikanDao.deleteFavoriteAnime(jikanResponse)

    //suspend fun selectAllFavoriteAnime(jikanResponse: JikanResponse) = jikanDao.selectAllFavoriteAnime(jikanResponse)

    suspend fun createJikanResponse(animeName: String): JikanResponse{
        return retrofit.jikanService.getJikanService(animeName)
    }
}