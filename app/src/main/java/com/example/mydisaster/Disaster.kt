package com.example.disasterapp

import androidx.annotation.DrawableRes

data class Disaster(
    val nameDisaster: String = "",
    val disasterType: String = "",
    // Latihan: gambar per item
    @DrawableRes val image: Int = 0
)