package com.mahmoudbashir.gymcompose.ui

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.navigation.NavController

@Composable
fun DefaultScreen(
    navController: NavController,
    userId:String?
){
    val id = userId
    Log.d("??????","DefaultScreenUserId : $userId")

}