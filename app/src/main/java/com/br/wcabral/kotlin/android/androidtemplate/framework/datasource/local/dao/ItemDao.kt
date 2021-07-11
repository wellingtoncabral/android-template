package com.br.wcabral.kotlin.android.androidtemplate.framework.datasource.local.dao

import androidx.room.*
import com.br.wcabral.kotlin.android.androidtemplate.framework.datasource.local.entity.Item
import kotlinx.coroutines.flow.Flow

@Dao
interface ItemDao {
    @Query("SELECT * FROM tb_items")
    fun loadItems(): Flow<List<Item>>

    @Query("SELECT * FROM tb_items WHERE id = :itemId")
    fun loadItem(itemId: Long): Flow<Item?>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addItem(item: Item)

    @Update
    suspend fun updateItem(item: Item)

    @Update
    suspend fun removeItem(item: Item)
}
