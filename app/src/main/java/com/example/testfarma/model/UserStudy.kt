package com.example.testfarma.model

import androidx.annotation.DrawableRes

data class UserStudy(

    @DrawableRes val imageResourceId : Int,
    val name : String,
    val price : Int,
    val requirements : List<String>

)
