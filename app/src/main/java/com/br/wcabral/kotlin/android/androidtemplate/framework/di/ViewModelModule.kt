package com.br.wcabral.kotlin.android.androidtemplate.framework.di

import com.br.wcabral.kotlin.android.androidtemplate.presentation.router.Router
import com.br.wcabral.kotlin.android.androidtemplate.presentation.ui.items.ItemsViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {

    viewModel { (router: Router) ->
        ItemsViewModel(
            loadItemsUseCase = get(),
            router = router
        )
    }

}