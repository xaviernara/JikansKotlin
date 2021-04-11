package com.example.jikanskotlin.module

import android.content.Context
import androidx.room.Room
import com.example.jikanskotlin.adaptor.JikanService
import com.example.jikanskotlin.repo.dao.JikanDao
import com.example.jikanskotlin.repo.local.JikansDB
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton



@Module
@InstallIn(SingletonComponent::class)
object JikanDBModule {


    @Provides
    @Singleton
    fun providesDb(@ApplicationContext appContext: Context): JikansDB =
        Room.databaseBuilder(appContext, JikansDB::class.java, "JikanDB")
            .build()


    @Provides
    @Singleton
    fun provideJikanDao(db: JikansDB): JikanDao = db.jikansDao()




    /*

        We can annotate a function with @Provides in Hilt modules to tell
        Hilt how to provide types that cannot be constructor injected.

        The function body of the @Provides annotated function will be executed every time Hilt
        needs to provide an instance of that type. The return type of the @Provides-annotated function
        tells Hilt the binding's type or how to provide instances of that type.
        The function parameters are the dependencies of the type.
     */






   /* @Provides
    @Singleton
    fun provideJikansService(): JikanService {
        var jikanService : JikanService
        return jikanService
    }*/


    private val client = HttpLoggingInterceptor()
        .apply {
            level = HttpLoggingInterceptor.Level.BODY
        }
        .let { loginInterceptor ->
            OkHttpClient.Builder().addInterceptor(loginInterceptor).build()
        }

    @Provides
    @Singleton
    fun providesRefrofitInstance(): Retrofit {
        return Retrofit.Builder().
        baseUrl("https://api.jikan.moe/v3/search/anime")
            .addConverterFactory(MoshiConverterFactory.create())
            .client(client).build()

    }


}