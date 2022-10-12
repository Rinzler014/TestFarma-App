package com.example.testfarma

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.os.IBinder.DeathRecipient
import android.util.Log
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.core.app.BundleCompat
import androidx.core.content.ContextCompat.startActivity
import com.example.testfarma.data.DataSource
import com.google.firebase.database.FirebaseDatabase


class ClinicalStudyRecyclerViewAdapter(

    private val context : Context?

) : RecyclerView.Adapter<ClinicalStudyRecyclerViewAdapter.StudyCardViewHolder>() {

    //Instance of Firebase DataBase
    private val database = FirebaseDatabase.getInstance().reference
    /**
     * Source Data to display
     */
    val studies = DataSource.clinicalStudies


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) : StudyCardViewHolder {

        val adapterLayout = LayoutInflater.from(parent.context).inflate(R.layout.fragment_clinical_study_list, parent, false)
        return StudyCardViewHolder(adapterLayout)

    }

    override fun onBindViewHolder(holder: StudyCardViewHolder, position: Int) {
        val study = studies[position]
        val resources = context?.resources

        /*
        database.child("KxBxqLwCzaUj0so6p7Sho96WTNM2").child("name").get().addOnSuccessListener {
            holder.studyName?.text = it.value.toString()
        }.addOnFailureListener {
            holder.studyName?.text = resources?.getString(R.string.error_database_data)
        }
        */

        holder.studyImage?.setImageResource(study.imageResourceId)
        holder.studyName?.text = study.name
        holder.studyPrice?.text = resources?.getString(R.string.study_price, study.price)
        holder.studyReq?.text = study.requirements.joinToString("\n")

    }

    override fun getItemCount(): Int {

        return studies.size

    }

    /**
     * Initialize view elements
     */
    class StudyCardViewHolder(view : View?) : RecyclerView.ViewHolder(view!!) {
        val card = view?.findViewById<CardView>(R.id.card_view)
        val studyImage = view?.findViewById<ImageView>(R.id.clinical_study_image)
        val studyName = view?.findViewById<TextView>(R.id.clinical_study_name)
        val studyPrice = view?.findViewById<TextView>(R.id.clinical_study_price)
        val studyReq = view?.findViewById<TextView>(R.id.clinical_study_requirements)
    }

}