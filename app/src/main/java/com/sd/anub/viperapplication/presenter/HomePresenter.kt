package com.sd.anub.viperapplication.presenter


import android.util.Log
import com.sd.anub.viperapplication.entity.ImageModel
import com.sd.anub.viperapplication.interactor.HomeInteractor
import com.sd.anub.viperapplication.viper.HomeContract

class HomePresenter(private var view: HomeContract.View) : HomeContract.Presenter, HomeContract.InteractorOutput {



    override fun onGetImageSuccess(image: ArrayList<ImageModel>) {
        view.showImages(image)
    }


    private var interactor: HomeContract.Interactor? = HomeInteractor()   // 2

    override fun onViewCreated() {
        interactor?.getImageCall { result ->
            if (result.isNotEmpty()) {
                onGetImageSuccess(result)
            } else {
                Log.i("error", "Error occurred")
                onGetImageError("error")
            }
        }
    }

    override fun onDestroy() {
        interactor = null
    }

    override fun onGetImageError(message: String) {
        view.showError(message)
    }

}
