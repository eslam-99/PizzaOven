package com.example.pizzaoven.ui.screens.pizza_oven.components

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.clipToBounds
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Gray
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.pizzaoven.ui.screens.pizza_oven.models.PizzaTopping
import com.example.pizzaoven.ui.screens.pizza_oven.models.PizzaUiModel
import com.example.pizzaoven.ui.theme.SFPro

@Composable
fun PizzaToppings(
    pizza: PizzaUiModel,
    toggleTopping: (PizzaTopping) -> Unit,
) {
    Column(
        modifier = Modifier
            .padding(top = 48.dp)
            .fillMaxWidth()
    ) {
        Text(
            text = "CUSTOMIZE YOUR PIZZA",
            fontFamily = SFPro,
            fontWeight = FontWeight.Medium,
            fontSize = 12.sp,
            textAlign = TextAlign.Start,
            color = Gray,
            modifier = Modifier.padding(horizontal = 16.dp),
        )
        LazyRow(
            modifier = Modifier.padding(top = 12.dp),
            horizontalArrangement = Arrangement.spacedBy(12.dp),
            contentPadding = PaddingValues(horizontal = 16.dp),
        ) {
            items(PizzaTopping.entries.size) { index ->
                val pizzaTopping = PizzaTopping.entries[index]
                val isSelected =
                    pizza.pizzaType in pizza.pizzaToppings &&
                            pizzaTopping in pizza.pizzaToppings[pizza.pizzaType]!!
                PizzaToppingButton(isSelected, toggleTopping, pizzaTopping)
            }
        }
    }
}

@Composable
private fun PizzaToppingButton(
    isSelected: Boolean,
    toggleTopping: (PizzaTopping) -> Unit,
    pizzaTopping: PizzaTopping
) {
    val bgColor = animateColorAsState(
        if (isSelected) Color(0xFFDDF4E0) else White,
        animationSpec = tween(500)
    )
    Box(
        modifier = Modifier
            .padding(horizontal = 6.dp)
            .padding(top = 24.dp)
            .size(56.dp)
            .clip(CircleShape)
            .clipToBounds()
            .background(bgColor.value)
            .clickable(
                onClick = {
                    toggleTopping(pizzaTopping)
                },
            ),
        contentAlignment = Alignment.Center,
    ) {
        Image(
            painter = painterResource(id = pizzaTopping.coverImage),
            contentDescription = pizzaTopping.name,
            modifier = Modifier.padding(10.dp),
        )
    }
}