package com.compose.cryptocurrency.domain.model

data class PAI(
    val id:Int,
    val date:Long,
    val value:Float,
    val selected:Boolean = false,
)