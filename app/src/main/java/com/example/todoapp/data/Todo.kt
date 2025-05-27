package com.example.todoapp.data

import androidx.compose.runtime.Stable

@Stable
data class Todo(
    val id: Int,
    val text: String,
    val completed: Boolean = false
)
