package com.venuez.apollo_compose.ui.screen.data_bundle.component

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Composable
fun MainDataBundleItem(modifier: Modifier = Modifier,onSellBundleClick : () -> Unit) {
    Card(
        modifier = modifier,
        colors = CardDefaults.cardColors(containerColor = Color.Transparent),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
        shape = MaterialTheme.shapes.medium
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight()
                .background(
                    brush = Brush.horizontalGradient(
                        colors = listOf(
                            MaterialTheme.colorScheme.primary,
                            MaterialTheme.colorScheme.primary,
                            MaterialTheme.colorScheme.tertiary
                        )
                    ),
                    shape = MaterialTheme.shapes.medium,
                )
        ) {
            HeaderItem()

            BodyItem(
                modifier = Modifier
                    .fillMaxWidth(0.9f)
                    .wrapContentHeight()
                    .align(Alignment.CenterHorizontally)
                    .border(1.dp, color = MaterialTheme.colorScheme.tertiary)
            )

            FooterItem(onSellBundleClick)

        }

    }
}

@Composable
private fun FooterItem(onSellBundleClick: () -> Unit) {
    Row(
        modifier = Modifier
            .padding(vertical = 12.dp)
            .fillMaxWidth()
            .wrapContentHeight(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
    ) {

        Text(
            modifier = Modifier
                .fillMaxWidth(0.4f)
                .background(
                    color = MaterialTheme.colorScheme.tertiary,
                    shape = CutCornerShape(
                        topStart = 0.dp,
                        bottomStart = 0.dp,
                        topEnd = 50.dp,
                        bottomEnd = 50.dp
                    )
                ), text = "Exclusive",
            style = MaterialTheme.typography.titleMedium,
            textAlign = TextAlign.Center
        )

        Button(modifier = Modifier.padding(horizontal = 12.dp), onClick = onSellBundleClick, colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.tertiary), shape = MaterialTheme.shapes.small) {
            Text(
                text = "Sell Bundle",
                style = MaterialTheme.typography.titleMedium.copy(
                    color = MaterialTheme.colorScheme.onTertiary,
                    fontWeight = FontWeight.Medium
                )
            )
        }

    }
}


@Composable
private fun BodyItem(modifier: Modifier = Modifier) {
    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceEvenly
    ) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Text(text = "500/ 120", style = MaterialTheme.typography.bodyMedium)
            Text(text = "Onnet/ Offnet", style = MaterialTheme.typography.bodyMedium)
        }
        Divider(
            modifier = Modifier
                .height(60.dp)  //fill the max height
                .width(1.dp), color = MaterialTheme.colorScheme.tertiary
        )
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Text(text = "1024 MB", style = MaterialTheme.typography.bodyMedium)
            Text(text = "Internet", style = MaterialTheme.typography.bodyMedium)
        }
        Divider(
            modifier = Modifier
                .height(60.dp)   //fill the max height
                .width(1.dp), color = MaterialTheme.colorScheme.tertiary
        )
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Text(text = "1000", style = MaterialTheme.typography.bodyMedium)
            Text(text = "SMS", style = MaterialTheme.typography.bodyMedium)
        }
    }
}

@Composable
private fun HeaderItem() {
    Row {
        Column(
            modifier = Modifier
                .padding(12.dp)
                .weight(2f)
                .align(Alignment.CenterVertically)
        ) {
            Text(
                text = "Smart 1500",
                style = MaterialTheme.typography.titleLarge.copy(fontWeight = FontWeight.Medium),
                color = MaterialTheme.colorScheme.onTertiary
            )
            Text(
                text = "15 days Validity",
                style = MaterialTheme.typography.bodySmall,
                color = Color.Yellow
            )
        }

        Column(
            modifier = Modifier
                .height(80.dp)
                .padding(bottom = 8.dp),
            verticalArrangement = Arrangement.Bottom,
            horizontalAlignment = Alignment.End
        ) {
            Text(
                text = "Rs. 10",
                style = MaterialTheme.typography.titleMedium,
                color = Color.Yellow
            )
            Text(
                text = "Commission",
                style = MaterialTheme.typography.bodySmall,
                color = MaterialTheme.colorScheme.onTertiary
            )
        }

        Divider(
            modifier = Modifier
                .padding(12.dp)
                .height(60.dp)
                .width(1.dp), thickness = 2.dp
        )

        Column(
            modifier = Modifier.padding(end = 16.dp, top = 8.dp),
            horizontalAlignment = Alignment.Start,
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = "Rs. 1500",
                style = MaterialTheme.typography.titleSmall,
                color = Color.Yellow,
            )
            Text(
                text = "Rs 1385",
                style = MaterialTheme.typography.titleLarge.copy(fontWeight = FontWeight.Medium),
                color = MaterialTheme.colorScheme.onTertiary
            )
            Text(
                modifier = Modifier.align(Alignment.End),
                text = "+ Tax Incl",
                style = MaterialTheme.typography.bodySmall.copy(fontSize = 8.sp, fontWeight = FontWeight.Medium),
                color = MaterialTheme.colorScheme.secondaryContainer,
            )
        }
    }
}

