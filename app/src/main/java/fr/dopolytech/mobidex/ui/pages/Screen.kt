package fr.dopolytech.mobidex.ui.pages

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import fr.dopolytech.mobidex.ui.MyViewModel
import fr.dopolytech.mobidex.ui.components.ListedPokemonCard

@Composable
fun Screen(viewModel: MyViewModel, navController: NavHostController) {
  val uiState by viewModel.uiState.collectAsState()

  Column (modifier = Modifier.height(40.dp)) {
    Text(text = "Pokemon count:" + uiState.pokemonList.count.toString())
    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        contentPadding = PaddingValues(horizontal = 16.dp, vertical = 16.dp),
        horizontalArrangement = Arrangement.spacedBy(10.dp),
        verticalArrangement = Arrangement.spacedBy(10.dp)) {
          items(uiState.pokemonList.results) { pokemon -> ListedPokemonCard(pokemon = pokemon, navController = navController) }
        }
  }
}
