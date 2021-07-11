package com.br.wcabral.kotlin.android.androidtemplate.data.mapper

import com.br.wcabral.kotlin.android.androidtemplate.domain.entity.Item
import com.br.wcabral.kotlin.android.androidtemplate.data.model.ItemData as ItemEntity

fun ItemEntity.toDomainModel() = Item(
    id,
    title,
    isDone
)

fun Item.toEntity() = ItemEntity(
    id,
    title,
    isDone
)
