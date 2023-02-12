package com.mahmoudbashir.gymcompose.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.Place
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.mahmoudbashir.gymcompose.ui.model.Gym
import com.mahmoudbashir.gymcompose.ui.theme.GymComposeTheme
import com.mahmoudbashir.gymcompose.ui.theme.Purple200
import com.mahmoudbashir.gymcompose.ui.viewModel.GymViewModel

@Composable
fun GymScreen(onItemClick: (Int) -> Unit) {
    //Column Iteration
    // here to make the static column to be scrollable
//    Column(modifier = Modifier.verticalScroll(rememberScrollState())) {
//        gList.forEach {
//            GymItem(gym = it)
//        }
//    }

    val vm: GymViewModel = viewModel() // get default viewModelStoreOwner
//    var state by rememberSaveable() { mutableStateOf(vm.getGyms()) }
    LazyColumn() {
        items(vm.state) { gym ->
            GymItem(gym = gym,
                onFavClick = { id ->
                    vm.toggleFavourite(id)
                },
            ){id-> onItemClick(id) }
        }
    }
}

@Composable
fun GymItem(gym: Gym, onFavClick: (Int) -> Unit, onItemClick: (Int) -> Unit) {
    //var isFavourite by remember{ mutableStateOf(false) }
    val icon = if (gym.isFavourite) Icons.Filled.Favorite
    else Icons.Filled.FavoriteBorder

    Card(elevation = 10.dp,
        modifier = Modifier
            .padding(10.dp)
            .clickable {
                onItemClick(gym.id)
            }
    ) {
        Row(
            verticalAlignment =
            Alignment.CenterVertically, modifier = Modifier.padding(10.dp)
        ) {
            DefaultIcon(Icons.Filled.Place, Modifier.weight(0.15f), "Icon")
            GymDetails(gym = gym, Modifier.weight(0.70f))
            DefaultIcon(icon, Modifier.weight(0.15f), "Favourite") {
//                isFavourite = !isFavourite
                onFavClick(gym.id)
            }
        }
    }
}

@Composable
fun DefaultIcon(
    icon: ImageVector,
    modifier: Modifier,
    contentDescription: String,
    onClick: () -> Unit = {}
) {
    Image(
        imageVector = icon,
        contentDescription = contentDescription,
        modifier = modifier.clickable {
            onClick()
        },
        colorFilter = ColorFilter.tint(Color.DarkGray)
    )
}

@Composable
fun GymDetails(gym: Gym, modifier: Modifier) {
    Column(modifier = modifier) {
        Text(
            text = gym.name,
            style = MaterialTheme.typography.h5,
            color = Purple200
        )
        CompositionLocalProvider(
            LocalContentAlpha provides ContentAlpha.medium
        ) {
            Text(
                text = gym.place,
                style = MaterialTheme.typography.body2
            )
        }

    }
}


/*@Preview(showBackground = true)
@Composable
fun GymScreenPreview() {
    GymComposeTheme {
        GymScreen()
    }
}*/
