package com.example.testfarma.data

import com.example.testfarma.R
import com.example.testfarma.model.Study
import com.example.testfarma.model.UserStudy


object DataSource {


    val clinicalStudies : List<Study> = listOf(

        Study(
            R.drawable.tf_logo_single,
            "Pruebas de Antígeno SarS-CoV2.",
            129,
            listOf("Ayuno 8 Horas", "Sin limpieza bucal previa")
        ),

        Study(
            R.drawable.tf_logo_single,
            "Pruebas PCR-RT, en alianza con Laboratorio MDT.",
            299,
            listOf("Sin limpieza bucal previa")
        ),

        Study(
            R.drawable.tf_logo_single,
            "Pruebas Serológicas de anticuerpos.",
            0,
            listOf("Sin requisitos")
        ),

        Study(
            R.drawable.tf_logo_single,
            "Productos Farmacéuticos (Pronto Disponibles)",
            0,
            listOf("Sin requisitos")
        )

    )

    val userStudies : List<UserStudy> = listOf(

        UserStudy(

            R.drawable.tf_logo_single,
            "Prueba COVID-19 ANTIGENO",
            79,
            listOf("SIN REQUISITOS")
        )

    )

}