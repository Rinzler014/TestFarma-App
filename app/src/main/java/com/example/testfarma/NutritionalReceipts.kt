package com.example.testfarma

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.testfarma.databinding.FragmentNutritionalReceiptsBinding


class NutritionalReceipts : Fragment() {

    private lateinit var recyclerView: RecyclerView

    private var _binding : FragmentNutritionalReceiptsBinding? = null
    private val binding get() = _binding!!


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentNutritionalReceiptsBinding.inflate(inflater, container, false)
        val view = binding.root

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        recyclerView = binding.verticalRecyclerView
        recyclerView.layoutManager = LinearLayoutManager(context)
        recyclerView.adapter = NutritionalReceiptsAdapter()

    }

}