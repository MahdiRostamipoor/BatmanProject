package com.mahdi.rostamipoor.batmanproject.app

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import io.reactivex.SingleObserver
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import timber.log.Timber

abstract class BatmanViewModel : ViewModel(){
    val compositeDisposable= CompositeDisposable()
    val loading= MutableLiveData<Boolean>()

    override fun onCleared() {
        super.onCleared()
        compositeDisposable.clear()
    }
}

abstract class BatmanSingleObservable <T>(val compositeDisposable: CompositeDisposable) :
    SingleObserver<T> {

    override fun onSubscribe(d: Disposable) {
        compositeDisposable.add(d)
    }

    override fun onError(e: Throwable) {
        Timber.e("error server -> $e")
    }

}