package org.d3if4077.galerihewan.ui.main

import android.util.Log
import androidx.lifecycle.*
import kotlinx.coroutines.launch
import org.d3if4077.galerihewan.model.ApiStatus
import org.d3if4077.galerihewan.model.Hewan
import org.d3if4077.galerihewan.network.HewanApi

class MainViewModel : ViewModel() {

    private var data = MutableLiveData<List<Hewan>>()
    private var status = MutableLiveData<ApiStatus>()

    init {
        retrieveData()
    }

    private fun retrieveData() {
        viewModelScope.launch {
            status.value = ApiStatus.LOADING
            try {
                data.value = HewanApi.service.getHewan()
                status.value = ApiStatus.SUCCESS
            } catch (e: Exception) {
                Log.d("MainViewModel", "Failure: ${e.message}")
                status.value = ApiStatus.FAILED
            }
        }
    }

    fun getData(): LiveData<List<Hewan>> = data

    fun getStatus(): LiveData<ApiStatus> = status
}