package com.example.testfarma

import android.media.Image
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.example.testfarma.databinding.FragmentAccountSuccessCreationBinding
import com.google.firebase.auth.FirebaseAuth

class homeFragment : Fragment() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val cartButton = view.findViewById<Button>(R.id.cartButton)
        val leftButton = view.findViewById<Button>(R.id.leftButtonBar)
        val rightButton = view.findViewById<Button>(R.id.rightButtonBar)
        val infoButton = view.findViewById<Button>(R.id.infoButton)
        val barButton = view.findViewById<Button>(R.id.barButton)

        val imageid1 = view.findViewById<ImageView>(R.id.offer1)
        leftButton.setOnClickListener {
            imageid1.setImageResource(R.drawable.descuento)
        }
        rightButton.setOnClickListener {
            imageid1.setImageResource(R.drawable.descuento2)
        }
    }
}