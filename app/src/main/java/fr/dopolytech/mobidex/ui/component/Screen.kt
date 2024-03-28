package fr.dopolytech.mobidex.ui.component

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
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
                Text(text = uiState.text)
                Button(onClick = { viewModel.updateText(uiState.text+1) }) {
                    Text(text = "Change text")
                }
            }
        }
    }
}