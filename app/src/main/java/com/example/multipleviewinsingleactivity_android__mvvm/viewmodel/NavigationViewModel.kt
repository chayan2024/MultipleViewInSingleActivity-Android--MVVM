package com.example.multipleviewinsingleactivity_android__mvvm.viewmodel

import androidx.lifecycle.ViewModel
import java.util.*

class NavigationViewModel : ViewModel() {

    private val layoutStack = Stack<Int>()

    fun pushLayout(layoutId: Int) {
        layoutStack.push(layoutId)
    }

    fun popLayout(currentLayout: Int?): Int? {
        return if (layoutStack.isNotEmpty()) currentLayout?.minus(1) else null
    }

    fun getCurrentLayout(): Int? {
        return layoutStack.lastOrNull()
    }

}
