package com.example.pizzaoven.ui.screens.pizza_oven.models

data class PizzaUiModel(
    val pizzaType: PizzaType = PizzaType.Type1,
    val pizzaSize: PizzaSize = PizzaSize.Small,
    val pizzaToppings: Map<PizzaType, Set<PizzaTopping>> = emptyMap(),
    val actionHistory: ArrayDeque<PizzaAction> = ArrayDeque(),
) {
    fun calculatePrice(): Int {
        return pizzaType.price + pizzaSize.price + (pizzaToppings[pizzaType]?.sumOf { it.price }
            ?: 0)
    }
}