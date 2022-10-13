package com.example.testfarma.data

import com.example.testfarma.R
import com.example.testfarma.model.Promotion
import com.example.testfarma.model.Receipts
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
        ),

        UserStudy(

            R.drawable.tf_logo_single,
            "Prueba COVID-19",
            199,
            listOf("SIN REQUISITOS")
        )

    )

    val receipts : List<Receipts> = listOf(

        Receipts(

            R.drawable.tf_logo_single,
            "Jugo para el Estrés",
            18..90,
            listOf("10 almendras", "1 Platano", "1 Vaso de Agua de Coco"),
            listOf("Incorpora las almendras en la licuadora y procésalas con el banano y el agua de coco.",
                    "Bate todo hasta obtener una bebida homogénea."),
            listOf("Ingiere el jugo cuando sientas estrés.", "Tómalo como preventivo 3 veces a la semana.")

        ),

        Receipts(

            R.drawable.tf_logo_single,
            "Jugo para Adelgazar",
            30..70,
            listOf("2 cucharadas de anacardos (6 unidades)",
                    "2 cucharadas de semillas de girasol (unas 30 unidades)",
                    "1 vaso de agua (200 ml)"),
            listOf("Incorpora todos los ingredientes en la licuadora y procésalos por unos instantes."),
            listOf("Tómalo cuando tengas algún síntoma inicial de estrés.")
        ),

        Receipts(

            R.drawable.tf_logo_single,
            "Jugo para la Gastritis",
            30..70,
            listOf("2 ramas de apio",
                "½ taza de brócoli picado (75 g)",
                "½ taza de coliflor picada (75 g)",
                "1 vaso de agua (200 ml)"),
            listOf("Lava bien los vegetales e introdúcelos en la licuadora.",
                    "Agrega un vaso de agua y procesa por unos instantes, hasta obtener una bebida homogénea."),
            listOf("Toma el jugo a media mañana, en el desayuno.")
        )

    )

    val promotions : List<Promotion> = listOf(

        Promotion(R.drawable.promotion1),
        Promotion(R.drawable.promotion1),
        Promotion(R.drawable.promotion1),
        Promotion(R.drawable.promotion1)

    )



}