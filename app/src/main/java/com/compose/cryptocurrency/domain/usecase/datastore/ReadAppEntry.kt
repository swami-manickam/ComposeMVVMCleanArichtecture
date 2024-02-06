package com.compose.cryptocurrency.domain.usecase.datastore

import com.compose.cryptocurrency.domain.manager.LocalUserManger
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class ReadAppEntry @Inject constructor(private val localUserManger: LocalUserManger) {

     operator fun invoke(): Flow<Boolean> {
        return localUserManger.readAppEntry()
    }


}