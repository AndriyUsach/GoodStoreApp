package com.andriycube1404.goodsstoreapp.store.domain.model

import com.andriycube1404.goodsstoreapp.store.presentation.good_store.adapters.Item

data class Title(
    val title: String,
    val description: String
) : Item