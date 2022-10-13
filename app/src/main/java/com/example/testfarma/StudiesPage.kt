package com.example.testfarma

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class StudiesPage : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_studies_page)

        val button = findViewById<Button>(R.id.estudios1);

        button.setOnClickListener {
            val intent = Intent(this, pdfReader::class.java);
            startActivity(intent) ;
        }

    }
}