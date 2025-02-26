package com.semenov.numbers.ui.navgraph

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.semenov.data.model.EntityNumber
import com.semenov.numbers.ui.detailsscrean.DetailScreen
import com.semenov.numbers.ui.mainscreen.MainScreen

@Composable
fun NavGraph() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "main") {
        composable("main") {
            MainScreen(onItemClick = { selectedFact ->
                navController.navigate("detail/${selectedFact.number}/${selectedFact.description}")
            })
        }
        composable(
            "detail/{number}/{description}",
            arguments = listOf(
                navArgument("number") { type = NavType.IntType },
                navArgument("description") {type = NavType.StringType}),
        ) { backStackEntry ->
            val number = backStackEntry.arguments?.getInt("number")
            val description = backStackEntry.arguments?.getString("description")
            val fact = remember { EntityNumber(number ?: 0, description ?: "") }
            DetailScreen(entityNumber = fact) {
                navController.popBackStack()
            }
        }
    }
}