package com.example.jikanskotlin.adaptor

import com.example.jikanskotlin.model.JikanResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface JikanService {

    /**
     * Implementation using kotlin coroutines multithreading mechanism
     *
     * suspend is a keyword that lets the compiler know this is a coroutine function
     */

    // https://v2.jokeapi.dev/joke/any?amount=10
/*
    @Path(""): is used for url elements after the base url without ? before it
    ex: BASE_URL:https://v2.jokeapi.dev/joke/any,misc,xmas?amount=10

    @Path("category")

    @Get("") is used for url elements after the base url with ? before it
    @Get("amount")

 */

    /*
        Ex:
        description: python
         location: san francisco
         full_time: true


     */

    @GET("anime/")
    suspend fun getJikanService(@Query("q") animeName:String) : JikanResponse




}