package com.example.testfarma.ui.home

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.testfarma.R
import com.example.testfarma.databinding.FragmentHomeBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.ktx.Firebase

class HomeFragment : Fragment() {


    private var _binding: FragmentHomeBinding? = null
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
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root
        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val userUID = FirebaseAuth.getInstance().currentUser?.uid.toString()

        val helloMessage = view.findViewById<TextView>(R.id.hello_message)

        database.child(userUID).child("name").get().addOnSuccessListener {
            helloMessage.text = getString(R.string.hello_message_label, it.value)
        }.addOnFailureListener{
            Log.e("MAIN", "Error getting data", it)
            helloMessage.text = getString(R.string.hello_message_label, "Usuario")
        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}