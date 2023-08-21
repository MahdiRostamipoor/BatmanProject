package com.mahdi.rostamipoor.batmanproject.viewModel

import android.content.Context
import androidx.lifecycle.MutableLiveData
import com.mahdi.rostamipoor.batmanproject.app.BatmanSingleObservable
import com.mahdi.rostamipoor.batmanproject.app.BatmanViewModel
import com.mahdi.rostamipoor.batmanproject.database.DataDao
import com.mahdi.rostamipoor.batmanproject.model.MoviesModel
import com.mahdi.rostamipoor.batmanproject.service.ApiClient
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class ListMovieViewModel(val apiKey : String,val s : String , val context : Context,val dataDao : DataDao) : BatmanViewModel(){

    val listMoviesLiveData = MutableLiveData<MoviesModel>()

    init {
        ApiClient().getMovies(apiKey,s)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(object : BatmanSingleObservable<MoviesModel>(compositeDisposable){
                override fun onSuccess(t: MoviesModel) {
                    dataDao.addListMovie(t.Search)
                    val moviesModel = MoviesModel(dataDao.listMovie)
                    listMoviesLiveData.value = moviesModel
                }
            })
    }

    fun getMovies(){

        val moviesModel = MoviesModel(dataDao.listMovie)
        listMoviesLiveData.value = moviesModel

    }

}