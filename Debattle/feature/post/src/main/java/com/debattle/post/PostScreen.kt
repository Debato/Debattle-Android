package com.debattle.post

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.debattle.design.PurpleGrey80
import com.debattle.design.background
import com.debattle.design.blue
import com.debattle.design.red

@Composable
fun PostScreen(
    modifier: Modifier = Modifier,
    viewModel: PostViewModel = hiltViewModel()
) {
    var isAgreed by remember { mutableStateOf<Boolean?>(null) }
    var title by remember { mutableStateOf("") }
    var content by remember { mutableStateOf("") }

    Column(
        modifier = modifier.padding(horizontal = 30.dp)
    ) {
        Spacer(modifier = modifier.height(20.dp))
        BasicTextField(
            value = title,
            onValueChange = {
                if (title.length < 20)
                    title = it
            },
            modifier = modifier
                .fillMaxWidth()
                .background(background)
                .padding(all = 20.dp)
        )
        Row(modifier = modifier.padding(vertical = 15.dp)) {
            Button(
                onClick = { isAgreed = true },
                modifier = modifier.weight(1f),
                colors = ButtonDefaults.buttonColors(
                    containerColor = when (isAgreed) {
                        true -> blue
                        false, null -> PurpleGrey80
                    }
                )
            ) {
                Text(text = stringResource(R.string.agree))
            }
            Spacer(modifier = modifier.width(10.dp))
            Button(
                onClick = { isAgreed = false },
                modifier = modifier.weight(1f),
                colors = ButtonDefaults.buttonColors(
                    containerColor = when (isAgreed) {
                        false -> red
                        true, null -> PurpleGrey80
                    }
                )
            ) {
                Text(text = stringResource(R.string.disagree))
            }
        }
        BasicTextField(
            value = content,
            onValueChange = {
                if (content.length < 256)
                    content = it
            },
            modifier = modifier
                .fillMaxWidth()
                .background(background)
                .padding(vertical = 180.dp, horizontal = 20.dp)
        )
        Spacer(modifier = modifier.weight(1f))
        Button(
            onClick = {
                if (title.isNotEmpty() && content.isNotEmpty() && isAgreed != null)
                    viewModel.postArticle(title, content, isAgreed!!)
                else
                    Log.d("check", "빈 칸이 있습니다")
            },
            modifier = modifier.fillMaxWidth()
        ) {
            Text(text = stringResource(R.string.post))
        }
        Spacer(modifier = modifier.weight(1f))
    }
}