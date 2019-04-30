package com.sd.anub.viperapplication.network

import com.sd.anub.viperapplication.entity.ImageModel
import io.reactivex.Observable
import retrofit2.http.GET

interface ApiService {

        @GET("photos")
        fun getImages(): Observable<List<ImageModel>>


    /**
     * Companion object for the factory
     */
    companion object Factory {
        fun create(): ApiService {
            val retrofit = retrofit2.Retrofit.Builder()
                .addCallAdapterFactory(retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory.create())
                .addConverterFactory(retrofit2.converter.gson.GsonConverterFactory.create())
                .baseUrl("https://jsonplaceholder.typicode.com/")
                .build()

            return retrofit.create(ApiService::class.java)
        }
    }
}