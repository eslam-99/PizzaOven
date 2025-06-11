package com.example.pizzaoven.ui.screens.pizza_oven

import androidx.lifecycle.ViewModel
import com.example.pizzaoven.ui.screens.pizza_oven.models.ChangePizzaSize
import com.example.pizzaoven.ui.screens.pizza_oven.models.ChangePizzaType
import com.example.pizzaoven.ui.screens.pizza_oven.models.PizzaSize
import com.example.pizzaoven.ui.screens.pizza_oven.models.PizzaTopping
import com.example.pizzaoven.ui.screens.pizza_oven.models.PizzaType
import com.example.pizzaoven.ui.screens.pizza_oven.models.PizzaUiModel
import com.example.pizzaoven.ui.screens.pizza_oven.models.ToggleTopping
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class PizzaOvenViewModel() : ViewModel() {
    private val _state = MutableStateFlow<PizzaUiModel>(PizzaUiModel())
    val state = _state.asStateFlow()

    fun changePizzaType(pizzaType: PizzaType) {
        if (pizzaType == _state.value.pizzaType) return
        _state.value.actionHistory.addLast(ChangePizzaType(_state.value.pizzaType))
        _state.update { it.copy(pizzaType = pizzaType) }
    }

    fun changePizzaSize(pizzaSize: PizzaSize) {
        if (pizzaSize == _state.value.pizzaSize) return
        _state.value.actionHistory.addLast(ChangePizzaSize(_state.value.pizzaSize))
        _state.update { it.copy(pizzaSize = pizzaSize) }
    }

    fun toggleTopping(pizzaTopping: PizzaTopping) {
        val newToppingsSet =
            if (_state.value.pizzaToppings[_state.value.pizzaType]?.contains(pizzaTopping) == true) {
                _state.value.actionHistory.addLast(ToggleTopping(pizzaTopping, isSelected = false))
                _state.value.pizzaToppings[_state.value.pizzaType]!!.minus(pizzaTopping)
            } else {
                _state.value.actionHistory.addLast(ToggleTopping(pizzaTopping, isSelected = true))
                _state.value.pizzaToppings[_state.value.pizzaType]?.plus(pizzaTopping) ?: setOf(
                    pizzaTopping
                )
            }
        val newToppingsMap =
            _state.value.pizzaToppings.plus(_state.value.pizzaType to newToppingsSet)
        _state.update { it.copy(pizzaToppings = newToppingsMap) }
    }

    fun undoLastAction() {
        if (_state.value.actionHistory.isEmpty()) return
        val lastAction = _state.value.actionHistory.removeLast()
        when (lastAction) {
            is ChangePizzaType -> _state.update { it.copy(pizzaType = lastAction.oldPizzaType) }
            is ChangePizzaSize -> _state.update { it.copy(pizzaSize = lastAction.oldPizzaSize) }
            is ToggleTopping -> {
                val newToppingsSet = if (lastAction.isSelected) {
                    _state.value.pizzaToppings[_state.value.pizzaType]!!.minus(lastAction.pizzaTopping)
                } else {
                    _state.value.pizzaToppings[_state.value.pizzaType]!!.plus(lastAction.pizzaTopping)
                }
                val newToppingsMap =
                    _state.value.pizzaToppings.plus(_state.value.pizzaType to newToppingsSet)
                _state.update { it.copy(pizzaToppings = newToppingsMap) }
            }
        }
    }
}