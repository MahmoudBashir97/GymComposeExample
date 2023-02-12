package com.mahmoudbashir.gymcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.mahmoudbashir.gymcompose.ui.DefaultScreen
import com.mahmoudbashir.gymcompose.ui.GymDetailsScreen
import com.mahmoudbashir.gymcompose.ui.GymScreen
import com.mahmoudbashir.gymcompose.ui.LoginScreen
import com.mahmoudbashir.gymcompose.ui.theme.GymComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            GymComposeTheme {
                GymsAroundApp()
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    GymComposeTheme {
        Greeting("Android")
    }
}

@Composable
fun GymsAroundApp() {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = "login",
    ) {
        composable(route = "login") {
            LoginScreen {
                navController.navigate("gyms"){
                    popUpTo("login") { inclusive = true } // do popUp to LoginScreen from backStack
                    launchSingleTop = true
                }
            }
        }
        composable(route = "gyms") {
            GymScreen { id ->
                navController.navigate("details/$id")
               // navController.navigate("default?userId=$id")
            }
        }
        composable(
            route = "details/{gym_id}",
            arguments = listOf(
                navArgument(
                name = "gym_id",
            ) {
                type = NavType.IntType
            }
            )
        ) {
            val gymId = it.arguments?.getInt("gym_id")
            GymDetailsScreen(navController)
        }

        composable(route="default?userId={userId}",
        arguments = listOf(
            navArgument("userId"){
                defaultValue = "user1234"
            }
        )
        ){
            DefaultScreen(navController = navController,
                userId =it.arguments?.getString("userId") )
        }
    }
}
