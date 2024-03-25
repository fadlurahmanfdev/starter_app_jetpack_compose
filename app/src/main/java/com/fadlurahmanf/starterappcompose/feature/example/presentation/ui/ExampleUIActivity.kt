package com.fadlurahmanf.starterappcompose.feature.example.presentation.ui

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import com.fadlurahmanf.starterappcompose.feature.example.data.FeatureModel
import com.fadlurahmanf.starterappcompose.feature.example.presentation.compose.ItemFeatureCompose

@Composable
fun ExampleUIActivity() {
    val showDialog = remember { mutableStateOf(false) }

    val features = listOf(
        FeatureModel(
            title = "Show Loading Dialog",
            description = "Show Loading Dialog",
            key = "LOADING_DIALOG"
        ),
    )

    if (showDialog.value) {
        Log.d("LoggerTAG", "show dialog: ${showDialog.value}")
        LoadingDialog()
    } else {
        Log.d("LoggerTAG", "show dialog: ${showDialog.value}")
    }

    Scaffold { paddingValues ->
        LazyColumn(modifier = Modifier.padding(paddingValues)) {
            items(features) { feature ->
                Box(
                    modifier = Modifier.clickable {
                        showDialog.value = true
                    },
                ) {
                    ItemFeatureCompose(feature)
                }
            }
        }
    }
}

@Composable
fun LoadingDialog() {
    Dialog(
        onDismissRequest = {}, properties = DialogProperties(
            dismissOnBackPress = false,
            dismissOnClickOutside = false
        )
    ) {
        Card(
            shape = RoundedCornerShape(16.dp),
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(color = Color.White),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                CircularProgressIndicator(
                    modifier = Modifier
                        .width(35.dp)
                        .padding(top = 10.dp),
                    color = Color.Black,
                    trackColor = Color.Gray,
                )
                Text(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 10.dp, bottom = 10.dp),
                    textAlign = TextAlign.Center, text = "Loading...",
                )
            }
        }
    }
}