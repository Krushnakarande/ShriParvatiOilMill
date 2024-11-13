package com.example.pariwaragro

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.pariwaragro.adapter.MenuAdapter
import com.example.pariwaragro.databinding.FragmentMenuBottomSheetBinding
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class MenuBottomSheetFragment : BottomSheetDialogFragment() {
    private lateinit var binding: FragmentMenuBottomSheetBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMenuBottomSheetBinding.inflate(inflater,container,false)

        binding.buttonBack.setOnClickListener {
            dismiss()
        }

        val menuItemName = listOf("Onion","Urea","Bajra","Soyabean","item","Brofreya","Onion","Urea","Bajra","Soyabean","item","Brofreya")
        val menuItemPrice = listOf("₹34","₹45","₹12","₹65","₹20","₹30","₹34","₹45","₹12","₹65","₹20","₹30")
        val menuImage = listOf(
            R.drawable.menu1,
            R.drawable.menu2,
            R.drawable.menu3,
            R.drawable.menu4,
            R.drawable.menu2,
            R.drawable.menu1,
            R.drawable.menu1,
            R.drawable.menu2,
            R.drawable.menu3,
            R.drawable.menu4,
            R.drawable.menu2,
            R.drawable.menu1,
        )
        val adapter = MenuAdapter(ArrayList(menuItemName),ArrayList(menuItemPrice),ArrayList(menuImage))
        binding.menuRecyclerView.layoutManager = LinearLayoutManager(requireContext())
        binding.menuRecyclerView.adapter = adapter
        return binding.root
    }

    companion object {

    }
}