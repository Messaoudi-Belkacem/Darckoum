package com.example.darckoum.navigation

import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navigation
import com.example.darckoum.navigation.screen.BottomBarScreen
import com.example.darckoum.navigation.screen.LeafScreen
import com.example.darckoum.ui.screen.add.AddScreen
import com.example.darckoum.ui.screen.announcement.AnnouncementScreen
import com.example.darckoum.ui.screen.home.HomeScreen
import com.example.darckoum.ui.screen.profile.ProfileScreen

@Composable
fun HomeNavGraph(
    bottomBarNavHostController: NavHostController,
    navHostController: NavHostController
) {
    val time = 500
    NavHost(
        navController = bottomBarNavHostController,
        route = Graph.HOME,
        startDestination = BottomBarScreen.Home.route,
        enterTransition = { fadeIn(animationSpec = tween(time)) },
        exitTransition = { fadeOut(animationSpec = tween(time)) },
        popEnterTransition = { fadeIn(animationSpec = tween(time)) },
        popExitTransition = { fadeOut(animationSpec = tween(time)) }
    ) {
        composable(route = BottomBarScreen.Home.route) {
            HomeScreen(bottomBarNavHostController = bottomBarNavHostController)
        }
        composable(route = BottomBarScreen.Add.route) {
            AddScreen(bottomBarNavHostController = bottomBarNavHostController)
        }
        composable(route = BottomBarScreen.Profile.route) {
            ProfileScreen(
                bottomBarNavHostController = bottomBarNavHostController,
                navHostController = navHostController
            )
        }
        /*navigation(
            route = Graph.DETAILS,
            startDestination = LeafScreen.Announcement.route
        ) {
            composable(route = LeafScreen.Announcement.route) {
                AnnouncementScreen(bottomBarNavHostController = bottomBarNavHostController)
            }
        }*/
    }
}