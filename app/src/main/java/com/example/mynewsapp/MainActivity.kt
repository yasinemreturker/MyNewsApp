package com.example.mynewsapp

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.core.view.WindowCompat
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.ViewModel
import androidx.lifecycle.lifecycleScope
import com.example.common.presentation.ui.theme.MyNewsAppTheme
import com.example.onboarding.domain.usecase.AppEntryUseCases
import com.example.onboarding.presentation.OnBoardingViewModel
import com.example.onboarding.presentation.screen.OnBoardingScreen
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    @Inject
    lateinit var appEntryUseCases: AppEntryUseCases

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        WindowCompat.setDecorFitsSystemWindows(window, false)   // for system bar transparent
        installSplashScreen()
        enableEdgeToEdge()

        lifecycleScope.launch {
            appEntryUseCases.readAppEntry().collect {
                Log.d("Test", it.toString())
            }
        }

        setContent {
            MyNewsAppTheme {
                val viewModel: OnBoardingViewModel = hiltViewModel()
                OnBoardingScreen(event = viewModel::OnEvent)
            }
        }
    }
}