package com.fadlurahmanf.starterappcompose.feature.example.presentation.api

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.fadlurahmanf.starterappcompose.core.network.others.NetworkState
import com.fadlurahmanf.starterappcompose.feature.example.data.model.FeatureModel
import com.fadlurahmanf.starterappcompose.feature.example.presentation.compose.ItemFeatureCompose
import com.fadlurahmanf.starterappcompose.feature.example.presentation.ui.LoadingDialog

@Composable
fun ExampleApiActivity(viewModel: ExampleApiViewModel = hiltViewModel()) {
    val features = listOf(
        FeatureModel(
            title = "Guest Token",
            description = "Generate Guest Token",
            key = "API_1"
        ),
    )
    val showLoading = remember {
        mutableStateOf(false)
    }
    val generateGuestTokenState = viewModel.generateGuestTokenState.collectAsState()

    LaunchedEffect(key1 = generateGuestTokenState.value) {
        when (generateGuestTokenState.value) {
            is NetworkState.FAILED -> {
                showLoading.value = false
            }

            NetworkState.IDLE -> {
                showLoading.value = false
            }

            NetworkState.LOADING -> {
                showLoading.value = true
            }

            is NetworkState.SUCCESS -> {
                showLoading.value = false
            }
        }
    }

    if (showLoading.value) {
        LoadingDialog()
    }

    Scaffold { paddingValues ->
        LazyColumn(modifier = Modifier.padding(paddingValues)) {
            items(features) { feature ->
                Box(
                    modifier = Modifier.clickable {
                        when (feature.key) {
                            "API_1" -> {
                                viewModel.generateGuestToken()
                            }
                        }
                    },
                ) {
                    ItemFeatureCompose(feature)
                }
            }
        }
    }
}