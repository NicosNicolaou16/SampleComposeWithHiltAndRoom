package com.nick.samplecomposewithhiltandroom.compose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.nick.samplecomposewithhiltandroom.compose.navigation.Navigation
import com.nick.samplecomposewithhiltandroom.ui.theme.SampleComposeWithHiltAndRoomTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SampleComposeWithHiltAndRoomTheme {
                Navigation()
            }
        }
    }
}