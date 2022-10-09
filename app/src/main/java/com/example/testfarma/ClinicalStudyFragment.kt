package com.example.testfarma

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.LayoutManager
import com.example.testfarma.databinding.FragmentClinicalStudyBinding
import kotlinx.android.synthetic.main.fragment_clinical_study_list.view.*


/**
 * A fragment representing a list of Items.
 */
class ClinicalStudyFragment : Fragment() {

    private lateinit var recyclerView: RecyclerView

    private var _binding : FragmentClinicalStudyBinding? = null
    private val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentClinicalStudyBinding.inflate(inflater, container, false)
        val view = binding.root

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        recyclerView = binding.verticalRecyclerView
        recyclerView.layoutManager = LinearLayoutManager(context)
        recyclerView.adapter = ClinicalStudyRecyclerViewAdapter(context)

        recyclerView.setHasFixedSize(true)

    }

}