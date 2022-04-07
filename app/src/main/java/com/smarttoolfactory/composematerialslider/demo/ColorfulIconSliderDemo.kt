package com.smarttoolfactory.composematerialslider.demo

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ThumbUp
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.smarttoolfactory.composematerialslider.R
import com.smarttoolfactory.composematerialslider.ui.theme.Blue400
import com.smarttoolfactory.composematerialslider.ui.theme.Pink400
import com.smarttoolfactory.composematerialslider.ui.theme.Purple400
import com.smarttoolfactory.composematerialslider.ui.theme.Red400
import com.smarttoolfactory.composematerialslider.ui.theme.brush.instaGradient
import com.smarttoolfactory.composematerialslider.ui.theme.brush.sunriseGradient
import com.smarttoolfactory.composematerialslider.ui.theme.brush.sunsetGradient
import com.smarttoolfactory.slider.ColorfulIconSlider
import com.smarttoolfactory.slider.MaterialSliderDefaults
import com.smarttoolfactory.slider.SliderBrushColor

@Composable
fun ColorfulIconSliderDemo() {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(20.dp)
    ) {
        var progress by remember { mutableStateOf(0f) }

        TitleText("Text Thumb with Emoji")
        ColorfulIconSlider(
            value = progress,
            onValueChange = { value, offset ->
                progress = value
            },
        ) {
            Text(text = "😃", fontSize = 20.sp, color = Color.Black)
        }

        ColorfulIconSlider(
            value = progress,
            onValueChange = { value, offset ->
                progress = value
            },
            trackHeight = 12.dp,
            colors = MaterialSliderDefaults.materialColors(
                activeTrackColor = SliderBrushColor(color = Red400),
                inactiveTrackColor = SliderBrushColor(color = Color.Transparent)
            ),
            borderStroke = BorderStroke(1.dp, Red400)
        ) {
            Text(text = "😍️", fontSize = 30.sp, color = Color.Black)
        }

        ColorfulIconSlider(
            value = progress,
            onValueChange = { value, offset ->
                progress = value
            },
            trackHeight = 14.dp,
            colors = MaterialSliderDefaults.materialColors(
                activeTrackColor = SliderBrushColor(color = Blue400),
                inactiveTrackColor = SliderBrushColor(color = Color.Transparent)
            ),
            borderStroke = BorderStroke(1.dp, Blue400)
        ) {
            Text(text = "👍", fontSize = 40.sp, color = Color.Black)
        }


        ColorfulIconSlider(
            value = progress,
            onValueChange = { value, offset ->
                progress = value
            },
            trackHeight = 14.dp
        ) {
            Text(text = "😆", fontSize = 40.sp, color = Color.Black)
        }

        ColorfulIconSlider(
            value = progress,
            onValueChange = { value, offset ->
                progress = value
            },
            trackHeight = 14.dp
        ) {
            Text(text = "😂😂😂", fontSize = 30.sp, color = Color.Black)
        }


        TitleText("Box Thumb with Shape")
        ColorfulIconSlider(
            value = progress,
            onValueChange = { value, offset ->
                progress = value
            },
            trackHeight = 10.dp
        ) {
            Box(
                modifier = Modifier
                    .size(40.dp)
                    .border(4.dp, Red400, CircleShape)
            )
        }

        ColorfulIconSlider(
            value = progress,
            onValueChange = { value, offset ->
                progress = value
            },
            trackHeight = 10.dp,
            colors = MaterialSliderDefaults.materialColors()
        ) {
            Box(
                modifier = Modifier
                    .size(40.dp)
                    .shadow(1.dp, RoundedCornerShape(10.dp))
                    .background(Pink400, RoundedCornerShape(10.dp))
            )
        }

        ColorfulIconSlider(
            value = progress,
            onValueChange = { value, offset ->
                progress = value
            },
            trackHeight = 10.dp,
            colors = MaterialSliderDefaults.materialColors(
                inactiveTrackColor = SliderBrushColor(color = Color.Transparent),
                activeTrackColor = SliderBrushColor(
                    brush = sunriseGradient(),
                )
            ),
            borderStroke = BorderStroke(2.dp, sunriseGradient())
        ) {
            Box(
                modifier = Modifier
                    .size(40.dp)
                    .shadow(2.dp, CutCornerShape(5.dp))
                    .background(Purple400, CutCornerShape(5.dp))
            )
        }

        TitleText("Icon Thumb")
        ColorfulIconSlider(
            value = progress,
            onValueChange = { value, offset ->
                progress = value
            },
            trackHeight = 10.dp,
            colors = MaterialSliderDefaults.materialColors(
                inactiveTrackColor = SliderBrushColor(color = Color.Transparent),
                activeTrackColor = SliderBrushColor(
                    brush = sunsetGradient(),
                )
            ),
            borderStroke = BorderStroke(2.dp, sunsetGradient())
        ) {
            Icon(
                imageVector = Icons.Filled.ThumbUp,
                contentDescription = null,
                modifier = Modifier.size(40.dp),
                tint = Red400
            )
        }

        TitleText("Image Thumb")
        ColorfulIconSlider(
            value = progress,
            onValueChange = { value, offset ->
                progress = value
            },
            trackHeight = 10.dp,
            colors = MaterialSliderDefaults.materialColors(
                inactiveTrackColor = SliderBrushColor(color = Color.Transparent),
                activeTrackColor = SliderBrushColor(
                    brush = instaGradient(),
                )
            ),
            borderStroke = BorderStroke(2.dp, instaGradient())
        ) {
            Image(
                painter = painterResource(id = R.drawable.stf),
                contentDescription = null,
                modifier = Modifier.size(40.dp)
            )
        }
    }
}

