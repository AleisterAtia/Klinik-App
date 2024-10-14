package com.fadhiil2010.klinik_app.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.fadhiil2010.klinik_app.R
import com.fadhiil2010.klinik_app.model.ModelIcon
import com.fadhiil2010.klinik_app.model.ModelListDoctor


class AdapterMenuDoctor
    (private val itemDoctorList: List<ModelListDoctor>) :
    RecyclerView.Adapter<AdapterMenuDoctor.MyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        // Inflate layout item_destination.xml (pastikan file XML ini ada)
        val nView = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_doctor, parent, false)
        return MyViewHolder(nView)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentItem = itemDoctorList[position]
        holder.imgMenuDoctor.setImageResource(currentItem.ImageDr)
        holder.txtNamaDoctor.setText(currentItem.NamaDr)
        holder.txtBidang.setText(currentItem.BidangDr)
        holder.txtRating.setText(currentItem.totalReview)
        holder.txtAngkaRating.setText(currentItem.angkaReview)
    }

    override fun getItemCount(): Int
    {
        return itemDoctorList.size
    }

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imgMenuDoctor: ImageView = itemView.findViewById(R.id.imgDoctor)
        val txtNamaDoctor: TextView = itemView.findViewById(R.id.tvNamaDoctor)
        val txtBidang: TextView = itemView.findViewById(R.id.tvBidang)
        val txtRating: TextView = itemView.findViewById(R.id.tvRating)
        val txtAngkaRating: TextView = itemView.findViewById(R.id.tvAngkaRating)

    }
}

