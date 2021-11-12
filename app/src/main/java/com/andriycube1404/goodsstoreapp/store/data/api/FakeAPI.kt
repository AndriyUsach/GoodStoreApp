package com.andriycube1404.goodsstoreapp.store.data.api

import android.content.Context
import android.graphics.drawable.Drawable
import androidx.core.content.ContextCompat
import com.andriycube1404.goodsstoreapp.R
import com.andriycube1404.goodsstoreapp.store.domain.model.Good

class FakeAPI(private val context: Context) {

    private val names = listOf(
        "tulip",
        "sunflower",
        "rose",
        "poppy",
        "peony",
        "marigold",
        "lily",
        "lilac",
        "freesia",
        "daisy",
        "dahlia",
        "daffodil"
    )

    private val imagesId = listOf(
        R.drawable.daffodil,
        R.drawable.dahlia,
        R.drawable.daisy,
        R.drawable.freesia,
        R.drawable.lilac,
        R.drawable.lily,
        R.drawable.marigold,
        R.drawable.peony,
        R.drawable.poppy,
        R.drawable.rose,
        R.drawable.sunflower,
        R.drawable.tulip
    )

    private val series = listOf(
        "Design",
        "Story",
    )

    fun getData(): List<Good> {
        return List(10) {
            getRandomGood()
        }
    }

    private fun getRandomGood(): Good {
        val randomImage = getImage()
        return Good(
            name = getRandomName(),
            price = getRandomPrice(),
            series = getRandomSeries(),
            image = randomImage.first,
            imageId = randomImage.second
        )
    }

    private fun getRandomPrice(): Float {
        return (1.0 + Math.random() * 2).toFloat()
    }

    private fun getRandomName(): String {
        return names.random()
    }

    private fun getImage(): Pair<Drawable?, Int> {
        val id = getRandomImageId()
        return Pair(ContextCompat.getDrawable(context, id), id)
    }

    private fun getRandomImageId(): Int {
        return imagesId.random()
    }

    private fun getRandomSeries(): String {
        return series.random()
    }
}