package com.example.pizzaoven.ui.screens.pizza_oven.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.pizzaoven.R
import com.example.pizzaoven.ui.theme.SFPro

@Composable
fun AddToCartButton() {
    Row(
        modifier = Modifier
            .padding(bottom = 24.dp)
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.Center,
    ) {
        Button(
            onClick = {},
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF463936)),
            shape = RoundedCornerShape(14.dp),
            contentPadding = PaddingValues(horizontal = 32.dp, vertical = 12.dp),
        ) {
            Icon(
                painter = painterResource(id = R.drawable.cart_filled),
                contentDescription = "Cart",
                modifier = Modifier.size(24.dp),
                tint = White,
            )
            Text(
                text = "Add To Cart",
                fontFamily = SFPro,
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold,
                color = White,
                modifier = Modifier.padding(start = 16.dp),
            )
        }
    }
}