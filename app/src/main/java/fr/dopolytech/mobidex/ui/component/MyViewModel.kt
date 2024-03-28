package fr.dopolytech.mobidex.ui.component

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class MyViewModel : ViewModel() {
    private val _uiState = MutableStateFlow(UiState(text = "Mobidex: a mobile Pokedex"))
    val uiState: StateFlow<UiState> = _uiState.asStateFlow()

    fun updateText(text: String) {
        _uiState.value = UiState(text = text)
    }

}