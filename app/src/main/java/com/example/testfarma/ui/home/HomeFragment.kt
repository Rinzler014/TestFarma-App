package com.example.testfarma.ui.home

import android.content.res.Resources
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.CompositePageTransformer
import androidx.viewpager2.widget.MarginPageTransformer
import androidx.viewpager2.widget.ViewPager2
import com.example.testfarma.PromotionsSliderAdapter
import com.example.testfarma.R
import com.example.testfarma.databinding.FragmentHomeBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.ktx.Firebase
import java.lang.Math.abs

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

        val nextMeetingDate = view.findViewById<TextView>(R.id.next_meeting_date)
        val nextMeetingDoctor = view.findViewById<TextView>(R.id.doctor_name_text)

        val helloMessage = view.findViewById<TextView>(R.id.hello_message)

        database.child(userUID).child("name").get().addOnSuccessListener {
            helloMessage.text = getString(R.string.hello_message_label, it.value)
        }.addOnFailureListener{
            Log.e("MAIN", "Error getting data", it)
            helloMessage.text = getString(R.string.hello_message_label, "Usuario")
        }

        database.child(userUID).child("upcoming_meeting").get().addOnSuccessListener {
            nextMeetingDate.text = it.value.toString()
        }.addOnFailureListener{
            Log.e("MAIN", "Error getting data", it)
            nextMeetingDate.text = "00/00/0000"
        }

        database.child(userUID).child("upcoming_meeting_doctor").get().addOnSuccessListener {
            nextMeetingDoctor.text = it.value.toString()
        }.addOnFailureListener{
            Log.e("MAIN", "Error getting data", it)
            nextMeetingDoctor.text = getString(R.string.error_doctor_main_menu)
        }

        val viewerPager = view.findViewById<ViewPager2>(R.id.promotions)

        viewerPager.apply {

            clipChildren = false // No clipping the left and right items
            clipToPadding = false // Show the viewpager in full width without clipping the padding
            offscreenPageLimit = 3 // Render the left and right items
            (getChildAt(0) as RecyclerView).overScrollMode = RecyclerView.OVER_SCROLL_NEVER // Remove the scroll effect

        }

        viewerPager.adapter = PromotionsSliderAdapter()

        val compositePageTransformer = CompositePageTransformer()
        compositePageTransformer.addTransformer(MarginPageTransformer((40 * Resources.getSystem().displayMetrics.density).toInt()))
        compositePageTransformer.addTransformer { page, position ->
            val r = 1 - abs(position)
            page.scaleY = (0.80f + r * 0.20f)
        }
        viewerPager.setPageTransformer(compositePageTransformer)

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}