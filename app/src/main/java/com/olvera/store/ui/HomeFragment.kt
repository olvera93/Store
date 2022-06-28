package com.olvera.store.ui

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.GeneratedAdapter
import androidx.lifecycle.Observer
import com.olvera.store.R
import com.olvera.store.StoreApplication
import com.olvera.store.databinding.FragmentHomeBinding
import com.olvera.store.databinding.ItemStoreBinding
import com.olvera.store.util.BaseViewModelFragment

class HomeFragment : Fragment() {

    private lateinit var adapter: HomeAdapter
    private lateinit var viewModel: HomeViewModel
    private lateinit var binding: FragmentHomeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_home,
            container,
            false
        )

        viewModel = HomeViewModel(
            (requireContext().applicationContext as StoreApplication).storeRepository
        )

        binding.lifecycleOwner = this
        binding.storeListViewModel = viewModel

        getStores()

        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        getStores()
    }

    private fun getStores() {
        if (viewModel != null) {
            adapter = HomeAdapter(viewModel)
            binding.list.adapter = adapter

            viewModel.storeList.observe(viewLifecycleOwner, Observer {
                it?.let {
                    adapter.submitList(it)
                }
            })
        }
    }

}