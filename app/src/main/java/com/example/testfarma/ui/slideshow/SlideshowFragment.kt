package com.example.testfarma.ui.slideshow

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.testfarma.R
import com.example.testfarma.databinding.FragmentSlideshowBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase

class SlideshowFragment : Fragment() {

    private var _binding: FragmentSlideshowBinding? = null
    private val binding get() = _binding!!

    //Instance of Firebase DataBase
    private val database = FirebaseDatabase.getInstance().reference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentSlideshowBinding.inflate(inflater, container, false)
        val view = binding.root

        return view
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val userUID = FirebaseAuth.getInstance().currentUser?.uid.toString()

        val helloMessage = view.findViewById<TextView>(R.id.datos_user)
        database.child(userUID).child("username").get().addOnSuccessListener {
            helloMessage.text = it.value.toString()
        }.addOnFailureListener{
            Log.e("MAIN", "Error getting data", it)
            helloMessage.text = "Usuario"
        }
        database.child(userUID).child("birthdate").get().addOnSuccessListener {
            val user_date=view.findViewById<TextView>(R.id.date_out)
            user_date.text=it.value.toString()

        }
        database.child(userUID).child("gender").get().addOnSuccessListener {
            val user_gender=view.findViewById<TextView>(R.id.genero_out)
            user_gender.text=it.value.toString()

        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}