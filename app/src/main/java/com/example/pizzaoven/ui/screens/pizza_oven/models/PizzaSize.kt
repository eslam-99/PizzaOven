package com.example.pizzaoven.ui.screens.pizza_oven.models

enum class PizzaSize(
    val price: Int,
    val fillFraction: Float,
) {
    Small(0, 0.48f),
    Medium(30, 0.50f),
    Large(60, 0.52f),
}