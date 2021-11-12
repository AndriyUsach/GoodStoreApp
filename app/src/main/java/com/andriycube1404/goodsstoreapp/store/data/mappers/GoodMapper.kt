package com.andriycube1404.goodsstoreapp.store.data.mappers

import android.content.Context
import androidx.core.content.ContextCompat
import com.andriycube1404.goodsstoreapp.store.data.entities.GoodEntity
import com.andriycube1404.goodsstoreapp.store.domain.model.Good

fun Good.toGoodEntity(): GoodEntity {
    return GoodEntity(
        name = this.name,
        price = this.price,
        series = this.series,
        imageId = this.imageId
    )
}

fun GoodEntity.toGood(context: Context): Good {
    return Good(
        name = this.name,
        price = this.price,
        series = this.series,
        imageId = this.imageId,
        image = ContextCompat.getDrawable(context, this.imageId)
    )
}
