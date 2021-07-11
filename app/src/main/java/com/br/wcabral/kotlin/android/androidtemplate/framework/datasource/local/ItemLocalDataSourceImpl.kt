package com.br.wcabral.kotlin.android.androidtemplate.framework.datasource.local

import com.br.wcabral.kotlin.android.androidtemplate.data.model.ItemData
import com.br.wcabral.kotlin.android.androidtemplate.data.source.ItemLocalDataSource
import com.br.wcabral.kotlin.android.androidtemplate.framework.datasource.local.dao.ItemDao
import com.br.wcabral.kotlin.android.androidtemplate.framework.datasource.local.mapper.toData
import com.br.wcabral.kotlin.android.androidtemplate.framework.datasource.local.mapper.toEntity
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class ItemLocalDataSourceImpl(
    private val itemDao: ItemDao
) : ItemLocalDataSource {

    override fun loadItems(): Flow<List<ItemData>> {
        return itemDao.loadItems().map { items ->
            items.map { it.toData() }
        }
    }

    override fun loadItem(itemId: Long): Flow<ItemData?> {
        return itemDao.loadItem(itemId).map { item ->
            item?.toData()
        }
    }

    override suspend fun addItem(itemData: ItemData) {
        itemDao.addItem(itemData.toEntity())
    }

    override suspend fun updateItem(itemData: ItemData) {
        itemDao.updateItem(itemData.toEntity())
    }

    override suspend fun removeItem(itemData: ItemData) {
        itemDao.removeItem(itemData.toEntity())
    }
}
