package com.example.testfarma

data class User(val name : String,
                val lastname : String,
                val mom_lastname : String,
                val birthdate : String,
                val gender : String,
                val username : String,
                val mail : String,
                val past_meetings : List<String> = listOf(),
                val upcoming_meeting : String = "00/00/0000") {

}