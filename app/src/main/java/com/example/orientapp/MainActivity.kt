package com.example.orientapp

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.orientapp.databinding.MainActivityBinding
import com.example.orientapp.ui.main.MainViewModel

/**
 * This activity is used to show different background color on button click.
 */
class MainActivity : AppCompatActivity() {

    private lateinit var binding: MainActivityBinding
    private lateinit var viewModel: MainViewModel

    /**
     * This method is used to create the activity.
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Binding of views
        binding = MainActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Initializing a view model and retain the background color on orientation change.
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        viewModel.currentColour.observe(this, {
            binding.main.setBackgroundColor(Color.parseColor(it.toString()))
        })

        // Calling changeColor function on a button click
        binding.blueButton.setOnClickListener {
            changeColor("blue")

        }
        binding.greenButton.setOnClickListener {
            changeColor("green")

        }
        binding.redButton.setOnClickListener {
            changeColor("red")
        }

        binding.whiteButton.setOnClickListener {
            changeColor("white")
        }
    }

    /**
     * This method is used to change the color and store the values in view model.
     */
    private  fun changeColor(colour:String){
        viewModel.currentColour.value = colour
        binding.main.setBackgroundColor(Color.parseColor(colour))
    }

}