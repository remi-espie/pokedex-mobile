package fr.dopolytech.mobidex.network

import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import fr.dopolytech.mobidex.type.Pokemon
import fr.dopolytech.mobidex.type.PokemonList
import retrofit2.Retrofit
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType

import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

private const val BASE_URL = "https://pokeapi.co/api/v2/"

private val retrofit = Retrofit.Builder()
    .addConverterFactory(Json.asConverterFactory("application/json".toMediaType()))
    .baseUrl(BASE_URL)
    .build()


interface ApiService {
    @GET("pokemon")
    suspend fun getAllPokemon(): PokemonList

    @GET("pokemon/{id}")
    suspend fun getPokemon(@Path("id") id: Int): Pokemon

    @GET("pokemon")
    suspend fun getPokemonList(@Query("offset") offset: Int, @Query("limit") limit: Int): PokemonList
}

object Api {
    val service: ApiService by lazy {
        retrofit.create(ApiService::class.java)
    }
}

class ApiRepository() : ApiService {
    override suspend fun getAllPokemon(): PokemonList {
        return Api.service.getAllPokemon()
    }

    override suspend fun getPokemon(id: Int): Pokemon {
        return Api.service.getPokemon(id)
    }

    override suspend fun getPokemonList(offset: Int, limit: Int): PokemonList {
        return Api.service.getPokemonList(offset, limit)
    }
}
