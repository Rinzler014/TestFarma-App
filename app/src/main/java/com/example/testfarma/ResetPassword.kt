package com.example.testfarma

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import com.example.testfarma.databinding.FragmentResetPasswordBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase


class ResetPassword : Fragment() {

    private lateinit var auth : FirebaseAuth
    private var _binding : FragmentResetPasswordBinding? = null
    val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        auth = Firebase.auth
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        _binding = FragmentResetPasswordBinding.inflate(inflater, container, false)
        val view = binding.root

        return view

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val email = view.findViewById<EditText>(R.id.field_reset_email_edit)

        val resetButton = view.findViewById<Button>(R.id.reset_button)

        resetButton.setOnClickListener {

            auth.sendPasswordResetEmail(email.text.toString()).addOnCompleteListener {

                if(it.isSuccessful) {

                    Log.d("MAIN", email.text.toString())
                    val intent = Intent(context, PopUpWindow::class.java)
                    intent.putExtra("popuptitle", "Recuperacion de Contraseña")
                    intent.putExtra("popuptext", getString(R.string.pop_up_label_message))
                    intent.putExtra("popupbtn", getString(R.string.continue_label))
                    intent.putExtra("darkstatusbar", false)
                    startActivity(intent)

                } else {

                    Log.w("MAIN", "Error sending email", it.exception)
                    val intent = Intent(context, PopUpWindow::class.java)
                    intent.putExtra("popuptitle", "Recuperacion de Contraseña")
                    intent.putExtra("popuptext", "Error al recuperar contraseña, vuelve a intentarlo")
                    intent.putExtra("popupbtn", getString(R.string.continue_label))
                    intent.putExtra("darkstatusbar", false)
                    startActivity(intent)

                }

            }



        }


    }


}