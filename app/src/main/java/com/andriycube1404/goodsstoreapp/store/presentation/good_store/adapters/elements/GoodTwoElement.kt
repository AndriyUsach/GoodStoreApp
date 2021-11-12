package com.andriycube1404.goodsstoreapp.store.presentation.good_store.adapters.elements

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import com.andriycube1404.goodsstoreapp.R
import com.andriycube1404.goodsstoreapp.databinding.ItemGood2Binding
import com.andriycube1404.goodsstoreapp.store.domain.enums.Titles
import com.andriycube1404.goodsstoreapp.store.domain.model.Good
import com.andriycube1404.goodsstoreapp.store.presentation.good_store.adapters.BaseViewHolder
import com.andriycube1404.goodsstoreapp.store.presentation.good_store.adapters.Element
import com.andriycube1404.goodsstoreapp.store.presentation.good_store.adapters.Item
import com.andriycube1404.goodsstoreapp.store.presentation.good_store.adapters.viewholders.GoodTwoViewHolder

class GoodTwoElement : Element<ItemGood2Binding, Good> {
    override fun getViewHolder(
        layoutInflater: LayoutInflater,
        parent: ViewGroup
    ): BaseViewHolder<ItemGood2Binding, Good> {
        val binding = ItemGood2Binding.inflate(layoutInflater, parent, false)
        return GoodTwoViewHolder(binding)
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
            return item.series.lowercase() == Titles.Story.title.title.lowercase()
        }
        return false
    }

    override fun getLayoutId(): Int {
        return R.layout.item_good_2
    }
}