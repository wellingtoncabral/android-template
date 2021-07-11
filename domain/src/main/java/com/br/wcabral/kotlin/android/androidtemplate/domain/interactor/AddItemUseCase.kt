package com.br.wcabral.kotlin.android.androidtemplate.domain.interactor

import com.br.wcabral.kotlin.android.androidtemplate.domain.entity.Item
import com.br.wcabral.kotlin.android.androidtemplate.domain.interactor.base.UseCase
import com.br.wcabral.kotlin.android.androidtemplate.domain.repository.ItemRepository

class AddItemUseCase(private val itemRepository: ItemRepository): UseCase<Unit, Item>() {

    override suspend fun run(params: Item) {
        itemRepository.addItem(params)
    }

}
