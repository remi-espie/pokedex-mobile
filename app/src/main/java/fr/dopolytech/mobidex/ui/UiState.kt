package fr.dopolytech.mobidex.ui

import fr.dopolytech.mobidex.type.PokemonList


data class UiState(
    var text: String = "Mobidex: a mobile Pokedex",
    var pokemonList: PokemonList = PokemonList()
)