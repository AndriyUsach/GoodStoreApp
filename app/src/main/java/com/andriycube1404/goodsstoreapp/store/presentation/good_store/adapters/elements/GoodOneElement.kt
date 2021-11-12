package com.andriycube1404.goodsstoreapp.store.presentation.good_store.adapters.elements

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import com.andriycube1404.goodsstoreapp.R
import com.andriycube1404.goodsstoreapp.databinding.ItemGood1Binding
import com.andriycube1404.goodsstoreapp.store.domain.enums.Titles
import com.andriycube1404.goodsstoreapp.store.domain.model.Good
import com.andriycube1404.goodsstoreapp.store.presentation.good_store.adapters.BaseViewHolder
import com.andriycube1404.goodsstoreapp.store.presentation.good_store.adapters.Element
import com.andriycube1404.goodsstoreapp.store.presentation.good_store.adapters.Item
import com.andriycube1404.goodsstoreapp.store.presentation.good_store.adapters.viewholders.GoodOneViewHolder

class GoodOneElement() : Element<ItemGood1Binding, Good> {

    override fun getViewHolder(
        layoutInflater: LayoutInflater,
        parent: ViewGroup
    ): BaseViewHolder<ItemGood1Binding, Good> {
        val binding = ItemGood1Binding.inflate(layoutInflater, parent, false)
        return GoodOneViewHolder(binding)
    }

    private val diffUtil = object : DiffUtil.ItemCallback<Good>() {
        override fun areItemsTheSame(oldItem: Good, newItem: Good): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: Good, newItem: Good): Boolean {
            return oldItem == newItem
        }

    }

    override fun getDiffUtil(): DiffUtil.ItemCallback<Good> {
        return diffUtil
    }

    override fun isRelativeItem(item: Item): Boolean {
        if (item is Good) {
            return item.series.lowercase() == Titles.Design.title.title.lowercase()
        }
        return false
    }

    override fun getLayoutId(): Int {
        return R.layout.item_good_1
    }
}