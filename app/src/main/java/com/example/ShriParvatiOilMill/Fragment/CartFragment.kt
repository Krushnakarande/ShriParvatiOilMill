package com.example.ShriParvatiOilMill.Fragment

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.ShriParvatiOilMill.PayOutActivity
import com.example.ShriParvatiOilMill.R
import com.example.ShriParvatiOilMill.adapter.CartAdapter
import com.example.ShriParvatiOilMill.databinding.FragmentCartBinding

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

        val cartItemName = listOf("Coconut oil","Groundnut oil","Sunflower oil ","Flaxseed oil ","item")
        val cartItemPrice = listOf("₹150","₹65","₹130","₹250","₹78")
        val cartImage = listOf(
            R.drawable.o1,R.drawable.o2,R.drawable.o3,R.drawable.o4,R.drawable.o5
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