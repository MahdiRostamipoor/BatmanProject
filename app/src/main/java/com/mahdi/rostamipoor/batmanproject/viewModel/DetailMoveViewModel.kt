package com.mahdi.rostamipoor.batmanproject.viewModel

import androidx.lifecycle.MutableLiveData
import com.mahdi.rostamipoor.batmanproject.app.BatmanSingleObservable
import com.mahdi.rostamipoor.batmanproject.app.BatmanViewModel
import com.mahdi.rostamipoor.batmanproject.database.DataDao
import com.mahdi.rostamipoor.batmanproject.model.DetailMovieModel
import com.mahdi.rostamipoor.batmanproject.service.ApiClient
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class DetailMoveViewModel(val apiKey : String ,val id : String , val dataDao: DataDao) : BatmanViewModel() {

    val movieLiveData = MutableLiveData<DetailMovieModel>()

    init {
        ApiClient().getDetailMovie(apiKey , id)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(object : BatmanSingleObservable<DetailMovieModel>(compositeDisposable){
                override fun onSuccess(t: DetailMovieModel) {
                    movieLiveData.value = t
                    dataDao.addDetailMovie(t)
                }
            })
    }

    fun detailMovie(){

        if (dataDao.listDetailMovie(id)!=null){
            movieLiveData.value =dataDao.listDetailMovie(id)
        }

    }

}