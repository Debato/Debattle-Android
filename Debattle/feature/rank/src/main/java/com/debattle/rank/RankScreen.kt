package com.debattle.rank

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.debattle.design.blue
import com.debattle.design.red
import com.debattle.network.retrofit.model.Article

@Composable
fun RankScreen(
    modifier: Modifier = Modifier,
    homeViewModel: RankViewModel = hiltViewModel()
) {
    val uiState by homeViewModel.uiState.collectAsState()

    LaunchedEffect(Unit) {
        homeViewModel.getAllRank()
    }


    when(uiState) {
        is RankUiState.Error -> {}
        is RankUiState.Success -> {

            Column(
                modifier = modifier
                    .fillMaxSize()
                    .padding(horizontal = 30.dp)
            ) {
                Spacer(modifier = modifier.height(50.dp))
                Text(text = "오늘의 랭킹", fontWeight = FontWeight.Bold, fontSize = 20.sp)
                Spacer(modifier = modifier.height(8.dp))
                Divider(modifier = modifier.height(2.dp))
                Spacer(modifier = modifier.height(15.dp))

                RankList((uiState as RankUiState.Success).data)
            }
        }
        RankUiState.Loading -> CircularProgressIndicator()
    }
}

@Composable
fun RankList(articles: List<Article>, modifier: Modifier = Modifier) {
    LazyColumn(
        contentPadding = PaddingValues(vertical = 0.dp)
    ) {
        items(articles) { article ->
            Column(
                modifier = modifier
                    .fillMaxWidth()
                    .padding(5.dp)
                    .background(if (article.agreement) blue else red),

            ) {
                Text(text = article.title, fontSize = 15.sp, fontWeight = FontWeight.Bold)
                Spacer(modifier = modifier.height(10.dp))
                Text(text = "좋아요 : ${article.like}개", fontSize = 12.sp)
            }
        }
    }
}