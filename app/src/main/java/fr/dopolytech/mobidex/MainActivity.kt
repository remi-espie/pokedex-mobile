package fr.dopolytech.mobidex

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.ViewModel
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import fr.dopolytech.mobidex.ui.theme.MobidexTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MobidexTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Screens()
                }
            }
        }
    }
}

class MyViewModel: ViewModel() {
    var compteur by mutableIntStateOf(0)
    fun increment() {
        compteur++
    }
}

@Composable
fun Screens() {
    val navController = rememberNavController()

    val viewModel = remember { MyViewModel() }

    NavHost(navController = navController, startDestination = "Screen1") {
        composable("Screen1") {
            Screen1(navController, viewModel)
        }
        composable("Screen2") {
            Screen2(navController, viewModel)
        }
    }
}

@Composable
fun Screen1(navController: NavController, viewModel: MyViewModel) {

    Column {
        Text(text = "Screen 1")
        Text(text = "value: ${viewModel.compteur}")
        Button(onClick = { viewModel.increment() }) {
            Text("+1")
        }
        Button(onClick = { navController.navigate("Screen2") }) {
            Text("Go to Screen 2")
        }
    }
}

@Composable
fun Screen2(navController: NavController, viewModel: MyViewModel) {

    Column {
        Text(text = "Screen 2")
        Text(text = "value: ${viewModel.compteur}")
        Button(onClick = { viewModel.increment() }) {
            Text("+1")
        }
        Button(onClick = { navController.navigate("Screen1") }) {
            Text("Go to Screen 1")
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