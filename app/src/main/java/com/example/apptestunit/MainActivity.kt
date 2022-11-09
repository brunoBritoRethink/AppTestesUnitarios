package com.example.apptestunit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.get
import com.example.apptestunit.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root

        viewModel = ViewModelProvider(this).get()

        binding.button.setOnClickListener {
            binding.tvTitle.visibility = View.INVISIBLE
            binding.progressBar.visibility = View.VISIBLE
            viewModel.apply {
                this.addTitle("Bruno")
                this.getMovies()?.observe(this@MainActivity, Observer {
                    binding.tvTitle.text = it.elementAt(0).director
                    binding.tvTitle.visibility = View.VISIBLE
                    binding.progressBar.visibility = View.INVISIBLE
                })
            }
        }

        setContentView(view)
    }
}