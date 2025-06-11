package com.example.pizzaoven.ui.screens.pizza_oven.components

import android.annotation.SuppressLint
import androidx.compose.animation.core.animateIntAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.pizzaoven.ui.theme.PizzaOvenAnimationDuration
import com.example.pizzaoven.ui.theme.SFPro

@SuppressLint("DefaultLocale")
@Composable
fun PizzaPrice(pizzaPrice: Int) {
    val price = animateIntAsState(pizzaPrice, animationSpec = tween(PizzaOvenAnimationDuration))
    Text(
        text = "\$${price.value}",
        fontFamily = SFPro,
        fontWeight = FontWeight.Bold,
        fontSize = 28.sp,
        textAlign = TextAlign.Center,
        modifier = Modifier
            .padding(top = 24.dp)
            .fillMaxWidth()
            .padding(horizontal = 16.dp),
    )
}