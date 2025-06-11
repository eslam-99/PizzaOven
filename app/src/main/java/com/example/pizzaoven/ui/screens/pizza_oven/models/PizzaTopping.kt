package com.example.pizzaoven.ui.screens.pizza_oven.models

import androidx.annotation.DrawableRes
import com.example.pizzaoven.R

enum class PizzaTopping(
    val price: Int,
    @DrawableRes
    val coverImage: Int,
    @DrawableRes
    val toppingImages: List<Int>
) {
    Basil(
        20, R.drawable.basil_3, listOf(
            R.drawable.basil_1,
            R.drawable.basil_2,
            R.drawable.basil_3,
            R.drawable.basil_4,
            R.drawable.basil_5,
            R.drawable.basil_6,
            R.drawable.basil_7,
            R.drawable.basil_8,
            R.drawable.basil_9,
            R.drawable.basil_10,
        )
    ),
    Broccoli(
        20, R.drawable.broccoli_3, listOf(
            R.drawable.broccoli_1,
            R.drawable.broccoli_2,
            R.drawable.broccoli_3,
            R.drawable.broccoli_4,
            R.drawable.broccoli_5,
            R.drawable.broccoli_6,
            R.drawable.broccoli_7,
            R.drawable.broccoli_8,
            R.drawable.broccoli_9,
            R.drawable.broccoli_10,
        )
    ),
    Mushroom(
        20, R.drawable.mushroom_3, listOf(
            R.drawable.mushroom_1,
            R.drawable.mushroom_2,
            R.drawable.mushroom_3,
            R.drawable.mushroom_4,
            R.drawable.mushroom_5,
            R.drawable.mushroom_6,
            R.drawable.mushroom_7,
            R.drawable.mushroom_8,
            R.drawable.mushroom_9,
            R.drawable.mushroom_10,
        )
    ),
    Onion(
        20, R.drawable.onion_3, listOf(
            R.drawable.onion_1,
            R.drawable.onion_2,
            R.drawable.onion_3,
            R.drawable.onion_4,
            R.drawable.onion_5,
            R.drawable.onion_6,
            R.drawable.onion_7,
            R.drawable.onion_8,
            R.drawable.onion_9,
            R.drawable.onion_10,
        )
    ),
    Sausage(
        20, R.drawable.sausage_3, listOf(
            R.drawable.sausage_1,
            R.drawable.sausage_2,
            R.drawable.sausage_3,
            R.drawable.sausage_4,
            R.drawable.sausage_5,
            R.drawable.sausage_6,
            R.drawable.sausage_7,
            R.drawable.sausage_8,
            R.drawable.sausage_9,
            R.drawable.sausage_10,
        )
    ),
}