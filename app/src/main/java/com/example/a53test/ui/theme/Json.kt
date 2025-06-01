package com.example.a53test.ui.theme

import android.graphics.BitmapFactory
import android.graphics.ImageDecoder
import android.util.Log
import android.util.SparseArray
import android.view.animation.AlphaAnimation
import androidx.annotation.ColorRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.Divider
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.google.gson.reflect.TypeToken
import com.google.gson.Gson

@Composable
fun JsonOne(navController: NavController) {
    val context = LocalContext.current
    val json = context.assets.open("test2.json").bufferedReader().use { it.readText() }
    val test = object : TypeToken<List<One>>() {}.type
    val gson = Gson().fromJson<List<One>>(json, test)
    val size = 13
    var hallColor = Color(0xFF739EA5)

    LazyColumn(
        modifier = Modifier.fillMaxWidth()
    ) {
        items(gson.reversed()) { item ->
            Row(
                modifier = Modifier.fillMaxSize(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier.width(90.dp).height(38.dp)
                ) {
                    Text(
                        item.dateTime.toString().replace('.', '/'),
                        fontSize = 15.sp,
                        modifier = Modifier.padding(start = 17.dp),
                        color = Color.Gray
                    )
                    Row(
                        modifier = Modifier.padding(start = 20.dp)
                    ) {
                        item.hall.forEach {
                            if (it != "1館") hallColor = Color(0xFF19AA9E) else hallColor =
                                Color(0xFF10607E)
                            Text(
                                it,
                                fontSize = 15.sp,
                                color = hallColor,
                                modifier = Modifier.padding(start = 5.dp)
                            )
                        }
                    }
                }
                Text(
                    item.title ?: "",
                    fontSize = size.sp,
                    modifier = Modifier
                        .padding(start = 20.dp,end = 5.dp)
                        .clickable {
                            navController.navigate("pagetwo")
                           //PageTwo(item.title.toString(),item.dateTime.toString().replace('.', '/'), item.hall,item.content.toString())
                        }
                        .weight(1f),
                    fontWeight = FontWeight.Bold,
                    color = Color(0xFF323232)
                )
            }
//            Divider(
//                modifier = Modifier
//                    .fillMaxSize()
//                    .padding(4.dp),
//                thickness = 1.dp,
//                color = Color.LightGray
//            )
            HorizontalDivider(
                modifier = Modifier.padding(4.dp)
            )
        }
    }
}

@Composable
fun FirstART(navController: NavController) {
    val context = LocalContext.current
    val catch = context.assets.open("1館.json").bufferedReader().use { it.readText() }
    val test = object : TypeToken<List<ART>>() {}.type
    val info = Gson().fromJson<List<ART>>(catch, test)

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 60.dp, start = 20.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        items(info) { item ->
            Column(
                modifier = Modifier.fillMaxWidth()
            ) { Text(item.title, fontSize = 30.sp, modifier = Modifier.padding(top = 4.dp), fontWeight = FontWeight.W100) }

            Divider(
                thickness = 1.dp,
                color = Color.LightGray
            )

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Start
            ) {
                Text(item.content, fontSize = 15.sp, color = Color.LightGray, modifier = Modifier.weight(3f))
                val imageBitmap = remember(item.image) {
                    val open = context.assets.open(item.image)
                    val bitmap = BitmapFactory.decodeStream(open)
                    bitmap.asImageBitmap()
                }
                Image(
                    modifier = Modifier.size(180.dp).padding(end = 10.dp),
                    bitmap = imageBitmap,
                    contentDescription = ""
                )
            }
        }
    }
}

@Composable
fun TwoART(navController: NavController) {
    val context = LocalContext.current
    val catch = context.assets.open("2館.json").bufferedReader().use { it.readText() }
    val test = object : TypeToken<List<ART>>() {}.type
    val info = Gson().fromJson<List<ART>>(catch, test)

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 60.dp, start = 20.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        items(info) { item ->
            Column(
                modifier = Modifier.fillMaxWidth()
            ) { Text(item.title, fontSize = 30.sp, modifier = Modifier.padding(top = 4.dp), fontWeight = FontWeight.W100) }

            Divider(
                thickness = 1.dp,
                color = Color.LightGray
            )

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Start
            ) {
                Text(item.content, fontSize = 15.sp, color = Color.LightGray, modifier = Modifier.weight(3f))
                val imageBitmap = remember(item.image) {
                    val open = context.assets.open(item.image)
                    val bitmap = BitmapFactory.decodeStream(open)
                    bitmap.asImageBitmap()
                }
                Image(
                    modifier = Modifier.size(180.dp).padding(end = 10.dp),
                    bitmap = imageBitmap,
                    contentDescription = ""
                )
            }
        }
    }
}

@Composable
fun TicketJson(){

}