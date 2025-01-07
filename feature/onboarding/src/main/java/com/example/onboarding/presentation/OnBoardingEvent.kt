package com.example.onboarding.presentation

sealed class OnBoardingEvent {
    object SaveAppEntry: OnBoardingEvent()
}