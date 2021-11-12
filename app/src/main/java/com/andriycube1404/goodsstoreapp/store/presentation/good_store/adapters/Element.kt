package com.andriycube1404.goodsstoreapp.store.presentation.good_store.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.recyclerview.widget.DiffUtil
import androidx.viewbinding.ViewBinding

interface Element<V: ViewBinding, T: Item> {

    fun isRelativeItem(item: Item): Boolean

    fun getLayoutId(): Int

    fun getViewHolder(
        layoutInflater: LayoutInflater,
        parent: ViewGroup
    ): BaseViewHolder<V, T>

    fun getDiffUtil(): DiffUtil.ItemCallback<T>
}