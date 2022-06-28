package com.olvera.store.ui

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.olvera.store.repository.StoreRepository
import io.reactivex.disposables.CompositeDisposable

class HomeViewModel(private val storeRepository: StoreRepository): ViewModel() {

    val storeList = storeRepository.getStores()

}