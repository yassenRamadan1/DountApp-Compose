package com.example.dountappcompose.composable

import android.widget.Space
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem

import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.dountappcompose.R
import com.example.dountappcompose.ui.theme.White
import com.example.dountappcompose.ui.theme.bodySmall
import com.example.dountappcompose.ui.theme.primary_color


@Composable
fun CustomBottomNav(
) {
    BottomNavigation(
        backgroundColor = White,
        elevation = 0.dp,
        modifier = Modifier.padding(bottom = 4.dp)
    ) {
        NavigationItem(painter = painterResource(id = R.drawable.home))
        NavigationItem(painter = painterResource(id = R.drawable.heart_nav))
        NavigationItem(painter = painterResource(id = R.drawable.notification))
        NavigationItem(painter = painterResource(id = R.drawable.buy))
        NavigationItem(painter = painterResource(id = R.drawable.user))
    }
}

@Composable
private fun RowScope.NavigationItem(
    painter: Painter,
    modifier: Modifier = Modifier,
    isSelected: Boolean = false,
    onClick: () -> Unit = {},
) {
    BottomNavigationItem(
        selected = isSelected,
        onClick = { onClick() },
        icon = {
            Row(
                modifier = modifier
                    .size(52.dp)
                    .clip(if (isSelected) CircleShape else RoundedCornerShape(0.dp))
                    .background(if (isSelected) primary_color else Color.Transparent),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center,
            ) {
                Icon(
                    painter = painter,
                    contentDescription = "",
                    tint = primary_color,
                    modifier = Modifier.size(30.dp)
                )

            }

        },
    )
}

