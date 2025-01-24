package com.example.seekhoassignment

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.bumptech.glide.Glide
import com.example.seekhoassignment.model.Data
import com.example.seekhoassignment.ui.theme.Blue100
import com.example.seekhoassignment.ui.theme.Blue800
import com.example.seekhoassignment.viewModel.AnimeViewModel

@Composable
fun HomeScreen(
    mainActivity: MainActivity,
    navigationStack: NavController,
    apiViewModel: AnimeViewModel
) {
    val animeListResponse by apiViewModel.animeList.collectAsState()

    Box(
        modifier = Modifier
            .fillMaxSize()
            .statusBarsPadding()
            .navigationBarsPadding()
            .background(Blue100)
    )
    {
        Column(
            modifier = Modifier,
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.Start
        ) {
            Heading("Home Screen")
            when (animeListResponse) {
                is APIResult.Failure -> {
                    Box {
                        Text("No data found")
                    }
                }

                is APIResult.Loading -> {
                    CircularProgressIndicator(
                        modifier = Modifier
                            .padding(1.dp)
                            .width(20.dp)
                            .height(20.dp),
                        color = Color(0xFF888888),
                        strokeWidth = 3.dp
                    )
                }

                is APIResult.Success -> {
                    val listOfTopAnime = (animeListResponse as APIResult.Success).response.data
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .fillMaxHeight()
                    ) {
                        Column {
                            LazyColumn {
                                items(listOfTopAnime.size) { index ->
                                    CardViewForList(mainActivity, listOfTopAnime[index])
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}

@SuppressLint("CheckResult")
@Composable
fun CardViewForList(mainActivity: MainActivity, listOfTopAnime: Data) {
    Card(
        modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth(),
        shape = RoundedCornerShape(12),
        colors = CardColors(
            containerColor = Blue800,
            contentColor = Blue800,
            disabledContentColor = Blue100,
            disabledContainerColor = Blue100
        )
    ) {
        Column(
            modifier = Modifier
                .padding(8.dp)
        ) {
            Text(
                text = listOfTopAnime.title, style = TextStyle(
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Bold,
                    color = Blue100,
                ), modifier = Modifier.padding(3.dp)
            )
            Text(
                "Number Of Episodes: ${listOfTopAnime.episodes}", style = TextStyle(
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Bold,
                    color = Blue100,
                ), modifier = Modifier.padding(3.dp)
            )
            Text(
                "Rating: ${listOfTopAnime.rating}", style = TextStyle(
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Bold,
                    color = Blue100,
                ), modifier = Modifier.padding(3.dp)
            )
            Glide.with(mainActivity)
                .load(listOfTopAnime.url)
        }
    }
}

@Composable
fun TextWithStyle(stringToShow: String, isTitle: Boolean) {
    Text(
        text = stringToShow, style = TextStyle(
            fontSize = 14.sp,
            fontWeight = if (isTitle) FontWeight.Bold else FontWeight(300),
            color = Blue100,
        ), modifier = Modifier.padding(3.dp)
    )
}

@Composable
fun Heading(stringToShow: String) {
    Text(
        text = stringToShow,
        style = TextStyle(
            fontSize = 20.sp,
            fontWeight = FontWeight(700),
            color = Blue100,
        ),
        modifier = Modifier
            .height(60.dp)
            .padding()
            .fillMaxWidth()
            .background(Blue800)
            .padding(top = 20.dp, start = 10.dp),
    )
}