package com.udacity.shoestore

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.udacity.shoestore.models.Shoe

class ShoeStoreViewModel : ViewModel() {

    private val _shoeList = MutableLiveData<MutableList<Shoe>>(
        mutableListOf(
            Shoe("Stan Smith", 9.5, "Adidas", "Description"),
            Shoe("Suede", 8.0, "Puma", "Description")
        )
    )

    val shoeList: LiveData<MutableList<Shoe>>
        get() = _shoeList

    val shoeToAddName = MutableLiveData<String>()
    val shoeToAddCompany = MutableLiveData<String>()
    val shoeToAddDescription = MutableLiveData<String>()
    val shoeToAddSize = MutableLiveData<String>()

    fun addShoe(): Boolean {
        return _shoeList.value?.add(
            Shoe(
                shoeToAddName.value ?: "",
                shoeToAddSize.value?.toDouble() ?: 0.0,
                shoeToAddCompany.value ?: "",
                shoeToAddDescription.value ?: ""
            )
        ) ?: false
    }

}