package com.venuez.apollo_compose.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.style.TextAlign
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.venuez.apollo_compose.ui.auth.AuthNavHost
import com.venuez.apollo_compose.ui.auth.Home
import com.venuez.apollo_compose.ui.auth.Login
import com.venuez.apollo_compose.ui.theme.ApolloComposeTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AuthActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Authentication()
        }
    }

}

@Composable
fun Authentication() {
    ApolloComposeTheme {

        val navController = rememberNavController()
        val isOnTop =
            navController.currentBackStackEntryAsState().value?.destination?.route.let {  it == Login.route || it == Home.route}

        var title by remember {
            mutableStateOf("")
        }

        Scaffold(contentColor = MaterialTheme.colorScheme.background,
            topBar = { if (!isOnTop) AuthTopAppBar(navController, title) }) { innerPadding ->
            AuthNavHost(
                navController = navController,
                modifier = Modifier.padding(innerPadding)
            ) { title = it }
        }
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AuthTopAppBar(navController: NavHostController, title: String) {
    TopAppBar(colors = TopAppBarDefaults.topAppBarColors(containerColor = MaterialTheme.colorScheme.primary),
        title = {
            Text(
                modifier = Modifier.fillMaxWidth(),
                text = title,
                style = MaterialTheme.typography.titleLarge,
                color = MaterialTheme.colorScheme.onPrimary,
                textAlign = TextAlign.Center
            )
        },
        actions = {},
        navigationIcon = {
            if (navController.previousBackStackEntry != null) {
                IconButton(onClick = { navController.navigateUp() }) {
                    Icon(
                        imageVector = Icons.Filled.ArrowBack,
                        contentDescription = "Back",
                        tint = MaterialTheme.colorScheme.onPrimary
                    )
                }
            }
        })

}

enum class NavigationBarItems(val route: String, val icon: ImageVector) {
    Menu(route = "menu", icon = Icons.Default.List), Home(
        route = "home", icon = Icons.Filled.Home
    ),
    Complaints(route = "complaints", icon = Icons.Default.ShoppingCart), Alerts(
        route = "alerts",
        icon = Icons.Default.Notifications
    )
}



