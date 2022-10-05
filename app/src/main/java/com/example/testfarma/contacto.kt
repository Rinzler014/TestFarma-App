package com.example.testfarma

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.testfarma.databinding.FragmentContactoBinding
import com.example.testfarma.databinding.FragmentHomeBinding


class contacto : Fragment() {

    private var _binding : FragmentContactoBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentContactoBinding.inflate(inflater, container, false)
        val root: View = binding.root
        return root
    }

}