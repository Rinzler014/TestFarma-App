package com.example.testfarma

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.example.testfarma.databinding.FragmentLoginBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase


class Login : Fragment() {

    private var _binding : FragmentLoginBinding? = null
    private val binding get() = _binding!!

    private lateinit var auth : FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        auth = Firebase.auth
    }

    override fun onResume() {
        super.onResume()
        (activity as AppCompatActivity?)!!.supportActionBar!!.hide()
    }

    override fun onStop() {
        super.onStop()
        (activity as AppCompatActivity?)!!.supportActionBar!!.show()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentLoginBinding.inflate(inflater, container, false)
        val view = binding.root

        return view

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val mail = view.findViewById<EditText>(R.id.field_username_input_edit)
        val password = view.findViewById<EditText>(R.id.field_login_password_edit)

        val resetPassword = view.findViewById<TextView>(R.id.reset_password_button)

        val loginButton = view.findViewById<Button>(R.id.login_button)
        val createAccountButton = view.findViewById<Button>(R.id.button_create_account)

        loginButton.setOnClickListener {

            Log.d("MAIN", mail.text.toString() + " " + password.text.toString())

            if(mail.text.toString().isEmpty() || password.text.toString().isEmpty()){
                Toast.makeText(context, "Los campos no pueden ir vacios", Toast.LENGTH_SHORT).show()
            } else {

                auth.signInWithEmailAndPassword(mail.text.toString(), password.text.toString())
                    .addOnCompleteListener {
                        if (it.isSuccessful) {
                            Log.d("MAIN", "Sign In with Email Success!")
                            val action = LoginDirections.actionLoginToNavigation2(userUID = auth.currentUser?.uid.toString())
                            view.findNavController().navigate(action)
                        } else {
                            Log.w("MAIN", "Sign in with email failed", it.exception)
                            Toast.makeText(context, "Usuario o Contraseña Incorrecto", Toast.LENGTH_SHORT).show()
                        }
                    }
            }

        }

        resetPassword.setOnClickListener {

            val action = LoginDirections.actionLoginToResetPassword()
            view.findNavController().navigate(action)

        }

        createAccountButton.setOnClickListener {

            val action = LoginDirections.actionLoginToFirstFormFragment2()
            view.findNavController().navigate(action)

        }

    }

}