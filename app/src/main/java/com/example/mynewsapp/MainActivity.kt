package com.example.mynewsapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.material3.MaterialTheme
import androidx.compose.ui.Modifier
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.core.view.WindowCompat
import com.example.common.presentation.ui.theme.MyNewsAppTheme
import com.example.navigator.navgraph.NavGraph
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    val viewModel by viewModels<MainViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        WindowCompat.setDecorFitsSystemWindows(window, false)   // for system bar transparent
        enableEdgeToEdge()

         installSplashScreen().apply {
            setKeepOnScreenCondition {
                viewModel.splashCondition
            }
        }

        setContent {
            MyNewsAppTheme {
                Box(
                    modifier = Modifier.background(color = MaterialTheme.colorScheme.background)
                ){
                    val startDestination = viewModel.startDestination
                    NavGraph(startDestination = startDestination)
                }
            }
        }
    }
}