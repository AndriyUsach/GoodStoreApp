package com.andriycube1404.goodsstoreapp.store.domain.model

import android.graphics.drawable.Drawable
import com.andriycube1404.goodsstoreapp.store.presentation.good_store.adapters.Item

data class Good(
    val name: String,
    val price: Float,
    val series: String,
    val imageId: Int,
    val image: Drawable?
): Item