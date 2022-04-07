package com.smarttoolfactory.composematerialslider.demo

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.dp
import com.smarttoolfactory.composematerialslider.ui.theme.Yellow400
import com.smarttoolfactory.composematerialslider.ui.theme.brush.*
import com.smarttoolfactory.composematerialslider.ui.theme.gradientColorScaleRGB
import com.smarttoolfactory.composematerialslider.ui.theme.silverColors
import com.smarttoolfactory.slider.ColorfulSlider
import com.smarttoolfactory.slider.MaterialSliderDefaults
import com.smarttoolfactory.slider.SliderBrushColor

@Composable
fun SliderGradientDemo() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(20.dp)
    ) {

        TitleText("Thumb track gradients")
        var progress by remember { mutableStateOf(0f) }

        ColorfulSlider(
            value = progress,
            thumbRadius = 10.dp,
            trackHeight = 10.dp,
            onValueChange = { it ->
                progress = it
            },
            colors = MaterialSliderDefaults.materialColors(
                activeTrackColor = SliderBrushColor(
                    brush = sliderHueHSVGradient(),
                ),
            ),
            drawInactiveTrack = false
        )

        val radius1 = with(LocalDensity.current) {
            12.dp.toPx()
        }

        ColorfulSlider(
            value = progress,
            thumbRadius = 12.dp,
            trackHeight = 10.dp,
            onValueChange = { it ->
                progress = it
            },
            colors = MaterialSliderDefaults.materialColors(
                thumbColor = SliderBrushColor(
                    brush = Brush.sweepGradient(silverColors, center = Offset(radius1, radius1)),
                ),
                activeTrackColor = SliderBrushColor(
                    brush = silverGradient(),
                ),
            ),
            drawInactiveTrack = false
        )

        ColorfulSlider(
            value = progress,
            thumbRadius = 10.dp,
            trackHeight = 10.dp,
            onValueChange = { it ->
                progress = it
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
            value = progress,
            thumbRadius = 10.dp,
            trackHeight = 10.dp,
            onValueChange = { it ->
                progress = it
            },
            colors = MaterialSliderDefaults.materialColors(
                activeTrackColor = SliderBrushColor(
                    brush = sugarGradient(),
                ),
            )
        )

        val radius2 = with(LocalDensity.current) {
            15.dp.toPx()
        }
        ColorfulSlider(
            value = progress,
            thumbRadius = 10.dp,
            trackHeight = 10.dp,
            onValueChange = { it ->
                progress = it
            },
            colors = MaterialSliderDefaults.materialColors(
                activeTrackColor = SliderBrushColor(
                    brush = sunsetGradient(),
                )
            )
        )

        ColorfulSlider(
            value = progress,
            thumbRadius = 10.dp,
            trackHeight = 10.dp,
            onValueChange = { it ->
                progress = it
            },
            colors = MaterialSliderDefaults.materialColors(
                activeTrackColor = SliderBrushColor(
                    brush = sunriseGradient(),
                )
            )
        )

        ColorfulSlider(
            value = progress,
            thumbRadius = 15.dp,
            trackHeight = 10.dp,
            onValueChange = { it ->
                progress = it
            },
            colors = MaterialSliderDefaults.materialColors(
                thumbColor = SliderBrushColor(
                    brush = Brush.sweepGradient(
                        gradientColorScaleRGB,
                        center = Offset(radius2, radius2)
                    ),
                ),
                activeTrackColor = SliderBrushColor(
                    brush = sunsetGradient(),
                ),
            )
        )

        ColorfulSlider(
            value = progress,
            thumbRadius = 15.dp,
            trackHeight = 10.dp,
            onValueChange = { it ->
                progress = it
            },
            colors = MaterialSliderDefaults.materialColors(
                thumbColor = SliderBrushColor(
                    brush = Brush.sweepGradient(
                        gradientColorScaleRGB,
                        center = Offset(radius2, radius2)
                    ),
                ),
                activeTrackColor = SliderBrushColor(
                    brush = sunriseGradient(),
                ),
            )
        )

        ColorfulSlider(
            value = progress,
            thumbRadius = 10.dp,
            trackHeight = 10.dp,
            onValueChange = { it ->
                progress = it
            },
            colors = MaterialSliderDefaults.materialColors(
                activeTrackColor = SliderBrushColor(
                    brush = instaGradient(),
                )
            )
        )

        TitleText("Border gradients")
        var progress2 by remember { mutableStateOf(0f) }

        ColorfulSlider(
            value = progress2,
            thumbRadius = 10.dp,
            trackHeight = 10.dp,
            onValueChange = { it ->
                progress2 = it
            },
            colors = MaterialSliderDefaults.materialColors(
                inactiveTrackColor = SliderBrushColor(color = Color.Transparent),
                activeTrackColor = SliderBrushColor(
                    brush = sunriseGradient(),
                )
            ),
            borderStroke = BorderStroke(2.dp, sunriseGradient())
        )

        ColorfulSlider(
            value = progress2,
            thumbRadius = 10.dp,
            trackHeight = 10.dp,
            onValueChange = { it ->
                progress2 = it
            },
            colors = MaterialSliderDefaults.materialColors(
                inactiveTrackColor = SliderBrushColor(color = Color.Transparent),
                activeTrackColor = SliderBrushColor(
                    brush = sunsetGradient(),
                )
            ),
            borderStroke = BorderStroke(2.dp, sunsetGradient())
        )

        ColorfulSlider(
            value = progress2,
            thumbRadius = 10.dp,
            trackHeight = 10.dp,
            onValueChange = { it ->
                progress2 = it
            },
            colors = MaterialSliderDefaults.materialColors(
                inactiveTrackColor = SliderBrushColor(color = Color.Transparent),
                activeTrackColor = SliderBrushColor(
                    brush = instaGradient(),
                )
            ),
            borderStroke = BorderStroke(2.dp, instaGradient())
        )

    }
}
