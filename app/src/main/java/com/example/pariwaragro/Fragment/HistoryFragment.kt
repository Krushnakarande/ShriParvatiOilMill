package com.example.pariwaragro.Fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.pariwaragro.R
import com.example.pariwaragro.adapter.BuyAgainAdapter
import com.example.pariwaragro.databinding.FragmentHistoryBinding

class HistoryFragment : Fragment() {
    private lateinit var binding: FragmentHistoryBinding
    private lateinit var buyAgainAdapter: BuyAgainAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHistoryBinding.inflate(layoutInflater,container,false)
        // Inflate the layout for this fragment
        setupRecyclerView()
        return binding.root
    }

    private fun setupRecyclerView(){
        val buyAgainItemName = arrayListOf("Food 1","Food 2","Food 3")
        val buyAgainItemPrice = arrayListOf("₹60","₹35","₹50")
        val buyAgainItemImage = arrayListOf(R.drawable.menu1,R.drawable.menu2,R.drawable.menu3)
        buyAgainAdapter = BuyAgainAdapter(buyAgainItemName,buyAgainItemPrice,buyAgainItemImage)
        binding.BuyAgainRecyclerView.adapter = buyAgainAdapter
        binding.BuyAgainRecyclerView.layoutManager = LinearLayoutManager(requireContext())
    }

    companion object {

    }
}