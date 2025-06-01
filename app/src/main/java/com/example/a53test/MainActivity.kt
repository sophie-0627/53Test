@file:Suppress("UNREACHABLE_CODE")
@file:OptIn(ExperimentalMaterial3Api::class)

package com.example.a53test

import android.os.Bundle
import android.webkit.WebView
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
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
            Change()
        }
    }
}

enum class All{
    經營者,
    展館介紹,
    樓層立體圖,
    公共藝術,
    聯絡我們,
    全部票卡,
    主畫面,
}