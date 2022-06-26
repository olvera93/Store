package com.olvera.store.util

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

abstract class BaseFragment<viewBinding: ViewDataBinding, viewModel: ViewModel>: Fragment() {

    lateinit var viewDataBinding: viewBinding
    lateinit var viewModel: viewModel

    abstract fun getViewBinding(): Int
    abstract fun getViewModel(): Class<viewModel>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(this)[getViewModel()]
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewDataBinding = DataBindingUtil.inflate(inflater, getViewBinding(), container, false)
        return viewDataBinding.root
    }

}