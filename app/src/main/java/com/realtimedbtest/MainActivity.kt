package com.realtimedbtest

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.realtimedbtest.ui.theme.RealtimeDBTestTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent{
            RealtimeDBTestTheme{
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxWidth(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Text(text = "Hello Android!")
                }
                Buttonlist()
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Buttonlist() {
    val db: RealTimeDB = RealTimeDB()
    var text by remember { mutableStateOf("") } // textを定義
    Column(modifier = Modifier.fillMaxWidth()) {
        MyButton("Button1") { db::setLogModeToRef }
        TextField(
            value = text,
            onValueChange = { text = it },
            label = { Text("Enter text here") }
        )
        MyButton("Button2") { db.putData(text) }
        //MyButton("Button3") { db.putData("Hello") }
        //MyButton("Button4") { db.putData("He") }
    }
}

@Composable
fun MyButton(label: String, onclick: () -> Unit) {
    Button(
        onClick = onclick,
        modifier = Modifier.padding(8.dp)
    ) {
        Text(text = label)
    }
}