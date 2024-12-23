package com.learn.bottomsheetjetpackcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.animation.core.animateIntAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.runtime.snapshotFlow
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.animateLottieCompositionAsState
import com.airbnb.lottie.compose.rememberLottieComposition
import com.learn.bottomsheetjetpackcompose.ui.theme.BottomSheetJetpackComposeTheme
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BottomSheetJetpackComposeTheme {
                MainScreen()
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen() {
    val sheetState = rememberModalBottomSheetState()
    val scope = rememberCoroutineScope()
    var showBottomSheet by rememberSaveable { mutableStateOf(false) }
    Scaffold(
        floatingActionButton = {
            ExtendedFloatingActionButton(
                text = {
                    Text(text = "Show Bottom Sheet")
                },
                icon = {
                    Icon(imageVector = Icons.Filled.Add, contentDescription = null)
                },
                onClick = {
                    showBottomSheet = true
                }
            )
        }
    ) { contentPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(
                    top = contentPadding.calculateTopPadding(),
                    start = 20.dp, end = 20.dp
                ),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Main Screen",
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold
            )
        }

        if (showBottomSheet) {
            ModalBottomSheet(
                onDismissRequest = {
                    showBottomSheet = false
                },
                sheetState = sheetState
            ) {
                BottomSheetContent(onButtonClick = {
                    scope.launch {
                        sheetState.hide()
                    }.invokeOnCompletion {
                        if (!sheetState.isVisible) {
                            showBottomSheet = false
                        }
                    }
                })
            }
        }
    }
}


@Composable
fun BottomSheetContent(onButtonClick: () -> Unit) {
    val animateProgress = rememberSaveable {
        mutableIntStateOf(0)
    }
    LaunchedEffect(Unit) {
        animateProgress.intValue = 80
    }
    val number = animateIntAsState(
        targetValue = animateProgress.intValue,
        animationSpec = tween(durationMillis = 2000), label = "",
    )
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .verticalScroll(rememberScrollState())
            .padding(vertical = 20.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = number.value.toString(),
            fontSize = 20.sp
        )
        ShowLottie()

        Text(
            text = "Modal Bottom Sheet",
            modifier = Modifier.padding(vertical = 20.dp)
        )
        Text(
            text = "Modal Bottom Sheet",
            modifier = Modifier.padding(vertical = 20.dp)
        )
        Text(
            text = "Modal Bottom Sheet",
            modifier = Modifier.padding(vertical = 20.dp)
        )
        Text(
            text = "Modal Bottom Sheet",
            modifier = Modifier.padding(vertical = 20.dp)
        )
        Text(
            text = "Modal Bottom Sheet",
            modifier = Modifier.padding(vertical = 20.dp)
        )
        Text(
            text = "Modal Bottom Sheet",
            modifier = Modifier.padding(vertical = 20.dp)
        )
        Text(
            text = "Modal Bottom Sheet",
            modifier = Modifier.padding(vertical = 20.dp)
        )
        Text(
            text = "Modal Bottom Sheet",
            modifier = Modifier.padding(vertical = 20.dp)
        )
        Text(
            text = "Modal Bottom Sheet",
            modifier = Modifier.padding(vertical = 20.dp)
        )
        Text(
            text = "Modal Bottom Sheet",
            modifier = Modifier.padding(vertical = 20.dp)
        )
        Text(
            text = "Modal Bottom Sheet",
            modifier = Modifier.padding(vertical = 20.dp)
        )
        Text(
            text = "Modal Bottom Sheet",
            modifier = Modifier.padding(vertical = 20.dp)
        )
        Text(
            text = "Modal Bottom Sheet",
            modifier = Modifier.padding(vertical = 20.dp)
        )
        Text(
            text = "Modal Bottom Sheet",
            modifier = Modifier.padding(vertical = 20.dp)
        )
        Text(
            text = "Modal Bottom Sheet",
            modifier = Modifier.padding(vertical = 20.dp)
        )
        Text(
            text = "Modal Bottom Sheet",
            modifier = Modifier.padding(vertical = 20.dp)
        )
        Text(
            text = "Modal Bottom Sheet",
            modifier = Modifier.padding(vertical = 20.dp)
        )
        Button(onClick = {
            onButtonClick.invoke()
        }) {
            Text(text = "Hide bottom sheet")
        }
    }
}

@Composable
fun ShowLottie() {
    val composition by rememberLottieComposition(
        spec = LottieCompositionSpec.RawRes(resId = R.raw.lottie_fire)
    )
    var isPlaying by rememberSaveable {
        mutableStateOf(true)
    }
    val progress by animateLottieCompositionAsState(
        composition = composition,
        isPlaying = isPlaying
    )
    LaunchedEffect(composition) {
        snapshotFlow { progress }
            .collect { progress ->
                if (progress >= 1f) {
                    isPlaying = false
                }
            }
    }
    if (isPlaying) {
        LottieAnimation(
            modifier = Modifier.size(150.dp),
            composition = composition,
            progress = {
                progress
            }
        )
    }
}
