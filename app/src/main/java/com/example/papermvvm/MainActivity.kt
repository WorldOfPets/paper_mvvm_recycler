package com.example.papermvvm

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.ViewModelProvider
import com.example.papermvvm.databinding.ActivityMainBinding
import io.paperdb.Paper

class MainActivity : AppCompatActivity() {
    private lateinit var binding:ActivityMainBinding
    private lateinit var carViewModel: CarViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        Paper.init(this@MainActivity)
        carViewModel = ViewModelProvider(this)[CarViewModel::class.java]
        binding.btnAddCar.setOnClickListener {
            carViewModel.addCar(CarModel(1, "BMW", "X6"))
        }
    }
}