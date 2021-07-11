package com.br.wcabral.kotlin.android.androidtemplate.framework.di

import com.br.wcabral.kotlin.android.androidtemplate.presentation.ui.main.MainViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {

    viewModel {
        MainViewModel(
            loadItemsUseCase = get()
        )
    }

}