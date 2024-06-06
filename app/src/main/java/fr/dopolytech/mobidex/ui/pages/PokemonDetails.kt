package fr.dopolytech.mobidex.ui.pages

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.FilterQuality
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import fr.dopolytech.mobidex.ui.MyViewModel
import kotlin.math.abs

@Composable
fun PokemonDetails(
    viewModel: MyViewModel,
    pokemonId: String,
) {
  val pokemonIdInt = pokemonId.toInt()
  LaunchedEffect(pokemonIdInt) { viewModel.fetchPokemon(pokemonIdInt) }
  val pokemon = viewModel.pokemon.collectAsState().value

  val sensor = viewModel.sensor.collectAsState().value
  val initPitch = remember { sensor.pitch }
  val initRoll = remember { sensor.roll }

  val sprite = remember { mutableStateOf(pokemon?.sprites?.frontDefault) }

  if (abs(initPitch - sensor.pitch) > 25 || abs(initRoll - sensor.roll) > 25) {
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
      Text(text = "Pokemon:${pokemon.name}")
      AsyncImage(
          model = sprite.value,
          contentDescription = "${pokemon.name} default sprite",
          contentScale = ContentScale.Fit,
          filterQuality = FilterQuality.High,
          modifier = Modifier.width(200.dp).height(200.dp),
      )
    }
  }
}
