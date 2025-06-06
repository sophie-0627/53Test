package com.example.a53test.ui.theme

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.room.Database

@Composable
fun ALLNavHost(navController: NavHostController, viewModel: AllViewModel, db: UserData) {
    NavHost(navController = navController, startDestination = All.登入.name) {
        composable(All.登入.name) { Login(navController, db) }
        composable(All.註冊.name) { SignIn(navController, db) }
        composable(All.經營者.name) { Person(navController) }
        composable(All.展館介紹.name) { Info(navController) }
        composable(All.樓層立體圖.name) { Floor(navController) }
        composable(All.公共藝術.name) { ART(navController) }
        composable(All.聯絡我們.name) { Us(navController) }
        composable(All.全部票卡.name) { Ticket() }
        composable(All.主畫面.name) { Main(navController, viewModel) }
        composable(All.延遲.name) { SplashScreen(navController) }
        composable("Click") { PageTwo(navController, viewModel) }
    }
}
