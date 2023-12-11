package com.venuez.apollo_compose.ui.screen.data_bundle

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.AsyncImage
import com.venuez.apollo_compose.R
import com.venuez.apollo_compose.ui.screen.data_bundle.component.DataBundlePackageItem
import com.venuez.apollo_compose.ui.screen.data_bundle.component.MainDataBundleItem
import kotlinx.coroutines.launch

@Composable
fun DataBundleScreen(
    viewModel: DataBundleViewModel = hiltViewModel(),
    onClick: () -> Unit = {},
) {
    var openBottomSheet by rememberSaveable { mutableStateOf(false) }

    if (openBottomSheet) {
        ModalBottomSheet { openBottomSheet = false }
    }

    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.spacedBy(16.dp),
        contentPadding = PaddingValues(12.dp)
    ) {

        item {
            Text(
                text = "Data Bundle", style = MaterialTheme.typography.titleLarge.copy(
                    MaterialTheme.colorScheme.primary, fontWeight = FontWeight.Medium
                )
            )
        }
        item {
            MainDataBundleItem(
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentHeight()
            ) {
                openBottomSheet = true
            }
        }

        item {
            Text(
                modifier = Modifier.padding(vertical = 6.dp),
                text = "Select Package",
                style = MaterialTheme.typography.titleLarge.copy(
                    MaterialTheme.colorScheme.primary, fontWeight = FontWeight.Medium
                )
            )
        }

        items(count = 5) {
            DataBundlePackageItem(modifier = Modifier.clickable { onClick() }, pos = it)
        }
    }

}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ModalBottomSheet(onDismiss: () -> Unit) {
    val skipPartiallyExpanded by remember { mutableStateOf(false) }
    var edgeToEdgeEnabled by remember { mutableStateOf(false) }
    val scope = rememberCoroutineScope()
    val bottomSheetState = rememberModalBottomSheetState(
        skipPartiallyExpanded = skipPartiallyExpanded
    )

    ModalBottomSheet(onDismissRequest = onDismiss, sheetState = bottomSheetState, dragHandle = {}) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight()
                .padding(12.dp),
            verticalArrangement = Arrangement.SpaceEvenly,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            AsyncImage(
                modifier = Modifier
                    .padding(vertical = 12.dp)
                    .size(28.dp),
                model = "https://static-00.iconduck.com/assets.00/brand-telenor-icon-2048x1889-4ylayx2g.png",
                contentDescription = "logo icon"
            )

            Text(
                modifier = Modifier.padding(vertical = 12.dp),
                text = "Aik Apollo Coin ki value Rs. 1 hai.",
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.primary
            )

            Text(
                modifier = Modifier.padding(vertical = 12.dp).fillMaxWidth(0.8f),
                text = "You will get Rs 10 in your ELoad balance for 10 Apollo Coins",
                style = MaterialTheme.typography.titleMedium.copy(fontWeight = FontWeight.Medium),
                textAlign = TextAlign.Center,
                color = MaterialTheme.colorScheme.primary,
            )

            Button(
                shape = MaterialTheme.shapes.small,
                colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.primary),
                onClick = {
                    scope.launch { bottomSheetState.hide() }.invokeOnCompletion {
                        if (!bottomSheetState.isVisible) {
                            onDismiss()
                        }
                    }
                }) {
                Text(
                    text = "Claim Coins", color = MaterialTheme.colorScheme.onPrimary,
                    style = MaterialTheme.typography.titleSmall
                )
            }

        }
    }
}
