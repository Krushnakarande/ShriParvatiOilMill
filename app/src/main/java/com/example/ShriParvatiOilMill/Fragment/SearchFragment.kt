package com.example.ShriParvatiOilMill.Fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SearchView
import androidx.recyclerview.widget.GridLayoutManager
import com.example.ShriParvatiOilMill.R
import com.example.ShriParvatiOilMill.adapter.MenuAdapter
import com.example.ShriParvatiOilMill.databinding.FragmentSearchBinding

class SearchFragment : Fragment() {
    private lateinit var binding: FragmentSearchBinding
    private lateinit var adapter : MenuAdapter
    private val originalMenuItemName = listOf("Coconut oil","Groundnut oil","Sunflower oil ","Flaxseed oil ","item")
    private val originalMenuItemPrice = listOf("₹150","₹65","₹130","₹250","₹78")
    private val originalMenuImage = listOf(
        R.drawable.o1,R.drawable.o2,R.drawable.o3,R.drawable.o4,R.drawable.o5
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }
    private val filteredMenuItemName = mutableListOf<String>()
    private val filteredMenuItemPrice = mutableListOf<String>()
    private val filteredMenuItemImage = mutableListOf<Int>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentSearchBinding.inflate(inflater,container,false)
        adapter = MenuAdapter(filteredMenuItemName,filteredMenuItemPrice,filteredMenuItemImage)
        val layoutManager = GridLayoutManager(requireContext(), 2)

        binding.menuRecyclerView.layoutManager = layoutManager
        binding.menuRecyclerView.adapter = adapter

        //setup for search view
        setupSearchView()

        //show all menu items
        showAllMenu()

        return binding.root
    }

    private fun showAllMenu() {
        filteredMenuItemName.clear()
        filteredMenuItemPrice.clear()
        filteredMenuItemImage.clear()

        filteredMenuItemName.addAll(originalMenuItemName)
        filteredMenuItemPrice.addAll(originalMenuItemPrice)
        filteredMenuItemImage.addAll(originalMenuImage)

        adapter.notifyDataSetChanged()
    }

    private fun setupSearchView() {
        binding.searchView.setOnQueryTextListener(object :SearchView.OnQueryTextListener{
            override fun onQueryTextSubmit(query: String): Boolean {
                filterMenuItems(query)
                return true
            }

            override fun onQueryTextChange(newText: String): Boolean {
                filterMenuItems(newText)
                return true
            }
        })
    }

    private fun filterMenuItems(query: String) {
        filteredMenuItemName.clear()
        filteredMenuItemPrice.clear()
        filteredMenuItemImage.clear()

        originalMenuItemName.forEachIndexed { index, itemName ->
            if (itemName.contains(query,ignoreCase = true)){
                filteredMenuItemName.add(itemName)
                filteredMenuItemPrice.add(originalMenuItemPrice[index])
                filteredMenuItemImage.add(originalMenuImage[index])
            }
        }
        adapter.notifyDataSetChanged()
    }


    companion object {

    }
}