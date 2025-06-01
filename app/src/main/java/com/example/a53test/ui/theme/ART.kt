package com.example.a53test.ui.theme

import android.graphics.BitmapFactory
import android.icu.text.CaseMap.Title
import android.media.Image
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.content.MediaType.Companion.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
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
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.semantics.Role.Companion.Image
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.a53test.R
import com.google.gson.Gson
import kotlinx.coroutines.launch

@Composable
fun ART(navController: NavController) {
    var first by remember { mutableStateOf(false) }

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
    when (first) {
        true -> TwoART(navController)
        false -> FirstART(navController)
    }
}