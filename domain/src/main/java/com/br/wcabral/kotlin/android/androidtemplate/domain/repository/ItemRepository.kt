package com.br.wcabral.kotlin.android.androidtemplate.domain.repository

import com.br.wcabral.kotlin.android.androidtemplate.domain.entity.Item
import kotlinx.coroutines.flow.Flow

interface ItemRepository {
    fun loadItems(): Flow<List<Item>>
    fun loadItem(itemId: Long): Flow<Item?>
    suspend fun addItem(item: Item)
    suspend fun updateItem(item: Item)
    suspend fun removeItem(item: Item)
}
