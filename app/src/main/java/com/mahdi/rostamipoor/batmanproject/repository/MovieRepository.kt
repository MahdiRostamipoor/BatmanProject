package com.mahdi.rostamipoor.batmanproject.repository

import com.mahdi.rostamipoor.batmanproject.app.BatmanSingleObservable
import com.mahdi.rostamipoor.batmanproject.model.MoviesModel
import com.mahdi.rostamipoor.batmanproject.service.ApiClient
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class MovieRepository {

    fun refreshData(apiKey : String, s : String) {

        /*ApiClient().getMovies(apiKey,s)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(object : BatmanSingleObservable<MoviesModel>(compositeDisposable){
                override fun onSuccess(t: MoviesModel) {
                    listMoviesLiveData.value = t
                }
            })*/
    }

}