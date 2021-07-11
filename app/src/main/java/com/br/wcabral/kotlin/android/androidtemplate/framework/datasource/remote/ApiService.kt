package com.br.wcabral.kotlin.android.androidtemplate.framework.datasource.remote

import com.br.wcabral.kotlin.android.androidtemplate.framework.datasource.remote.entity.Item
import retrofit2.http.*

interface ApiService {

    @GET("items")
    suspend fun loadItems(): List<Item>

    @GET("items/{itemId}")
    suspend fun loadItem(@Path("itemId") itemId: Long): Item?

    @POST("items")
    suspend fun addItem(item: Item)

    @PUT("items")
    suspend fun updateItem(item: Item)

    @DELETE("items")
    suspend fun removeItem(item: Item)
}
