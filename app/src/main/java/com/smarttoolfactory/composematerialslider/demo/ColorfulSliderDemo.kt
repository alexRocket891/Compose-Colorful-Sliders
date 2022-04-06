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
import com.smarttoolfactory.composematerialslider.ui.theme.*
import com.smarttoolfactory.slider.ColorfulSlider
import com.smarttoolfactory.slider.MaterialSliderDefaults
import com.smarttoolfactory.slider.SliderBrushColor

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


        TitleText("Slider Colors")
        var progress3 by remember { mutableStateOf(0f) }

        ColorfulSlider(
            value = progress3,
            onValueChange = { it ->
                progress3 = it
            },
            colors = MaterialSliderDefaults.materialColors(
                activeTrackColor = SliderBrushColor(color = Red400),
                thumbColor = SliderBrushColor(color = Red400),
                inactiveTrackColor = SliderBrushColor(color = Grey400)
            )
        )

        ColorfulSlider(
            value = progress3,
            onValueChange = { it ->
                progress3 = it
            },
            colors = MaterialSliderDefaults.materialColors(
                activeTrackColor = SliderBrushColor(color = Red400),
                inactiveTrackColor = SliderBrushColor(color = Green400),
                thumbColor = SliderBrushColor(color = Orange400),
            )
        )

        ColorfulSlider(
            enabled = false,
            value = progress3,
            onValueChange = { it ->
                progress3 = it
            },

            colors = MaterialSliderDefaults.materialColors(
                activeTrackColor = SliderBrushColor(color = Red400),
                thumbColor = SliderBrushColor(color = Red400),
                inactiveTrackColor = SliderBrushColor(color = Grey400)
            )
        )

//        ColorfulIconSlider(
//            modifier = Modifier.width(240.dp),
//            value = red,
//            onValueChange = { value, offset ->
//                red = value
//            },
//            trackHeight = 12.dp
//        ) {
//            Box(contentAlignment = Alignment.Center, modifier = Modifier.padding(2.dp)) {
//                Text(text = "😱", fontSize = 40.sp)
//            }
//        }

    }
}

@Composable
fun TitleText(text: String) {
    Text(
        text = text,
        color = Blue400,
        fontSize = 14.sp,
        fontWeight = FontWeight.Bold,
        modifier = Modifier.padding(2.dp)
    )
}
