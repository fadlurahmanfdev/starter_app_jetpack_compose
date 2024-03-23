package com.fadlurahmanf.starterappcompose.feature.example.presentation.navigation

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun NavigationWithArgumentActivity(
    path1: String,
    path2: Int,
    optionalArg1: String? = null,
    optionalArg2: String? = null
) {
    Scaffold { paddingValues ->
        Column(modifier = Modifier.padding(paddingValues)) {
            Text(text = "MANDATORY PATH 1: $path1")
            Text(text = "MANDATORY PATH 2: $path2")
            Text(text = "OPTIONAL ARG 1: $optionalArg1")
            Text(text = "OPTIONAL ARG 2: $optionalArg2")
        }
    }
}