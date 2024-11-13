package com.example.pariwaragro

import android.os.Bundle
import android.renderscript.ScriptGroup.Binding
import android.widget.ArrayAdapter
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.helper.widget.Carousel.Adapter
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.pariwaragro.databinding.ActivityChooseLocationBinding

class ChooseLocationActivity : AppCompatActivity() {
    private val binding: ActivityChooseLocationBinding by lazy {
        ActivityChooseLocationBinding.inflate(layoutInflater)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(binding.root)
        val locationList= arrayOf("Shirdi","Rahata","Kopargaon","Nirmal Pimpri","Loni")
        val adapter = ArrayAdapter(this,android.R.layout.simple_list_item_1,locationList)
        val autoCompleteTextView = binding.ListOfLocation
        autoCompleteTextView.setAdapter(adapter)
    }
}