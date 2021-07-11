package com.br.wcabral.kotlin.android.androidtemplate.domain.interactor

import com.br.wcabral.kotlin.android.androidtemplate.domain.entity.Item
import com.br.wcabral.kotlin.android.androidtemplate.domain.interactor.base.FlowUseCase
import com.br.wcabral.kotlin.android.androidtemplate.domain.repository.ItemRepository
import kotlinx.coroutines.flow.Flow

class LoadItemsUseCase(
    private val itemRepository: ItemRepository
) : FlowUseCase<List<Item>, Unit?>() {

    override fun run(params: Unit?): Flow<List<Item>> = itemRepository.loadItems()

}
