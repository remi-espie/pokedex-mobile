package fr.dopolytech.mobidex.ui.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import fr.dopolytech.mobidex.navigator.navScreen
import fr.dopolytech.mobidex.type.ListedPokemon
import fr.dopolytech.mobidex.ui.theme.MobidexTheme

@Composable
fun ListedPokemonCard(pokemon: ListedPokemon,
                      navController: NavHostController = rememberNavController()
) {
    ElevatedCard (modifier = Modifier.clickable { }, onClick = {

        navController.navigate(navScreen.DetailPage.name)
    }) {
        Surface(
            modifier = Modifier.padding(40.dp)
        ) {
            Text("name: ${pokemon.name}")
        }
    }
}

@Composable
@Preview(showBackground = true)
fun ListedPokemonCardPreview() {
    val pokemon = ListedPokemon()
    pokemon.name = "test"

    MobidexTheme {
        ListedPokemonCard(pokemon)
    }
}
