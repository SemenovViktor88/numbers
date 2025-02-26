package com.semenov.numbers.ui.mainscreen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.semenov.data.model.EntityNumber
import com.semenov.data.repository.NumbersRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NumbersViewModel @Inject constructor(
    private val repository: NumbersRepository
) : ViewModel() {

    private val _history = MutableStateFlow<List<EntityNumber>>(emptyList())
    val history: StateFlow<List<EntityNumber>> = _history.asStateFlow()

    fun loadHistory() {
        viewModelScope.launch {
            repository.getAllNumbers().collect{
                _history.value = it
            }
        }
    }

    fun getFactForNumber(number: Int) {
        viewModelScope.launch {
            repository.getNumber(number)
            loadHistory()
        }
    }

    fun getRandomFact() {
        viewModelScope.launch {
            repository.getRandomNumber()
        }
    }
}