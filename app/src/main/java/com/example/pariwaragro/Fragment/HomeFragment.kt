@file:Suppress("UNREACHABLE_CODE")

package com.example.pariwaragro.Fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.denzcoskun.imageslider.constants.ScaleTypes
import com.denzcoskun.imageslider.interfaces.ItemClickListener
import com.denzcoskun.imageslider.models.SlideModel
import com.example.pariwaragro.MenuBottomSheetFragment
import com.example.pariwaragro.R
import com.example.pariwaragro.adapter.PopularAdaptar
import com.example.pariwaragro.databinding.FragmentHomeBinding
import org.jetbrains.annotations.TestOnly

class HomeFragment : Fragment() {
    private lateinit var binding: FragmentHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentHomeBinding.inflate(inflater,container,false)

        binding.viewAllMenu.setOnClickListener {
            val bottomSheetDialog = MenuBottomSheetFragment()
            bottomSheetDialog.show(parentFragmentManager,"Test")
        }

        return binding.root


    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val imageList = ArrayList<SlideModel>()
        imageList.add(SlideModel(R.drawable.banner1,ScaleTypes.FIT))
        imageList.add(SlideModel(R.drawable.banner2,ScaleTypes.FIT))
        imageList.add(SlideModel(R.drawable.banner3,ScaleTypes.FIT))
        imageList.add(SlideModel(R.drawable.banner4,ScaleTypes.FIT))

        var imageSlider = binding.imageSlider
        imageSlider.setImageList(imageList)
        imageSlider.setImageList(imageList,ScaleTypes.FIT)
        imageSlider.setItemClickListener(object :ItemClickListener{
            override fun doubleClick(position: Int) {
                TODO("Not yet implemented")
            }

            override fun onItemSelected(position: Int) {
                val itemPosition = imageList[position]
                val itemMessage = "Selected Image $position"
                Toast.makeText(requireContext(),itemMessage,Toast.LENGTH_SHORT).show()
            }
        })
        val foodName = listOf("Brofreya","Soyabean","BPG 788","Urea","item")
        val Price = listOf("₹150","₹65","₹130","₹250","₹78")
        val popularItemImages = listOf(R.drawable.menu1,R.drawable.menu2,R.drawable.menu3,R.drawable.menu5,R.drawable.menu4)
        val adaptar = PopularAdaptar(foodName,Price,popularItemImages)
        binding.PopularRecyclerView.layoutManager =LinearLayoutManager(requireContext())
        binding.PopularRecyclerView.adapter = adaptar
    }

    companion object {

    }
}