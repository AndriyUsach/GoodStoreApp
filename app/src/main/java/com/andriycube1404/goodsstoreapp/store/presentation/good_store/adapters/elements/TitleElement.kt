package com.andriycube1404.goodsstoreapp.store.presentation.good_store.adapters.elements

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import com.andriycube1404.goodsstoreapp.R
import com.andriycube1404.goodsstoreapp.databinding.ItemTitleBinding
import com.andriycube1404.goodsstoreapp.store.domain.model.Title
import com.andriycube1404.goodsstoreapp.store.presentation.good_store.adapters.BaseViewHolder
import com.andriycube1404.goodsstoreapp.store.presentation.good_store.adapters.Element
import com.andriycube1404.goodsstoreapp.store.presentation.good_store.adapters.Item
import com.andriycube1404.goodsstoreapp.store.presentation.good_store.adapters.viewholders.TitleViewHolder

class TitleElement() : Element<ItemTitleBinding, Title> {
    override fun getViewHolder(
        layoutInflater: LayoutInflater,
        parent: ViewGroup
    ): BaseViewHolder<ItemTitleBinding, Title> {
        val binding = ItemTitleBinding.inflate(layoutInflater, parent, false)
        return TitleViewHolder(binding)
    }

    private val diffUtil = object : DiffUtil.ItemCallback<Title>() {
        override fun areItemsTheSame(oldItem: Title, newItem: Title): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: Title, newItem: Title): Boolean {
            return oldItem == newItem
        }
    }

    override fun getDiffUtil(): DiffUtil.ItemCallback<Title> {
        return diffUtil
    }

    override fun isRelativeItem(item: Item): Boolean {
        return item is Title
    }

    override fun getLayoutId(): Int {
        return R.layout.item_title
    }
}