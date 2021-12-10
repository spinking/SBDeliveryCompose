package ru.skillbranch.sbdelivery.screens.home.ui

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import coil.annotation.ExperimentalCoilApi
import ru.skillbranch.sbdelivery.R
import ru.skillbranch.sbdelivery.screens.dishes.data.DishesUiState
import ru.skillbranch.sbdelivery.screens.home.logic.HomeFeature
import ru.skillbranch.sbdelivery.screens.root.logic.Msg

@ExperimentalCoilApi
@ExperimentalFoundationApi
@ExperimentalComposeUiApi
@Composable
fun HomeScreen(state: HomeFeature.State, accept: (Msg) -> Unit) {

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.verticalScroll(rememberScrollState())
    ) {
        Card(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth()
                .aspectRatio(16 / 9f)
        ) {
            Image(
                painter = painterResource(id = R.drawable.wallpaper),
                contentScale = ContentScale.Crop,
                contentDescription = "Wallpaper"
            )
        }

        when(state.recommended) {
            DishesUiState.Empty -> {

            }
            DishesUiState.Error -> {

            }
            DishesUiState.Loading -> ShimmerSection(itemWidth = 160.dp, title = "Рекомендуем")
            is DishesUiState.Value -> SectionList(
                dishes = state.recommended.dishes,
                title = "Рекомендуем",
                onClick = { accept(Msg.ClickDish(it.id, it.title)) },
                onAddToCart = { accept(Msg.AddToCart(it.id, it.title)) },
                onToggleLike = { accept(Msg.ToggleLike(it.id, it.isFavorite)) }
            )
        }

        when(state.best) {
            DishesUiState.Empty -> {

            }
            DishesUiState.Error -> {

            }
            DishesUiState.Loading -> ShimmerSection(itemWidth = 160.dp, title = "Лучшее")
            is DishesUiState.Value -> SectionList(
                dishes = state.best.dishes,
                title = "Лучшее",
                onClick = { accept(Msg.ClickDish(it.id, it.title)) },
                onAddToCart = { accept(Msg.AddToCart(it.id, it.title)) },
                onToggleLike = { accept(Msg.ToggleLike(it.id, it.isFavorite)) }
            )
        }

        when(state.popular) {
            DishesUiState.Empty -> {

            }
            DishesUiState.Error -> {

            }
            DishesUiState.Loading -> ShimmerSection(itemWidth = 160.dp, title = "Популярное")
            is DishesUiState.Value -> SectionList(
                dishes = state.popular.dishes,
                title = "Популярное",
                onClick = { accept(Msg.ClickDish(it.id, it.title)) },
                onAddToCart = { accept(Msg.AddToCart(it.id, it.title)) },
                onToggleLike = { accept(Msg.ToggleLike(it.id, it.isFavorite)) }
            )
        }
    }
}




