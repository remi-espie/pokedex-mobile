package fr.dopolytech.mobidex.data

import android.content.Context

/**
 * App container for Dependency injection.
 */
interface AppContainer {
    val pokemonRepository: PokemonRepository
}

/**
 * [AppContainer] implementation that provides instance of [OfflinePokemonRepository]
 */
class AppDataContainer(private val context: Context) : AppContainer {
    /**
     * Implementation for [PokemonRepository]
     */
    override val pokemonRepository: PokemonRepository by lazy {
        OfflinePokemonRepository(InventoryDatabase.getDatabase(context).pokemonDao())
    }

}
