package com.example.testfarma.data

import com.example.testfarma.R
import com.example.testfarma.model.Study


object DataSource {


    val clinicalStudies : List<Study> = listOf(

        Study(
            R.drawable.tf_logo_single,
            "Prueba COVID 1",
            99.00F,
            listOf("Ayuno 8 Horas", "Sin limpieza bucal")
        )


    )

}