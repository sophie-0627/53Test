package com.example.a53test.ui.theme

import android.graphics.BitmapFactory
import android.icu.text.CaseMap.Title
import android.media.Image
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.content.MediaType.Companion.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Divider
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.semantics.Role.Companion.Image
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.a53test.R
import com.google.gson.Gson
import kotlinx.coroutines.launch


data class First(
    val title: String,
    val content: String,
    val image: String
)

@Composable
fun ART(navController: NavController) {
    val list = listOf("1館","2館")
    var first = false

    list.forEach {
        Box (
            modifier = Modifier.fillMaxWidth()
        ){
            Box (
                modifier = Modifier.size(height = 30.dp, width = 20.dp)
                    .background(Color.Gray)
                    .clickable { first = true }
            ){
                Text(it, fontSize = 20.sp)
            }
        }
    }

    if(first){ First() }
}

@Composable
fun First(){
    val context = LocalContext.current
    val catch = context.assets.open("1館.json").bufferedReader() . use { it.readText() }
    val info = Gson().fromJson<List<First>>(catch,First::class.java)

    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) { items(info){ item ->
        Column(
            modifier = Modifier.fillMaxWidth()
        ) { Text(item.title, fontSize = 30.sp) }

        Divider(
            thickness = 1.dp,
            color = Color.LightGray
        )

        Row (
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Start
        ){
            Text(item.content, fontSize = 15.sp)

            val bitmap = BitmapFactory.decodeStream(context.assets.open(item.image))
            val imageBitmap = bitmap.asImageBitmap()
            Image(
                bitmap = imageBitmap,
                contentDescription = ""
            )
        }
    } }
}