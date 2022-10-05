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

class HomeFragment : Fragment() {


    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    //Instance of Firebase DataBase
    private val database = FirebaseDatabase.getInstance().reference

    private lateinit var auth : FirebaseAuth
    private lateinit var userUID : String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        arguments?.let {
            userUID = it.getString("userUID") as String
        }

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

        Log.d("MAIN", userUID)

        /*

        database.child(userUID).child("name").get().addOnSuccessListener {
            Log.i("firebase", "Got value")
        }.addOnFailureListener{
            Log.e("firebase", "Error getting data", it)
        }


         */


    /*

        val helloMessage = view.findViewById<TextView>(R.id.hello_message)
        helloMessage.text = getString(R.string.hello_message_label, userUID)
        */


    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}