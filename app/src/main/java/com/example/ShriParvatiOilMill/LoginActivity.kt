package com.example.ShriParvatiOilMill

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.ShriParvatiOilMill.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {
    private val binding:ActivityLoginBinding by lazy {
        ActivityLoginBinding.inflate(layoutInflater)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(binding.root)
        binding.loginbutton.setOnClickListener {
            val intent=Intent(this,SignActivity::class.java)
            startActivity(intent)
        }

        binding.donthavebutton.setOnClickListener {
            val intent=Intent(this,SignActivity::class.java)
            startActivity(intent)
        }

    }
}