package com.example.pizzaoven

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.pizzaoven.ui.screens.pizza_oven.PizzaOvenScreen
import com.example.pizzaoven.ui.screens.pizza_oven.PizzaOvenViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            PizzaOvenScreen(PizzaOvenViewModel())
        }
    }
}