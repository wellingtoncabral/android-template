package com.br.wcabral.kotlin.android.androidtemplate.framework.datasource.remote.entity

import com.google.gson.annotations.SerializedName

data class Item(
    @SerializedName("id")
    var id: Long = 0,

    @SerializedName("title")
    var title: String = "",

    @SerializedName("is_done")
    var isDone: Boolean = false
)
