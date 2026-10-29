package com.example.disasterapp

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.disasterapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val adapterDisaster = DisasterAdapter(generateDummy()) { disaster ->
            Toast.makeText(
                this@MainActivity,
                "You clicked on ${disaster.nameDisaster}",
                Toast.LENGTH_SHORT
            ).show()
        }

        with(binding) {
            // LinearLayoutManager (langkah 7) -- aktifkan ini kalau mau list vertikal
            // rvDisaster.apply {
            //     adapter = adapterDisaster
            //     layoutManager = LinearLayoutManager(this@MainActivity)
            // }

            // GridLayoutManager 2 kolom (langkah 21)
            rvDisaster.apply {
                adapter = adapterDisaster
                layoutManager = GridLayoutManager(this@MainActivity, 2)
            }
        }
    }

    fun generateDummy(): List<Disaster> {
        return listOf(
            Disaster(nameDisaster = "Tsunami", disasterType = "Natural", image = R.drawable.ic_natural),
            Disaster(nameDisaster = "Volcanic Eruption", disasterType = "Natural", image = R.drawable.ic_natural),
            Disaster(nameDisaster = "Earthquake", disasterType = "Natural", image = R.drawable.ic_natural),
            Disaster(nameDisaster = "Flood", disasterType = "Natural", image = R.drawable.ic_natural),
            Disaster(nameDisaster = "Fire", disasterType = "Natural", image = R.drawable.ic_natural),
            Disaster(nameDisaster = "Nuclear Accident", disasterType = "Man-made", image = R.drawable.ic_manmade),
            Disaster(nameDisaster = "Terrorist Attack", disasterType = "Man-made", image = R.drawable.ic_manmade),
            Disaster(nameDisaster = "War", disasterType = "Man-made", image = R.drawable.ic_manmade)
        )
    }
}