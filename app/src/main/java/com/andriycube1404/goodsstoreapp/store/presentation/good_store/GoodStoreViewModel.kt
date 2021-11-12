package com.andriycube1404.goodsstoreapp.store.presentation.good_store

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.andriycube1404.goodsstoreapp.store.domain.enums.Titles
import com.andriycube1404.goodsstoreapp.store.domain.model.Good
import com.andriycube1404.goodsstoreapp.store.domain.repository.GoodsStoreRepository
import com.andriycube1404.goodsstoreapp.store.presentation.good_store.adapters.Item
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class GoodStoreViewModel @Inject constructor(
    private val repository: GoodsStoreRepository
): ViewModel() {

    private val _goodList = MutableStateFlow<List<Item>>(emptyList())
    val goodList: StateFlow<List<Item>>
        get() = _goodList

    init {
        refreshGoodList()
    }

    private fun refreshGoodList() {
        viewModelScope.launch {
            repository.getGoods().collectLatest { it ->
                println("size parent : ${it.size}")
                val goods = mutableListOf<Item>()
                for (title in Titles.values()) {
                    println(title)
                    val topicGoods = it.filter {
                        it.series.lowercase() == title.title.title.lowercase()
                    }
                    if (topicGoods.isNotEmpty()) {
                        goods.add(title.title)
                        topicGoods.forEach {
                            goods.add(it)
                        }
                    }
                }
                _goodList.value = goods
            }
        }
    }

    fun refreshGoodList(search: String? = null) {
        viewModelScope.launch {
            repository.getGoods().collectLatest {
                val items = mutableListOf<Item>()
                for (series in Titles.values()) {
                    val seriesGood = it.filter { good ->
                        good.series.lowercase() == series.title.title.lowercase() &&
                                filtering(search, good.name)
                    }
                    if (seriesGood.isNotEmpty()) {
                        items.add(series.title)
                        items.addAll(seriesGood)
                    }
                }
                _goodList.value = items
            }
        }
    }


    private fun filtering(search: String?, name: String): Boolean {
        if (search.isNullOrEmpty()) return true
        return name.contains(search)
    }
}
