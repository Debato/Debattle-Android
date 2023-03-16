package com.debattle.rank

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
fun RankScreen(
    modifier: Modifier = Modifier,
    viewModel: RankViewModel = hiltViewModel()
) {
    Column(
        modifier = modifier.fillMaxSize().background(Color.Red)
    ) {
        viewModel.getAllRank()
    }
}