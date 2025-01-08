package com.example.navigator.navgraph

sealed class Route(
    val route: String
) {
    object OnBoardingScreen : Route("onBoardingScreen")
    object HomeScreen : Route("HomeScreen")
    object SearchScreen : Route("SearchScreen")
    object BookmarkScreen : Route("BookmarkScreen")
    object DetailsScreen : Route("DetailsScreen")
    object AppStartNavigation : Route("appStartNavigation")
    object NewsNavigation : Route("newsNavigation")
    object NewsNavigatorScreen : Route("newsNavigatorScreen")
}