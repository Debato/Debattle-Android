package com.debattle.home

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
fun HomeScreen(
    homeViewModel: HomeViewModel = hiltViewModel()
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 60.dp),
        horizontalAlignment = Alignment.CenterHorizontally

    ) {
        Text(text = "오늘의 주제", fontSize = 30.sp, fontWeight = FontWeight.Bold)
        Spacer(modifier = Modifier.height(40.dp))

    }
}