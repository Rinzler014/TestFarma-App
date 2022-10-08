package com.example.testfarma

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
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

        val resetButton = view.findViewById<Button>(R.id.reset_button)

        resetButton.setOnClickListener {

            val intent = Intent(context, PopUpWindow::class.java)
            intent.putExtra("popuptitle", "Recuperacion de Contraseña")
            intent.putExtra("popuptext", getString(R.string.pop_up_label_message))
            intent.putExtra("popupbtn", getString(R.string.continue_label))
            intent.putExtra("darkstatusbar", false)
            startActivity(intent)

        }


    }


}