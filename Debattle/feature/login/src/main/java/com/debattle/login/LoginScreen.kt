package com.debattle.login

import android.app.Application
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.debattle.design.background
import com.debattle.design.kakao

@Composable
fun LoginScreen(
    viewModel: LoginViewModel = hiltViewModel()
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(background)
            .padding(top = 110.dp) // 110
    ) {
        Image(painter = painterResource(id = R.drawable.ic_logo), contentDescription = null, modifier = Modifier.fillMaxWidth(), alignment = Alignment.Center)
        Spacer(modifier = Modifier.height(60.dp))  // 60
        Text(text = "Welcome", fontSize = 34.sp, fontWeight = FontWeight.Bold, color = Color.Black, modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 50.dp), textAlign = TextAlign.Center)
        Spacer(modifier = Modifier.height(65.dp))  // 65
        Text(text = "Debattle은 매일 바뀌는 주제로 사용자분들이 토론을 할 수 있는 공간입니다. 의견을 표현하고 설득하여 랭킹에 이름을 올려보세요!", fontSize = 14.sp, fontWeight = FontWeight.Normal, color = Color.Black, modifier = Modifier.padding(horizontal = 32.dp), textAlign = TextAlign.Center)
        Spacer(modifier = Modifier.height(80.dp)) // 80
        kakaoButton(viewModel)
    }
}

@Composable
fun kakaoButton(
    viewModel: LoginViewModel
) {
    Button(onClick = { viewModel.loginWithKakao() }, shape = RoundedCornerShape(10.dp), modifier = Modifier
        .fillMaxWidth()
        .padding(horizontal = 32.dp), colors = ButtonDefaults.buttonColors(kakao)) {
        Row {
            Image(painter = painterResource(id = R.drawable.ic_kakao), contentDescription = null, modifier = Modifier.padding(end = 10.dp))
            Text(text = "카카오 로그인", color = Color.Black)
        }
    }
}

