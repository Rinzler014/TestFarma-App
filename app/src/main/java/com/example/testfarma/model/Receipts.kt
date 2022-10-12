package com.example.testfarma.model

import androidx.annotation.DrawableRes

data class Receipts(

    @DrawableRes val imageResourceId : Int,
    val name : String,
    val recom_age : IntRange,
    val ingredients : List<String>,
    val preparation : List<String>,
    val consumptionMode : List<String>

)
