package com.venuez.apollo_compose.ui.screen.stock

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.venuez.apollo_compose.ui.screen.stock.national.NationalScreen
import kotlinx.coroutines.launch

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun StockInScreen(
    viewModel: StockInViewModel = hiltViewModel(),
    onClick: () -> Unit = {}
) {
    val tabData = listOf(
        "National",
        "Regional"
    )
    val pagerState = rememberPagerState(
        initialPage = 0,
    )
    val tabIndex = pagerState.currentPage
    val coroutineScope = rememberCoroutineScope()

    Column(modifier = Modifier.fillMaxSize()) {

        TabRow(
            selectedTabIndex = tabIndex,
            modifier = Modifier.padding(top = 0.dp)
        ) {
            tabData.forEachIndexed { index, text ->
                Tab(selected = tabIndex == index, onClick = {
                    coroutineScope.launch {
                        pagerState.animateScrollToPage(index)
                    }
                }, text = {
                    Text(text = text, style = MaterialTheme.typography.titleMedium)
                })
            }
        }


        HorizontalPager(
            state = pagerState,
            pageCount = tabData.size
        ) { index ->

            NationalScreen(modifier = Modifier.fillMaxSize(),onClick)

        }

    }


}