package com.example.pizzaoven.ui.screens.pizza_oven.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color.Companion.Black
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.pizzaoven.R
import com.example.pizzaoven.ui.theme.SFPro

@Composable
fun PizzaAppBar(
    undoLastAction: () -> Unit,
) {
    Row(
        modifier = Modifier
            .padding(horizontal = 16.dp)
            .padding(top = 16.dp)
    ) {
        Icon(
            painter = painterResource(id = R.drawable.arrow_back),
            contentDescription = "Back",
            tint = Black,
            modifier = Modifier
                .size(24.dp)
                .clickable { undoLastAction() },
        )
        Text(
            text = "Pizza",
            fontFamily = SFPro,
            fontWeight = FontWeight.Bold,
            fontSize = 24.sp,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .padding(horizontal = 12.dp)
                .weight(1f),
        )
        Icon(
            painter = painterResource(id = R.drawable.favourite_outlined),
            contentDescription = "Back",
            modifier = Modifier.size(24.dp),
            tint = Black,
        )
    }
}