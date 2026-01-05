package com.nick.samplecomposewithhiltandroom.compose.launcher_screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.nick.samplecomposewithhiltandroom.R
import com.nick.samplecomposewithhiltandroom.compose.navigation.navigation_3.Navigator
import kotlinx.coroutines.delay

@Composable
fun LauncherScreen(navigator: Navigator) {
    LaunchedEffect(key1 = true) {
        delay(2000L)
        navigator.goBack()
    }
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.DarkGray)
    ) {
        Image(
            painter = painterResource(id = R.drawable.ic_baseline_image_24),
            contentDescription = null,
            modifier = Modifier
                .fillMaxWidth()
                .height(height = 300.dp)
        )
    }
}