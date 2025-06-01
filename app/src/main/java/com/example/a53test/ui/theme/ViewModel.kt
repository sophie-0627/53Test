package com.example.a53test.ui.theme

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class AllViewModel:ViewModel(){
    var title by mutableStateOf("")
    var dateTime by mutableStateOf("")
    var hall by mutableStateOf<List<String>>(emptyList())
    var content by mutableStateOf("")
}