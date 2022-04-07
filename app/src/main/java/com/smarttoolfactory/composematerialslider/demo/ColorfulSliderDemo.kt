package com.smarttoolfactory.composematerialslider.demo

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.smarttoolfactory.composematerialslider.ui.theme.Blue400
import com.smarttoolfactory.slider.ColorfulSlider
import com.smarttoolfactory.slider.MaterialSliderDefaults

@Composable
fun ColorfulSliderDemo() {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(20.dp)
    ) {

        var progress1 by remember { mutableStateOf(0f) }

        TitleText("Thumb radius and track height")

        Text("Progress: $progress1")
        ColorfulSlider(
            value = progress1,
            onValueChange = { value ->
                progress1 = value
            },
            colors = MaterialSliderDefaults.defaultColors()
        )

        ColorfulSlider(
            value = progress1,
            thumbRadius = 10.dp,
            trackHeight = 12.dp,
            onValueChange = { value ->
                progress1 = value
            },
            colors = MaterialSliderDefaults.defaultColors()
        )

        ColorfulSlider(
            value = progress1,
            thumbRadius = 16.dp,
            trackHeight = 12.dp,
            onValueChange = { value ->
                progress1 = value
            },
            colors = MaterialSliderDefaults.defaultColors()
        )

        ColorfulSlider(
            value = progress1,
            thumbRadius = 5.dp,
            trackHeight = 12.dp,
            onValueChange = { value ->
                progress1 = value
            },
            colors = MaterialSliderDefaults.defaultColors()
        )

        ColorfulSlider(
            value = progress1,
            thumbRadius = 8.dp,
            trackHeight = 30.dp,
            onValueChange = { value ->
                progress1 = value
            },
            colors = MaterialSliderDefaults.defaultColors()
        )

        ColorfulSlider(
            value = progress1,
            onValueChange = { value ->
                progress1 = value
            },
            colors = MaterialSliderDefaults.materialColors()
        )

        ColorfulSlider(
            value = progress1,
            thumbRadius = 10.dp,
            trackHeight = 12.dp,
            onValueChange = { value ->
                progress1 = value
            },
            colors = MaterialSliderDefaults.materialColors()
        )

        ColorfulSlider(
            value = progress1,
            thumbRadius = 16.dp,
            trackHeight = 12.dp,
            onValueChange = { value ->
                progress1 = value
            },
            colors = MaterialSliderDefaults.materialColors()
        )

        ColorfulSlider(
            value = progress1,
            thumbRadius = 5.dp,
            trackHeight = 12.dp,
            onValueChange = { value ->
                progress1 = value
            },
            colors = MaterialSliderDefaults.materialColors()
        )

        ColorfulSlider(
            value = progress1,
            thumbRadius = 8.dp,
            trackHeight = 30.dp,
            onValueChange = { value ->
                progress1 = value
            },
            colors = MaterialSliderDefaults.materialColors()
        )
    }
}

@Composable
fun TitleText(text: String) {
    Text(
        text = text,
        color = Blue400,
        fontSize = 16.sp,
        fontWeight = FontWeight.Bold,
        modifier = Modifier.padding(horizontal = 4.dp, vertical = 8.dp)
    )
}
