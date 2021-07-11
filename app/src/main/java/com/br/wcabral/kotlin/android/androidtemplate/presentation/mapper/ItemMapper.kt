package com.br.wcabral.kotlin.android.androidtemplate.presentation.mapper

import com.br.wcabral.kotlin.android.androidtemplate.domain.entity.Item
import com.br.wcabral.kotlin.android.androidtemplate.presentation.binding.Item as ItemEntity

fun ItemEntity.toDomainModel() = Item(
    id,
    title,
    isDone
)

fun Item.toEntity() = ItemEntity().apply {
    id = this@toEntity.id
    title = this@toEntity.title
    isDone = this@toEntity.isDone
}
