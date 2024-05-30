package fr.dopolytech.mobidex.navigator

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import fr.dopolytech.mobidex.R
import fr.dopolytech.mobidex.ui.MyViewModel
import fr.dopolytech.mobidex.ui.pages.PokemonDetails
import fr.dopolytech.mobidex.ui.pages.Screen

@Composable
fun navHost(viewModel: MyViewModel, navController: NavHostController = rememberNavController()) {
  // Get current back stack entry
  val backStackEntry by navController.currentBackStackEntryAsState()
  // Get the name of the current screen
  val currentScreen =
      navScreen.valueOf(backStackEntry?.destination?.route ?: navScreen.StartPage.name)

  Scaffold(
      topBar = {
        MobidexAppBar(
            currentScreen = currentScreen,
            canNavigateBack = navController.previousBackStackEntry != null,
            navigateUp = { navController.navigateUp() })
      }) { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = navScreen.StartPage.name,
            modifier =
                Modifier.fillMaxSize()
                    .verticalScroll(rememberScrollState())
                    .padding(innerPadding)) {
              composable(route = navScreen.StartPage.name) { Screen(viewModel = viewModel) }
              composable(route = navScreen.DetailPage.name) {
                val context = LocalContext.current
                PokemonDetails(viewModel = viewModel, pokemon = context.resources.getString(id))
              }
            }
      }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MobidexAppBar(
    currentScreen: navScreen,
    canNavigateBack: Boolean,
    navigateUp: () -> Unit,
    modifier: Modifier = Modifier
) {
  TopAppBar(
      title = { Text(stringResource(currentScreen.title)) },
      colors =
          TopAppBarDefaults.mediumTopAppBarColors(
              containerColor = MaterialTheme.colorScheme.primaryContainer),
      modifier = modifier,
      navigationIcon = {
        if (canNavigateBack) {
          IconButton(onClick = navigateUp) {
            Icon(
                imageVector = Icons.Filled.ArrowBack,
                contentDescription = stringResource(R.string.back_button))
          }
        }
      })
}
