package com.br.wcabral.kotlin.android.androidtemplate.framework.datasource.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.br.wcabral.kotlin.android.androidtemplate.framework.datasource.local.dao.ItemDao
import com.br.wcabral.kotlin.android.androidtemplate.framework.datasource.local.entity.Item

@Database(entities = [Item::class], version = 1)
abstract class RoomLocalDatabase: RoomDatabase() {
    abstract fun getItemDao(): ItemDao
}
