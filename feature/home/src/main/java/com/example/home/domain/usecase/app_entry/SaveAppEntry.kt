package com.example.home.domain.usecase.app_entry

import com.example.home.domain.manager.LocalUserManager

class SaveAppEntry(
    private val localUserManager: LocalUserManager
) {
    suspend fun invoke() {
        localUserManager.saveAppEntry()
    }
}