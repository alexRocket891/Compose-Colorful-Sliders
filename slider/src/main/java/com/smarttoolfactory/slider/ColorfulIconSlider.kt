package com.smarttoolfactory.slider

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.requiredSizeIn
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberUpdatedState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PointMode
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.input.pointer.consumeDownChange
import androidx.compose.ui.input.pointer.consumePositionChange
import androidx.compose.ui.layout.Layout
import androidx.compose.ui.layout.Measurable
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.unit.Constraints
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import com.smarttoolfactory.slider.gesture.pointerMotionEvents

@Composable
fun ColorfulIconSlider(
    modifier: Modifier = Modifier,
    value: Float,
    onValueChange: (Float, Offset) -> Unit,
    enabled: Boolean = true,
    valueRange: ClosedFloatingPointRange<Float> = 0f..1f,
    steps: Int = 0,
    onValueChangeFinished: (() -> Unit)? = null,
    trackHeight: Dp = TrackHeight,
    coerceThumbInTrack: Boolean = false,
    drawInactiveTrack: Boolean = true,
    colors: MaterialSliderColors = MaterialSliderDefaults.defaultColors(),
    thumb: @Composable () -> Unit
) {

    require(steps >= 0) { "steps should be >= 0" }
    val onValueChangeState = rememberUpdatedState(onValueChange)
    val tickFractions = remember(steps) {
        stepsToTickFractions(steps)
    }
    BoxWithConstraints(
        modifier = modifier
            .minimumTouchTargetSize()
            .requiredSizeIn(
                minWidth = ThumbRadius * 2,
                minHeight = ThumbRadius * 2,
                maxHeight = 48.dp
            ),
        contentAlignment = Alignment.CenterStart
    ) {

        val isRtl = LocalLayoutDirection.current == LayoutDirection.Rtl

        val width = constraints.maxWidth.toFloat()

        // Start of the track used for measuring progress,
        // it's line + radius of cap which is half of height of track
        // to draw this on canvas starting point of line
        // should be at trackStart + trackHeightInPx / 2 while drawing
        val trackStart: Float
        // End of the track that is used for measuring progress
        val trackEnd: Float
        val strokeRadius: Float
        with(LocalDensity.current) {
            strokeRadius = trackHeight.toPx() / 2
            trackStart = strokeRadius
            trackEnd = width - trackStart
        }
        val trackHeightPx = strokeRadius * 2

        // Sales and interpolates from offset from dragging to user value in valueRange
        fun scaleToUserValue(offset: Float) =
            scale(trackStart, trackEnd, offset, valueRange.start, valueRange.endInclusive)

        // Scales user value using valueRange to position on x axis on screen
        fun scaleToOffset(userValue: Float) =
            scale(valueRange.start, valueRange.endInclusive, userValue, trackStart, trackEnd)

        val rawOffset = remember { mutableStateOf(scaleToOffset(value)) }

        CorrectValueSideEffect(::scaleToOffset, valueRange, trackStart..trackEnd, rawOffset, value)

        val coerced = value.coerceIn(valueRange.start, valueRange.endInclusive)
        val fraction = calculateFraction(valueRange.start, valueRange.endInclusive, coerced)

        val dragModifier = Modifier.pointerMotionEvents(
            onDown = {
                if (enabled) {
                    rawOffset.value = if (!isRtl) it.position.x else trackEnd - it.position.x
                    val offsetInTrack = rawOffset.value.coerceIn(trackStart, trackEnd)
                    onValueChangeState.value.invoke(
                        scaleToUserValue(offsetInTrack),
                        Offset(rawOffset.value, strokeRadius)
                    )
                    it.consumeDownChange()
                }
            },
            onMove = {
                if (enabled) {
                    rawOffset.value = if (!isRtl) it.position.x else trackEnd - it.position.x
                    val offsetInTrack = rawOffset.value.coerceIn(trackStart, trackEnd)
                    onValueChangeState.value.invoke(
                        scaleToUserValue(offsetInTrack),
                        Offset(rawOffset.value, strokeRadius)
                    )
                    it.consumePositionChange()
                }

            },
            onUp = {
                if (enabled) {
                    onValueChangeFinished?.invoke()
                    it.consumeDownChange()
                }
            }
        )


        val content = @Composable {
            IconSliderImpl(
                enabled = enabled,
                fraction = fraction,
                trackStart = trackStart,
                tickFractions = tickFractions,
                colors = colors,
                trackHeight = trackHeightPx,
                drawInactiveTrack = drawInactiveTrack,
                modifier = dragModifier.background(Color.Yellow)
            )

            thumb()
        }


        Layout(
            modifier = modifier,
            content = content
        ) { measurables: List<Measurable>, constraints: Constraints ->

            val placeables = measurables.map { measurable: Measurable ->
                measurable.measure(constraints)
            }
            val track = placeables.first()
            val thumbPlaceable = placeables.last()
            val trackWidth = trackEnd - trackStart
            val thumbWidth = thumbPlaceable.width

            val height = (track.height.coerceAtLeast(thumbPlaceable.height)).toInt()

            layout(trackWidth.toInt(), height) {
                track.placeRelative(0, 0)
                thumbPlaceable.placeRelative(
                    (fraction * trackWidth).toInt(),
                    (height - thumbPlaceable.height) / 2
                )
            }
        }

    }
}

@Composable
private fun IconSliderImpl(
    enabled: Boolean,
    fraction: Float,
    trackStart: Float,
    tickFractions: List<Float>,
    colors: MaterialSliderColors,
    trackHeight: Float,
    drawInactiveTrack: Boolean,
    modifier: Modifier,
) {

    Box(
        // DefaultSliderConstraints constrains this Box with min width and max height
        modifier.then(DefaultSliderConstraints)
    ) {

        Track(
            modifier = Modifier
                .align(Alignment.CenterStart)
                .fillMaxSize(),
            fraction = fraction,
            tickFractions = tickFractions,
            trackStart = trackStart,
            trackHeight = trackHeight,
            colors = colors,
            enabled = enabled,
            drawInactiveTrack = drawInactiveTrack
        )
    }
}

@Composable
private fun Track(
    modifier: Modifier,
    fraction: Float,
    tickFractions: List<Float>,
    trackStart: Float,
    trackHeight: Float,
    colors: MaterialSliderColors,
    enabled: Boolean,
    drawInactiveTrack: Boolean,
) {

    val debug = false

    // Colors for drawing track and/or ticks
    val activeTrackColor: Brush =
        colors.trackColor(enabled = enabled, active = true).value
    val inactiveTrackColor: Brush =
        colors.trackColor(enabled = enabled, active = false).value
    val inactiveTickColor = colors.tickColor(enabled, active = false).value
    val activeTickColor = colors.tickColor(enabled, active = true).value

    // stroke radius is used for drawing length it adds this radius to both sides of the line
    val strokeRadius = trackHeight / 2

    // Start of drawing in Canvas
    // when not coerced set start of drawing line at trackStart + strokeRadius
    // to limit drawing start edge at track start end edge at track end

    // When coerced move edges of drawing by thumb radius to cover thumb edges in drawing
    // it needs to move to right as stroke radius minus thumb radius to match track start
    val drawStart = trackStart

    Canvas(modifier = modifier) {
        val width = size.width
        val isRtl = layoutDirection == LayoutDirection.Rtl

        val centerY = center.y

        // left side of the slider that is drawn on canvas, left tip of stroke radius on left side
        val sliderLeft = Offset(drawStart, centerY)
        // right side of the slider that is drawn on canvas, right tip of stroke radius on left side
        val sliderRight = Offset((width - drawStart).coerceAtLeast(drawStart), centerY)

        val sliderStart = if (isRtl) sliderRight else sliderLeft
        val sliderEnd = if (isRtl) sliderLeft else sliderRight

        val sliderValue = Offset(
            sliderStart.x + (sliderEnd.x - sliderStart.x) * fraction,
            center.y
        )

        drawLine(
            brush = inactiveTrackColor,
            start = sliderStart,
            end = sliderEnd,
            strokeWidth = trackHeight,
            cap = StrokeCap.Round
        )

        drawLine(
            brush = activeTrackColor,
            start = sliderStart,
            end = if (drawInactiveTrack) sliderValue else sliderEnd,
            strokeWidth = trackHeight,
            cap = StrokeCap.Round
        )

        if (debug) {
            drawLine(
                color = Color.Yellow,
                start = sliderStart,
                end = sliderEnd,
                strokeWidth = strokeRadius / 4
            )
        }

        if (drawInactiveTrack) {
            tickFractions.groupBy { it > fraction }
                .forEach { (outsideFraction, list) ->
                    drawPoints(
                        points = list.map {
                            Offset(
                                androidx.compose.ui.geometry.lerp(sliderStart, sliderEnd, it).x,
                                center.y
                            )
                        },
                        pointMode = PointMode.Points,
                        brush = if (outsideFraction) inactiveTickColor
                        else activeTickColor,
                        strokeWidth = strokeRadius,
                        cap = StrokeCap.Round
                    )
                }
        }
    }
}