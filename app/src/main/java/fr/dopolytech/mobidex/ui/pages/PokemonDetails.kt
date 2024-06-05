package fr.dopolytech.mobidex.ui.pages

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.width
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import fr.dopolytech.mobidex.ui.MyViewModel

@Composable
fun PokemonDetails(
    viewModel: MyViewModel,
    pokemonId: String,
) {
    val pokemonIdInt = pokemonId.toInt()
    LaunchedEffect(pokemonIdInt) { viewModel.fetchPokemon(pokemonIdInt) }
    val pokemon = viewModel.pokemon.collectAsState().value

  Column {
    if (pokemon == null) {
      CircularProgressIndicator(
          modifier = Modifier.width(64.dp),
          color = MaterialTheme.colorScheme.secondary,
          trackColor = MaterialTheme.colorScheme.surfaceVariant,
      )
    } else {
      Text(text = "Pokemon:${pokemon.name}")
    }
  }
}
