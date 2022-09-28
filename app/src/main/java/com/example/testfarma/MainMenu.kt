package com.example.testfarma

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import androidx.navigation.findNavController
import com.example.testfarma.databinding.FragmentFirstFormBinding
import com.example.testfarma.databinding.FragmentMainMenuBinding


class MainMenu : Fragment() {

    private var _binding : FragmentMainMenuBinding? = null
    private val binding  get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        _binding = FragmentMainMenuBinding.inflate(inflater, container, false)
        val view = binding.root

        return view

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val menu_button = view.findViewById<ImageButton>(R.id.dropdown_menu_button)

        menu_button.setOnClickListener {

            val action = MainMenuDirections.actionMainMenuToMenu()
            view.findNavController().navigate(action)

        }

    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}