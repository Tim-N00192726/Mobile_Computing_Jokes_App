package com.example.mc_ca

import android.util.Log
import androidx.lifecycle.*
import com.example.mc_ca.data.TeamEntity
import com.example.mc_ca.dataaccess.RetrofitInstance
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {

    // MutableLiveData - means this list can be changed at runtime
    // Note!!! _plants above is private, only visible here the underscore represents variables not exposed to the UI layer (fragments)
    private val _jokes: MutableLiveData<List<TeamEntity>> = MutableLiveData()

    // Plants is exposed to the UI - Fragment
    val jokes: LiveData<List<TeamEntity>>
        // get() This is a getter() function, which returns the list of plants as LiveData
        get() = _jokes

    private val _isLoading = MutableLiveData(false)
    val isLoading: LiveData<Boolean>
        get() = _isLoading


    // No Longer get the data from SampleDataProvider
    init {
//        // here we get the plant list data to share with the user interface
        getJokes()
    }

    private fun getJokes() {
        // web-access so run in a background thread - Coroutine
        viewModelScope.launch {
            _isLoading.value = true
            val fetchedJokes = RetrofitInstance.api.getJokes()
            Log.i(TAG, "List of Teams : $fetchedJokes")
            _jokes.value = fetchedJokes
            _isLoading.value = false
        }
    }
}