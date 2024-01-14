package com.startandroid.myapplication

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.key
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.startandroid.myapplication.MainActivity.Companion.TAG
import com.startandroid.myapplication.ui.theme.ComposeAppTheme

class MainActivity : ComponentActivity() {

    companion object {
        const val TAG = "MainActivity"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    //Greeting("Android")
                    HomeScreen()
                }
            }
        }
    }
}
/*

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ComposeAppTheme {
        Greeting("Android")
    }
}*/

@Composable
fun SomeItem(text: String) {
    Log.d(TAG, "SomeItem $text")
    Text(
        text = text,
        fontSize = 20.sp,
        modifier = Modifier
            .fillMaxWidth()
            .border(width = 1.dp, color = Color.Black)
            .padding(16.dp)
    )
}

/*
@Composable
fun HomeScreen() {
    Log.d(TAG, "HomeScreen")
    val list = remember {
        mutableStateListOf("item_1", "item_2", "item_3")
    }
    Column(
        modifier = Modifier.verticalScroll(rememberScrollState())
    ) {
        TextButton(onClick = {
            Log.d(TAG, "--append--")
            list.add(0, "item_${list.size + 1}")
        }) {
            Text(text = "Insert")
        }
        list.forEach{
            key(it) {
                SomeItem(text = it)
            }
        }
    }
}*/


@Composable
fun HomeScreen() {
    Log.d(TAG, "HomeScreen")
    val list = remember {
        List<String>(20) {
            "item_$it"
        }.toMutableList()
    }
    
    LazyColumn(
        verticalArrangement = Arrangement.spacedBy(4.dp),
        modifier = Modifier
            .border(width = 2.dp, color = Color.Green),
        contentPadding = PaddingValues(16.dp)
    ) {
        items(list) {
            SomeItem(text = it)
        }
    }
}