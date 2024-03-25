package com.fadlurahmanf.starterappcompose.core.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.fadlurahmanf.starterappcompose.feature.example.presentation.ListFeatureActivity
import com.fadlurahmanf.starterappcompose.feature.example.presentation.crypto.CryptoActivity
import com.fadlurahmanf.starterappcompose.feature.example.presentation.navigation.ExampleNavigationActivity
import com.fadlurahmanf.starterappcompose.feature.example.presentation.navigation.NavigationWithArgumentActivity
import com.fadlurahmanf.starterappcompose.feature.example.presentation.splash.ExampleSplashActivity

@Composable
fun MainApp() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = NavRoute.ExampleSplashActivity.path) {
        composable(NavRoute.ExampleSplashActivity.path) {
            ExampleSplashActivity(
                onSplashEnded = {
                    navController.navigate(NavRoute.ListFeatureActivity.path) {
                        popUpTo(NavRoute.ExampleSplashActivity.path) {
                            inclusive = true
                        }
                    }
                }
            )
        }
        composable(NavRoute.ListFeatureActivity.path) {
            ListFeatureActivity(
                onNavigateToExampleNavigation = { model ->
                    when (model.key) {
                        "NAVIGATION" -> {
                            navController.navigate(NavRoute.ExampleNavigationActivity.path)
                        }

                        "CRYPTO" -> {
                            navController.navigate(NavRoute.ExampleCryptoActivity.path)
                        }
                    }
                }
            )
        }
        composable(NavRoute.ExampleNavigationActivity.path) {
            ExampleNavigationActivity(
                onNavigateToExampleNavigation = { model ->
                    when (model.key) {
                        "MANDATORY_ARGUMENT" -> {
                            val path = NavRoute.ExampleNavigationWithArgumentActivity.passPath(
                                "ISI_PATH_1",
                                2
                            )
                            navController.navigate(path)
                        }

                        "OPTIONAL_ARGUMENT" -> {
                            val path =
                                NavRoute.ExampleNavigationWithArgumentActivity.passOptionalArgument2(
                                    "ISI_PATH_1",
                                    2,
                                    "ISI OPTIONAL ARG 2"
                                )
                            navController.navigate(path)
                        }
                    }
                }
            )
        }
        composable(
            NavRoute.ExampleNavigationWithArgumentActivity.path,
            arguments = listOf(
                navArgument("path1") {
                    type = NavType.StringType
                },
                navArgument("path2") {
                    type = NavType.IntType
                }
            )
        ) { navBackStackEntry ->
            val path1 = navBackStackEntry.arguments?.getString("path1")
            val path2 = navBackStackEntry.arguments?.getInt("path2")
            val optionalArg1 = navBackStackEntry.arguments?.getString("optionalArg1")
            val optionalArg2 = navBackStackEntry.arguments?.getString("optionalArg2")
            NavigationWithArgumentActivity(path1 ?: "-", path2 ?: -1, optionalArg1, optionalArg2)
        }
        composable(
            NavRoute.ExampleCryptoActivity.path,
        ) { _ ->
            CryptoActivity()
        }
    }
}