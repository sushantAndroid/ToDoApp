package com.example.todoapp.view

import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable

@Composable
fun TodoInput(
    text: String,
    onTextChange: (String) -> Unit,
    onAddTodo: () -> Unit
) {
    // Stateless input component
    Row {
        TextField(
            value = text,
            onValueChange = onTextChange,
            placeholder = { Text("Enter todo") }
        )
        Button(onClick = onAddTodo) {
            Text("Add")
        }
    }
}