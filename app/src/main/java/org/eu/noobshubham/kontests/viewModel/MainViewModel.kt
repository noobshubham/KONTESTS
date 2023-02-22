package org.eu.noobshubham.kontests.viewModel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import org.eu.noobshubham.kontests.model.Kontests
import org.eu.noobshubham.kontests.network.ApiUtils

class MainViewModel : ViewModel() {
    var kontestsListResponse: List<Kontests> by mutableStateOf(listOf())
    var errorMessage: String by mutableStateOf("")

    init {
        getKontestsList()
    }

    fun getKontestsList() {
        viewModelScope.launch {
            // val apiService = ApiUtils.getInstance().create(ApiService::class.java)
            val apiService = ApiUtils.konestsService
            try {
                val kontestsList = apiService.getAllKontests()
                kontestsListResponse = kontestsList
            } catch (e: java.lang.Exception) {
                errorMessage = e.message.toString()
            }
        }
    }
}