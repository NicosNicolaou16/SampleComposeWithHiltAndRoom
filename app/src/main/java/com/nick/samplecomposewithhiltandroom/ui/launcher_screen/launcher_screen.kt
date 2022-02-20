package com.nick.samplecomposewithhiltandroom.ui.launcher_screen

import androidx.compose.animation.core.Animatable
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavController
import com.nick.samplecomposewithhiltandroom.R
import com.nick.samplecomposewithhiltandroom.utils.screen_routes.Screens.SHIPS_SCREEN
import kotlinx.coroutines.delay

@Composable
fun LauncherScreen(navController: NavController) {
    val scale = remember {
        Animatable(0f)
    }
    LaunchedEffect(key1 = true) {
        delay(2000L)
        navController.navigate(SHIPS_SCREEN)
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
            modifier = Modifier.scale(scale.value)
        )
    }
}