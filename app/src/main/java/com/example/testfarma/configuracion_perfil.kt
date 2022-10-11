package com.example.testfarma

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.TextView
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase

class configuracion_perfil : Fragment() {
    //Instance of Firebase DataBase
    private val database = FirebaseDatabase.getInstance().reference

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_configuracion_perfil, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val username = FirebaseAuth.getInstance().currentUser?.uid.toString()
        val helloMessage = view.findViewById<TextView>(R.id.config_user)
        database.child(username).child("username").get().addOnSuccessListener {
            helloMessage.text = it.value.toString()
        }.addOnFailureListener{
            Log.e("MAIN", "Error getting data", it)
            helloMessage.text = "Usuario"
        }

        database.child(username).child("username").get().addOnSuccessListener {
           val user_name=view.findViewById<EditText>(R.id.user_name_output)
            user_name.hint=it.value.toString()

        }
        database.child(username).child("mail").get().addOnSuccessListener {
            val user_mail=view.findViewById<EditText>(R.id.mail_output)
            user_mail.hint=it.value.toString()

        }
    }

}