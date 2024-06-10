package fr.dopolytech.mobidex.navigator

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import fr.dopolytech.mobidex.ui.MyViewModel
import fr.dopolytech.mobidex.ui.design.BannerWrapper
import fr.dopolytech.mobidex.ui.pages.PokemonDetailsPage
import fr.dopolytech.mobidex.ui.pages.Screen

@Composable
fun MainNav(viewModel: MyViewModel, navController: NavHostController = rememberNavController()) {
//  // Get current back stack entry
//  val backStackEntry by navController.currentBackStackEntryAsState()
//  // Get the name of the current screen
//  val currentScreen = backStackEntry?.destination?.route?.let { route ->
//    navScreen.entries.find { it.name == route }
//  } ?: navScreen.StartPage

    Scaffold(
//      topBar = {
//        MobidexAppBar(
//            currentScreen = currentScreen,
//            canNavigateBack = navController.previousBackStackEntry != null,
//            navigateUp = { navController.navigateUp() })
//      }
    ) { innerPadding ->
        BannerWrapper {
            NavHost(
                navController = navController,
                startDestination = navScreen.StartPage.name,
                modifier =
                Modifier
                    .fillMaxSize()
                    .verticalScroll(rememberScrollState())
                    .padding(innerPadding)
            ) {
                composable(route = navScreen.StartPage.name) {
                    Screen(viewModel = viewModel, navController)
                }
                composable(
                    route = navScreen.DetailPage.name + "/{pokemonId}",
                    arguments = listOf(navArgument("pokemonId") { type = NavType.StringType })
                ) { navBackStackEntry ->
                    val pokemonId = navBackStackEntry.arguments?.getString("pokemonId")!!
                    PokemonDetailsPage(viewModel = viewModel, pokemonId = pokemonId)
                }
            }
        }
    }
}

//@OptIn(ExperimentalMaterial3Api::class)
//@Composable
//fun MobidexAppBar(
//    currentScreen: navScreen,
//    canNavigateBack: Boolean,
//    navigateUp: () -> Unit,
//    modifier: Modifier = Modifier
//) {
//  TopAppBar(
//      title = { Text(stringResource(currentScreen.title)) },
//      colors =
//          TopAppBarDefaults.mediumTopAppBarColors(
//              containerColor = MaterialTheme.colorScheme.primaryContainer),
//      modifier = modifier,
//      navigationIcon = {
//        if (canNavigateBack) {
//          IconButton(onClick = navigateUp) {
//            Icon(
//                imageVector = Icons.Filled.ArrowBack,
//                contentDescription = stringResource(R.string.back_button))
//          }
//        }
//      })
//}
