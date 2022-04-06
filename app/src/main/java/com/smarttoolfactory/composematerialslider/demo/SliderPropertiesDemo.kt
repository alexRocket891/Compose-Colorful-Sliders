package com.smarttoolfactory.composematerialslider.demo

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.onSizeChanged
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import com.smarttoolfactory.composematerialslider.ui.theme.Green400
import com.smarttoolfactory.composematerialslider.ui.theme.Pink400
import com.smarttoolfactory.composematerialslider.ui.theme.Red400
import com.smarttoolfactory.slider.ColorfulSlider
import com.smarttoolfactory.slider.MaterialSliderDefaults
import com.smarttoolfactory.slider.SliderWithTitle
import kotlin.math.roundToInt

@Composable
fun SliderPropertiesDemo() {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(20.dp)
    ) {

        TitleText("SliderWithTitle")
        Column(modifier = Modifier.padding(horizontal = 24.dp)) {
            var labelProgress by remember { mutableStateOf(0f) }
            SliderWithTitle(
                value = labelProgress,
                onValueChange = {
                    labelProgress = it
                },
                label = {
                    Text(
                        text = "$${labelProgress.roundToInt()}",
                        modifier = Modifier
                            .shadow(1.dp, shape = CircleShape)
                            .background(Pink400, shape = CircleShape)
                            .padding(5.dp),
                        color = Color.White
                    )
                },
                thumbRadius = 10.dp,
                trackHeight = 10.dp,
                valueRange = 0f..100f,
                colors = MaterialSliderDefaults.materialColors()
            )
        }

        TitleText("Sliders that return value and offset")
        Column(modifier = Modifier.padding(horizontal = 24.dp)) {
            var labelProgress by remember { mutableStateOf(0f) }
            var labelOffset by remember { mutableStateOf(Offset.Zero) }

            var labelWidth = 0
            Text(text = "Label",
                modifier = Modifier
                    .offset {
                        IntOffset(labelOffset.x.toInt() - labelWidth / 2, labelOffset.y.toInt())
                    }
                    .onSizeChanged {
                        labelWidth = it.width
                    }
                    .shadow(1.dp, shape = RoundedCornerShape(10.dp))
                    .background(Red400, shape = RoundedCornerShape(10.dp))
                    .padding(5.dp),
                color = Color.White
            )

            ColorfulSlider(
                value = labelProgress,
                onValueChange = { value, offset ->
                    labelProgress = value
                    labelOffset = offset
                },
                thumbRadius = 10.dp,
                trackHeight = 10.dp,
                colors = MaterialSliderDefaults.materialColors()
            )
        }

        Column(modifier = Modifier.padding(horizontal = 24.dp)) {

            var labelProgress by remember { mutableStateOf(0f) }
            var labelOffset by remember { mutableStateOf(Offset.Zero) }

            var labelWidth by remember { mutableStateOf(0) }
            Text(text = "Price ${labelProgress.roundToInt()}",
                modifier = Modifier
                    .offset {
                        IntOffset(labelOffset.x.toInt() - labelWidth / 2, labelOffset.y.toInt())
                    }
                    .onSizeChanged {
                        labelWidth = it.width
                    }
                    .shadow(1.dp, shape = RoundedCornerShape(10.dp))
                    .background(Green400, shape = RoundedCornerShape(10.dp))
                    .padding(5.dp),
                color = Color.White
            )

            ColorfulSlider(
                value = labelProgress,
                onValueChange = { value, offset ->
                    labelProgress = value
                    labelOffset = offset
                },
                thumbRadius = 10.dp,
                trackHeight = 10.dp,
                valueRange = 0f..100f,
                colors = MaterialSliderDefaults.materialColors()
            )
        }

        TitleText("Draw Inactive Color Option")
        var progress2 by remember { mutableStateOf(0f) }

        ColorfulSlider(
            value = progress2,
            thumbRadius = 10.dp,
            trackHeight = 10.dp,
            onValueChange = { it ->
                progress2 = it
            },
            colors = MaterialSliderDefaults.materialColors()
        )

        ColorfulSlider(
            value = progress2,
            thumbRadius = 10.dp,
            trackHeight = 10.dp,
            onValueChange = { it ->
                progress2 = it
            },
            colors = MaterialSliderDefaults.materialColors(),
            drawInactiveTrack = false
        )

        TitleText("coerceThumbInTrack Option")
        var progress4 by remember { mutableStateOf(0f) }

        ColorfulSlider(
            value = progress4,
            thumbRadius = 10.dp,
            trackHeight = 30.dp,
            onValueChange = { it ->
                progress4 = it
            },
            colors = MaterialSliderDefaults.materialColors(),
            coerceThumbInTrack = false

        )

        ColorfulSlider(
            value = progress4,
            thumbRadius = 10.dp,
            trackHeight = 30.dp,
            onValueChange = { it ->
                progress4 = it
            },
            colors = MaterialSliderDefaults.materialColors(),
            coerceThumbInTrack = true
        )
    }
}
