package com.example.pizzaoven.ui.screens.pizza_oven

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.navigationBars
import androidx.compose.foundation.layout.statusBars
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.tooling.preview.Preview
import com.example.pizzaoven.ui.screens.pizza_oven.components.AddToCartButton
import com.example.pizzaoven.ui.screens.pizza_oven.components.PizzaAppBar
import com.example.pizzaoven.ui.screens.pizza_oven.components.PizzaPlate
import com.example.pizzaoven.ui.screens.pizza_oven.components.PizzaPrice
import com.example.pizzaoven.ui.screens.pizza_oven.components.PizzaSizeChanger
import com.example.pizzaoven.ui.screens.pizza_oven.components.PizzaToppings
import com.example.pizzaoven.ui.screens.pizza_oven.models.PizzaSize
import com.example.pizzaoven.ui.screens.pizza_oven.models.PizzaTopping
import com.example.pizzaoven.ui.screens.pizza_oven.models.PizzaType
import com.example.pizzaoven.ui.screens.pizza_oven.models.PizzaUiModel

@Composable
fun PizzaOvenScreen(viewModel: PizzaOvenViewModel) {
    val state = viewModel.state.collectAsState()
    PizzaOvenContent(
        pizza = state.value,
        changePizzaType = viewModel::changePizzaType,
        changePizzaSize = viewModel::changePizzaSize,
        toggleTopping = viewModel::toggleTopping,
        undoLastAction = viewModel::undoLastAction,
    )
}

@Composable
fun PizzaOvenContent(
    pizza: PizzaUiModel,
    changePizzaType: (PizzaType) -> Unit,
    changePizzaSize: (PizzaSize) -> Unit,
    toggleTopping: (PizzaTopping) -> Unit,
    undoLastAction: () -> Unit,
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(White)
            .windowInsetsPadding(WindowInsets.statusBars)
            .windowInsetsPadding(WindowInsets.navigationBars)
    ) {
        Column(
            modifier = Modifier
                .weight(1f)
                .verticalScroll(rememberScrollState())
        ) {
            PizzaAppBar(undoLastAction)
            PizzaPlate(pizza, changePizzaType)
            PizzaPrice(pizza.calculatePrice())
            PizzaSizeChanger(pizza.pizzaSize, changePizzaSize)
            PizzaToppings(pizza, toggleTopping)
        }
        AddToCartButton()
    }
}

@Preview
@Composable
fun PizzaOvenScreenPreview() {
    val viewModel = PizzaOvenViewModel()
    PizzaOvenScreen(viewModel)
}