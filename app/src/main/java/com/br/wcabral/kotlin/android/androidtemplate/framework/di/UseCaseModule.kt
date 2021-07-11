package com.br.wcabral.kotlin.android.androidtemplate.framework.di

import com.br.wcabral.kotlin.android.androidtemplate.domain.interactor.AddItemUseCase
import com.br.wcabral.kotlin.android.androidtemplate.domain.interactor.LoadItemsUseCase
import org.koin.dsl.module

val useCaseModule = module {

    factory { LoadItemsUseCase(itemRepository = get()) }
    factory { AddItemUseCase( itemRepository = get()) }

}