package com.venuez.apollo_compose.ui.auth

interface AuthDestination {
    val route: String
}

object Login : AuthDestination {
    override val route: String = "login"
}

object Home : AuthDestination {
    override val route: String = "home"
}

object StockIn : AuthDestination {
    override val route: String = "stock_in"
}

object DataBundle : AuthDestination {
    override val route: String = "data_bundle"
}

object PowerLoad : AuthDestination {
    override val route: String = "power_load"
}
