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

class SecondCategoryFragment : Fragment() {

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
        val view = inflater.inflate(R.layout.fragment_secondcategory, container, false)

        val backBtn = view.findViewById<ImageButton>(R.id.backButton)
        backBtn.setOnClickListener {
            it.findNavController().navigate(R.id.action_categoryTwoFragment_to_dashboardFragment)
        }

        recyclerView = view.findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(requireContext())

        // Initialize the data lists
        imageList = arrayOf(
            R.drawable.cultural_center_philippines,
            R.drawable.coconut_palace,
            R.drawable.libertad_market,
            R.drawable.runway_manila,
            R.drawable.baclaran_church
        )

        textList = arrayOf(
            "Cultural Center of the Philippines",
            "Coconut Palace",
            "Libertad Market",
            "Runway Manila",
            "Baclaran Church"
        )

        descList = arrayOf(
            "The Cultural Center of the Philippines (CCP) is a prominent landmark in Pasay City and a hub for Philippine arts and culture. It hosts numerous performances, exhibitions, and events that showcase Filipino talent in theater, dance, music, and visual arts. The CCP's unique Brutalist architecture and scenic location along Manila Bay make it a must-visit for culture enthusiasts and tourists, providing a space to experience the richness of Philippine heritage.",
            "The Coconut Palace, also known as Tahanang Pilipino, is an architectural marvel built from coconut lumber and other indigenous materials. Originally commissioned in the 1980s, it stands as a symbol of Filipino craftsmanship and creativity. Located in Pasay City, this unique structure offers visitors a glimpse into Filipino architecture and design, with its intricate details and beautiful views of Manila Bay. The Coconut Palace is a landmark that highlights both tradition and innovation in Philippine architecture.",
            "Libertad Market is a bustling public market in Pasay City known for its vibrant energy and wide variety of goods. From fresh produce and local delicacies to handcrafted items, the market offers a genuine taste of Filipino culture and daily life. A visit to Libertad Market is an opportunity to experience the lively atmosphere and interact with friendly vendors. It’s a favorite destination for locals and tourists alike, providing an authentic Filipino shopping experience.",
            "Runway Manila is an enclosed, air-conditioned pedestrian bridge connecting Ninoy Aquino International Airport (NAIA) Terminal 3 to Newport City. It allows travelers and locals to conveniently cross from the airport to nearby hotels, shopping centers, and entertainment venues without needing additional transportation. Runway Manila is not only practical but also a unique structure, offering impressive views of the airport and surrounding areas, making it a must-visit for anyone passing through Pasay City.",
            "Baclaran Church, also known as the National Shrine of Our Mother of Perpetual Help, is one of the most visited Catholic churches in the Philippines. Known for its beautiful architecture and serene atmosphere, it attracts thousands of devotees each week. Located in Pasay City, Baclaran Church is a place of peace, prayer, and reflection, offering visitors a glimpse into the strong devotion of the Filipino people."
        )

        // Populate dataList
        dataList = arrayListOf()
        populateData()

        // Set up the adapter for the RecyclerView
        recyclerView.adapter = secondadapter(dataList)

        return view
    }

    private fun populateData() {
        for (i in imageList.indices) {
            val dataClass = DataClass(imageList[i], textList[i], descList[i])
            dataList.add(dataClass)
        }
    }
}
