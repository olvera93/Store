package com.olvera.store.ui.addStore

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.olvera.store.R
import com.olvera.store.StoreApplication
import com.olvera.store.databinding.FragmentAddStoreBinding

class AddStoreFragment : Fragment() {

    private lateinit var viewModel: AddStoreViewModel
    private lateinit var binding: FragmentAddStoreBinding

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
            R.layout.fragment_add_store,
            container,
            false
        )
        viewModel = AddStoreViewModel(
            (requireContext().applicationContext as StoreApplication).storeRepository
        )

        binding.lifecycleOwner = this
        binding.viewModel = viewModel

        binding.btnAdd.setOnClickListener {
            viewModel.newStore()
        }

        setupNavigation()

        return binding.root
    }

    fun setupNavigation() {
        viewModel.storeDone.observe(viewLifecycleOwner, Observer {
            if (it) {
                findNavController().navigate(
                    R.id.action_addFragment_to_storeListFragment
                )
            }
        })
    }
}