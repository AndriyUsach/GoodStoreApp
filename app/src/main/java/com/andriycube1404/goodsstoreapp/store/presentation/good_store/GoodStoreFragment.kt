package com.andriycube1404.goodsstoreapp.store.presentation.good_store

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.andriycube1404.goodsstoreapp.R
import com.andriycube1404.goodsstoreapp.databinding.FragmentGoodStoreBinding
import com.andriycube1404.goodsstoreapp.store.presentation.good_store.adapters.Element
import com.andriycube1404.goodsstoreapp.store.presentation.good_store.adapters.GoodStoreAdapter
import com.andriycube1404.goodsstoreapp.store.presentation.good_store.adapters.Item
import com.andriycube1404.goodsstoreapp.store.presentation.good_store.adapters.elements.GoodOneElement
import com.andriycube1404.goodsstoreapp.store.presentation.good_store.adapters.elements.GoodTwoElement
import com.andriycube1404.goodsstoreapp.store.presentation.good_store.adapters.elements.TitleElement
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest

@AndroidEntryPoint
class GoodStoreFragment : Fragment() {

    private lateinit var binding: FragmentGoodStoreBinding
    private val viewModel: GoodStoreViewModel by viewModels()

    lateinit var adapter: GoodStoreAdapter
    lateinit var mLayoutManager: GridLayoutManager
    lateinit var goodList: List<Item>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentGoodStoreBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        adapter = GoodStoreAdapter(getElementList())
        mLayoutManager = GridLayoutManager(requireContext(), 2, RecyclerView.VERTICAL, false)
        mLayoutManager.spanSizeLookup = object : GridLayoutManager.SpanSizeLookup() {
            override fun getSpanSize(position: Int): Int {
                val type = adapter.getItemViewType(position)
                return when(type) {
                    R.layout.item_title -> 2
                    else -> 1
                }
            }

        }
        binding.goodRecycler.apply {
            adapter = this@GoodStoreFragment.adapter
            layoutManager = mLayoutManager
        }

        lifecycleScope.launchWhenStarted {
            viewModel.goodList.collectLatest {
                if (it.isNotEmpty()) {
                    println("list length: ${it.size}")
                    adapter.submitList(it)
                }
            }
        }
    }


    private fun getElementList(): List<Element<*, *>> {
        return listOf(
            TitleElement(),
            GoodOneElement(),
            GoodTwoElement()
        )
    }
}