package com.example.a53test.ui.theme

import android.util.Log
import android.view.View
import androidx.activity.ComponentActivity
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.a53test.R

@Composable
fun PageTwo(navController: NavController, viewModel: AllViewModel) {
    val title = viewModel.title
    val hall = viewModel.hall
    val dateTime = viewModel.dateTime
    val content = viewModel.content

    Column(
        modifier = Modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.Center
    ) {
        Icon(
            painter = painterResource(R.drawable.baseline_arrow_back_ios_new_24),
            contentDescription = "",
            tint = Color(0xFF10607E),
            modifier = Modifier
                .clickable { navController.navigate(All.主畫面.name) }
                .padding(start = 20.dp, top = 50.dp)
        )
        SP(10)
        Column (
            modifier = Modifier.fillMaxWidth(),
            verticalArrangement = Arrangement.Center
        ){
            Text(
                title,
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp,
                modifier = Modifier.padding(start = 25.dp, end = 25.dp)
            )
            SP(10)
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Start
            ) {
                Spacer(modifier = Modifier.padding(start = 25.dp))
                hall.forEach {
                    Text(
                        it,
                        color = if (it == "1館") Color(0xFF10607E)
                        else Color(0xFF19AA9E),
                        modifier = Modifier.padding(end = 5.dp)
                    )
                }
                Spacer(modifier = Modifier.padding(start = 190.dp))
                Text(
                    "發行日期：${dateTime}",
                    textAlign = TextAlign.End ,
                    color = Color.Gray
                )
            }
            SP(20)
            Text(
                content,
                fontSize = 18.sp,
                color = Color.Gray,
                modifier = Modifier.padding(start = 25.dp, end = 25.dp)
            )
        }
    }
}

@Composable
fun SP(DP: Int) {
    Spacer(modifier = Modifier.padding(DP.dp))
}