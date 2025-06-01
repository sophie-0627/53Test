package com.example.a53test.ui.theme

import com.example.a53test.R
import android.graphics.pdf.PdfRendererPreV.Page
import android.media.midi.MidiDevice
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.withInfiniteAnimationFrameMillis
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.DrawerState
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.rememberDrawerState
import androidx.compose.material3.rememberTopAppBarState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.AbsoluteAlignment
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.focus.focusModifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.modifier.modifierLocalOf
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.a53test.All
import com.example.a53test.ui.theme.JsonOne
import com.example.a53test.ui.theme._53TestTheme
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch


@Composable
fun Main(navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding()
    ) {
        val pagerState = rememberPagerState(pageCount = { 2 })
        HorizontalPager(
            state = pagerState
        ) { page ->
            val image = when (page) {
                0 -> R.drawable.d
                1 -> R.drawable.s
                else -> R.drawable.baseline_square_24
            }
            Image(
                painter = painterResource(image),
                contentDescription = "",
                modifier = Modifier
                    .height(250.dp)
                    .fillMaxWidth(),
                contentScale = ContentScale.Crop
            )
        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(5.dp),
            horizontalArrangement = Arrangement.End
        ) {
            repeat(pagerState.pageCount) { index ->
                Box(
                    modifier = Modifier
                        .height(10.dp)
                        .clip(CircleShape)
                        .background(if (pagerState.currentPage == index) Color.DarkGray else Color.LightGray)
                        .animateContentSize()
                        .width(if (pagerState.currentPage == index) 40.dp else 10.dp)
                )
                Spacer(modifier = Modifier.padding(3.dp))
            }
        }

        Text("媒體中心", fontSize = 23.sp, modifier = Modifier.padding(10.dp),fontWeight = FontWeight.Bold)
        JsonOne(navController)
        Text("購票資訊", fontSize = 23.sp, modifier = Modifier.padding(start = 10.dp),fontWeight = FontWeight.Bold)

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(5.dp))
                .padding(10.dp)
                .size(height = 150.dp, width = 400.dp)
                .background(Color.White)
                .border(2.dp, color = Color.LightGray, RoundedCornerShape(10.dp)),
        ) {
            Button(
                onClick = { navController.navigate(All.全部票卡.name) },
                modifier = Modifier
                    .size(height = 45.dp, width = 100.dp)
                    .align(Alignment.BottomEnd)
                    .padding(end = 5.dp, bottom = 10.dp),
                shape = RoundedCornerShape(500.dp),
                border = BorderStroke(1.dp,Color.LightGray),
                colors = ButtonDefaults.buttonColors(Color.White)
            ) {
                Text("購票", color = Color.Black)
            }

            Text(
                "2023第41屆新一代設計展",
                fontSize = 20.sp,
                modifier = Modifier
                    .padding(start = 10.dp, top = 10.dp)
                    .align(Alignment.TopStart),
                fontWeight = FontWeight.Bold
            )

            Text(
                "YODEX",
                fontSize = 20.sp,
                modifier = Modifier
                    .padding(start = 10.dp, bottom = 10.dp)
                    .align(Alignment.BottomStart)
            )
        }
    }
}
