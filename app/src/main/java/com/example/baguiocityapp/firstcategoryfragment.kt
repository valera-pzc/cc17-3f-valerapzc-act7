package com.example.baguiocityapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class firstcategoryfragment : Fragment() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var dataList: ArrayList<DataClass>
    private lateinit var imageList: Array<Int>
    private lateinit var textList: Array<String>
    private lateinit var descList: Array<String>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_firstcategory, container, false)

        // Set up the back button navigation
        val backBtn = view.findViewById<ImageButton>(R.id.backButton)
        backBtn.setOnClickListener { it.findNavController().navigate(R.id.action_categoryOneFragment_to_dashboardFragment) }

        // Initialize the RecyclerView and data
        recyclerView = view.findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(requireContext())

        // Initialize the data lists
        imageList = arrayOf(
            R.drawable.four_seasons_buffet,
            R.drawable.vikings_moa,
            R.drawable.tong_yang_moa,
            R.drawable.apartment_1b
        )

        textList = arrayOf(
            "Four Seasons Buffet & Hotpot",
            "Vikings SM Mall of Asia",
            "Tong Yang, SM Mall of Asia",
            "Apartment 1B"
        )

        descList = arrayOf(
            "Four Seasons Buffet & Hotpot offers an all-you-can-eat experience with a vast selection of fresh ingredients and cooking stations for a unique hotpot dining experience. Perfect for family gatherings and group outings, the restaurant’s casual, lively ambiance is enhanced by its diverse menu of meats, seafood, and vegetables, along with a wide array of dipping sauces and broths. Known for its fresh, high-quality ingredients, Four Seasons provides an unforgettable buffet-style hotpot adventure.",
            "Vikings at SM Mall of Asia is a luxury buffet restaurant offering a wide range of cuisines including Japanese, Italian, Filipino, and more. Known for its grand spread, Vikings offers everything from sushi and sashimi to pasta and Filipino classics. The upscale atmosphere combined with its culinary diversity makes it a popular choice for celebrations and special gatherings, delivering an exceptional dining experience with a refined touch.",
            "Tong Yang at SM Mall of Asia brings together grill and hotpot in one dining experience. With a wide array of meats, seafood, and vegetables to grill or cook in the flavorful broth of your choice, Tong Yang offers a customizable meal for every taste. The restaurant’s lively atmosphere and extensive choices make it a favorite for diners looking to enjoy the best of both worlds—barbecue and hotpot.",
            "Apartment 1B is a cozy, upscale restaurant offering comfort food with a twist. Known for its intimate atmosphere and warm ambiance, it’s ideal for a relaxed meal. Apartment 1B’s menu includes refined comfort dishes, from pastas and sandwiches to steaks and brunch options. With its chic interiors and attentive service, it provides a memorable dining experience perfect for casual meet-ups or romantic dinners."
        )

        // Populate dataList
        dataList = arrayListOf()
        populateData()

        // Set up the adapter for the RecyclerView
        recyclerView.adapter = firstadapter(dataList)

        return view
    }

    private fun populateData() {
        for (i in imageList.indices) {
            val dataClass = DataClass(imageList[i], textList[i], descList[i])
            dataList.add(dataClass)
        }
    }
}