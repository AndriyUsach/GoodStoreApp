package com.andriycube1404.goodsstoreapp.store.presentation.good_store.adapters.viewholders

import android.annotation.SuppressLint
import com.andriycube1404.goodsstoreapp.databinding.ItemGood2Binding
import com.andriycube1404.goodsstoreapp.store.domain.model.Good
import com.andriycube1404.goodsstoreapp.store.presentation.good_store.adapters.BaseViewHolder
import kotlin.math.round

class GoodTwoViewHolder(
    binding: ItemGood2Binding
) : BaseViewHolder<ItemGood2Binding, Good>(binding) {

    @SuppressLint("SetTextI18n")
    override fun onBind(item: Good) {
        with(binding) {
            goodName.text = item.name
            goodPrice.text = "$${round(item.price * 100) / 100}"
            goodImage.setImageDrawable(item.image)
        }
    }
}