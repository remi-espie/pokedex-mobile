package fr.dopolytech.mobidex.data

import fr.dopolytech.mobidex.type.Pokemon

class OfflinePokemonRepository(private val pokemonDao: PokemonDao): PokemonRepository {
    override fun getAllPokemonsStream() = pokemonDao.getAllPokemons()

    override fun getPokemonStream(id: Int) = pokemonDao.getPokemon(id)

    override suspend fun insertPokemon(pokemon: Pokemon) {
        pokemonDao.insert(pokemon)
    }

    override suspend fun deletePokemon(pokemon: Pokemon) {
        pokemonDao.delete(pokemon)
    }

    override suspend fun updatePokemon(pokemon: Pokemon) {
        pokemonDao.update(pokemon)
    }
}