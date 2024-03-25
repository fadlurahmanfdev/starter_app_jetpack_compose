package com.fadlurahmanf.starterappcompose.feature.example.presentation.ui

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.fadlurahmanf.starterappcompose.feature.example.data.FeatureModel
import com.fadlurahmanf.starterappcompose.feature.example.presentation.compose.ItemFeatureCompose

@Composable
fun ExampleUIActivity() {
    val features = listOf(
        FeatureModel(
            title = "Show Loading Dialog",
            description = "Show Loading Dialog",
            key = "LOADING_DIALOG"
        ),
    )
    Scaffold { paddingValues ->
        LazyColumn(modifier = Modifier.padding(paddingValues)) {
            items(features) { feature ->
                Box(
                    modifier = Modifier.clickable {},
                ) {
                    ItemFeatureCompose(feature)
                }
            }
        }
    }
}