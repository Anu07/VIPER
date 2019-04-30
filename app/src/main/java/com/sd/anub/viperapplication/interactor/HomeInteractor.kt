package com.sd.anub.viperapplication.interactor

import com.sd.anub.viperapplication.entity.ImageModel
import com.sd.anub.viperapplication.network.ApiService
import com.sd.anub.viperapplication.viper.HomeContract
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers

class HomeInteractor : HomeContract.Interactor {


    private var disposable: Disposable? = null
    val apiService by lazy {
        ApiService.create()
    }

    override fun getImageCall(interactorOutput:  (result: ArrayList<ImageModel>) -> Unit) {
        disposable = apiService.getImages()
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
            .subscribe(
                { result -> interactorOutput(result as ArrayList<ImageModel>) },
                { "error" }
            )
    }
}