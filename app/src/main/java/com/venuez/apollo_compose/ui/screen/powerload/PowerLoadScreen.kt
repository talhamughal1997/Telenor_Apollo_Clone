package com.venuez.apollo_compose.ui.screen.powerload

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.GridItemSpan
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.VectorPainter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.AsyncImage
import com.venuez.apollo_compose.R

@Composable
fun PowerLoadScreen(
    modifier: Modifier = Modifier,
    viewModel: PowerLoadViewModel = hiltViewModel(),
) {
    LazyVerticalGrid(
        modifier = Modifier.fillMaxSize(),
        columns = GridCells.Fixed(3),
        verticalArrangement = Arrangement.spacedBy(38.dp),
        horizontalArrangement = Arrangement.spacedBy(16.dp),
        contentPadding = PaddingValues( 12.dp)
    ) {

        item(span = { GridItemSpan(maxCurrentLineSpan) }) {
            FrequentlyUsedBundle()
        }

        item(span = { GridItemSpan(maxCurrentLineSpan) }) {
            Column(horizontalAlignment = Alignment.End) {
                Text(
                    text = "View All Bundles",
                    style = MaterialTheme.typography.titleSmall,
                    color = MaterialTheme.colorScheme.tertiary,
                    textDecoration = TextDecoration.Underline
                )
            }
        }

        items(items = PowerLoadItems.values()){
            SubMenus(modifier = Modifier.wrapContentSize(),icon = it.icon, title = it.title)
        }
    }
}


@Composable
fun FrequentlyUsedBundle() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
    ) {

        Text(
            text = "Frequently used Bundles",
            style = MaterialTheme.typography.titleSmall,
            color = MaterialTheme.colorScheme.primary
        )

        Spacer(modifier = Modifier.padding(8.dp))

        LazyRow(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight(),
            horizontalArrangement = Arrangement.spacedBy(space = 0.dp),
        ) {
            items(items = usedBundles) {
                FrequentlyUsedBundleItem(it)
            }
        }
    }
}

@Composable
fun FrequentlyUsedBundleItem(title: String) {
    Column(
        modifier = Modifier
            .width(100.dp)
            .wrapContentHeight(),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        AsyncImage(
            modifier = Modifier
                .size(50.dp)
                .clip(CircleShape)
                .border(
                    width = 1.dp,
                    color = MaterialTheme.colorScheme.tertiary,
                    shape = CircleShape
                )
                .padding(14.dp),
            model = "https://static-00.iconduck.com/assets.00/brand-telenor-icon-2048x1889-4ylayx2g.png",
            contentDescription = "logo icon"
        )

        Spacer(modifier = Modifier.padding(vertical = 6.dp))

        Text(
            modifier = Modifier.fillMaxWidth(0.7f),
            text = title,
            style = MaterialTheme.typography.labelSmall,
            color = MaterialTheme.colorScheme.primary,
            textAlign = TextAlign.Center
        )
    }
}


@Composable
private fun SubMenus(modifier: Modifier = Modifier, icon: ImageVector, title: String) {
    Column(modifier = modifier, horizontalAlignment = Alignment.CenterHorizontally) {

        Card(
            modifier = Modifier
                .wrapContentSize(),
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



private enum class PowerLoadItems(val title:String,val icon:ImageVector){

    Data_Bundles("Data Bundles",Icons.Filled.Smartphone),
    Voice_Offers("Voice Offers",Icons.Filled.VoiceChat),
    Gaming("Gaming",Icons.Filled.Gamepad),
    Easy_Card("Easy Card",Icons.Filled.CreditCard),
    Broadband("Broadband",Icons.Filled.WifiChannel),
    Ilaqai_Offers("Ilaqai Offers",Icons.Filled.LocalOffer),
}

private val usedBundles = listOf(
    "7 Din, Latadad Onnet @ Rs 140",
    "30D2GB IMO @ Rs 57",
    "3 Din, 300 Onnet, 25 Offnet",
    "20 GB @ Rs 599"
)
