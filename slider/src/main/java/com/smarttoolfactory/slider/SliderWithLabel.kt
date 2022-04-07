package com.smarttoolfactory.slider

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.offset
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.onSizeChanged
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp

enum class LabelPosition {
    Top, Bottom
}

@Composable
fun SliderWithLabel(
    value: Float,
    onValueChange: (Float) -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    valueRange: ClosedFloatingPointRange<Float> = 0f..1f,
    steps: Int = 0,
    onValueChangeFinished: (() -> Unit)? = null,
    trackHeight: Dp = TrackHeight,
    thumbRadius: Dp = ThumbRadius,
    colors: MaterialSliderColors = MaterialSliderDefaults.defaultColors(),
    borderStroke: BorderStroke? = null,
    drawInactiveTrack: Boolean = true,
    coerceThumbInTrack: Boolean = false,
    labelPosition: LabelPosition = LabelPosition.Top,
    yOffset: Dp = 0.dp,
    label: @Composable () -> Unit = {}
) {
    Column(modifier = Modifier) {

        val yOffsetInt = with(LocalDensity.current) {
            yOffset.toPx().toInt()
        }

        var labelOffset by remember { mutableStateOf(Offset.Zero) }
        var labelWidth by remember { mutableStateOf(0) }

        if (labelPosition == LabelPosition.Top) {
            Box(Modifier
                .offset {
                    IntOffset(labelOffset.x.toInt() - labelWidth / 2, yOffsetInt)
                }
                .onSizeChanged {
                    labelWidth = it.width
                }
            ) {
                label()
            }
            ColorfulSlider(
                modifier = modifier,
                value = value,
                onValueChange = { value, offset ->
                    labelOffset = offset
                    onValueChange(value)
                },
                enabled = enabled,
                valueRange = valueRange,
                steps = steps,
                onValueChangeFinished = onValueChangeFinished,
                trackHeight = trackHeight,
                thumbRadius = thumbRadius,
                borderStroke = borderStroke,
                drawInactiveTrack = drawInactiveTrack,
                coerceThumbInTrack = coerceThumbInTrack,
                colors = colors
            )
        } else {
            ColorfulSlider(
                modifier = modifier,
                value = value,
                onValueChange = { value, offset ->
                    labelOffset = offset
                    onValueChange(value)
                },
                enabled = enabled,
                valueRange = valueRange,
                steps = steps,
                onValueChangeFinished = onValueChangeFinished,
                trackHeight = trackHeight,
                thumbRadius = thumbRadius,
                borderStroke = borderStroke,
                drawInactiveTrack = drawInactiveTrack,
                coerceThumbInTrack = coerceThumbInTrack,
                colors = colors
            )

            Box(Modifier
                .offset {
                    IntOffset(labelOffset.x.toInt() - labelWidth / 2, yOffsetInt)
                }
                .onSizeChanged {
                    labelWidth = it.width
                }
            ) {
                label()
            }
        }
    }
}