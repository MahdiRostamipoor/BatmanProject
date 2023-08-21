package com.mahdi.rostamipoor.batmanproject.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import com.mahdi.rostamipoor.batmanproject.R
import com.mahdi.rostamipoor.batmanproject.database.DataBase
import com.mahdi.rostamipoor.batmanproject.viewModel.DetailMoveViewModel
import com.squareup.picasso.Picasso

class DetailMovie : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_movie)

        val pic_movie = findViewById<ImageView>(R.id.pic_movie)
        val back = findViewById<ImageView>(R.id.back)
        val txt_rating = findViewById<TextView>(R.id.txt_rating)
        val txt_title_movie = findViewById<TextView>(R.id.txt_title_movie)
        val date_movie = findViewById<TextView>(R.id.date_movie)
        val plot_movie = findViewById<TextView>(R.id.plot_movie)
        val actors_movie = findViewById<TextView>(R.id.actors_movie)
        val language_movie = findViewById<TextView>(R.id.language_movie)

        val idImdb = intent.getStringExtra("idIMDB")

        val viewModel = DetailMoveViewModel("3e974fca" , idImdb.toString() ,DataBase.getInstance(applicationContext)!!.movieDao)
        viewModel.detailMovie()

        viewModel.movieLiveData.observe(this){
            Picasso.get().load(it.Poster).into(pic_movie)
            txt_rating.text = "IMDb RATING : ${it.imdbRating}"
            txt_title_movie.text = it.Title
            date_movie.text = it.Released
            plot_movie.text = it.Plot
            actors_movie.text = it.Actors
            language_movie.text = it.Language
        }


        back.setOnClickListener{
            finish()
        }

    }
}