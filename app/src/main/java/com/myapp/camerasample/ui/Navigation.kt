package com.myapp.camerasample.ui

import androidx.annotation.StringRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Info
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.NavHostController
import com.myapp.camerasample.R
import com.myapp.camerasample.ui.screen.HomeScreen
import com.myapp.camerasample.ui.screen.SecondScreen

enum class Screens(
    val group: Group,
    val route: String
) {
    HomeScreen(Group.HOME, "home_screen_route"),
    SecondScreen(Group.INFO, "center_screen_route");
    /**
     * ナビゲーションタブ定義
     *
     * @property title タブタイトル
     * @property imgRes タブアイコン
     * @property route タブの先頭のroute
     */
    enum class Group(@StringRes val title: Int, val imgRes: ImageVector, val route: String) {
        HOME(
            R.string.tab_home,
            Icons.Filled.Home,
            "home_screen_route"
        ),
        INFO(
            R.string.tab_center,
            Icons.Filled.Info,
            "center_screen_route"
        );
    }

    companion object {
        /**
         * 遷移パスからタブグループ検索
         *
         * @param route 遷移パス
         * @return タブグループ（存在しない遷移パスの場合はNullを返す)
         */
        fun findGroupByRoute(route: String?): Group? {
            return values()
                .filter { it.route == route }
                .map { it.group }
                .firstOrNull()
        }
    }
}

/**
 * NavigationHost 画面遷移定義
 *
 * @param navController ナビゲーションAPI
 */
@Composable
fun AppNavHost(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = Screens.HomeScreen.route
    ) {
        // HOMEタブ
        composable(route = Screens.HomeScreen.route) {
            HomeScreen()
        }
        composable(route = Screens.SecondScreen.route) {
            SecondScreen()
        }
    }
}
