package com.sd.anub.viperapplication.entity

import com.google.gson.annotations.SerializedName

data class ImageModel(
    @SerializedName("albumId")
    var albumId: Int = 0,

    @SerializedName("title")
    var title: String? = null,

    @SerializedName("url")
    var url: String? = null,

    @SerializedName("id")
    var id: String? = null,

    @SerializedName("thumbnailUrl")
    var thumbnailUrl: String? = null
)

