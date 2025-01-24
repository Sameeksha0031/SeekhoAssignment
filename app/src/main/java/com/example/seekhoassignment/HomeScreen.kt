package com.example.seekhoassignment

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavController
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.seekhoassignment.ui.theme.Blue100
import com.example.seekhoassignment.ui.theme.Blue800
import com.example.seekhoassignment.viewModel.AnimeViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

@Composable
fun HomeScreen(mainActivity: MainActivity, navigationStack : NavController, apiViewModel: AnimeViewModel) {
    val coroutineScope = rememberCoroutineScope()


    //val animeListResponse = apiViewModel.animeList.


    Box(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
    ) {
        Column {
            Box {
            }

            LazyColumn {
                items(10) {
                    CardViewForList(mainActivity)
                }
            }
        }
    }
}

@SuppressLint("CheckResult")
@Composable
fun CardViewForList(mainActivity: MainActivity) {
    Card(
        modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth()
            .background(Blue800),
        shape = RoundedCornerShape(12),
    ) {
        Column(
            modifier = Modifier
                .padding(8.dp)
        ) {
            Text(
                "Title", style = TextStyle(
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Bold,
                    color = Blue100,
                ), modifier = Modifier.padding(3.dp)
            )
            Text(
                "Number Of Episodes", style = TextStyle(
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Bold,
                    color = Blue100,
                ), modifier = Modifier.padding(3.dp)
            )
            Text(
                "Rating", style = TextStyle(
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Bold,
                    color = Blue100,
                ), modifier = Modifier.padding(3.dp)
            )
            Glide.with(mainActivity)
                .load("https://picsum.photos/200/300")
        }
    }
}

@Composable
fun TextWithStyle(stringToShow : String, isTitle : Boolean) {
    Text(
        text = stringToShow, style = TextStyle(
            fontSize = 14.sp,
            fontWeight = if(isTitle) FontWeight.Bold else FontWeight(300),
            color = Blue100,
        ), modifier = Modifier.padding(3.dp)
    )
}