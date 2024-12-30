package com.example.mynewsapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.core.view.WindowCompat
import com.example.common.presentation.ui.theme.MyNewsAppTheme
import com.example.onboarding.presentation.screen.OnBoardingScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        WindowCompat.setDecorFitsSystemWindows(window, false)   // for system bar transparent
        installSplashScreen()
        enableEdgeToEdge()
        setContent {
            MyNewsAppTheme {
                OnBoardingScreen()
            }
        }
    }
}