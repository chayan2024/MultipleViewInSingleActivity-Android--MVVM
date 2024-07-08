package com.example.multipleviewinsingleactivity_android__mvvm
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.multipleviewinsingleactivity_android__mvvm.databinding.ActivityMainBinding
import com.example.multipleviewinsingleactivity_android__mvvm.viewmodel.NavigationViewModel

class MainActivity : AppCompatActivity() {

    private val viewModel: NavigationViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Inflate layout using data binding
        val binding: ActivityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.lifecycleOwner = this
        binding.viewModel = viewModel
    }
}

