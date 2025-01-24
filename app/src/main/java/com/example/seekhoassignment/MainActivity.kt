package com.example.seekhoassignment

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.seekhoassignment.ui.theme.SeekhoAssignmentTheme
import com.example.seekhoassignment.viewModel.AnimeViewModel

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            SeekhoAssignmentTheme {
                val apiViewModel = viewModel { AnimeViewModel() }
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    NavigationStack(apiViewModel,this@MainActivity)
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier, viewModel: AnimeViewModel) {
    Column {
        Text(
            text = "Hello $name!",
            modifier = modifier
        )
        Button(
            onClick = {
                viewModel.getList()
            }
        ) {
            Text("First Api")
        }
        Button(
            onClick = {
                viewModel.getAnimeDetail("17")
            }
        ) {
            Text("Second Api")
        }
    }
}

