package com.example.orientapp.ui.main

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

/**
 * This class is used to define view model for persistent screen orientation.
 */
class MainViewModel : ViewModel() {

    // Variable to store current background color of screen before rotating.
    val currentColour:MutableLiveData<String> by lazy {
        MutableLiveData<String>()
    }

}