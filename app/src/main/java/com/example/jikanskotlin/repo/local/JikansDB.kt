package com.example.jikanskotlin.repo.local

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.jikanskotlin.model.JikanResponse
import com.example.jikanskotlin.repo.dao.JikanDao


@Database(entities = [JikanResponse::class], version = 1)
@TypeConverters(Converters::class)
abstract class JikansDB : RoomDatabase(){
    abstract fun jikansDao(): JikanDao
}