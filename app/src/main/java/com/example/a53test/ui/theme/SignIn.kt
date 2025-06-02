package com.example.a53test.ui.theme

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
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
import androidx.navigation.NavController
import com.example.a53test.R
import kotlinx.coroutines.launch

@Composable
fun SignIn(navController: NavController,db:UserData) {
    val context = LocalContext.current
    val coroutine  = rememberCoroutineScope()

    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var checkPasswd by remember { mutableStateOf("") }
    val chickPasswd = Regex("^[a-zA-Z0-9]+$")

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        SP(10)
        Image(
            modifier = Modifier.padding(50.dp),
            painter = painterResource(id = R.drawable.p),
            contentDescription = ""
        )
        SP(5)
        Text("註 冊", fontSize = 30.sp,color = Color(0xFF1AAB9E))
        SP(40)
        TextField(
            value = email,
            onValueChange = { email = it },
            label = { Text(" 輸入E-mail") },
            leadingIcon = {
                Image(
                    modifier = Modifier.padding(10.dp),
                    painter = painterResource(id = R.drawable.hg),
                    contentDescription = "",
                )
            },
            colors = TextFieldDefaults.colors(
                unfocusedContainerColor = Color.Transparent,
                focusedContainerColor = Color.Transparent
            ),
            modifier = Modifier.padding(7.dp)
        )
        TextField(
            value = password,
            onValueChange = { password = it },
            label = { Text(" 輸入密碼") },
            leadingIcon = {
                Image(
                    modifier = Modifier.padding(10.dp),
                    painter = painterResource(id = R.drawable.b),
                    contentDescription = "",
                )
            },
            colors = TextFieldDefaults.colors(
                unfocusedContainerColor = Color.Transparent,
                focusedContainerColor = Color.Transparent
            ),
            modifier = Modifier.padding(7.dp)
        )
        TextField(
            value = checkPasswd,
            onValueChange = { checkPasswd = it },
            label = { Text(" 請再次輸入密碼") },
            leadingIcon = {
                Image(
                    modifier = Modifier.padding(10.dp),
                    painter = painterResource(id = R.drawable.b),
                    contentDescription = "",
                )
            },
            colors = TextFieldDefaults.colors(
                unfocusedContainerColor = Color.Transparent,
                focusedContainerColor = Color.Transparent
            ),
            modifier = Modifier.padding(20.dp)
        )
        SP(20)
        Button(
            shape = RoundedCornerShape(10),
            onClick = {
                if(android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()&&password == checkPasswd ){
                    if(chickPasswd.matches(password)){
                        coroutine.launch {
                            val user = UserClass(0,email,password)
                            val check = db.dao().Check(email,password)
                            if(check != null) {
                                Toast.makeText(context,"已有帳號",Toast.LENGTH_SHORT).show()
                            } else {
                                db.dao().Insert(user)
                                navController.navigate(All.登入.name)
                            }
                        }
                    } else {
                        Toast.makeText(context,"密碼不符合要求",Toast.LENGTH_SHORT).show()
                    }
                } else if (password.length <= 6){
                    Toast.makeText(context,"密碼長度太短",Toast.LENGTH_SHORT).show()
                } else{
                    Toast.makeText(context,"error",Toast.LENGTH_SHORT).show()
                }},
            modifier = Modifier.size(height = 50.dp, width = 300.dp),
            colors = ButtonDefaults.buttonColors(Color(0xFF1AAB9E))
        ) {
            Text("註 冊")
        }
        SP(45)
        Row {
            Text("已有帳號了!")
            SP(10)
            Text("登入",
                color = Color(0xFF1AAB9E),
                modifier = Modifier.clickable { navController.navigate(All.登入.name) }
            )
        }
    }
}