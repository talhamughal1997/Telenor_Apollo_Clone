package com.venuez.apollo_compose.ui.screen.home.compoenent

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.GridItemSpan
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material.icons.rounded.AttachMoney
import androidx.compose.material.icons.rounded.Commit
import androidx.compose.material.icons.rounded.Sell
import androidx.compose.material.icons.rounded.Warehouse
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.DialogProperties


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DashboardMenu(modifier: Modifier = Modifier, onStockClick: () -> Unit) {
    var isShowingPopUp by remember {
        mutableStateOf(false)
    }
    if (isShowingPopUp) {
        AlertDialog(
            modifier = Modifier.padding(12.dp),
            onDismissRequest = { isShowingPopUp = false },
            properties = DialogProperties(
                usePlatformDefaultWidth = false
            )
        ) {
            PopUp()
        }
    }

    LazyVerticalGrid(modifier = modifier,
        columns = GridCells.Fixed(3),
        contentPadding = PaddingValues(vertical = 38.dp, horizontal = 8.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp),
        content = {
            item(span = { GridItemSpan(maxCurrentLineSpan) }) {
                Highlights(
                    modifier = Modifier
                        .fillMaxWidth()
                        .wrapContentHeight()
                )
            }

            item(span = { GridItemSpan(maxCurrentLineSpan) }) {
                MainMenus(modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentHeight()
                    .padding(top = 12.dp)
                    .clickable { onStockClick() })
            }

            items(items = DashboardMenuItems.values()) {
                SubMenus(
                    modifier = Modifier
                        .fillMaxWidth()
                        .wrapContentHeight()
                        .padding(top = 12.dp)
                        .clickable { /*onStockClick()*/
                            isShowingPopUp = true
                        }, icon = it.icon, title = it.title
                )
            }
        })

}

@Composable
private fun PopUp() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .background(
                color = MaterialTheme.colorScheme.surface, shape = MaterialTheme.shapes.medium
            )
            .padding(12.dp)
    ) {
        Text(
            text = "Confirmation",
            style = MaterialTheme.typography.titleLarge.copy(fontWeight = FontWeight.Medium),
            color = MaterialTheme.colorScheme.primary
        )
        Text(
            text = "Are you sure you want to transfer amount?",
            style = MaterialTheme.typography.bodyMedium,
            color = MaterialTheme.colorScheme.primary
        )

        Row(
            modifier = Modifier
                .padding(top = 12.dp)
                .fillMaxWidth()
                .wrapContentHeight()
                .background(
                    color = MaterialTheme.colorScheme.tertiaryContainer,
                    shape = MaterialTheme.shapes.small
                )
                .padding(8.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceAround
        ) {
            Text(
                text = "Easyload",
                style = MaterialTheme.typography.titleSmall,
                color = MaterialTheme.colorScheme.onTertiaryContainer
            )
            Text(
                text = "Rs. 150",
                style = MaterialTheme.typography.titleSmall,
                color = MaterialTheme.colorScheme.onTertiaryContainer
            )
        }

        Row(
            modifier = Modifier
                .padding(top = 12.dp)
                .fillMaxWidth()
                .wrapContentHeight()
                .background(
                    color = MaterialTheme.colorScheme.tertiaryContainer,
                    shape = MaterialTheme.shapes.small
                )
                .padding(8.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceAround
        ) {
            Text(
                text = "Customer Mobile No.",
                style = MaterialTheme.typography.titleSmall,
                color = MaterialTheme.colorScheme.onTertiaryContainer
            )
            Text(
                text = "0345 1234567",
                style = MaterialTheme.typography.titleSmall,
                color = MaterialTheme.colorScheme.onTertiaryContainer
            )
        }

        Text(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 12.dp),
            text = "Do you want to transfer?",
            style = MaterialTheme.typography.bodyMedium,
            color = MaterialTheme.colorScheme.primary,
            textAlign = TextAlign.Center
        )

        Row(modifier = Modifier
            .fillMaxWidth()
            .padding(top = 12.dp), horizontalArrangement = Arrangement.SpaceBetween) {

            Button(
                shape = MaterialTheme.shapes.small,
                modifier = Modifier
                    .weight(0.5f)
                    .padding(8.dp),
                onClick = {},
                colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.primaryContainer)
            ) {
                Text(
                    text = "Cancel",
                    style = MaterialTheme.typography.titleMedium,
                    color = MaterialTheme.colorScheme.onPrimaryContainer
                )
            }


            Button(
                shape = MaterialTheme.shapes.small,
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(0.5f)
                    .padding(8.dp),
                onClick = {},
                colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.tertiary)
            ) {
                Text(
                    text = "Yes",
                    style = MaterialTheme.typography.titleMedium,
                    color = MaterialTheme.colorScheme.onTertiary
                )

            }
        }
    }

}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SubMenus(modifier: Modifier = Modifier, icon: ImageVector, title: String) {
    Column(modifier = modifier, horizontalAlignment = Alignment.CenterHorizontally) {
        Card(
            modifier = Modifier.wrapContentSize(),
            shape = MaterialTheme.shapes.medium,
            colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.onPrimary),
            elevation = CardDefaults.cardElevation(defaultElevation = 2.dp),
        ) {
            Box(modifier = Modifier.size(100.dp), contentAlignment = Alignment.Center) {
                Icon(
                    modifier = Modifier
                        .size(48.dp)
                        .align(Alignment.Center),
                    imageVector = icon,
                    contentDescription = "sub menu icon",
                    tint = MaterialTheme.colorScheme.onSurface
                )
            }
        }

        Spacer(modifier = Modifier.padding(vertical = 8.dp))

        Text(
            text = title,
            style = MaterialTheme.typography.titleSmall,
            color = MaterialTheme.colorScheme.primary,
            textAlign = TextAlign.Center
        )
    }
}


enum class DashboardMenuItems(val icon: ImageVector, val title: String) {
    Stock(Icons.Rounded.Warehouse, "Stock"), Transaction_History(
        Icons.Rounded.AttachMoney,
        "Transaction History"
    ),
    My_Commision(Icons.Rounded.Commit, "My Commission")
}

@Composable
fun MainMenus(modifier: Modifier = Modifier) {
    Row(modifier = modifier) {

        MainDashboardMenuItem(
            modifier = Modifier.weight(1f),
            icon = Icons.Rounded.Sell,
            text = "Sell ELoad",
        )

        MainDashboardMenuItem(
            modifier = Modifier.weight(1f),
            icon = Icons.Rounded.AttachMoney,
            text = "EasyPaisa",
        )
    }
}

@Composable
private fun MainDashboardMenuItem(
    modifier: Modifier = Modifier,
    icon: ImageVector = Icons.Default.Phone,
    text: String = "",
) {
    Card(
        modifier = modifier.padding(horizontal = 12.dp),
        shape = MaterialTheme.shapes.medium,
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.onPrimary),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {
        Column(
            modifier = Modifier
                .padding(vertical = 12.dp)
                .align(Alignment.CenterHorizontally),
            verticalArrangement = Arrangement.SpaceAround,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Icon(
                modifier = Modifier
                    .size(100.dp)
                    .padding(12.dp),
                imageVector = icon,
                contentDescription = "sell icon",
                tint = MaterialTheme.colorScheme.onSurface
            )
            Text(
                modifier = Modifier.padding(vertical = 12.dp),
                text = text,
                style = MaterialTheme.typography.titleMedium.copy(
                    color = MaterialTheme.colorScheme.primary,
                )
            )
        }
    }
}

@Composable
fun Highlights(modifier: Modifier = Modifier) {
    Card(
        modifier = modifier,
        shape = MaterialTheme.shapes.medium,
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.onPrimary),
        elevation = CardDefaults.cardElevation(defaultElevation = 6.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 22.dp, vertical = 12.dp)
        ) {
            Text(
                modifier = Modifier.align(Alignment.Start),
                text = "Highlights",
                style = MaterialTheme.typography.titleMedium.copy(color = MaterialTheme.colorScheme.onSurface)
            )

            Row(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(vertical = 18.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {

                HighlightItem(
                    highlightText = "1200", color = MaterialTheme.colorScheme.secondary, "BVS Hits"
                )
                HighlightItem(
                    highlightText = "72",
                    color = MaterialTheme.colorScheme.tertiary,
                    "Active Retail"
                )
                HighlightItem(
                    highlightText = "1144", color = MaterialTheme.colorScheme.inversePrimary, "FCA"
                )

            }

            Text(
                modifier = Modifier.align(Alignment.CenterHorizontally),
                text = "Review Performance ->",
                style = MaterialTheme.typography.bodyMedium.copy(color = MaterialTheme.colorScheme.tertiary)
            )
        }
    }
}

@Composable
private fun HighlightItem(highlightText: String, color: Color, bottomText: String) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Box(modifier = Modifier.wrapContentSize(), contentAlignment = Alignment.Center) {
            CircularProgressIndicator(
                modifier = Modifier.size(80.dp),
                strokeCap = StrokeCap.Round,
                progress = 1f,
                strokeWidth = 1.dp,
                color = color
            )
            Text(
                text = highlightText, style = MaterialTheme.typography.titleMedium.copy(
                    color = MaterialTheme.colorScheme.primary,
                )
            )
        }
        Spacer(modifier = Modifier.padding(2.dp))
        Text(
            text = bottomText, style = MaterialTheme.typography.titleSmall.copy(
                color = MaterialTheme.colorScheme.primary, fontWeight = FontWeight.Normal
            )
        )
    }
}
