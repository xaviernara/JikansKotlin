package com.example.jikanskotlin.repo.local

import androidx.room.TypeConverter
import com.example.jikanskotlin.model.Result
import com.squareup.moshi.Moshi
import com.squareup.moshi.Types
import com.squareup.moshi.adapter

class Converters {



    //Converter for Result object to String
    //DONT NEED type variable WHEN CONVERTING A CUSTOM OBJECT TO STRING
    @TypeConverter
    fun resultsToString(result: List<Result>): String {
        val type = Types.newParameterizedType(List::class.java, Result::class.java)
        val adapter = Moshi.Builder().build().adapter<List<Result>>(type)
        return adapter.toJson(result)
    }

    //Converter for String to Result object
    //DONT NEED type variable WHEN CONVERTING A CUSTOM OBJECT TO STRING
    @TypeConverter
    fun stringToResult(jsonString: String): List<Result> {
        val type = Types.newParameterizedType(List::class.java, Result::class.java)
        val adapter = Moshi.Builder().build().adapter<List<Result>>(type)
        return adapter.fromJson(jsonString)?:listOf()
    }

    //////////////////////////////////////////////////////////////////////

  /*  //Converter for List to String
    //ONLY NEED type variable WHEN CONVERTING A LIST<>
    @TypeConverter
    fun listToString(list : List<String>):String{
        val type = Types.newParameterizedType(List::class.java,String::class.java)
        val adapter = Moshi.Builder().build().adapter<List<String>>(type)
        return adapter.toJson(list)
    }

    //Converter for String to list
    //ONLY NEED type variable WHEN CONVERTING A LIST<>
    @TypeConverter
    fun stringToList(jsonString: String): List<String>? {
        val type = Types.newParameterizedType(List::class.java,String::class.java)
        val adapter = Moshi.Builder().build().adapter<List<String>>(type)
        return adapter.fromJson(jsonString)?:listOf()
    }
*/









}