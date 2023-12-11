package com.venuez.apollo_compose.ui.screen.home

import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.venuez.apollo_compose.ui.screen.home.compoenent.DashboardMenu
import com.venuez.apollo_compose.ui.screen.home.compoenent.ProfileHeader

@Composable
fun HomeScreen(
    viewModel: HomeViewModel = hiltViewModel(), onStockClick: () -> Unit = {},
) {
    Column(Modifier.fillMaxSize()) {
        ProfileHeader(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight()
        )
        DashboardMenu(
            modifier = Modifier.fillMaxSize(), onStockClick
        )
    }
}
