package fr.dopolytech.mobidex.ui.pages

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import fr.dopolytech.mobidex.ui.MyViewModel

@Composable
fun PokemonDetails(
    viewModel: MyViewModel,
    pokemon: String,
) {
    viewModel.fetchPokemon(pokemon.toInt())
    val pkm = viewModel.pokemon.collectAsState().value

    Column {
        if (pkm != null) {
            Text(text = "Pokemon:${pkm.name}")
        }
    }
}
