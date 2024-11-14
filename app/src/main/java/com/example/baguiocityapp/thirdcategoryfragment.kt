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

/**
 * A simple [Fragment] subclass.
 * Use the [CategoryThreeFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class thirdcategoryfragment : Fragment() {

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
        val view = inflater.inflate(R.layout.fragment_thirdcategory, container, false)

        val backBtn = view.findViewById<ImageButton>(R.id.backButton)
        backBtn.setOnClickListener { view -> view.findNavController().navigate(R.id.action_categoryThreeFragment_to_dashboardFragment) }

        recyclerView = view.findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(requireContext())

        // Initialize the data lists
        imageList = arrayOf(
            R.drawable.blue_bay_walk,
            R.drawable.starcity,
            R.drawable.moa,
            R.drawable.dessert_museum,
            R.drawable.newport_mall
        )

        textList = arrayOf(
            "Blue Bay Walk Park",
            "Star City",
            "SM Mall of Asia",
            "The Dessert Museum",
            "Newport Mall"
        )

        descList = arrayOf(
            "Blue Bay Walk Park is a laid-back leisure spot in Pasay City where families and friends can enjoy open spaces, dining, and relaxation. The park features landscaped gardens, walkways, and a pet-friendly environment, making it perfect for a casual stroll or a picnic. With various restaurants and cafes nearby, visitors can indulge in a variety of cuisines while enjoying the serene ambiance. The park also frequently hosts weekend markets and live entertainment, creating a lively yet relaxed atmosphere suitable for all ages.",
            "Star City is a beloved amusement park in Pasay City, featuring thrilling rides, carnival games, and attractions for all ages. Snow World is a winter wonderland where visitors can experience real snow and see intricate ice sculptures, a rare sight in the tropics. For thrill-seekers, Surf Dance is a top choice, simulating the excitement of surfing on huge waves. Star City also offers a spine-tingling experience with Gabi ng Lagim, a horror house attraction that adds an extra thrill to your visit.",
            "SM Mall of Asia, one of the largest malls in Asia, is a dynamic spot for shopping, dining, and entertainment in Pasay City. The mall features an array of international and local brands, and its entertainment offerings are top-notch. The MOA Eye Ferris Wheel is a must-try attraction, providing a panoramic view of Manila Bay and the city skyline. Along the coast is SM By the Bay, a scenic area with outdoor dining options and a great spot to watch the sunset. For a unique experience, visitors can enjoy the Olympic-sized ice skating rink, which is a rarity in the Philippines.",
            "The Dessert Museum is a sugary wonderland in Pasay City that brings sweet treats to life through interactive and colorful rooms themed around popular desserts like donuts, candy canes, and marshmallows. Perfect for photo opportunities and family fun, visitors can explore eight immersive rooms and enjoy free dessert samples along the way. The museum is a delightful blend of art and sweets, making it a memorable experience for both kids and adults.",
            "Newport Mall is a premium lifestyle and entertainment destination located in Resorts World Manila, near NAIA Terminal 3. With its luxurious shops, fine dining restaurants, and a state-of-the-art cinema, Newport Mall offers a high-end shopping and entertainment experience. Visitors can also enjoy live performances at the Newport Performing Arts Theater or try their luck at the nearby casino. Newport Mall’s elegant ambiance and diverse attractions make it a favorite among locals and tourists seeking a sophisticated leisure spot."
        )


        // Populate dataList
        dataList = arrayListOf()
        populateData()

        // Set up the adapter for the RecyclerView
        recyclerView.adapter = thirdadapter(dataList)

        return view
    }

    private fun populateData() {
        for (i in imageList.indices) {
            val dataClass = DataClass(imageList[i], textList[i], descList[i])
            dataList.add(dataClass)
        }
    }
}