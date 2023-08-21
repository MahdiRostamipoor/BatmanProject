package com.mahdi.rostamipoor.batmanproject.database

import androidx.room.*
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import com.mahdi.rostamipoor.batmanproject.model.DetailMovieModel
import com.mahdi.rostamipoor.batmanproject.model.Search

@Dao
interface DataDao {

    @get:Query("SELECT * FROM listmovie")
    val listMovie : List<Search>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addListMovie(movie: List<Search>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addDetailMovie(movie: DetailMovieModel)

    @Query("SELECT * FROM DetailMovie WHERE imdbID == :key")
    fun listDetailMovie(key : String) : DetailMovieModel
}