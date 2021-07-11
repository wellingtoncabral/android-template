package com.br.wcabral.kotlin.android.androidtemplate.framework.datasource.local.mapper

import com.br.wcabral.kotlin.android.androidtemplate.data.model.ItemData
import com.br.wcabral.kotlin.android.androidtemplate.framework.datasource.local.entity.Item as ItemEntity

fun ItemData.toEntity() = ItemEntity(
    id,
    title,
    isDone
)

fun ItemEntity.toData() = ItemData(
    id,
    title,
    isDone
)
