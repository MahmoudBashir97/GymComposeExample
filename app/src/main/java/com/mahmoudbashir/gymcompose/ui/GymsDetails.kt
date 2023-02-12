package com.mahmoudbashir.gymcompose.ui

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.mahmoudbashir.gymcompose.ui.viewModel.GymDetailsViewModel

@Composable
fun GymDetailsScreen(navController: NavController){
    val viewModel:GymDetailsViewModel = viewModel()

    Button(onClick = {
                     navController.navigate("login"){
                         popUpTo("gyms") { inclusive = true }
                     }

    }, modifier = Modifier.fillMaxWidth()
        .height(100.dp),
    colors = ButtonDefaults.btnDefaults()) {
        Text(text = "Logout", style = TextStyle(
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold,
            color = Color.Black
        ))
    }
}