package fr.dopolytech.mobidex.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import fr.dopolytech.mobidex.data.PokemonRepository
import fr.dopolytech.mobidex.network.ApiRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class MyViewModel(private val pokemonRepository: PokemonRepository) : ViewModel() {
    private val _uiState = MutableStateFlow(UiState())
    val uiState: StateFlow<UiState> = _uiState.asStateFlow()

    fun updateText(text: String) {
        _uiState.value = UiState(text = text)
    }

    init {
        getAllPokemon()
    }

    private fun getAllPokemon() {
        viewModelScope.launch {
            try {
                val response = ApiRepository().getAllPokemon()
                for (pokemon in response.results) {
                    getPokemon(pokemon.url)
                }
                _uiState.value = UiState(pokemonList = response)
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }

    suspend fun getPokemon(url: String) {
        viewModelScope.launch {
            try {
                val id = url.split("/")[6].toInt()
                val response = ApiRepository().getPokemon(id)
                pokemonRepository.insertPokemon(response)
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }
}
