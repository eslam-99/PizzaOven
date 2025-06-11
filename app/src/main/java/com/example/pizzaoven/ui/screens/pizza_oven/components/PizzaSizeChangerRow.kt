package com.example.pizzaoven.ui.screens.pizza_oven.components

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.pizzaoven.ui.screens.pizza_oven.models.PizzaSize
import com.example.pizzaoven.ui.theme.PizzaOvenAnimationDuration
import com.example.pizzaoven.ui.theme.SFPro

@Composable
fun PizzaSizeChanger(pizzaSize: PizzaSize, changePizzaSize: (PizzaSize) -> Unit) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 12.dp)
            .padding(top = 24.dp),
        contentAlignment = Alignment.CenterStart
    ) {
        var paddingStart = when (pizzaSize) {
            PizzaSize.Small -> 0f
            PizzaSize.Medium -> 72f
            PizzaSize.Large -> 144f
        }
        var paddingEnd = when (pizzaSize) {
            PizzaSize.Small -> 144f
            PizzaSize.Medium -> 72f
            PizzaSize.Large -> 0f
        }

        Box(
            modifier = Modifier.fillMaxWidth(),
            contentAlignment = Alignment.Center,
        ) {
            Box(
                modifier = Modifier
                    .padding(
                        start = animateFloatAsState(paddingStart, tween(PizzaOvenAnimationDuration)).value.dp,
                        end = animateFloatAsState(paddingEnd, tween(PizzaOvenAnimationDuration)).value.dp,
                    )
                    .padding(top = 24.dp)
                    .size(48.dp)
                    .shadow(elevation = 10.dp, shape = CircleShape)
                    .clip(CircleShape)
                    .background(White)
            )
        }

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center,
        ) {
            PizzaSizeButton(changePizzaSize, PizzaSize.Small, "S")
            PizzaSizeButton(changePizzaSize, PizzaSize.Medium, "M")
            PizzaSizeButton(changePizzaSize, PizzaSize.Large, "L")
        }
    }
}

@Composable
private fun PizzaSizeButton(
    changePizzaSize: (PizzaSize) -> Unit,
    pizzaSize: PizzaSize,
    pizzaSizeText: String,
) {
    Box(
        modifier = Modifier
            .padding(horizontal = 12.dp)
            .padding(top = 24.dp)
            .size(48.dp)
            .clip(CircleShape)
            .clickable(
                onClick = {
                    changePizzaSize(pizzaSize)
                },
            ),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = pizzaSizeText,
            fontFamily = SFPro,
            fontWeight = FontWeight.Medium,
            fontSize = 24.sp,
            textAlign = TextAlign.Center,
        )
    }
}