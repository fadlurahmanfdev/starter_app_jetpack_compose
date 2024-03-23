package com.fadlurahmanf.starterappcompose.core.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.fadlurahmanf.starterappcompose.feature.example.presentation.ListFeatureActivity
import com.fadlurahmanf.starterappcompose.feature.example.presentation.navigation.ExampleNavigationActivity
import com.fadlurahmanf.starterappcompose.feature.example.presentation.navigation.NavigationWithArgumentActivity

@Composable
fun MainApp() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "example_list_feature") {
        composable("example_list_feature") {
            ListFeatureActivity(
                onNavigateToExampleNavigation = { model ->
                    when (model.key) {
                        "NAVIGATION" -> {
                            navController.navigate("example_navigation_activity")
                        }
                    }
                }
            )
        }
        composable(
            "example_navigation_activity"
        ) {
            ExampleNavigationActivity(
                onNavigateToExampleNavigation = { model ->
                    when (model.key) {
                        "MANDATORY_ARGUMENT" -> {
                            val path = NavRoute.NavigationWithArgument.passPath(
                                "ISI_PATH_1",
                                2
                            )
                            navController.navigate(path)
                        }

                        "OPTIONAL_ARGUMENT" -> {
                            val path = NavRoute.NavigationWithArgument.passOptionalArgument2(
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
            NavRoute.NavigationWithArgument.path,
            arguments = listOf(
                navArgument("path1") {
                    type = NavType.StringType
                },
                navArgument("path2") {
                    type = NavType.IntType
                },
                navArgument("optionalArg1") {
                    type = NavType.StringType
                    nullable = true
                }
            )
        ) { navBackStackEntry ->
            val path1 = navBackStackEntry.arguments?.getString("path1")
            val path2 = navBackStackEntry.arguments?.getInt("path2")
            val optionalArg1 = navBackStackEntry.arguments?.getString("optionalArg1")
            val optionalArg2 = navBackStackEntry.arguments?.getString("optionalArg2")
            NavigationWithArgumentActivity(path1 ?: "-", path2 ?: -1, optionalArg1, optionalArg2)
        }
    }
}