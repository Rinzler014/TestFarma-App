package com.example.testfarma

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.example.testfarma.databinding.FragmentAccountSuccessCreationBinding


class AccountSuccessCreation : Fragment() {

    private var _binding : FragmentAccountSuccessCreationBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        (activity as AppCompatActivity).supportActionBar?.show()
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
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentAccountSuccessCreationBinding.inflate(inflater, container, false)
        val view = binding.root

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val button_to_login = view.findViewById<Button>(R.id.button_to_login)

        button_to_login.setOnClickListener {

            val action = AccountSuccessCreationDirections.actionAccountSuccessCreation2ToLogin()
            view.findNavController().navigate(action)

        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}