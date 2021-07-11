package com.br.wcabral.kotlin.android.androidtemplate.framework.di

import com.br.wcabral.kotlin.android.androidtemplate.data.repository.ItemRepositoryImpl
import com.br.wcabral.kotlin.android.androidtemplate.domain.repository.ItemRepository
import org.koin.dsl.module

val repositoryModule = module {

    // Repositories
    single<ItemRepository> { ItemRepositoryImpl(
        itemLocalDataSource = get(),
//        itemRemoteDataSource = get(),
    )}

}