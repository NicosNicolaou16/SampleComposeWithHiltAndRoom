package com.nick.samplecomposewithhiltandroom.ui

import androidx.annotation.MainThread
import androidx.annotation.UiThread
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.AlertDialog
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.window.DialogProperties
import androidx.lifecycle.viewmodel.compose.viewModel
import com.nick.samplecomposewithhiltandroom.MainActivityViewModel
import com.nick.samplecomposewithhiltandroom.R
import com.nick.samplecomposewithhiltandroom.ui.theme.BlackTransparent
import com.nick.samplecomposewithhiltandroom.ui.theme.Purple200

@Composable
fun LoaderAndErrorHandler(mainActivityViewModel: MainActivityViewModel = viewModel()) {
    val isLoading = mainActivityViewModel.loading.observeAsState(initial = false).value
    if (isLoading) StartDefaultLoader()

    val error =
        mainActivityViewModel.error.observeAsState(initial = null).value
    if (error != null) ShowOKDialog(title = error, message = "")
}

@UiThread
@MainThread
@Composable
fun StartDefaultLoader() {
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .fillMaxSize()
            .background(color = BlackTransparent)
    ) {
        CircularProgressIndicator(color = Purple200)
    }
}

/**
 * this method uses to show a Alert Dialog message
 * @param title custom string message to show on the Alert Dialog
 * @param message custom string message to show on the Alert Dialog
 * */
@UiThread
@MainThread
@Composable
fun ShowOKDialog(
    title: String?,
    message: String?
) {
    val openDialog = remember { mutableStateOf(true) }
    if (openDialog.value)
        AlertDialog(
            onDismissRequest = { openDialog.value = false },
            confirmButton = {
                TextButton(onClick = {
                    openDialog.value = false
                }) { Text(text = stringResource(id = R.string.ok)) }
            },
            title = { title?.let { Text(text = it) } },
            text = { message?.let { Text(text = it) } },
            properties = DialogProperties(
                dismissOnBackPress = false,
                dismissOnClickOutside = false
            ),
        )
}