package fr.dopolytech.mobidex.ui.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.FilterQuality
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.capitalize
import androidx.compose.ui.text.intl.Locale
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import fr.dopolytech.mobidex.type.Pokemon

@Composable
fun PokemonDetails(pokemon: Pokemon, sprite: String? = null) {
    Column(
        modifier = Modifier.fillMaxSize().padding(25.dp, 35.dp),
        verticalArrangement = Arrangement.spacedBy(35.dp)
    ) {
        DetailsCard(pokemon = pokemon, sprite = sprite)
        StatsCard(pokemon = pokemon)
    }
}

@Composable
private fun DetailsCard(pokemon: Pokemon, sprite: String? = null) {


    Card(modifier = Modifier.fillMaxWidth()) {
        Row {
            // Picture
            AsyncImage(
                model = sprite,
                contentDescription = "${pokemon.name} default sprite",
                contentScale = ContentScale.Fit,
                filterQuality = FilterQuality.High,
                modifier = Modifier
                    .width(200.dp)
                    .height(200.dp),
            )
            Column(modifier = Modifier.padding(0.dp, 20.dp)) {
                // Name and ID
                Text(text = pokemon.name.capitalize(Locale.current), fontSize = 24.sp)
                Text(text = "ID ${pokemon.id}")

                Spacer(modifier = Modifier.height(20.dp))

                // Types
                Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                    for (type in pokemon.types.listIterator()) {
                        val colours = determineTypeColour(type.type.name)
                        Text(
                            text = type.type.name.replace("-", " "),
                            modifier = Modifier
                                .background(
                                    color = Color(colours[0]),
                                    shape = RoundedCornerShape(20.dp)
                                )
                                .border(
                                    border = BorderStroke(2.dp, Color(colours[1])),
                                    shape = RoundedCornerShape(20.dp)
                                )
                                .padding(8.dp, 4.dp)
                        )
                    }
                }
            }
        }
    }
}

@Composable
private fun StatsCard(pokemon: Pokemon) {
    Card(
        modifier = Modifier
            .height(150.dp)
    ) {
        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            modifier = Modifier.padding(10.dp),
            verticalArrangement = Arrangement.Center,
        ) {
            itemsIndexed(pokemon.stats) {
                _, stat ->
                Text(
                    text = "${stat.stat.name.capitalize(Locale.current).replace("-", " ")}: ${stat.baseStat}",
                    modifier = Modifier.fillMaxWidth().align(Alignment.CenterHorizontally)
                )
            }
        }
    }
}

fun determineTypeColour(name: String): List<Long> {
    return when (name) {
        "bug" -> listOf(0xff389a52, 0xff184e23)
        "dark" -> listOf(0xff5a5979, 0xff040706)
        "dragon" -> listOf(0xff5fcdd6, 0xff458a95)
        "electric" -> listOf(0xfffefb75, 0xffe4e430)
        "fairy" -> listOf(0xffe81469, 0xff9a1748)
        "fighting" -> listOf(0xffef6138, 0xff963f24)
        "fire" -> listOf(0xfffd4c5a, 0xffaa2222)
        "flying" -> listOf(0xff94b3c9, 0xff4a677d)
        "ghost" -> listOf(0xff95658e, 0xff323266)
        "grass" -> listOf(0xff27cb4d, 0xff147b3f)
        "ground" -> listOf(0xff6f481f, 0xffa87331)
        "ice" -> listOf(0xffd8f0fa, 0xff7ecdee)
        "normal" -> listOf(0xffca98a7, 0xff734f59)
        "poison" -> listOf(0xff9a68d8, 0xff5d2b8b)
        "psychic" -> listOf(0xfff61d91, 0xffa5286d)
        "rock" -> listOf(0xff893e25, 0xff4c160d)
        "steel" -> listOf(0xff41be94, 0xff517a6c)
        "water" -> listOf(0xff86a8fc, 0xff1851e0)
        else -> listOf(0xffffffff, 0xffffffff)
    }
}
