package com.tomcz.coroutinesplayground

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

class Foo : ViewModel() {

    val state: MutableStateFlow<Int> = MutableStateFlow(0)

    init {
        viewModelScope.launch {
            state.value = 1
            state.value = 2
            delay(1)
            state.value = 3
            state.value = 4
            state.value = 5
            delay(1)
            state.value = 6
            delay(1)
            state.value = 7
        }
    }
}
