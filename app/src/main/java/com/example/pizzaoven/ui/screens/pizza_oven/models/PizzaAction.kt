package com.example.pizzaoven.ui.screens.pizza_oven.models

interface PizzaAction

class ChangePizzaType(val oldPizzaType: PizzaType) : PizzaAction

class ChangePizzaSize(val oldPizzaSize: PizzaSize) : PizzaAction

class ToggleTopping(val pizzaTopping: PizzaTopping, val isSelected: Boolean) : PizzaAction