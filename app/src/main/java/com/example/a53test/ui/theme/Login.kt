package com.example.a53test.ui.theme

import android.annotation.SuppressLint
import android.provider.ContactsContract.CommonDataKinds.Email
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.contentColorFor
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.os.unregisterForAllProfilingResults
import androidx.navigation.NavController
import androidx.room.Database
import com.example.a53test.R
import kotlinx.coroutines.launch

@SuppressLint("RememberReturnType")
@Composable
fun Login(navController: NavController,db:UserData) {
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    val context = LocalContext.current
    val coroutine = rememberCoroutineScope()

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Sp(10)

        Image(
            modifier = Modifier.padding(50.dp),
            painter = painterResource(id = R.drawable.p),
            contentDescription = ""
        )

        Sp(50)

        Text(
            "登 入",
            fontSize = 30.sp,
            color = Color(0xFF025872)
        )

        Sp(40)

        TextField(
            value = email,
            onValueChange = { email = it },
            label = { Text(" 輸入E-mail") },
            leadingIcon = {
                Image(
                    modifier = Modifier.padding(10.dp),
                    painter = painterResource(id = R.drawable.m),
                    contentDescription = "",
                )
            },
            colors = TextFieldDefaults.colors(
                unfocusedContainerColor = Color.Transparent,
                focusedContainerColor = Color.Transparent
            ),
            modifier = Modifier.padding(30.dp)
        )

        TextField(
            value = password,
            onValueChange = { password = it },
            label = { Text(" 輸入密碼") },
            leadingIcon = {
                Image(
                    modifier = Modifier.padding(10.dp),
                    painter = painterResource(id = R.drawable.a),
                    contentDescription = "",
                )
            },
            colors = TextFieldDefaults.colors(
                unfocusedContainerColor = Color.Transparent,
                focusedContainerColor = Color.Transparent
            ),
            modifier = Modifier.padding(30.dp)
        )

        Sp(20)

        Button(
            shape = RoundedCornerShape(10),
            onClick = {
                if(email.isEmpty() || password.isEmpty() || password.length <= 6||email.length > 30){
                    Toast.makeText(context,"error1",Toast.LENGTH_SHORT).show()
                }
                else if (!android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()){
                    Toast.makeText(context,"error2",Toast.LENGTH_SHORT).show()
                }
                else{
                    coroutine.launch {
                        val check = db.dao().Check(email,password)
                        if(check != null){
                            navController.navigate(All.延遲.name)
                        } else {
                            Toast.makeText(context,"帳號密碼錯誤",Toast.LENGTH_SHORT).show()
                        }
                    }
                }
            },
            modifier = Modifier.size(height = 50.dp, width = 300.dp),
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF025872))
        ) { Text("登 入") }

        Sp(130)

        Row {
            Text("沒有任何帳號嗎?")
            Sp(10)
            Text("註冊帳號",
                color = Color(0xFF025872),
                modifier = Modifier.clickable { navController.navigate(All.註冊.name) }
            )
        }
    }
}

@Composable
fun Sp(hp: Int) {
    Spacer(modifier = Modifier.size(hp.dp))
}