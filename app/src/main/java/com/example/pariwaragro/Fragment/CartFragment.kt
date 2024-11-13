package com.example.pariwaragro.Fragment

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.pariwaragro.CongratsBottomSheet
import com.example.pariwaragro.PayOutActivity
import com.example.pariwaragro.R
import com.example.pariwaragro.adapter.CartAdapter
import com.example.pariwaragro.databinding.CartItemBinding
import com.example.pariwaragro.databinding.FragmentCartBinding

class CartFragment : Fragment() {
    private lateinit var binding: FragmentCartBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
       binding = FragmentCartBinding.inflate(inflater,container,false)

        val cartItemName = listOf("Onion","Urea","Bajra","Soyabean","item","Brofreya")
        val cartItemPrice = listOf("₹34","₹45","₹12","₹65","₹20","₹30")
        val cartImage = listOf(
            R.drawable.menu1,
            R.drawable.menu2,
            R.drawable.menu3,
            R.drawable.menu4,
            R.drawable.menu2,
            R.drawable.menu1,
        )
        val adapter = CartAdapter(ArrayList(cartItemName),ArrayList(cartItemPrice),ArrayList(cartImage))
        binding.cartRecyclerView.layoutManager = LinearLayoutManager(requireContext())
        binding.cartRecyclerView.adapter = adapter
        binding.proceedButton.setOnClickListener {
            val intent = Intent(requireContext(),PayOutActivity::class.java)
            startActivity(intent)
        }
        return binding.root
    }

    companion object {

    }
}