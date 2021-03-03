package com.example.jikanskotlin.repo.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.jikanskotlin.model.JikanResponse
import com.example.jikanskotlin.repo.dao.JikanDao


@Database(entities = [JikanResponse::class], version = 1)
abstract class JikansDB : RoomDatabase(){
    abstract fun jikansDao(): JikanDao
}