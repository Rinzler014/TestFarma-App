package com.example.testfarma.ui.gallery


import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.testfarma.R
import com.example.testfarma.databinding.FragmentGalleryBinding
import com.google.firebase.auth.FirebaseAuth
import java.net.URI
import java.net.URL


class GalleryFragment : Fragment() {


    private var _binding: FragmentGalleryBinding? = null

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentGalleryBinding.inflate(inflater, container, false)
        val root: View = binding.root

        return root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val boton_1 = view.findViewById<Button>(R.id.button_info)
        boton_1.setOnClickListener {
            val openURL = Intent(android.content.Intent.ACTION_VIEW)
            openURL.data = Uri.parse("https://testfarma.com.mx/")
            startActivity(openURL)
        }


    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null

    }
}