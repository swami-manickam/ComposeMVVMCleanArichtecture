package com.compose.cryptocurrency.domain.usecase.datastore

import com.compose.cryptocurrency.domain.manager.LocalUserManger
import javax.inject.Inject

class SaveAppEntry @Inject constructor(private val localUserManger: LocalUserManger) {

    suspend operator fun invoke() {
    localUserManger.saveAppEntry()
    }


}