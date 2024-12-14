package com.example.myapplication

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.adapter.bagsAdapter
import com.example.myapplication.databinding.ActivityDashboardBinding

class Dashboard : AppCompatActivity() {
    lateinit var binding: ActivityDashboardBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityDashboardBinding.inflate(layoutInflater) // Inflate the layout using binding
        setContentView(binding.root)

        // Retrieve data from intent
        val name = intent.getStringExtra("name")
        val email = intent.getStringExtra("email")
        val gender= intent.getStringExtra("gender")
        val country= intent.getStringExtra("countryFromSpinner")
        val city= intent.getStringExtra("countryFromAutoComplete")
        // Set the text to the TextViews using binding
        binding.welcomeTextView.text = "Welcome $name"
        binding.emailTextView.text = "Email: $email"
        binding.gender.text="Gender: $gender"
        binding.country.text="Country: $country"
        binding.city.text="City: $city"

        val recyclerView: RecyclerView = binding.recy
        recyclerView.layoutManager = LinearLayoutManager(this)


        val imageList = arrayListOf(R.drawable.bag1, R.drawable.bag2, R.drawable.bag3, R.drawable.bag4)
        val titleList = arrayListOf("Luois Vuiton", "Gucci","Gucci Pink", "Gucci Pattern")
        val descList = arrayListOf("Beautiful and elegance", "Comfort and style", "Pink and preety", "Fashion For Real")


// Create an instance of the adapter
        val adapter = bagsAdapter(this, imageList, titleList, descList)
        recyclerView.adapter = adapter


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}