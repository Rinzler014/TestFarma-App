package com.example.testfarma

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.testfarma.data.DataSource

class PromotionsSliderAdapter(

) : RecyclerView.Adapter<PromotionsSliderAdapter.CarouselItemViewHolder>() {

    class CarouselItemViewHolder(view : View?) : RecyclerView.ViewHolder(view!!) {

        val imageResourceId = view?.findViewById<ImageView>(R.id.textview)

    }

    private val promotions = DataSource.promotions

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CarouselItemViewHolder {
        val viewHolder = LayoutInflater.from(parent.context).inflate(R.layout.promotions_item, parent, false)
        return CarouselItemViewHolder(viewHolder)
    }

    override fun onBindViewHolder(holder: CarouselItemViewHolder, position: Int) {

        val promotion = promotions[position]

        holder.imageResourceId?.setImageResource(promotion.imageResourceId)

    }

    override fun getItemCount(): Int {

        return promotions.size

    }

}