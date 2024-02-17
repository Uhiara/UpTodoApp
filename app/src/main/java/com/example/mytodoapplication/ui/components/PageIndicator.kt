package com.example.mytodoapplication.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.mytodoapplication.R
import com.example.mytodoapplication.ui.theme.Gray


@Composable
fun PageIndicator(
    modifier: Modifier = Modifier,
    pageSize: Int,
    selectedPage: Int,
    selectedColor: Color = if (isSystemInDarkTheme()) Color.White else colorResource(id = R.color.text_button),
    unselectedColor: Color = Gray
) {
    Row(modifier = modifier, horizontalArrangement = Arrangement.Center) {
        repeat(pageSize) { page ->
            Box(
                modifier = Modifier
                    .clip(RoundedCornerShape(4.dp))
                    .height(2.dp)
                    .width(28.dp)
                    .background(color = if (page == selectedPage) selectedColor else unselectedColor)
            )
            if (page < pageSize - 1) {
                Spacer(modifier = Modifier.width(4.dp))
            }
        }
    }
}

@Preview
@Composable
fun PageIndicatorPreview() {
    PageIndicator(pageSize = 3, selectedPage = 1, selectedColor = Color.Red)
}