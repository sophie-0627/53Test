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
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.a53test.ui.theme.ART
import com.example.a53test.ui.theme.AllViewModel
import com.example.a53test.ui.theme.Change

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val viewModel:AllViewModel = viewModel()
            Change(viewModel)
        }
    }
}