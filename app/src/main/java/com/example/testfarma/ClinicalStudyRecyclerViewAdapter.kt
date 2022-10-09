package com.example.testfarma

import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.example.testfarma.data.DataSource

class ClinicalStudyRecyclerViewAdapter(

) : RecyclerView.Adapter<ClinicalStudyRecyclerViewAdapter.StudyCardViewHolder>() {

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

        holder.studyImage?.setImageResource(study.imageResourceId)
        holder.studyName?.text = study.name
        holder.studyPrice?.text = study.price.toString()
        holder.studyReq?.text = study.requirements.joinToString("\n")

    }

    override fun getItemCount(): Int {

        return studies.size

    }

    /**
     * Initialize view elements
     */
    class StudyCardViewHolder(view : View?) : RecyclerView.ViewHolder(view!!) {
        val studyImage = view?.findViewById<ImageView>(R.id.clinical_study_image)
        val studyName = view?.findViewById<TextView>(R.id.clinical_study_name)
        val studyPrice = view?.findViewById<TextView>(R.id.clinical_study_price)
        val studyReq = view?.findViewById<TextView>(R.id.clinical_study_requirements)
    }

}