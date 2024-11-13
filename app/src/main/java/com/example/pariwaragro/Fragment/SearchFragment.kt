package com.example.pariwaragro.Fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SearchView
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.pariwaragro.R
import com.example.pariwaragro.adapter.MenuAdapter
import com.example.pariwaragro.databinding.FragmentSearchBinding

class SearchFragment : Fragment() {
    private lateinit var binding: FragmentSearchBinding
    private lateinit var adapter : MenuAdapter
    private val originalMenuItemName = listOf("Onion","Urea","Bajra","Soyabean","item","Brofreya","Onion","Urea","Bajra","Soyabean","item","Brofreya")
    private val originalMenuItemPrice = listOf("₹34","₹45","₹12","₹65","₹20","₹30","₹34","₹45","₹12","₹65","₹20","₹30")
    private val originalMenuImage = listOf(
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
        binding.menuRecyclerView.layoutManager = LinearLayoutManager(requireContext())
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