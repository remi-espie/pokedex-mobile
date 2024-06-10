package fr.dopolytech.mobidex.ui.pages

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.width
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import fr.dopolytech.mobidex.ui.MyViewModel
import kotlin.math.abs
import fr.dopolytech.mobidex.ui.components.PokemonDetails

@Composable
fun PokemonDetailsPage(
    viewModel: MyViewModel,
    pokemonId: String,
) {
  val pokemonIdInt = pokemonId.toInt()
  LaunchedEffect(pokemonIdInt) { viewModel.fetchPokemon(pokemonIdInt) }
  val pokemon = viewModel.pokemon.collectAsState().value

  val sensor = viewModel.sensor.collectAsState().value
  val initAzimuth = remember { sensor.azimuth }

  val sprite = remember { mutableStateOf(pokemon?.sprites?.frontDefault) }

  if (abs(initAzimuth - sensor.azimuth) > 22.5) {
    sprite.value = pokemon?.sprites?.backDefault
  } else {
    sprite.value = pokemon?.sprites?.frontDefault
  }

  Column {
    if (pokemon == null) {
      CircularProgressIndicator(
          modifier = Modifier.width(64.dp),
          color = MaterialTheme.colorScheme.secondary,
          trackColor = MaterialTheme.colorScheme.surfaceVariant,
      )
    } else {
      PokemonDetails(pokemon = pokemon)
    }
  }
}
