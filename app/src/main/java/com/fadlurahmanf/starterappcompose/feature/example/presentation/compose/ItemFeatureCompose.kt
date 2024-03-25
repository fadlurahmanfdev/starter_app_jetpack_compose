package com.fadlurahmanf.starterappcompose.feature.example.presentation.compose

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.fadlurahmanf.starterappcompose.R
import com.fadlurahmanf.starterappcompose.feature.example.data.FeatureModel

@Composable
fun ItemFeatureCompose(
    feature: FeatureModel
) {
    Row(
        modifier = Modifier
            .fillMaxWidth(), verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            painter = painterResource(id = R.drawable.baseline_app_shortcut_24),
            contentDescription = "feature"
        )
        Column(
            modifier = Modifier
                .padding(10.dp, 0.dp, 0.dp, 0.dp)
        ) {
            Text(text = feature.title)
            Text(text = feature.description)
        }
    }
}