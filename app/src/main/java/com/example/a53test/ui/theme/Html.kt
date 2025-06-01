package com.example.a53test.ui.theme

import android.app.Person
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.viewinterop.AndroidView
import androidx.navigation.NavController
import com.example.a53test.R

@Composable
fun Person(navController: NavController) {
    AndroidView(
        factory = { context ->
            WebView(context).apply {
                settings.javaScriptEnabled = true
                webViewClient = WebViewClient()
                loadUrl("file:///android_asset/經營者.html")
            }
        }
    )
}

@Composable
fun Info(navController: NavController) {
    AndroidView(
        factory = { context ->
            WebView(context).apply {
                settings.javaScriptEnabled = true
                webViewClient = WebViewClient()
                loadUrl("file:///android_asset/展館介紹.html")
            }
        }
    )
}