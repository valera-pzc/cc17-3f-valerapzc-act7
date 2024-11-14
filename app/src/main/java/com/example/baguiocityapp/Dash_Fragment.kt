package com.example.baguiocityapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.cardview.widget.CardView
import androidx.navigation.findNavController

class Dash_Fragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val layout = inflater.inflate(R.layout.fragment_dash, container, false)

        val cardOne = layout.findViewById<CardView>(R.id.categoryOne)
        val cardTwo = layout.findViewById<CardView>(R.id.categoryTwo)
        val cardThree = layout.findViewById<CardView>(R.id.categoryThree)

        cardOne.setOnClickListener {
                view -> view.findNavController().navigate(R.id.action_dashboardFragment_to_categoryOneFragment)
        }

        cardTwo.setOnClickListener {
                view -> view.findNavController().navigate(R.id.action_dashboardFragment_to_secondcategoryfragment)
        }

        cardThree.setOnClickListener {
                view -> view.findNavController().navigate(R.id.action_dashboardFragment_to_categoryThreeFragment)
        }

        return layout
    }
}