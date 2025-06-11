package com.example.pizzaoven.ui.screens.pizza_oven.components

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeOut
import androidx.compose.animation.scaleIn
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.runtime.snapshotFlow
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.pizzaoven.R
import com.example.pizzaoven.ui.screens.pizza_oven.models.PizzaTopping
import com.example.pizzaoven.ui.screens.pizza_oven.models.PizzaType
import com.example.pizzaoven.ui.screens.pizza_oven.models.PizzaUiModel
import com.example.pizzaoven.ui.theme.PizzaOvenAnimationDuration
import kotlin.random.Random

@Composable
fun PizzaPlate(
    pizza: PizzaUiModel,
    changePizzaType: (PizzaType) -> Unit,
) {
    Box(
        modifier = Modifier
            .padding(top = 12.dp)
            .fillMaxWidth()
            .aspectRatio(1.3f)
    ) {
        Image(
            painter = painterResource(id = R.drawable.plate),
            contentDescription = "Pizza Plate",
            modifier = Modifier
                .fillMaxWidth(0.66f)
                .align(Alignment.Center)
        )

        val pagerState =
            rememberPagerState(initialPage = PizzaType.entries.indexOf(pizza.pizzaType)) { PizzaType.entries.size }

        LaunchedEffect(key1 = PizzaType.entries.indexOf(pizza.pizzaType)) {
            pagerState.animateScrollToPage(
                PizzaType.entries.indexOf(pizza.pizzaType),
                animationSpec = tween(PizzaOvenAnimationDuration)
            )
        }

        LaunchedEffect(pagerState) {
            snapshotFlow { pagerState.currentPage }.collect { page ->
                changePizzaType(PizzaType.entries[page])
            }
        }

        Column(
            modifier = Modifier.fillMaxWidth()
        ) {
            HorizontalPager(
                state = pagerState,
                modifier = Modifier.fillMaxSize(),
            ) { page ->
                Box(
                    modifier = Modifier.fillMaxSize(),
                    contentAlignment = Alignment.Center,
                ) {
                    val animatedPizzaSize =
                        animateFloatAsState(pizza.pizzaSize.fillFraction, tween(PizzaOvenAnimationDuration))
                    Image(
                        painter = painterResource(id = PizzaType.entries[page].image),
                        contentDescription = "",
                        modifier = Modifier.fillMaxWidth(animatedPizzaSize.value),
                        contentScale = ContentScale.FillWidth
                    )
                    val animatedToppingSize =
                        animateFloatAsState(pizza.pizzaSize.fillFraction, tween(PizzaOvenAnimationDuration))
                    val pizzaType = PizzaType.entries[page]
                    PizzaTopping.entries.forEach { topping ->
                        Column(
                            modifier = Modifier.fillMaxSize(),
                            verticalArrangement = Arrangement.Center
                        ) {
                            AnimatedVisibility(
                                pizza.pizzaToppings[pizzaType]?.contains(topping) == true,
                                enter = scaleIn(initialScale = 50f, animationSpec = tween(PizzaOvenAnimationDuration)),
                                exit = fadeOut(tween(200)),
                            ) {
                                Box(
                                    modifier = Modifier.fillMaxSize(),
                                    contentAlignment = Alignment.Center,
                                ) {
                                    (0..1)
                                        .forEach { i ->
                                            topping.toppingImages.forEach { image ->
                                                val randomX =
                                                    remember { (Random.nextFloat() - 0.5f) * 300 }
                                                val randomY =
                                                    remember { (Random.nextFloat() - 0.5f) * 300 }
                                                val randomAnimatedX =
                                                    animateFloatAsState(
                                                        randomX * animatedToppingSize.value * 0.85f,
                                                        tween(100)
                                                    )
                                                val randomAnimatedY =
                                                    animateFloatAsState(
                                                        randomY * animatedToppingSize.value * 0.85f,
                                                        tween(100)
                                                    )
                                                Image(
                                                    painter = painterResource(id = image),
                                                    contentDescription = null,
                                                    modifier = Modifier
                                                        .size((48 * animatedToppingSize.value).dp)
                                                        .offset(
                                                            x = randomAnimatedX.value.dp,
                                                            y = randomAnimatedY.value.dp,
                                                        ),
                                                    contentScale = ContentScale.Fit,
                                                )
                                            }
                                        }
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}