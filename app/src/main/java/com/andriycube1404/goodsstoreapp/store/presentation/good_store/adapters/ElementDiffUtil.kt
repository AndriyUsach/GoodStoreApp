package com.andriycube1404.goodsstoreapp.store.presentation.good_store.adapters

import androidx.recyclerview.widget.DiffUtil

class ElementDiffUtil(
    private val elements: List<Element<*, *>>
) : DiffUtil.ItemCallback<Item>() {

    override fun areItemsTheSame(oldItem: Item, newItem: Item): Boolean {
        if (oldItem::class != newItem::class) return false

        return getItemCallback(oldItem).areItemsTheSame(oldItem, newItem)
    }

    override fun areContentsTheSame(oldItem: Item, newItem: Item): Boolean {
        if (oldItem::class != newItem::class) return false

        return getItemCallback(oldItem).areContentsTheSame(oldItem, newItem)
    }

    private fun getItemCallback(
        item: Item
    ) : DiffUtil.ItemCallback<Item> {
        return elements.find { it.isRelativeItem(item) }
            ?.getDiffUtil()
            ?.let { it as DiffUtil.ItemCallback<Item> }
            ?: throw IllegalArgumentException("DiffUtil not found for $item")
    }
}