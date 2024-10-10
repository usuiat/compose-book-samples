package net.engawapg.composebooksamples.practicaluiexample

import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.animation.slideOutVertically
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import kotlinx.serialization.Serializable

@Composable
fun App() {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = Route.Prefectures,
    ) {
        composable<Route.Prefectures> {
            PrefecturesScreen(
                onPrefectureClick = { prefecture ->
                    navController.navigate(
                        Route.PrefectureDetail(name = prefecture.name)
                    )
                }
            )
        }
        composable<Route.PrefectureDetail>(
            enterTransition = { slideInHorizontally(initialOffsetX = { it }) },
            exitTransition = null,
            popEnterTransition = null,
            popExitTransition = { slideOutHorizontally(targetOffsetX = { it }) }
        ) { navBackStackEntry ->
            val prefectureDetail: Route.PrefectureDetail
                    = navBackStackEntry.toRoute()
            PrefectureDetailScreen(
                prefectureName = prefectureDetail.name,
                onBackClick = { navController.popBackStack() },
                onOpenWikiClick = { wikiUrl ->
                    navController.navigate(
                        Route.WikiView(url = wikiUrl)
                    )
                }
            )
        }
        composable<Route.WikiView>(
            enterTransition = { slideInVertically(initialOffsetY = { it }) },
            exitTransition = null,
            popEnterTransition = null,
            popExitTransition = { slideOutVertically(targetOffsetY = { it }) }
        ) { navBackStackEntry ->
            val wikiView: Route.WikiView = navBackStackEntry.toRoute()
            WikiViewScreen(
                url = wikiView.url,
                onCloseClick = { navController.popBackStack() }
            )
        }
    }
}

object Route {
    @Serializable
    data object Prefectures

    @Serializable
    data class PrefectureDetail(
        val name: String
    )

    @Serializable
    data class WikiView(
        val url: String
    )
}
