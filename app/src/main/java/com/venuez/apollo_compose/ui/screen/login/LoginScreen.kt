package com.venuez.apollo_compose.ui.screen.login

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.AsyncImage
import com.venuez.apollo_compose.R
import com.venuez.apollo_compose.core.ApolloPasswordField
import com.venuez.apollo_compose.core.ApolloTextField

@Composable
fun LoginScreen(
    modifier: Modifier = Modifier,
    viewModel: LoginViewModel = hiltViewModel(),
    onLoginClick: () -> Unit = {}
) {
    Column(modifier = modifier, horizontalAlignment = Alignment.CenterHorizontally) {
        ImageHeader(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
        )
        Spacer(modifier = Modifier.padding(4.dp))
        SignInContainer(
            modifier = Modifier
                .fillMaxWidth()
                .weight(3f), viewModel,
            onLoginClick = onLoginClick
        )
        Footer(
            modifier
                .fillMaxWidth()
                .fillMaxHeight(0.125f)
        )
    }
}

@Composable
private fun ImageHeader(modifier: Modifier = Modifier) {
    Box(modifier = modifier) {
        Image(
            modifier = Modifier.fillMaxSize(),
            painter = painterResource(id = R.drawable.bg_login_header),
            contentDescription = null,
            contentScale = ContentScale.FillBounds
        )
        AsyncImage(
            modifier = Modifier
                .size(150.dp, 100.dp)
                .align(Alignment.Center),
            model = "https://i.pinimg.com/originals/6d/f2/13/6df2131053b789f5acc4f8dacb33ee74.png",
            contentDescription = null
        )

    }
}

@Composable
private fun SignInContainer(
    modifier: Modifier = Modifier,
    viewModel: LoginViewModel,
    onLoginClick: () -> Unit
) {
    val value by viewModel.eLoadOrUserId.collectAsState()
    val pswd by viewModel.pswd.collectAsState()

    Column(modifier = modifier, horizontalAlignment = Alignment.CenterHorizontally) {
        Text(
            text = "Sign In",
            style = MaterialTheme.typography.headlineLarge.copy(color = MaterialTheme.colorScheme.onSurface)
        )
        Spacer(modifier = Modifier.padding(12.dp))
        ApolloTextField(
            modifier = Modifier.fillMaxWidth(0.85f),
            title = "ELoad Number or User Id",
            hint = "Type Here",
            value = value,
            leadingIcon = {
                Icon(
                    imageVector = Icons.Filled.Email,
                    contentDescription = "email icon"
                )
            },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
            onValueChange = { viewModel.onELoadOrUserIdChange(it) })
        Spacer(modifier = Modifier.padding(14.dp))
        ApolloPasswordField(
            modifier = Modifier.fillMaxWidth(0.85f),
            title = "Password",
            hint = "********",
            value = pswd,
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
            onValueChange = { viewModel.onPasswordChange(it) })

        TextButton(modifier = Modifier
            .padding(12.dp)
            .align(Alignment.End),
            onClick = { Log.d("HomeScreen", "Forgot Password Click") }) {
            Text(
                text = "Forgot password?",
                style = MaterialTheme.typography.titleMedium.copy(MaterialTheme.colorScheme.tertiary)
            )
        }

        Button(
            modifier = Modifier
                .fillMaxWidth(0.44f)
                .height(80.dp)
                .padding(18.dp),
            shape = MaterialTheme.shapes.small,
            colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.tertiary),
            onClick = onLoginClick
        ) {
            Text(
                text = "Login",
                style = MaterialTheme.typography.titleMedium.copy(color = MaterialTheme.colorScheme.onTertiary)
            )
        }

        TextButton(modifier = Modifier
            .padding(vertical = 18.dp),
            onClick = { Log.d("HomeScreen", "Register as a Retailer Click") }) {
            Text(
                text = "Register as a Retailer",
                style = MaterialTheme.typography.titleMedium.copy(MaterialTheme.colorScheme.tertiary)
            )
        }

    }

}

@Composable
private fun Footer(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.SpaceEvenly,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        AsyncImage(
            modifier = Modifier.size(28.dp),
            model="https://static-00.iconduck.com/assets.00/brand-telenor-icon-2048x1889-4ylayx2g.png",
            contentDescription = "telenor logo"
        )

        Text(
            text = "A Product of Telenor Pakistan",
            style = MaterialTheme.typography.titleSmall.copy(
                fontWeight = FontWeight.Normal,
                color = MaterialTheme.colorScheme.tertiary
            )
        )
        Text(
            text = "Version 44.3",
            style = MaterialTheme.typography.titleSmall.copy(
                fontWeight = FontWeight.SemiBold,
                color = MaterialTheme.colorScheme.tertiary
            )
        )
    }
}
