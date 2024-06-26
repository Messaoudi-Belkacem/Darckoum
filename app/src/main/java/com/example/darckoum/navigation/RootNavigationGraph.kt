package com.example.darckoum.navigation

import androidx.compose.animation.core.tween
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import androidx.navigation.compose.rememberNavController
import com.example.darckoum.navigation.screen.AuthenticationScreen
import com.example.darckoum.navigation.screen.BottomBarScreen
import com.example.darckoum.navigation.screen.LeafScreen
import com.example.darckoum.ui.screen.login.LoginScreen
import com.example.darckoum.ui.screen.register.RegisterScreen

@Composable
fun RootNavigationGraph(
    startDestination: String
) {
    val navHostController = rememberNavController()
    val bottomBarNavHostController = rememberNavController()
    val time = 500
    NavHost(
        navController = navHostController,
        route = Graph.ROOT,
        startDestination = startDestination,
        enterTransition = { slideInHorizontally(animationSpec = tween(time), initialOffsetX = {fullWidth ->  
            -fullWidth
        }) },
        exitTransition = { slideOutHorizontally(animationSpec = tween(time), targetOffsetX = {fullWidth ->
            fullWidth
        }) },
        popEnterTransition = { slideInHorizontally(animationSpec = tween(time), initialOffsetX = {fullWidth ->
            -fullWidth
        }) },
        popExitTransition = { slideOutHorizontally(animationSpec = tween(time), targetOffsetX = {fullWidth ->
            fullWidth
        }) }
    ) {
        navigation(
            route = Graph.AUTHENTICATION,
            startDestination = AuthenticationScreen.LogIn.route
        ) {
            composable(route = AuthenticationScreen.LogIn.route) {
                LoginScreen(navHostController = navHostController)
            }
            composable(route = AuthenticationScreen.SignUp.route) {
                RegisterScreen(navHostController = navHostController)
            }
        }
        navigation(
            route = Graph.HOME,
            startDestination = LeafScreen.Main.route
        ) {
            composable(route = BottomBarScreen.Home.route) {

            }
            composable(route = BottomBarScreen.Add.route) {

            }
            composable(route = BottomBarScreen.Profile.route) {

            }
            navigation(
                route = Graph.DETAILS,
                startDestination = LeafScreen.Announcement.route
            ) {
                composable(route = LeafScreen.Announcement.route) {

                }
            }
        }
    }
}

object Graph {
    const val ROOT = "root_graph"
    const val AUTHENTICATION = "authentication_graph"
    const val HOME = "home_graph"
    const val DETAILS = "details_graph"
}