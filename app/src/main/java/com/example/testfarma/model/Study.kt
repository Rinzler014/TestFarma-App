package com.example.testfarma.model

import androidx.annotation.DrawableRes

data class Study (

    @DrawableRes val imageResourceId : Int,
    val name : String,
    val price : Float,
    val requirements : List<String>

)
