package com.example.a53test.ui.theme

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.a53test.R

@Composable
fun PageTwo(title: String, dateTime: String, hall: List<String>, content: String) {
    Column {
        Icon(
            painter = painterResource(R.drawable.baseline_arrow_back_ios_new_24),
            contentDescription = "",
            tint = Color(0xFF10607E)
        )

        Text(
            title,
            modifier = Modifier.weight(2f),
            fontWeight = FontWeight.Bold,
            fontSize = 40.sp
        )

        Row(
            horizontalArrangement = Arrangement.Start
        ) {
            hall.forEach {
                Text(
                    it,
                    color = if (it == "1館") Color(0xFF10607E)
                    else Color(0xFF19AA9E),
                )
            }
            Text("發行內容：${dateTime}")
        }
        Text(
            content,
            fontSize = 40.sp,
            fontWeight = FontWeight.Bold
        )
    }
}