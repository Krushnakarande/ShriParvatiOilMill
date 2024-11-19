package com.example.ShriParvatiOilMill.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.ShriParvatiOilMill.databinding.MenuItemBinding

class MenuAdapter(private val menuItemsName: List<String>, private val menuItemPrice: List<String>, private val menuImages: List<Int>): RecyclerView.Adapter<MenuAdapter.MenuViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MenuViewHolder {
        val binding = MenuItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return MenuViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MenuViewHolder, position: Int) {
        holder.bind(position)
    }

    override fun getItemCount(): Int =menuItemsName.size

    inner class MenuViewHolder(private val binding: MenuItemBinding) :RecyclerView.ViewHolder(binding.root) {
       fun bind(position: Int) {
            binding.apply {
                foodNamePopular.text = menuItemsName[position]
                PricePopolar.text = menuItemPrice[position]
                imageView5.setImageResource(menuImages[position])
            }
        }

    }
}