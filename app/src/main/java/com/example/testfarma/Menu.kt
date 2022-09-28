package com.example.testfarma

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.navigation.findNavController
import com.example.testfarma.databinding.FragmentMenuBinding


class Menu : Fragment() {

    private var _binding : FragmentMenuBinding? = null
    private val binding get() = _binding!!


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentMenuBinding.inflate(inflater, container, false)
        val view = binding.root

        return view

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val homeButton = view.findViewById<TextView>(R.id.home_button)
        val ourCompanyButton = view.findViewById<TextView>(R.id.our_company_button)
        val myDataButton = view.findViewById<TextView>(R.id.my_data_button)
        val modifyMyDataButton = view.findViewById<TextView>(R.id.modify_my_data_button)

        homeButton.setOnClickListener {



        }

        ourCompanyButton.setOnClickListener {

            val action = MenuDirections.actionMenuToGalleryFragment()
            view.findNavController().navigate(action)

        }

        myDataButton.setOnClickListener {

            val action = MenuDirections.actionMenuToSlideshowFragment()
            view.findNavController().navigate(action)

        }

        modifyMyDataButton.setOnClickListener {


        }


    }


}