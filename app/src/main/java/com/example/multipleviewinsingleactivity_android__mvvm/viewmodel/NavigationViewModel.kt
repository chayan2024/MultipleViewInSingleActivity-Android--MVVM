package com.example.multipleviewinsingleactivity_android__mvvm.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.multipleviewinsingleactivity_android__mvvm.R
import java.util.Stack

class NavigationViewModel : ViewModel() {
    private val layoutStack = Stack<Int>()
    private val _currentLayout = MutableLiveData<Int>()

    val currentLayout: LiveData<Int>
        get() = _currentLayout

    init {
        // Initialize with Layout 1 as the starting layout
        switchToLayout(R.id.layout1)
    }

    fun switchToLayout(layoutId: Int) {
        layoutStack.push(layoutId)
        _currentLayout.value = layoutId
    }

    fun popAndSwitchLayout() {
        if (layoutStack.size > 1) {
            layoutStack.pop()
            _currentLayout.value = layoutStack.peek()
        }
    }

    fun isLayoutVisible(layoutId: Int): Boolean {
        return _currentLayout.value == layoutId
    }
}
