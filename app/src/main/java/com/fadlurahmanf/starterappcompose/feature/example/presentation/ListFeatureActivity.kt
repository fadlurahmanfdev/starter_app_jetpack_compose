package com.fadlurahmanf.starterappcompose.feature.example.presentation

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.fadlurahmanf.starterappcompose.feature.example.data.FeatureModel
import com.fadlurahmanf.starterappcompose.feature.example.presentation.compose.ItemFeatureCompose

@Composable
fun ListFeatureActivity(onNavigateToExampleNavigation: (FeatureModel) -> Unit) {
    val features = listOf(
        FeatureModel(
            title = "Navigation Feature",
            description = "List of navigation feature",
            key = "NAVIGATION"
        ),
        FeatureModel(
            title = "Crypto Feature",
            description = "Crypto Activity",
            key = "CRYPTO"
        )
    )
    Scaffold { paddingValues ->
        LazyColumn(modifier = Modifier.padding(paddingValues)) {
            items(features) { feature ->
                ItemFeatureCompose(feature, onNavigateToExampleNavigation)
            }
        }
    }
}

