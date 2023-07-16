package com.example.dountappcompose.composable

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.dountappcompose.ui.theme.frame_back_ground

@Composable
fun BottomSheet(
    modifier: Modifier = Modifier,
    arrangement: Arrangement = Arrangement,
    content: @Composable ColumnScope.() -> Unit,

) {
    Surface(
        modifier = modifier
            .clip(RoundedCornerShape(topStartPercent = 15, topEndPercent = 15))
            .fillMaxSize()
            .background(frame_back_ground),
    ) {
        Column(
            modifier = Modifier.padding(vertical = 16.dp),
            verticalArrangement = arrangement.spacedBy(16.dp)
        ) {
            content(this)
        }
    }
}
@Preview
@Composable
fun BottomSheetPreview(){
    BottomSheet(){}
}