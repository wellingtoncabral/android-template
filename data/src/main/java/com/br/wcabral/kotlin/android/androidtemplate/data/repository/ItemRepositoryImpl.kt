package com.br.wcabral.kotlin.android.androidtemplate.data.repository

import com.br.wcabral.kotlin.android.androidtemplate.data.mapper.toDomainModel
import com.br.wcabral.kotlin.android.androidtemplate.data.mapper.toEntity
import com.br.wcabral.kotlin.android.androidtemplate.data.source.ItemLocalDataSource
import com.br.wcabral.kotlin.android.androidtemplate.domain.entity.Item
import com.br.wcabral.kotlin.android.androidtemplate.domain.repository.ItemRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class ItemRepositoryImpl(
    private val itemLocalDataSource: ItemLocalDataSource,
//    private val itemRemoteDataSource: ItemRemoteDataSource,
) : ItemRepository {

    override fun loadItems(): Flow<List<Item>> {
        return itemLocalDataSource.loadItems().map { items ->
            items.map {
                it.toDomainModel()
            }
        }
    }

    override fun loadItem(itemId: Long): Flow<Item?> {
        return itemLocalDataSource.loadItem(itemId).map { itemData ->
            itemData?.toDomainModel()
        }
    }

    override suspend fun addItem(item: Item) {
        itemLocalDataSource.addItem(item.toEntity())
    }

    override suspend fun updateItem(item: Item) {
        itemLocalDataSource.updateItem(item.toEntity())
    }

    override suspend fun removeItem(item: Item) {
        itemLocalDataSource.removeItem(item.toEntity())
    }
}
