package com.br.wcabral.kotlin.android.androidtemplate.framework.datasource.remote

import com.br.wcabral.kotlin.android.androidtemplate.data.model.ItemData
import com.br.wcabral.kotlin.android.androidtemplate.data.source.ItemRemoteDataSource
import com.br.wcabral.kotlin.android.androidtemplate.framework.datasource.remote.mapper.toData
import com.br.wcabral.kotlin.android.androidtemplate.framework.datasource.remote.mapper.toEntity

class ItemRemoteDataSourceImpl(
    private val apiService: ApiService
) : ItemRemoteDataSource {

    override suspend fun loadItems(): List<ItemData> {
        return apiService.loadItems().map { it.toData() }
    }

    override suspend fun loadItem(itemId: Long): ItemData? {
        return apiService.loadItem(itemId)?.toData()
    }

    override suspend fun addItem(itemData: ItemData) {
        apiService.addItem(itemData.toEntity())
    }

    override suspend fun updateItem(itemData: ItemData) {
        apiService.updateItem(itemData.toEntity())
    }

    override suspend fun removeItem(itemData: ItemData) {
        apiService.removeItem(itemData.toEntity())
    }
}
