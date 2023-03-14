package com.debattle.debattle

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.debattle.debattle.navigation.DebattleNavHost
import com.debattle.design.DebattleTheme
import com.debattle.login.LoginViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DebattleTheme {
                Surface(
                    modifier = Modifier.fillMaxSize()
                ) {
                    DebattleNavHost(rememberNavController())
                }
            }
        }
    }
}


