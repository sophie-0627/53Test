@file:Suppress("UNREACHABLE_CODE")
@file:OptIn(ExperimentalMaterial3Api::class)

package com.example.a53test

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.a53test.ui.theme.ART
import com.example.a53test.ui.theme.Change

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Page()
        }
    }
}

enum class All{
    page1,
    關於展覽,
    樓層立體圖,
    公共藝術,
    聯絡我們,
    全部票卡,
    主畫面
}

@Composable
fun Page(){
    var page = rememberNavController()

    NavHost(navController = page, startDestination = "page1"){
        composable("page1"){ Change(page) }
        composable("關於展覽") {  }
        composable("樓層立體圖") {  }
        composable("公共藝術") { ART(page) }
        composable("聯絡我們") {  }
        composable("全部票卡") {  }
        composable("主畫面") {  }
    }
}