package com.example.multipleviewinsingleactivity_android__mvvm

import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.example.multipleviewinsingleactivity_android__mvvm.viewmodel.NavigationViewModel
import java.util.Stack

class MainActivity : AppCompatActivity() {

    private val viewModel: NavigationViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        switchLayout(viewModel.getCurrentLayout() ?: R.id.layout1)
        setupButtons(viewModel.getCurrentLayout() ?: R.id.layout1)
    }

    private fun setupButtons(layoutId: Int) {
        val layout = findViewById<View>(layoutId)

        if (layout == null) return

        val buttonNext = layout.findViewById<Button>(R.id.buttonNext)
        val buttonPrevious = layout.findViewById<Button>(R.id.buttonPrevious)
        val buttonConfirm = layout.findViewById<Button>(R.id.buttonConfirm)

        buttonNext?.setOnClickListener {
            when (layoutId) {
                R.id.layout1 -> switchToLayout(R.id.layout2)
                R.id.layout2 -> switchToLayout(R.id.layout3)
                R.id.layout3 -> switchToLayout(R.id.layout4)
                R.id.layout4 -> switchToLayout(R.id.layout5)
                // Add more cases as needed for additional layouts
            }
        }

        buttonPrevious?.setOnClickListener {
            viewModel.popLayout(viewModel.getCurrentLayout())?.let { previousLayoutId ->
                    switchToLayout(previousLayoutId)
            }
        }


    }

    private fun switchToLayout(layoutId: Int) {
        switchLayout(layoutId)
        setupButtons(layoutId)
    }

    private fun switchLayout(layoutId: Int) {
        viewModel.pushLayout(layoutId)

        findViewById<View>(R.id.layout1).visibility = View.GONE
        findViewById<View>(R.id.layout2).visibility = View.GONE
        findViewById<View>(R.id.layout3).visibility = View.GONE
        findViewById<View>(R.id.layout4).visibility = View.GONE
        findViewById<View>(R.id.layout5).visibility = View.GONE

        findViewById<View>(layoutId).visibility = View.VISIBLE
    }
}
