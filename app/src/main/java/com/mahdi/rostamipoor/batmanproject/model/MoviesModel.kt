package com.mahdi.rostamipoor.batmanproject.model

import androidx.lifecycle.MutableLiveData
import androidx.room.Entity
import androidx.room.PrimaryKey

data class MoviesModel(
    val Search: List<Search>
)

@Entity(tableName = "ListMovie")
data class Search(
    val Poster: String,
    val Title: String,
    val Type: String,
    val Year: String,
    @PrimaryKey
    val imdbID: String
)