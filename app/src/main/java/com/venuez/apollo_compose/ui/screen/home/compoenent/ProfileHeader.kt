package com.venuez.apollo_compose.ui.screen.home.compoenent

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.outlined.CurrencyBitcoin
import androidx.compose.material.icons.rounded.VerifiedUser
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.venuez.apollo_compose.R


@Composable
fun ProfileHeader(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier.background(
            brush = Brush.horizontalGradient(
                colors = listOf(
                    MaterialTheme.colorScheme.primary,
                    MaterialTheme.colorScheme.primary,
                    MaterialTheme.colorScheme.tertiary
                )
            ), shape = MaterialTheme.shapes.extraLarge.copy(
                topEnd = CornerSize(0.dp), topStart = CornerSize(0.dp)
            )
        ),
    ) {
        ProfileContent()
        AddELoadButton(
            modifier = Modifier
                .padding(8.dp)
                .align(Alignment.CenterHorizontally)
        )

    }
}

@Composable
private fun ProfileContent() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .padding(16.dp),
    ) {
        ProfileIcon(
            modifier = Modifier
                .size(74.dp)
                .align(Alignment.Top)
        )
        ProfileAndEload(modifier = Modifier.align(Alignment.CenterVertically))
        AsyncImage(
            modifier = Modifier
                .size(84.dp)
                .padding(6.dp)
                .align(Alignment.Top),
            model = "https://i.pinimg.com/originals/6d/f2/13/6df2131053b789f5acc4f8dacb33ee74.png",
            contentDescription = "logo icon",
        )
    }
}

@Composable
private fun ProfileAndEload(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier.padding(horizontal = 12.dp),
        verticalArrangement = Arrangement.SpaceEvenly
    ) {
        ProfileName(
            modifier = Modifier
                .wrapContentSize()
        )
        ELoadAndMyCoins(Modifier.wrapContentHeight())
    }
}

@Composable
private fun ELoadAndMyCoins(modifier: Modifier = Modifier) {
    Row(modifier = modifier) {
        Column {
            Spacer(modifier = Modifier.padding(2.dp))
            Text(
                text = "ELoad Amount",
                style = MaterialTheme.typography.bodySmall.copy(color = MaterialTheme.colorScheme.onPrimary)
            )
            Text(
                text = "RS 1,340",
                style = MaterialTheme.typography.titleLarge.copy(
                    color = MaterialTheme.colorScheme.onPrimary,
                    fontWeight = FontWeight.Bold
                )
            )
        }
        Spacer(modifier = Modifier.padding(top = 2.dp))
        Divider(
            modifier = Modifier
                .height(70.dp)
                .align(Alignment.Top)
                .padding(14.dp)
                .width(1.dp), color = MaterialTheme.colorScheme.onPrimary
        )

        Column {
            Spacer(modifier = Modifier.padding(2.dp))
            Text(
                text = "My Coins",
                style = MaterialTheme.typography.bodySmall.copy(color = MaterialTheme.colorScheme.onPrimary)
            )

            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ) {
                Image(
                    modifier = Modifier.size(28.dp),
                    imageVector = Icons.Outlined.CurrencyBitcoin,
                    contentDescription = "coin icon",
                    contentScale = ContentScale.Fit,
                    colorFilter = ColorFilter.tint(color = MaterialTheme.colorScheme.tertiaryContainer)
                )
                Spacer(modifier = Modifier.padding(horizontal = 2.dp))
                Text(
                    text = "219",
                    style = MaterialTheme.typography.titleLarge.copy(
                        color = MaterialTheme.colorScheme.onPrimary,
                        fontWeight = FontWeight.Bold
                    )
                )
            }
        }
    }
}

@Composable
private fun ProfileName(modifier: Modifier = Modifier) {
    Row(
        modifier = modifier, verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = "Hello, ",
            style = MaterialTheme.typography.titleLarge.copy(
                color = MaterialTheme.colorScheme.onPrimary,
                fontWeight = FontWeight.Normal
            )
        )
        Text(
            text = "Hamza Khan", style = MaterialTheme.typography.titleLarge.copy(
                color = MaterialTheme.colorScheme.onPrimary, fontWeight = FontWeight.ExtraBold
            )
        )
    }
}

@Composable
private fun ProfileIcon(modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
    ) {
        Image(
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .fillMaxSize()
                .clip(CircleShape)
                .background(color = Color.White)
                .border(2.dp, Color.Gray, CircleShape),
            imageVector = Icons.Filled.Person,
            contentDescription = "profile icon"
        )

        Icon(
            modifier = Modifier
                .align(Alignment.BottomEnd)
                .padding(start = 4.dp),
            imageVector = Icons.Rounded.VerifiedUser,
            contentDescription = "verified user icon",
            tint = MaterialTheme.colorScheme.inversePrimary
        )

    }
}


@Composable
fun AddELoadButton(modifier: Modifier = Modifier, onClick: () -> Unit = {}) {
    Button(
        modifier = modifier,
        onClick = onClick,
        colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.secondaryContainer)
    ) {
        Text(
            text = "Add ELoad +",
            style = MaterialTheme.typography.titleSmall.copy(color = MaterialTheme.colorScheme.onSecondaryContainer)
        )
    }
}
