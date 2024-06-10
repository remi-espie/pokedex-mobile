package fr.dopolytech.mobidex.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Card
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.FilterQuality
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.capitalize
import androidx.compose.ui.text.intl.Locale
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import fr.dopolytech.mobidex.type.Pokemon

@Composable
fun PokemonDetails(pokemon: Pokemon) {
    Surface(modifier = Modifier.fillMaxSize()) {
        Card(modifier = Modifier.padding(8.dp)) {
            Row {
                AsyncImage(
                    model = pokemon.sprites.frontDefault,
                    contentDescription = "${pokemon.name} default sprite",
                    contentScale = ContentScale.Fit,
                    filterQuality = FilterQuality.High,
                    modifier = Modifier
                        .width(200.dp)
                        .height(200.dp),
                )
                Column(modifier = Modifier.padding(0.dp, 20.dp)) {
                    Text(text = pokemon.name.capitalize(Locale.current), fontSize = 24.sp)
                }
            }
        }
    }

}
