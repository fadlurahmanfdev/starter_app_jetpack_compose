package com.fadlurahmanf.starterappcompose.feature.example.presentation

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.fadlurahmanf.starterappcompose.feature.example.data.model.FeatureModel
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
        ),
        FeatureModel(
            title = "UI Feature",
            description = "List of UI Features",
            key = "UI"
        ),
        FeatureModel(
            title = "List of API",
            description = "List of API Call",
            key = "API"
        )
    )
    Scaffold { paddingValues ->
        LazyColumn(modifier = Modifier.padding(paddingValues)) {
            items(features) { feature ->
                Box(
                    modifier = Modifier.clickable {
                        onNavigateToExampleNavigation(feature)
                    },
                ) {
                    ItemFeatureCompose(feature)
                }
            }
        }
    }
}

