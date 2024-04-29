package fr.dopolytech.mobidex.data

import fr.dopolytech.mobidex.type.Pokemon
import kotlinx.coroutines.flow.Flow

interface PokemonRepository {
    /**
     * Retrieve all the pokemons from the given data source.
     */
    fun getAllPokemonsStream(): Flow<List<Pokemon>>

    /**
     * Retrieve an pokemon from the given data source that matches with the [id].
     */
    fun getPokemonStream(id: Int): Flow<Pokemon?>

    /**
     * Insert pokemon in the data source
     */
    suspend fun insertPokemon(pokemon: Pokemon)

    /**
     * Delete pokemon from the data source
     */
    suspend fun deletePokemon(pokemon: Pokemon)

    /**
     * Update pokemon in the data source
     */
    suspend fun updatePokemon(pokemon: Pokemon)
}