package com.study.duckapi.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.study.duckapi.domain.model.DuckModel
import com.study.duckapi.domain.repository.DuckRepository
import com.study.duckapi.domain.util.ResourceState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel@Inject constructor(
    private val duckRepository: DuckRepository
): ViewModel() {

    private val _duckState: MutableLiveData<ResourceState<DuckModel>> = MutableLiveData()
    val duckState: LiveData<ResourceState<DuckModel>> = _duckState

    init {
        fetchDuckFromViewModel()
    }

    private fun fetchDuckFromViewModel(){
        viewModelScope.launch {
            _duckState.value = duckRepository.fetchDuckApiFromRepository()
        }
    }

}