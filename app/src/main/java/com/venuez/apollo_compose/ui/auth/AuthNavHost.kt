package com.venuez.apollo_compose.ui.auth

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.venuez.apollo_compose.ui.nav.navigateSingleTopTo
import com.venuez.apollo_compose.ui.nav.navigateWithPopCurrentRoute
import com.venuez.apollo_compose.ui.screen.data_bundle.DataBundleScreen
import com.venuez.apollo_compose.ui.screen.home.HomeScreen
import com.venuez.apollo_compose.ui.screen.login.LoginScreen
import com.venuez.apollo_compose.ui.screen.powerload.PowerLoadScreen
import com.venuez.apollo_compose.ui.screen.stock.StockInScreen

@Composable
fun AuthNavHost(navController: NavHostController, modifier: Modifier,onTitleChange: (String) -> Unit) {
    val context = LocalContext.current

    NavHost(navController = navController, startDestination = Login.route, modifier = modifier) {
        composable(route = Login.route) {
            onTitleChange("Login")
            LoginScreen {
                navController.navigateWithPopCurrentRoute(Home.route,Login.route)
            }
        }
        composable(route = Home.route) {
            onTitleChange("Home")
            HomeScreen { navController.navigateSingleTopTo(StockIn.route) }
        }
        composable(route = StockIn.route) {
            onTitleChange("Stock In")
            StockInScreen { navController.navigateSingleTopTo(DataBundle.route) }
        }
        composable(route = DataBundle.route) {
            onTitleChange("Data Bundle")
            DataBundleScreen{navController.navigateSingleTopTo(PowerLoad.route)}
        }
        composable(route = PowerLoad.route) {
            onTitleChange("Power Load")
            PowerLoadScreen()
        }
    }
}
