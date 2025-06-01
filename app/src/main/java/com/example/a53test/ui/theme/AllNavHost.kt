package com.example.a53test.ui.theme

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

@Composable
fun ALLNavHost(navController: NavHostController,viewModel: AllViewModel) {
    NavHost(navController = navController, startDestination = All.主畫面.name) {
        composable(All.經營者.name) { Person(navController) }
        composable(All.展館介紹.name) { Info(navController) }
        composable(All.樓層立體圖.name) { Floor(navController) }
        composable(All.公共藝術.name) { ART(navController) }
        composable(All.聯絡我們.name) { Us(navController) }
        composable(All.全部票卡.name) {  }
        composable(All.主畫面.name) { Main(navController,viewModel) }
        composable("Click") { PageTwo(navController,viewModel) }
    }
}
