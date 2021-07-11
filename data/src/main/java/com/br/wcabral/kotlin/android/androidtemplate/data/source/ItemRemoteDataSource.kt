package com.br.wcabral.kotlin.android.androidtemplate.data.source

import com.br.wcabral.kotlin.android.androidtemplate.data.model.ItemData

interface ItemRemoteDataSource {
    suspend fun loadItems(): List<ItemData>
    suspend fun loadItem(itemId: Long): ItemData?
    suspend fun addItem(itemData: ItemData)
    suspend fun updateItem(itemData: ItemData)
    suspend fun removeItem(itemData: ItemData)
}
