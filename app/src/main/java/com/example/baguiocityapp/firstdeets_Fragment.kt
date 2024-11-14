package com.example.baguiocityapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.navigation.findNavController

class firstdeets_Fragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_firstdeets, container, false)

        val backBtn = view.findViewById<ImageButton>(R.id.backButton)
        backBtn.setOnClickListener { it.findNavController().navigate(R.id.action_firstdeets_Fragment_to_firstcategoryfragment) }
        // Get data from bundle
        val imageResId = arguments?.getInt("imageResId") ?: 0
        val description = arguments?.getString("description") ?: ""

        // Initialize views
        val imageView = view.findViewById<ImageView>(R.id.detailsImageView)
        val textView = view.findViewById<TextView>(R.id.detailsTextView)

        // Set data to views
        imageView.setImageResource(imageResId)
        textView.text = description

        return view
    }
}