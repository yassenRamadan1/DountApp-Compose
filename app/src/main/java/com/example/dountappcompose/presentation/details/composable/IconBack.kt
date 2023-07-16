package com.example.dountappcompose.presentation.details.composable

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.dountappcompose.R

@Composable
fun IconBack(
    onClickBack: () -> Unit
){
    IconButton(onClickBack, modifier = Modifier.wrapContentSize()) {
        Image(painter = painterResource(id = R.drawable.icon_back2)
            , contentDescription = ""
            , modifier = Modifier.size(30.dp)
        )
    }
}