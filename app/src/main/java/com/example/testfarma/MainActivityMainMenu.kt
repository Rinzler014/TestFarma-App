package com.example.testfarma

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_menu)
    }
    fun toastMessage(view: View) {
        val messageEditText = "Boton!"
        val message = messageEditText.toString()
        var toast = Toast.makeText(this, message, Toast.LENGTH_LONG).also {
            it.show()
        }
    }
}