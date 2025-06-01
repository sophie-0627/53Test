package com.example.a53test.ui.theme

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.a53test.R
import kotlinx.coroutines.handleCoroutineException

@Composable
fun Floor(navController: NavController){
    var first by remember { mutableStateOf(false) }

    Column {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 20.dp, top = 15.dp)
        ) {
            Button(
                border = BorderStroke(1.dp, Color.LightGray),
                colors = if (!first)
                    ButtonDefaults.buttonColors(
                        containerColor = Color(0xFF005E86),
                        contentColor = Color.White
                    ) else ButtonDefaults.buttonColors(
                    containerColor = Color.White,
                    contentColor = Color.Black
                ),
                shape = RoundedCornerShape(1),
                onClick = { first = false },
                modifier = Modifier
                    .clip(RoundedCornerShape(2))
                    .size(height = 43.dp, width = 100.dp)
            ) {
                Text(
                    "一館",
                    fontSize = 20.sp
                )
            }
            Spacer(modifier = Modifier.padding(15.dp))
            Button(
                border = BorderStroke(1.dp, Color.LightGray),
                colors = if (first)
                    ButtonDefaults.buttonColors(
                        containerColor = Color(0xFF005E86),
                        contentColor = Color.White
                    ) else ButtonDefaults.buttonColors(
                    containerColor = Color.White,
                    contentColor = Color.Black
                ),
                shape = RoundedCornerShape(1),
                onClick = { first = true },
                modifier = Modifier
                    .clip(RoundedCornerShape(2))
                    .size(height = 43.dp, width = 100.dp)
            ) {
                Text(
                    "二館",
                    fontSize = 20.sp
                )
            }
        }

        if(!first){
            Image(
                painter = painterResource(R.drawable.c),
                contentDescription = "",
                modifier = Modifier.size(height = 1000.dp, width = 900.dp)
            )
        } else {
            Image(
                painter = painterResource(R.drawable.g),
                contentDescription = "",
                modifier = Modifier.size(height = 1000.dp, width = 1000.dp)
            )
        }
    }
}