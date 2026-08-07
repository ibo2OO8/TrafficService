package com.ibrohimapk3.trafficservice.screen

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class ServiceViewModel : ViewModel() {

    private val _selectedIndex = MutableStateFlow(0)

    val selectedIndex = _selectedIndex.asStateFlow()

    fun changeIndex(index: Int) {
        _selectedIndex.value = index
    }
}