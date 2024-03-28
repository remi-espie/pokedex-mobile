package fr.dopolytech.mobidex.type

import kotlinx.serialization.Serializable

@Serializable
data class PokemonList(
    var count: Int = 0,
    var next: String? = null,
    var previous: String? = null,
    var results: List<ListedPokemon> = listOf()
)

@Serializable
data class ListedPokemon(
    var name: String = "",
    var url: String = ""
)
