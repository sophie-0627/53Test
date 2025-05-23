package com.example.a53test.ui.theme

import android.util.Log
import android.util.SparseArray
import android.view.animation.AlphaAnimation
import androidx.annotation.ColorRes
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.Divider
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.google.gson.reflect.TypeToken
import com.google.gson.Gson

data class One(
    var title: String?,
    var dateTime: String?,
    var hall: List<String>,
    var content: String?
)

@Composable
fun JsonOne(navController: NavController) {
    val context = LocalContext.current
    val json = context.assets.open("test2.json").bufferedReader().use { it.readText() }
    val test = object : TypeToken<List<One>>() {}.type
    val gson = Gson().fromJson<List<One>>(json, test)
    val size = 14
    var hallColor = Color(0xFF739EA5)

    LazyColumn (
        modifier = Modifier.fillMaxWidth()
    ){
        items(gson.reversed()) { item ->
            Row(
                modifier = Modifier.fillMaxSize(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally
                ){
                    Text(
                        item.dateTime.toString().replace('.', '/'),
                        fontSize = size.sp,
                        modifier = Modifier.padding(start = 17.dp),
                        color = Color.Gray
                    )
                    Row {
                        item.hall.forEach {
                            if (it != "1館") hallColor = Color(0xFF739EA5) else hallColor = Color(0xFF1D5361)
                            Text(it, fontSize = size.sp, color = hallColor, modifier = Modifier.padding(start = 10.dp))
                        }
                    }
                }
                Text(item.title ?: "",
                    fontSize = size.sp,
                    modifier = Modifier.padding(start = 10.dp)
                        .clickable { navController.navigate(item) },
                    fontWeight = FontWeight.Bold)
            }
            Divider(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(4.dp),
                thickness = 1.dp,
                color = Color.LightGray
            )
        }
    }
}