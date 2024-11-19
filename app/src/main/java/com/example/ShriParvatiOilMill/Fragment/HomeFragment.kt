@file:Suppress("UNREACHABLE_CODE")

package com.example.ShriParvatiOilMill.Fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.denzcoskun.imageslider.constants.ScaleTypes
import com.denzcoskun.imageslider.interfaces.ItemClickListener
import com.denzcoskun.imageslider.models.SlideModel
import com.example.ShriParvatiOilMill.MenuBottomSheetFragment
import com.example.ShriParvatiOilMill.R
import com.example.ShriParvatiOilMill.adapter.PopularAdaptar
import com.example.ShriParvatiOilMill.databinding.FragmentHomeBinding
import androidx.recyclerview.widget.GridLayoutManager

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
        imageList.add(SlideModel(R.drawable.o1,ScaleTypes.FIT))
        imageList.add(SlideModel(R.drawable.o2,ScaleTypes.FIT))
        imageList.add(SlideModel(R.drawable.o3,ScaleTypes.FIT))
        imageList.add(SlideModel(R.drawable.o4,ScaleTypes.FIT))

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
        val foodName = listOf("Coconut oil","Groundnut oil","Sunflower oil ","Flaxseed oil ","item")
        val Price = listOf("₹150","₹65","₹130","₹250","₹78")
        val popularItemImages = listOf(R.drawable.o1,R.drawable.o2,R.drawable.o3,R.drawable.o4,R.drawable.o5)
        val adaptar = PopularAdaptar(foodName,Price,popularItemImages)

        val layoutManager = GridLayoutManager(requireContext(), 2) // 2 for 2 columns


        binding.PopulerRecyclerView.layoutManager = layoutManager

        binding.PopulerRecyclerView.adapter = adaptar
    }

    companion object {

    }
}
