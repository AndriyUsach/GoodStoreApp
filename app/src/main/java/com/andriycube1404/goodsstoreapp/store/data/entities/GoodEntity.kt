package com.andriycube1404.goodsstoreapp.store.data.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class GoodEntity(
    @ColumnInfo(name = "good_name") val name: String,
    @ColumnInfo(name = "good_price") val price: Float,
    @ColumnInfo(name = "good_series") val series: String,
    @ColumnInfo(name = "good_image") val imageId: Int,
    @PrimaryKey(autoGenerate = true) @ColumnInfo(name = "id") val id: Long = 0
)