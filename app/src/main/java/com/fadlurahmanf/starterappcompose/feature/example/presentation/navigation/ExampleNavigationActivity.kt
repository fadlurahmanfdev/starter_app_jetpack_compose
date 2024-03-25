package com.fadlurahmanf.starterappcompose.feature.example.presentation.navigation

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
fun ExampleNavigationActivity(onNavigateToExampleNavigation: (FeatureModel) -> Unit) {
    val features = listOf(
        FeatureModel(
            title = "Mandatory Argument",
            description = "Navigate to next activity with mandatory argument",
            key = "MANDATORY_ARGUMENT"
        ), FeatureModel(
            title = "Optional Argument",
            description = "Navigate to next activity with optional argument",
            key = "OPTIONAL_ARGUMENT"
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