package com.debattle.home

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Scaffold
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.debattle.network.retrofit.model.Article

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun HomeScreen(
    navigateToPost: () -> Unit,
    homeViewModel: HomeViewModel = hiltViewModel()
) {
    val uiState by homeViewModel.uiState.collectAsState()

    LaunchedEffect(Unit) {
        homeViewModel.getAllArticles()
    }

    when(uiState) {
        is HomeUiState.Error -> Column(modifier = Modifier.fillMaxSize(), verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally) {
            Text(text = (uiState as HomeUiState.Error).message)
        }
        HomeUiState.Loading -> Column(modifier = Modifier.fillMaxSize(), verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally) {
            CircularProgressIndicator()
        }
        is HomeUiState.Success -> {
            Scaffold(
                floatingActionButton = {
                    FloatingActionButton(onClick = { navigateToPost() }) {}
                }
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(horizontal = 20.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Spacer(modifier = Modifier.height(60.dp))
                    Text(text = "오늘의 주제", fontSize = 40.sp, fontWeight = FontWeight.Bold)
                    Spacer(modifier = Modifier.height(40.dp))
                    ArticleList(articles = (uiState as HomeUiState.Success).data)
                }
            }
        }
    }

}

@Composable
fun ArticleList(articles: List<Article>) {
    val clicked = remember { mutableStateListOf<Boolean>() }

    articles.forEach { _ -> clicked.add(false) }
    LazyColumn {
        itemsIndexed(articles) { index, article ->
            Row(verticalAlignment = Alignment.Bottom) {
                Column(
                    modifier = Modifier
                        .background(checkAgreement(article), shape = RoundedCornerShape(15.dp))
                        .width(350.dp)
                        .padding(horizontal = 10.dp, vertical = 10.dp)
                ) {
                    Text(
                        text = article.title,
                        fontSize = 15.sp,
                        color = Color.White,
                        fontWeight = FontWeight.Bold
                    )
                    Spacer(modifier = Modifier.height(5.dp))
                    Text(text = article.content, fontSize = 12.sp, color = Color.White)
                }
                Image(
                    painter = painterResource(
                        if (clicked[index]) R.drawable.star_full else R.drawable.star_less
                    ),
                    contentDescription = null,
                    modifier = Modifier.clickable {
                        clicked[index] = !clicked[index]
                    }
                )
            }
            Spacer(modifier = Modifier.height(10.dp))
        }
    }
}

fun checkAgreement(article: Article): Color {
    if (article.agreement) return Color.Blue
    return Color.Red
}
