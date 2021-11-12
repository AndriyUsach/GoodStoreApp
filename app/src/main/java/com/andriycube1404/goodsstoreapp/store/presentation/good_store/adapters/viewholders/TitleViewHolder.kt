package com.andriycube1404.goodsstoreapp.store.presentation.good_store.adapters.viewholders

import com.andriycube1404.goodsstoreapp.databinding.ItemTitleBinding
import com.andriycube1404.goodsstoreapp.store.domain.model.Title
import com.andriycube1404.goodsstoreapp.store.presentation.good_store.adapters.BaseViewHolder

class TitleViewHolder(
    binding: ItemTitleBinding
) : BaseViewHolder<ItemTitleBinding, Title>(binding) {

    override fun onBind(item: Title) {
        binding.title.text = item.title
        binding.description.text = item.description
    }
}