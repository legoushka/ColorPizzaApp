package com.example.colorpizzaapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.example.colorpizzaapp.databinding.ActivityMainBinding
import com.github.javafaker.Faker

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    private lateinit var viewModel: MainActivityViewModel
    private val faker = Faker.instance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val colorListViewModel = ViewModelProvider(this).get(MainActivityViewModel::class.java)
        colorListViewModel.fetchColorList((this?.application as? ColorsApp)?.colorApi)

    }
}