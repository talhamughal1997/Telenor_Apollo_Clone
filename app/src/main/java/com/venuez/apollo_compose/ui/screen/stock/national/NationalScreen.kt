package com.venuez.apollo_compose.ui.screen.stock.national

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.venuez.apollo_compose.R

@Composable
fun NationalScreen(modifier: Modifier = Modifier,onClick: () -> Unit = {}) {
    LazyVerticalGrid(
        modifier = modifier,
        columns = GridCells.Fixed(2),
        verticalArrangement = Arrangement.spacedBy(12.dp),
        horizontalArrangement = Arrangement.SpaceEvenly,
        contentPadding = PaddingValues(vertical = 16.dp)
    ) {
        items(items = NationalItems.values()) {
            NationalItem(it.locationName, it.personName, it.coinTitle, onClick)
        }
    }
}

@Composable
fun NationalItem(locationName: String, personName: String, coinTitle: String, onClick: () -> Unit) {
    Card(
        modifier = Modifier
            .wrapContentSize()
            .padding(horizontal = 18.dp)
            .clickable { onClick() },
        shape = MaterialTheme.shapes.medium,
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.onPrimary),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
    ) {

        Box(modifier = Modifier
            .fillMaxSize()
            .padding(12.dp), contentAlignment = Alignment.Center) {

            CircularProgressIndicator(
                modifier = Modifier.size(120.dp),
                strokeCap = StrokeCap.Round,
                progress = 1f,
                strokeWidth = 1.dp,
                color = MaterialTheme.colorScheme.tertiary
            )

            Column(
                verticalArrangement = Arrangement.Top,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                Text(
                    text = locationName, style = MaterialTheme.typography.labelMedium.copy(
                        color = MaterialTheme.colorScheme.primary,
                    )
                )

                Image(
                    modifier = Modifier
                        .size(54.dp),
                    painter = painterResource(id = R.drawable.ic_crown),
                    contentDescription = "sell icon",
                    contentScale = ContentScale.Fit,
                )

                Text(
                    text = personName, style = MaterialTheme.typography.labelMedium.copy(
                        color = MaterialTheme.colorScheme.primary,
                    )
                )
            }
        }

        Text(
            modifier = Modifier.align(Alignment.CenterHorizontally),
            text = coinTitle,
            style = MaterialTheme.typography.titleMedium.copy(
                color = MaterialTheme.colorScheme.primary,
                fontWeight = FontWeight.Medium
            ),
            maxLines = 1
        )

    }
}

enum class NationalItems(val locationName: String, val personName: String, val coinTitle: String) {
    ItemOne("North-1", "Ali Khan", "FCA"),
    ItemTwo("South-3", "Qasim Ali", "BYN"),
    ItemThree("North-3", "Zardad", "Recharge"),
    ItemFour("Central-3", "M.Ali Rind", "MNP"),
    ItemFive("North-2", "Azain Tariq", "Coins Earned"),
    ItemSix("Central-2", "Jamil Aslam", "Recharge"),
    ItemSeven("South-1", "Rehmat Ch", "PL Volume"),
    ItemEight("Central-1", "Ali Hassan", "Pl Count"),
}