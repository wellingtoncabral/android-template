package com.br.wcabral.kotlin.android.androidtemplate.framework.di

import androidx.room.Room
import com.br.wcabral.kotlin.android.androidtemplate.data.source.ItemLocalDataSource
import com.br.wcabral.kotlin.android.androidtemplate.framework.datasource.local.ItemLocalDataSourceImpl
import com.br.wcabral.kotlin.android.androidtemplate.framework.datasource.local.RoomLocalDatabase
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module

val localDataSourceModule = module {

    // Room Database
    single {
        Room.databaseBuilder(
            androidApplication(),
            RoomLocalDatabase::class.java,
            "MyDatabase.db"
        ).build()
    }

    // Daos
    factory { get<RoomLocalDatabase>().getItemDao() }

    // Data sources
    factory<ItemLocalDataSource> { ItemLocalDataSourceImpl(
        itemDao = get()
    )}
}
