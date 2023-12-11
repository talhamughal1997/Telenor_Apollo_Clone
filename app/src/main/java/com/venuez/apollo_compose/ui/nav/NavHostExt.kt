package com.venuez.apollo_compose.ui.nav

import androidx.navigation.NavHostController


fun NavHostController.navigateSingleTopTo(route: String) =
    this.navigate(route) { launchSingleTop = true }


fun NavHostController.navigateWithPopCurrentRoute(
    route: String, popUpToRoute: String
) {
    this.navigate(route) {
        popUpTo(popUpToRoute) {
            inclusive = true
        }
    }
}