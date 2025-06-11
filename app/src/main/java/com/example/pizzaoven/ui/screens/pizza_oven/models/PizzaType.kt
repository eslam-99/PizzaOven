package com.example.pizzaoven.ui.screens.pizza_oven.models

import androidx.annotation.DrawableRes
import com.example.pizzaoven.R

enum class PizzaType(
    val price: Int,
    @DrawableRes
    val image: Int,
) {
    Type1(60, R.drawable.bread_1),
    Type2(70, R.drawable.bread_2),
    Type3(80, R.drawable.bread_3),
    Type4(90, R.drawable.bread_4),
    Type5(100, R.drawable.bread_5),
}