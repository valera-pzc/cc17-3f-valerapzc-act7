package com.example.baguiocityapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView

class secondadapter(private val dataList: ArrayList<DataClass>): RecyclerView.Adapter<secondadapter.ViewHolderClass>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderClass {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.card_layout, parent, false)
        return ViewHolderClass(itemView)
    }

    override fun getItemCount(): Int {
        return dataList.size
    }

    override fun onBindViewHolder(holder: ViewHolderClass, position: Int) {
        val dataItem =  dataList[position]
        holder.rvImage.setImageResource(dataItem.imageResource)
        holder.rvContentText.text = dataItem.description

        holder.itemView.setOnClickListener {
            val bundle = Bundle().apply {
                putInt("imageResId", dataItem.imageResource)
                putString("description", dataItem.description)
            }
            it.findNavController().navigate(R.id.action_categoryTwoFragment_to_seconddeets_Fragment, bundle)
        }

    }

    class ViewHolderClass(itemView:     View): RecyclerView.ViewHolder(itemView){
        val rvImage: ImageView = itemView.findViewById(R.id.cardImage)
        val rvContentText: TextView = itemView.findViewById(R.id.textContent)
    }
}