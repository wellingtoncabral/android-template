package com.br.wcabral.kotlin.android.androidtemplate.domain.interactor

import com.br.wcabral.kotlin.android.androidtemplate.domain.entity.Item
import com.br.wcabral.kotlin.android.androidtemplate.domain.repository.ItemRepository

class RemoveItemUseCase(private val itemRepository: ItemRepository) {

    suspend operator fun invoke(item: Item) {
        itemRepository.removeItem(item)
    }
}
