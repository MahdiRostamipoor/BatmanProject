package com.mahdi.rostamipoor.batmanproject.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.mahdi.rostamipoor.batmanproject.R
import com.mahdi.rostamipoor.batmanproject.adapter.MoviesAdapter
import com.mahdi.rostamipoor.batmanproject.database.DataBase
import com.mahdi.rostamipoor.batmanproject.model.Search
import com.mahdi.rostamipoor.batmanproject.viewModel.ListMovieViewModel

class MainActivity : AppCompatActivity() , MoviesAdapter.OnClickItems{

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView = findViewById<RecyclerView>(R.id.recy_movies)
        recyclerView.layoutManager = LinearLayoutManager(this)


        val viewModel = ListMovieViewModel("3e974fca","batman",applicationContext,DataBase.getInstance(applicationContext)!!.movieDao)
        viewModel.getMovies()
        viewModel.listMoviesLiveData.observe(this){
            val adapter = MoviesAdapter(it,this)
            recyclerView.adapter = adapter
            adapter.notifyDataSetChanged()
        }

    }

    override fun onClick(model: Search) {
        startActivity(Intent(this , DetailMovie::class.java).apply {
            putExtra("idIMDB" , model.imdbID)
        })
    }
}