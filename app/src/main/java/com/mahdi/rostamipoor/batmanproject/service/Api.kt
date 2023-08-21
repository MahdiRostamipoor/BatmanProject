package com.mahdi.rostamipoor.batmanproject.service

import com.google.gson.GsonBuilder
import com.google.gson.JsonArray
import com.google.gson.JsonObject
import com.mahdi.rostamipoor.batmanproject.model.DetailMovieModel
import com.mahdi.rostamipoor.batmanproject.model.MoviesModel
import io.reactivex.Single
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

interface Api {

    @GET("/")
    fun getMovies(@Query("apikey") apiKey: String, @Query("s") searchQuery: String) : Single<MoviesModel>

    @GET("/")
    fun getDetailMovie(@Query("apikey") apiKey: String, @Query("i") imdbId: String) : Single<DetailMovieModel>

}

fun ApiClient() : Api{

    val gson = GsonBuilder()
        .setLenient()
        .create()

    val retrofit = Retrofit.Builder()
        .baseUrl("https://www.omdbapi.com")
        .addConverterFactory(GsonConverterFactory.create(gson))
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .build()

    return retrofit.create(Api::class.java)

}