package com.example.testfarma

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.testfarma.data.DataSource
import com.google.firebase.database.FirebaseDatabase

class NutritionalReceiptsAdapter (

) : RecyclerView.Adapter<NutritionalReceiptsAdapter.ReceiptCardViewHolder>() {

    //Instance of Firebase DataBase
    private val database = FirebaseDatabase.getInstance().reference
    /**
     * Source Data to display
     */
    val receipts = DataSource.receipts

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) : ReceiptCardViewHolder {

        val adapterLayout = LayoutInflater.from(parent.context).inflate(R.layout.fragment_nutritional_receipts_list_items, parent, false)
        return NutritionalReceiptsAdapter.ReceiptCardViewHolder(adapterLayout)

    }

    override fun onBindViewHolder(holder: NutritionalReceiptsAdapter.ReceiptCardViewHolder, position: Int) {
        val receipt = receipts[position]

        /*
        database.child("KxBxqLwCzaUj0so6p7Sho96WTNM2").child("name").get().addOnSuccessListener {
            holder.studyName?.text = it.value.toString()
        }.addOnFailureListener {
            holder.studyName?.text = resources?.getString(R.string.error_database_data)
        }
        */

        holder.receiptImage?.setImageResource(receipt.imageResourceId)
        holder.receiptName?.text = receipt.name

        holder.receiptCard?.setOnClickListener {

            val intent = Intent(it.context, PopUpWindowReceipts::class.java)
            intent.putExtra("popuptitle", receipt.name)
            intent.putExtra("popuptextingredients", "- " + receipt.ingredients.joinToString("\n- "))
            intent.putExtra("popuptextpreparation", receipt.preparation.joinToString("\n\n"))
            intent.putExtra("popuptextconsumption", receipt.consumptionMode.joinToString("\n\n"))
            intent.putExtra("popupbtn", "Aceptar")
            intent.putExtra("darkstatusbar", false)
            it.context.startActivity(intent)

        }

    }

    override fun getItemCount(): Int {

        return receipts.size

    }


    class ReceiptCardViewHolder(view : View?) : RecyclerView.ViewHolder(view!!) {

        val receiptCard = view?.findViewById<CardView>(R.id.card_view_receipts)
        val receiptImage = view?.findViewById<ImageView>(R.id.receipt_image)
        val receiptName = view?.findViewById<TextView>(R.id.receipt_name)

    }


}