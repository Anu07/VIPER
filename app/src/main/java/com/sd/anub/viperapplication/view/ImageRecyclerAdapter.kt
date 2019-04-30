package com.sd.anub.viperapplication.view

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.sd.anub.viperapplication.R
import com.sd.anub.viperapplication.entity.ImageModel
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.image_item.view.*


class ImageRecyclerAdapter(val items: ArrayList<ImageModel>?, val context: Context?) :
    RecyclerView.Adapter<ImageRecyclerAdapter.ImageViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImageViewHolder {
       return ImageViewHolder(LayoutInflater.from(context).inflate(R.layout.image_item, parent, false))
    }

    override fun getItemCount(): Int {
        return 100
    }

    override fun onBindViewHolder(holder: ImageViewHolder, position: Int) {
        if(items!!.size>0){
            Log.e("Url",""+items!![position].url)
            Picasso.get()
                .load(items!!.get(position).url)
                .placeholder(R.drawable.ic_placeholder)
                .error(R.drawable.ic_placeholder)
                .resize(150,150)
                .into(holder?.imgView)

            holder.txtView.text = "Color_"+items!!.get(position).id
        }

    }


    class ImageViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        // Holds the TextView that will add each animal to
        val imgView = view.img
        val txtView = view.titleTxt
    }

}