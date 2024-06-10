package fr.dopolytech.mobidex.ui.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import fr.dopolytech.mobidex.navigator.navScreen
import fr.dopolytech.mobidex.type.ListedPokemon
import fr.dopolytech.mobidex.ui.theme.MobidexTheme

@Composable
fun ListedPokemonCard(
    pokemon: ListedPokemon,
    navController: NavHostController
) {
  ElevatedCard(
      modifier = Modifier.clickable {},
      onClick = {
          val pokemonId = if (pokemon.url.last() == '/') {
              pokemon.url.dropLast(1).split("/").last()
          } else {
              pokemon.url.split("/").last()
          }
          navController.navigate(navScreen.DetailPage.name + "/$pokemonId")
      }) {
        Surface(modifier =
            Modifier.padding(40.dp)
        ) { Text("${pokemon.name} (#${pokemon.url.split("/")[pokemon.url.split("/").size-2]})") }
      }
}

@Preview(showBackground = true)
@Composable
fun ListedPokemonCardPreview() {
    val pokemon = ListedPokemon("test", "https://pokeapi.co/api/v2/pokemon/1/")
    MobidexTheme {
        Surface(modifier = Modifier.padding(15.dp)) {
            ListedPokemonCard(pokemon = pokemon, navController = rememberNavController())
        }
    }
}
