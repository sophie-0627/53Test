package com.example.a53test.ui.theme

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldColors
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.focusModifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.modifier.modifierLocalMapOf
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@Composable
fun Us(navController: NavController) {
    var title by remember { mutableStateOf("") }
    var name by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var phone by remember { mutableStateOf("") }
    var Information by remember { mutableStateOf("") }
    var context = LocalContext.current
    var size = 15

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        SP(size)
        Text("標題", fontSize = 20.sp)
        TextField(
            value = title,
            onValueChange = { title = it },
            label = { Text("標題") },
            colors = TextFieldDefaults.colors(
                focusedContainerColor = Color.Transparent,
                unfocusedContainerColor = Color.Transparent
            ),

        )

        SP(size)
        Text("姓名", fontSize = 20.sp)
        TextField(
            value = name,
            onValueChange = { name = it },
            label = { Text("姓名") },
        )

        SP(size)
        Text("Email", fontSize = 20.sp)
        TextField(
            value = email,
            onValueChange = { email = it },
            label = { Text("Email") },
        )

        SP(size)
        Text("電話", fontSize = 20.sp)
        TextField(
            value = phone,
            onValueChange = { phone = it },
            label = { Text("電話") },
        )

        SP(size)
        Text("內容", fontSize = 20.sp)
        TextField(
            value = Information,
            onValueChange = { Information = it },
            label = { Text("內容") },
        )

        SP(30)
        Button(onClick = {
            title = ""
            name = ""
            email = ""
            phone = ""
            Information = ""
        },
            shape = RoundedCornerShape(3.dp),
            modifier = Modifier.size(height = 45.dp, width =250.dp ),
            colors = ButtonDefaults.buttonColors(Color(0xFF025872))
        ) {
            Text("重填")
        }

        SP(size)
        Button(onClick = {
            if(title.isNotEmpty()||name.isNotEmpty()||email.isNotEmpty()||phone.isNotEmpty()||Information.isNotEmpty()){
                if(title.length <= 30||name.length < 15||email.length < 30){
                    if(android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()){
                        if(android.util.Patterns.PHONE.matcher(phone).matches()){
                            Toast.makeText(context,"成功送出",Toast.LENGTH_SHORT).show()
                        }else {
                            Toast.makeText(context,"電話格式錯誤",Toast.LENGTH_SHORT).show()
                        }
                    } else {
                        Toast.makeText(context,"Email錯誤",Toast.LENGTH_SHORT).show()
                    }
                } else {
                    Toast.makeText(context,"字元超過錯誤",Toast.LENGTH_SHORT).show()
                }
            }
            else {
                Toast.makeText(context,"空格錯誤",Toast.LENGTH_SHORT).show()
            }
        },
            shape = RoundedCornerShape(3.dp),
            modifier = Modifier.size(height = 45.dp, width = 250.dp ),
            colors = ButtonDefaults.buttonColors(Color(0xFF025872))
        ) {
            Text("送出")
        }
    }
}