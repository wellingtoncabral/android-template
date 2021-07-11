package com.br.wcabral.kotlin.android.androidtemplate.data.source

import com.br.wcabral.kotlin.android.androidtemplate.data.model.ItemData
import kotlinx.coroutines.flow.Flow

interface ItemLocalDataSource {
    fun loadItems(): Flow<List<ItemData>>
    fun loadItem(itemId: Long): Flow<ItemData?>
    suspend fun addItem(itemData: ItemData)
    suspend fun updateItem(itemData: ItemData)
    suspend fun removeItem(itemData: ItemData)
}
