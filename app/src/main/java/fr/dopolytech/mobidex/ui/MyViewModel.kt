package fr.dopolytech.mobidex.ui

import android.hardware.Sensor
import android.hardware.SensorManager
import androidx.compose.ui.platform.LocalContext
import androidx.core.content.ContextCompat
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import fr.dopolytech.mobidex.data.PokemonRepository
import fr.dopolytech.mobidex.network.ApiRepository
import fr.dopolytech.mobidex.type.Pokemon
import fr.dopolytech.mobidex.type.RotationSensorType
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class MyViewModel(private val pokemonRepository: PokemonRepository) : ViewModel() {
    private val _uiState = MutableStateFlow(UiState())
    val uiState: StateFlow<UiState> = _uiState.asStateFlow()

    private val _pokemon = MutableStateFlow<Pokemon?>(null)
    val pokemon: StateFlow<Pokemon?> = _pokemon.asStateFlow()

    private val _sensor = MutableStateFlow(RotationSensorType())
    val sensor: StateFlow<RotationSensorType> = _sensor.asStateFlow()

    init {
        getAllPokemon()
    }

    private fun getAllPokemon() {
        viewModelScope.launch {
            try {
                val response = ApiRepository().getAllPokemon()
                _uiState.value = UiState(pokemonList = response)
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }

    fun addFavoritePokemon(url: String) {
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

    fun updatePokemonList(offset: Int, limit: Int = 20) {
        viewModelScope.launch {
            try {
                val response = ApiRepository().getPokemonList(offset, limit)
                response.results = _uiState.value.pokemonList.results + response.results
                _uiState.value = UiState(pokemonList = response)
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }

    fun fetchPokemon(id: Int) {
        _pokemon.value = null
        viewModelScope.launch {
            try {
                val response = ApiRepository().getPokemon(id)
                _pokemon.value = response
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }

    fun setRotation(pitch: Float, roll: Float) {
        _sensor.value = RotationSensorType(pitch, roll)
    }
}
