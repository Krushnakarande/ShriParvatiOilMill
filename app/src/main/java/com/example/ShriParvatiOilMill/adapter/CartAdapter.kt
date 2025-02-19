package com.example.ShriParvatiOilMill.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.ShriParvatiOilMill.databinding.CartItemBinding

class CartAdapter(private val CartItems: MutableList<String>,private val cartItemPrice:MutableList<String>,private var CartImage:MutableList<Int>) : RecyclerView.Adapter<CartAdapter.CartViewHolder>() {

    private val itemQuantites = IntArray(CartItems.size){1}
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CartViewHolder {
       val binding=CartItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return CartViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CartViewHolder, position: Int) {
        holder.bind(position)
    }
    override fun getItemCount(): Int = CartItems.size

    inner class CartViewHolder(private val binding: CartItemBinding) :RecyclerView.ViewHolder(binding.root) {
        fun bind(position: Int) {
            binding.apply {
                val quantity =itemQuantites[position]
                cartitemName.text= CartItems[position]
                cartitemPrice.text= cartItemPrice[position]
                cartimage.setImageResource(CartImage[position])
                cartitemQuantity.text= quantity.toString()

                minusbutton.setOnClickListener {
                    decreaseQuantity(position)
                }
                plusbutton.setOnClickListener {
                    increaseQuantity(position)
                }
                deleteButton.setOnClickListener {
                    val itemPosition = adapterPosition
                    if (itemPosition!=RecyclerView.NO_POSITION){
                        deleteItem(itemPosition)
                    }
                }

            }
        }

        private fun increaseQuantity(position: Int)
        {
            if (itemQuantites[position]<10){
                itemQuantites[position]++
                binding.cartitemQuantity.text = itemQuantites[position].toString()
            }
        }

        private fun decreaseQuantity(position: Int)
        {
            if (itemQuantites[position]>1){
                itemQuantites[position]--
                binding.cartitemQuantity.text = itemQuantites[position].toString()
            }
        }

        private fun deleteItem(position: Int)
        {
            CartItems.removeAt(position)
            CartImage.removeAt(position)
            cartItemPrice.removeAt(position)
            notifyItemRemoved(position)
            notifyItemRangeChanged(position,CartItems.size)
        }

    }
}