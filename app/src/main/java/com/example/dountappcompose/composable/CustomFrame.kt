package com.example.dountappcompose.composable

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ShapeDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.dountappcompose.ui.theme.White

@Composable
fun CustomFrame(
    modifier: Modifier= Modifier,
    size: Dp=30.dp,
    shape:RoundedCornerShape= CircleShape,
    color: Color= White,
    content:@Composable BoxScope.() -> Unit,
){
    Box(contentAlignment = Alignment.Center
        ,modifier = modifier
            .size(size)
            .background(color, shape)
    )
        {
            content(this)
                 }
}