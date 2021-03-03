package com.example.jikanskotlin.repo

import com.example.jikanskotlin.model.JikanResponse
import com.example.jikanskotlin.repo.dao.JikanDao
import javax.inject.Inject

class JikanRepo  @Inject constructor(private val jikanDao: JikanDao) {

    val animeList = jikanDao.selectAllFavoriteAnime()

    suspend fun insertFavoriteAnime(jikanResponse: JikanResponse) = jikanDao.insertFavoriteAnime(jikanResponse)

    suspend fun deleteFavoriteAnime(jikanResponse: JikanResponse) = jikanDao.deleteFavoriteAnime(jikanResponse)

    //suspend fun selectAllFavoriteAnime(jikanResponse: JikanResponse) = jikanDao.selectAllFavoriteAnime(jikanResponse)
}