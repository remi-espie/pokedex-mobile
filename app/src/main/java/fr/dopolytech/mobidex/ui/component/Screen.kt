package fr.dopolytech.mobidex.ui.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import fr.dopolytech.mobidex.ui.MyViewModel
import fr.dopolytech.mobidex.ui.theme.MobidexTheme

@Composable
fun Screen(viewModel: MyViewModel) {
    val uiState by viewModel.uiState.collectAsState()

    MobidexTheme {
        // A surface container using the 'background' color from the theme
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            Column {
                Text(text = "Pokemon count:" + uiState.pokemonList.count.toString())
                LazyVerticalGrid(
                    columns = GridCells.Fixed(2),
                    contentPadding = PaddingValues(horizontal = 16.dp, vertical = 16.dp),
                    ) {
                    items(uiState.pokemonList.results) { pokemon ->
                        Box {
                            Text(text = pokemon.name)
                        }
                    }
                }
            }
        }
    }
}