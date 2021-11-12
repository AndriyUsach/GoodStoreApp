package com.andriycube1404.goodsstoreapp.store.presentation.good_store.adapters

import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding

abstract class BaseViewHolder<out V: ViewBinding, T: Item>(
    val binding: V
) : RecyclerView.ViewHolder(binding.root) {

    abstract fun onBind(item: T)
}