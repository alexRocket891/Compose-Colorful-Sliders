package com.smarttoolfactory.slider

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.offset
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.layout.onSizeChanged
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.IntOffset

@Composable
fun SliderWithTitle(
    value: Float,
    onValueChange: (Float) -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    valueRange: ClosedFloatingPointRange<Float> = 0f..1f,
    steps: Int = 0,
    onValueChangeFinished: (() -> Unit)? = null,
    trackHeight: Dp = TrackHeight,
    thumbRadius: Dp = ThumbRadius,
    coerceThumbInTrack: Boolean = false,
    drawInactiveTrack: Boolean = true,
    label: @Composable () -> Unit = {},
    colors: MaterialSliderColors = MaterialSliderDefaults.defaultColors()
) {
    Column(modifier = Modifier) {

        var labelOffset by remember { mutableStateOf(Offset.Zero) }
        var labelWidth by remember { mutableStateOf(0) }

        Box(Modifier
            .offset {
                IntOffset(labelOffset.x.toInt() - labelWidth / 2, labelOffset.y.toInt())
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
            coerceThumbInTrack = coerceThumbInTrack,
            drawInactiveTrack = drawInactiveTrack,
            colors = colors
        )
    }
}