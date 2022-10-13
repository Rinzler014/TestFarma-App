package com.example.testfarma

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.pdfview.PDFView

class pdfReader : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pdf_reader)

        val pdf = findViewById<PDFView>(R.id.pdfBox);

        pdf.fromAsset("RESULTADOS-186190.pdf").show();

        val buttonGoBack = findViewById<Button>(R.id.goBack);

        buttonGoBack.setOnClickListener {
            startActivity(Intent(this,UserStudies::class.java))
        }

    }
}