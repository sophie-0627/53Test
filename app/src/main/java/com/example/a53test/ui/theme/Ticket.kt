package com.example.a53test.ui.theme

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import com.example.a53test.R

@Composable
fun Ticket() {
    Scaffold(
        bottomBar = {
            IconButton(onClick = {

            }) {
                Icon(
                    painter = painterResource(R.drawable.baseline_add_24),
                    contentDescription = "",
                    tint = Color(0xFF707070)
                )
            }
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier.padding(innerPadding)
        ) {

        }
    }
}