package com.fadlurahmanf.starterappcompose.feature.example.presentation.crypto

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
fun CryptoActivity(viewModel: ExampleCryptoViewModel = hiltViewModel()) {
    LaunchedEffect(key1 = null) {
        viewModel.generateRSACryptoKey()
    }
    Scaffold { paddingValues ->
        Column(
            modifier = Modifier
                .padding(paddingValues)
                .verticalScroll(rememberScrollState())
        ) {
            Text(
                text = "CRYPTO KEY :\n" +
                        "PUBLIC KEY: ${viewModel.cryptoKeyState.collectAsState().value?.publicKey}\n\n" +
                        "PRIVATE KEY: ${viewModel.cryptoKeyState.collectAsState().value?.privateKey}"
            )
        }
    }
}