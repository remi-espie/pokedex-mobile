package fr.dopolytech.mobidex

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import fr.dopolytech.mobidex.data.AppContainer
import fr.dopolytech.mobidex.data.AppDataContainer
import fr.dopolytech.mobidex.ui.MyViewModel
import fr.dopolytech.mobidex.ui.pages.Screen
import fr.dopolytech.mobidex.ui.theme.MobidexTheme

class MainActivity : ComponentActivity() {

    lateinit var container: AppContainer
    lateinit var viewModel: MyViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        container = AppDataContainer(this)
        viewModel = MyViewModel(container.pokemonRepository)
        setContent {
            MobidexTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Screen(viewModel = viewModel)
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MobidexTheme {
        Text(text = "Mobidex: a mobile Pokedex")
    }
}