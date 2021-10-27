package com.my.composeapp.ui.activity.ui.home

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.my.myapp.api.TencentNewsApiInterface
import com.my.network.TencentNetworkWithEnvelopeApi
import com.my.network.apiresponse.NetworkResponse
import kotlinx.coroutines.launch

class HomeViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is home Fragment"
    }
    val text: LiveData<String> = _text

    init {
        viewModelScope.launch {
            when (val result =
                TencentNetworkWithEnvelopeApi.getService(TencentNewsApiInterface::class.java)
                    .getNewsChannels(1, "294")) {
                is NetworkResponse.Success -> {
                    Log.e("MainActivity", "${result}")
                }
                is NetworkResponse.ApiError -> {
                    Log.e("MainActivity", "${result}")
                }
                is NetworkResponse.NetworkError -> {
                    Log.e("MainActivity", "${result}")
                }
                is NetworkResponse.UnknownError -> {
                    Log.e("MainActivity", "${result}")
                }
            }


            when (val result =
                TencentNetworkWithEnvelopeApi.getService(TencentNewsApiInterface::class.java)
                    .getProjectTree()) {
                is NetworkResponse.Success -> {
                    Log.e("MainActivity", "${result}")
                }
                is NetworkResponse.ApiError -> {
                    Log.e("MainActivity", "${result}")
                }
                is NetworkResponse.NetworkError -> {
                    Log.e("MainActivity", "${result}")
                }
                is NetworkResponse.UnknownError -> {
                    Log.e("MainActivity", "${result}")
                }
            }

        }
    }
}