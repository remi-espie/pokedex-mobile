package fr.dopolytech.mobidex.network

import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import fr.dopolytech.mobidex.type.PokemonList
import retrofit2.Retrofit
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType

import retrofit2.http.GET

private const val BASE_URL = "https://pokeapi.co/api/v2/"

private val retrofit = Retrofit.Builder()
    .addConverterFactory(Json.asConverterFactory("application/json".toMediaType()))
    .baseUrl(BASE_URL)
    .build()


interface ApiService {
    @GET("pokemon")
    suspend fun getAllPokemon(): PokemonList
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
}