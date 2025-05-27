package com.example.todoapp.view

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import com.example.todoapp.data.Todo

@Composable
fun TodoList(
    todos: List<Todo>,
    onToggleTodo: (Int) -> Unit,
    onDeleteTodo: (Int) -> Unit
) {
    // Stateless list component
    LazyColumn {
        items(todos) { todo ->
            TodoItem(
                todo = todo,
                onToggle = { onToggleTodo(todo.id) },
                onDelete = { onDeleteTodo(todo.id) }
            )
        }
    }
}