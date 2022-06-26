package com.olvera.store.ui

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.olvera.store.R
import com.olvera.store.util.BaseViewModelFragment

class HomeFragment : BaseViewModelFragment<HomeViewModel>() {

    override fun getViewModel(): Class<HomeViewModel> = HomeViewModel::class.java


}