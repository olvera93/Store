package com.olvera.store.ui.addStore

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.olvera.store.model.Store
import com.olvera.store.repository.StoreRepository
import kotlinx.coroutines.launch

class AddStoreViewModel(private val storeRepository: StoreRepository) : ViewModel() {

    private var _storeDone = MutableLiveData<Boolean>(false)
    val storeDone = _storeDone

    var name: String? = null
    var phone: String? = null
    var webSite: String? = null


    fun setName(s: CharSequence, start:Int, before: Int, count:Int){
        name = s.toString()
    }

    fun setPhone(s: CharSequence, start:Int, before: Int, count:Int){
        phone = s.toString()
    }

    fun setWebSite(s: CharSequence, start:Int, before: Int, count:Int){
        webSite = s.toString()
    }
    fun newStore() = viewModelScope.launch {
        if (!name.isNullOrBlank() && !phone.isNullOrBlank() && !webSite.isNullOrBlank()) {
            val store = Store(
                name = name!!,
                phone = phone!!,
                webSite = webSite!!
            )

            storeRepository.addStore(store)
            _storeDone.value = true
        }
    }

}