package fr.dopolytech.mobidex.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import fr.dopolytech.mobidex.type.Pokemon
import kotlinx.coroutines.flow.Flow

@Dao
interface PokemonDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(pokemon: Pokemon)

    @Update
    suspend fun update(pokemon: Pokemon)

    @Delete
    suspend fun delete(pokemon: Pokemon)

    @Query("SELECT * from pokemon WHERE id = :id")
    fun getPokemon(id: Int): Flow<Pokemon>

    @Query("SELECT * from pokemon")
    fun getAllPokemons(): Flow<List<Pokemon>>
}