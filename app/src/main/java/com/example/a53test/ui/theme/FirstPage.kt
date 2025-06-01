package com.example.a53test.ui.theme

import android.graphics.pdf.PdfDocument.Page
import android.icu.text.IDNA.Info
import com.example.a53test.R
import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.DrawerState
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.motionEventSpy
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Change(viewModel: AllViewModel) {
    var drawer = rememberDrawerState(initialValue = DrawerValue.Closed)
    val scope = rememberCoroutineScope()
    var Screen = rememberNavController()

    var currentBackStackEntry = Screen.currentBackStackEntryAsState()
    var currentRouter = currentBackStackEntry.value?.destination?.route
    var showScaffold = if(currentRouter != "Click"||currentRouter != All.聯絡我們.name) true else false

    if(showScaffold){
    ModalNavigationDrawer(
        drawerState = drawer,
        drawerContent = {
            ModalDrawerSheet {
                Inside(drawer, scope, Screen)
            }
        }
    ) {
            Scaffold(
                topBar = {
                    TopAppBar(
                        navigationIcon = {
                            IconButton(
                                onClick = { scope.launch { drawer.open() } },
                                modifier = Modifier.size(40.dp)
                            ) {
                                Icon(
                                    painter = painterResource(R.drawable.baseline_menu_24),
                                    tint = Color(0xFF005E86),
                                    contentDescription = ""
                                )
                            }
                        },
                        title = {
                            Image(
                                modifier = Modifier.width(300.dp),
                                painter = painterResource(R.drawable.p),
                                contentDescription = ""
                            )
                        }
                    )
                }
            ) { innerPadding ->
                Column(
                    modifier = Modifier.padding(innerPadding)
                ) {
                    ALLNavHost(Screen,viewModel)
                }
            }
        }
    }
    else {
        ALLNavHost(Screen,viewModel)
    }
}

@Composable
fun Inside(drawer: DrawerState, scope: CoroutineScope, navController: NavController) {
    val list = listOf("關於展覽", "樓層立體圖", "公共藝術", "聯絡我們", "全部票卡", "主畫面")
    val information = listOf("經營者", "展館介紹")

    LazyColumn {
        items(list) { item ->
            if(item == "關於展覽"){
                Row(
                    modifier = Modifier
                        .padding(start = 20.dp)
                        .padding(10.dp)
                        .size(height = 20.dp, width = 100.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(
                        painter = painterResource(R.drawable.baseline_square_24),
                        tint = Color(0xFF025872),
                        contentDescription = "",
                    )
                    Text(item, fontSize = 15.sp)
                }
            } else {
                Row(
                    modifier = Modifier
                        .padding(start = 20.dp)
                        .padding(10.dp)
                        .size(height = 20.dp, width = 100.dp)
                        .clickable {
                            scope.launch{ drawer.close() }
                            navController.navigate(item)
                        },
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(
                        painter = painterResource(R.drawable.baseline_square_24),
                        tint = Color(0xFF025872),
                        contentDescription = "",
                    )
                    Text(item, fontSize = 15.sp)
                }
            }

            if (item == "關於展覽") {
                information.forEach {
                    var text = if (it == "經營者") All.經營者.name else  All.展館介紹.name
                    Row(
                        modifier = Modifier
                            .padding(start = 45.dp)
                            .width(100.dp)
                            .size(height = 20.dp, width = 100.dp)
                            .clickable {
                                scope.launch{ drawer.close() }
                                navController.navigate(text)
                            },
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Icon(
                            modifier = Modifier.size(15.dp),
                            painter = painterResource(R.drawable.l),
                            tint = Color(0xFF025872),
                            contentDescription = "",
                        )
                        Text(it, fontSize = 15.sp)
                    }
                    Spacer(modifier = Modifier.padding(5.dp))
                }
            }
        }
    }
}