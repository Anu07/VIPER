package com.sd.anub.viperapplication.viper

import com.sd.anub.viperapplication.entity.ImageModel

interface HomeContract {

    interface View {
        fun showImages(image: ArrayList<ImageModel>)
        fun showError(message: String)
    }

    interface Presenter {
        fun onDestroy()
        fun onViewCreated()
    }

    interface Interactor {
        fun getImageCall(interactorOutput:  (result: ArrayList<ImageModel>) -> Unit)
    }

    interface InteractorOutput {
        fun onGetImageSuccess(image: ArrayList<ImageModel>)
        fun onGetImageError(message: String)
    }

}