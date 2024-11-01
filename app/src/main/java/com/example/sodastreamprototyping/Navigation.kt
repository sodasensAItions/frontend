package com.example.sodastreamprototyping

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument

@Composable
fun Navigation()
{
    val navController = rememberNavController();

    NavHost(navController, startDestination = Screen.SignIn.route) {
        composable(route = Screen.SignIn.route) {
            SignInScreen(
                onSignUpClick = { navController.navigate("sign_up") },
                onSignInSuccess = { navController.navigate("home") }
            )
        }
        composable(route = Screen.SignUp.route) {
            SignUpScreen(
                onSignInClick = { navController.popBackStack() }
            )
        }
        composable(route = Screen.Home.route) {
            Home(navController = navController)
        }

        composable(route = Screen.Basket.route){
            ShoppingBasket(navController)
        }

        composable(
            route = Screen.Edit.route + "/{drinkID}",
            arguments = listOf(
                navArgument("drinkID"){
                    type = NavType.StringType
                    nullable = false
                }
            )){
            entry ->
            EditMenu(navController = navController, drinkIDString = entry.arguments?.getString("drinkID"))
        }

        composable(route = Screen.Checkout.route){
            Checkout(navController)
        }

    }
}