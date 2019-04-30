package com.sd.anub.viperapplication.view

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.sd.anub.viperapplication.R
import com.sd.anub.viperapplication.entity.ImageModel
import com.sd.anub.viperapplication.network.ApiService
import com.sd.anub.viperapplication.presenter.HomePresenter
import com.sd.anub.viperapplication.viper.HomeContract
import io.reactivex.Observable
import timber.log.Timber

class HomeFragment : Fragment(), HomeContract.View {

    private lateinit var mAdapter: ImageRecyclerAdapter
    lateinit var v: View
    var ImgsList: ArrayList<ImageModel>? = ArrayList()
    lateinit var recyclerView: RecyclerView
    private var presenter: HomeContract.Presenter? =  HomePresenter(this)


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        v = inflater.inflate(R.layout.content_main, container, false)
        initView()
        return v
    }


    private fun initView() {
        recyclerView = activity?.findViewById<View>(R.id.imgGrid) as RecyclerView
        recyclerView.setHasFixedSize(true)
        mAdapter= ImageRecyclerAdapter(ImgsList, context)
        recyclerView.adapter = mAdapter
        recyclerView.layoutManager = GridLayoutManager(activity,3)
        recyclerView.itemAnimator = DefaultItemAnimator()
    }


    override fun showImages(image: ArrayList<ImageModel>) {
        Log.e("List size",""+image.size)
        ImgsList?.addAll(image)
        mAdapter.notifyDataSetChanged()
    }


    override fun onResume() {
        super.onResume()
        presenter?.onViewCreated()
    }


    override fun showError(message: String) {
        Timber.e(message)
    }


    override fun onDestroy() {
        presenter?.onDestroy()
        presenter = null
        super.onDestroy()
    }
}

