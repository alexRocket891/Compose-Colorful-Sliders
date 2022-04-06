package com.smarttoolfactory.composematerialslider.demo

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.onSizeChanged
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.smarttoolfactory.composematerialslider.ui.theme.Blue400
import com.smarttoolfactory.composematerialslider.ui.theme.Green400
import com.smarttoolfactory.composematerialslider.ui.theme.Red400
import com.smarttoolfactory.composematerialslider.ui.theme.Yellow400
import com.smarttoolfactory.composematerialslider.ui.theme.brush.*
import com.smarttoolfactory.slider.ColorfulSlider
import com.smarttoolfactory.slider.MaterialSliderDefaults
import com.smarttoolfactory.slider.SliderBrushColor
import kotlin.math.roundToInt

@Composable
fun ColorfulSliderDemo() {

    Column(
        modifier = Modifier
            .verticalScroll(rememberScrollState())
            .fillMaxSize()
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


        TitleText("Draw Inactive Color Selection")
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

        TitleText("Thumb and/or track color/brush")
        var progress3 by remember { mutableStateOf(0f) }

        ColorfulSlider(
            value = progress3,
            thumbRadius = 10.dp,
            trackHeight = 10.dp,
            onValueChange = { it ->
                progress3 = it
            },
            colors = MaterialSliderDefaults.materialColors()
        )
        ColorfulSlider(
            value = progress3,
            thumbRadius = 10.dp,
            trackHeight = 10.dp,
            onValueChange = { it ->
                progress3 = it
            },
            colors = MaterialSliderDefaults.materialColors(
                activeTrackColor = SliderBrushColor(
                    brush = sliderHueHSVGradient(),
                ),
            ),
            drawInactiveTrack = false
        )

        ColorfulSlider(
            value = progress3,
            thumbRadius = 10.dp,
            trackHeight = 10.dp,
            onValueChange = { it ->
                progress3 = it
            },
            colors = MaterialSliderDefaults.materialColors(
                thumbColor = SliderBrushColor(
                    brush = silverGradient()
                ),
                activeTrackColor = SliderBrushColor(
                    brush = silverGradient(),
                ),
            ),
            drawInactiveTrack = false
        )

        ColorfulSlider(
            value = progress3,
            thumbRadius = 10.dp,
            trackHeight = 10.dp,
            onValueChange = { it ->
                progress3 = it
            },
            colors = MaterialSliderDefaults.materialColors(
                thumbColor = SliderBrushColor(
                   color = Yellow400
                ),
                activeTrackColor = SliderBrushColor(
                    brush = goldGradient(),
                ),
            ),
            drawInactiveTrack = false
        )

        ColorfulSlider(
            value = progress3,
            thumbRadius = 10.dp,
            trackHeight = 10.dp,
            onValueChange = { it ->
                progress3 = it
            },
            colors = MaterialSliderDefaults.materialColors(
                activeTrackColor = SliderBrushColor(
                    brush = sugarGradient(),
                ),
            )
        )

        ColorfulSlider(
            value = progress3,
            thumbRadius = 10.dp,
            trackHeight = 10.dp,
            onValueChange = { it ->
                progress3 = it
            },
            colors = MaterialSliderDefaults.materialColors(
                activeTrackColor = SliderBrushColor(
                    brush = sunsetGradient(),
                ),
            )
        )
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
            var labelText by remember { mutableStateOf("Price $0") }

            var labelWidth by remember { mutableStateOf(0) }
            Text(text = labelText,
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
                    labelText = "Price $${value.roundToInt()}"
                },
                thumbRadius = 10.dp,
                trackHeight = 10.dp,
                valueRange = 0f..100f,
                colors = MaterialSliderDefaults.materialColors()
            )

        }

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
private fun TitleText(text: String) {
    Text(
        text = text,
        color = Blue400,
        fontSize = 14.sp,
        fontWeight = FontWeight.Bold,
        modifier = Modifier.padding(2.dp)
    )
}
