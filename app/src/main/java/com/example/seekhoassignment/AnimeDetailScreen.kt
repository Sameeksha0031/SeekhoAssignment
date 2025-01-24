package com.example.seekhoassignment

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.seekhoassignment.ui.theme.Blue100
import com.example.seekhoassignment.viewModel.AnimeViewModel

@Composable
fun AnimeDetailScreen(
    mainActivity: MainActivity,
    navigationStack: NavHostController,
    apiViewModel: AnimeViewModel
) {
    Box {
        Column {
            Card(modifier = Modifier.size(250.dp, 250.dp)) {}
            Text(
                "Title", style = TextStyle(
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Bold,
                    color = Blue100,
                ), modifier = Modifier.padding(3.dp)
            )
            Text(
                "Title", style = TextStyle(
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Bold,
                    color = Blue100,
                ), modifier = Modifier.padding(3.dp)
            )
            Text(
                "Title", style = TextStyle(
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Bold,
                    color = Blue100,
                ), modifier = Modifier.padding(3.dp)
            )
            Text(
                "Title", style = TextStyle(
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Bold,
                    color = Blue100,
                ), modifier = Modifier.padding(3.dp)
            )
        }
    }
}