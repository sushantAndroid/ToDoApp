# Todo App - Jetpack Compose State Hoisting Example

A simple Todo application built with Jetpack Compose that demonstrates advanced state hoisting patterns and best practices for state management in Android development.

## 🎯 Purpose

This project serves as a comprehensive example of **state hoisting** in Jetpack Compose, showcasing how to build maintainable, testable, and reusable UI components by properly managing state at the appropriate levels of your component hierarchy.

## ✨ Features

- ✅ Add new todo items
- ✅ Toggle todo completion status
- ✅ Delete todo items
- ✅ Visual indication for completed items (strikethrough text)
- ✅ Clean, Material Design UI

## 🏗️ Architecture & State Management

### State Hoisting Benefits Demonstrated

1. **Single Source of Truth**: All todo data is managed centrally in `TodoApp`
2. **Reusable Components**: Stateless components can be used in different contexts
3. **Testability**: Each component can be tested independently
4. **Predictable Data Flow**: Data flows down through props, events flow up through callbacks
5. **Easy Debugging**: All state mutations happen in one centralized location

### Component Structure

```
TodoApp (Stateful)
├── TodoInput (Stateless)
└── TodoList (Stateless)
    └── TodoItem (Stateless)
```

- **TodoApp**: Manages all application state and business logic
- **TodoInput**: Renders input field and add button, delegates actions upward
- **TodoList**: Renders list of todos using LazyColumn for performance
- **TodoItem**: Renders individual todo with toggle and delete functionality

## 🚀 Getting Started

### Prerequisites

- Android Studio Arctic Fox or later
- Kotlin 1.8.0 or later
- Minimum SDK: API 24 (Android 7.0)
- Target SDK: API 34 (Android 14)

### Installation

1. Clone the repository:
```bash
git clone https://github.com/yourusername/todo-app-compose.git
cd todo-app-compose
```

2. Open the project in Android Studio

3. Sync the project with Gradle files

4. Run the app on an emulator or physical device

### Dependencies

Add these dependencies to your `build.gradle.kts` (Module: app):

```kotlin
dependencies {
    implementation("androidx.compose.ui:ui:$compose_version")
    implementation("androidx.compose.ui:ui-tooling-preview:$compose_version")
    implementation("androidx.compose.material3:material3:1.1.2")
    implementation("androidx.compose.material:material-icons-core:$compose_version")
    implementation("androidx.compose.material:material-icons-extended:$compose_version")
    implementation("androidx.activity:activity-compose:1.8.0")
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.7.0")
}
```

## 📁 Project Structure

```
app/src/main/java/com/example/todoapp/
├── data/
│   └── Todo.kt              # Data model
├── ui/
│   ├── components/
│   │   ├── TodoInput.kt     # Input component
│   │   ├── TodoItem.kt      # Individual todo item
│   │   └── TodoList.kt      # List of todos
│   └── TodoApp.kt           # Main app composable
└── MainActivity.kt          # Entry point
```

## 🔧 Key Implementation Details

### State Management Pattern

```kotlin
@Composable
fun TodoApp() {
    // Centralized state management
    var todos by remember { mutableStateOf(listOf<Todo>()) }
    var newTodoText by remember { mutableStateOf("") }
    
    // State is passed down, events are hoisted up
    Column {
        TodoInput(
            text = newTodoText,
            onTextChange = { newTodoText = it },
            onAddTodo = { /* Handle todo addition */ }
        )
        TodoList(
            todos = todos,
            onToggleTodo = { /* Handle toggle */ },
            onDeleteTodo = { /* Handle deletion */ }
        )
    }
}
```

### Stateless Component Example

```kotlin
@Composable
fun TodoInput(
    text: String,
    onTextChange: (String) -> Unit,
    onAddTodo: () -> Unit
) {
    // Pure function - no internal state
    // Easily testable and reusable
}
```

## 📚 Learning Resources

This project demonstrates key Compose concepts:

- **State Hoisting**: Moving state up to make components stateless
- **Unidirectional Data Flow**: Data down, events up pattern
- **Composition over Inheritance**: Building complex UIs from simple components
- **Remember & MutableState**: Managing state in Compose
- **LazyColumn**: Efficient list rendering for large datasets

## 🤝 Contributing

1. Fork the repository
2. Create a feature branch (`git checkout -b feature/amazing-feature`)
3. Commit your changes (`git commit -m 'Add amazing feature'`)
4. Push to the branch (`git push origin feature/amazing-feature`)
5. Open a Pull Request



## 🙏 Acknowledgments
https://medium.com/@sauravsushant58/all-about-state-in-compose-bf178a7ec21b
---

**Built with ❤️ using Jetpack Compose**
