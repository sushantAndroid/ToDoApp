package com.example.todoapp.view

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.example.todoapp.data.Todo

@Composable
fun TodoApp() {
    // All state is managed at the top level
    var todos by remember { mutableStateOf(listOf<Todo>()) }
    var newTodoText by remember { mutableStateOf("") }

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        TodoInput(
            text = newTodoText,
            onTextChange = { newTodoText = it },
            onAddTodo = {
                if (newTodoText.isNotBlank()) {
                    todos = todos + Todo(id = todos.size, text = newTodoText)
                    newTodoText = ""
                }
            }
        )

        TodoList(
            todos = todos,
            onToggleTodo = { todoId ->
                todos = todos.map { todo ->
                    if (todo.id == todoId) todo.copy(completed = !todo.completed)
                    else todo
                }
            },
            onDeleteTodo = { todoId ->
                todos = todos.filterNot { it.id == todoId }
            }
        )
    }
}