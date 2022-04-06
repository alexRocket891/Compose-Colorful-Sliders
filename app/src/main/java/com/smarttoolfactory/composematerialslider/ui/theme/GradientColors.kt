package com.smarttoolfactory.composematerialslider.ui.theme

import androidx.compose.ui.graphics.Color


fun gradientColorScaleHSV(
    saturation: Float = 1f,
    value: Float = 1f,
    alpha: Float = 1f
) = listOf(
    Color.hsv(hue = 0f, saturation = saturation, value = value, alpha = alpha),
    Color.hsv(hue = 60f, saturation = saturation, value = value, alpha = alpha),
    Color.hsv(hue = 120f, saturation = saturation, value = value, alpha = alpha),
    Color.hsv(hue = 180f, saturation = saturation, value = value, alpha = alpha),
    Color.hsv(hue = 240f, saturation = saturation, value = value, alpha = alpha),
    Color.hsv(hue = 300f, saturation = saturation, value = value, alpha = alpha),
    Color.hsv(hue = 360f, saturation = saturation, value = value, alpha = alpha)
)

fun gradientColorScaleHSL(
    saturation: Float = 1f,
    lightness: Float = .5f,
    alpha: Float = 1f
) = listOf(
    Color.hsl(hue = 0f, saturation = saturation, lightness = lightness, alpha = alpha),
    Color.hsl(hue = 60f, saturation = saturation, lightness = lightness, alpha = alpha),
    Color.hsl(hue = 120f, saturation = saturation, lightness = lightness, alpha = alpha),
    Color.hsl(hue = 180f, saturation = saturation, lightness = lightness, alpha = alpha),
    Color.hsl(hue = 240f, saturation = saturation, lightness = lightness, alpha = alpha),
    Color.hsl(hue = 300f, saturation = saturation, lightness = lightness, alpha = alpha),
    Color.hsl(hue = 360f, saturation = saturation, lightness = lightness, alpha = alpha)
)


val gradientColorScaleRGB = listOf(
    Color.Red,
    Color.Magenta,
    Color.Blue,
    Color.Cyan,
    Color.Green,
    Color.Yellow,
    Color.Red
)

val gradientColorScaleRGBReversed = listOf(
    Color.Red,
    Color.Yellow,
    Color.Green,
    Color.Cyan,
    Color.Blue,
    Color.Magenta,
    Color.Red
)

val silverColors = listOf(
    Color(0xffC0C0C0),
    Color(0xffFFFFFF),
    Color(0xffC0C0C0),
    Color(0xffA9A9A9),
    Color(0xffFFFFFF),
    Color(0xff808080),
)
val silverColors2 = listOf(
    Color(0xffC0C0C0),
    Color(0xffCFCFCF),
    Color(0xffDDDDDD),
    Color(0xffCFCFCF),
    Color(0xff808080),
    )
val goldColors = listOf(
    Color(0xffBF953F),
    Color(0xffFCF6BA),
    Color(0xffB38728),
    Color(0xffFBF5B7),
    Color(0xffAA771C),
)

val sunsetColors = listOf(
    Color(0xff040308),
    Color(0xffAD4A28),
    Color(0xffDD723C),
    Color(0xffFC7001),
    Color(0xffDCB697),
    Color(0xff9BA5AE),
    Color(0xff3E5879),
    Color(0xff020B1A)
)