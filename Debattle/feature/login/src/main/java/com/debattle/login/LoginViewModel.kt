package com.debattle.login

import android.app.Application
import android.content.Context
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.debattle.domain.SignUpUseCase
import com.kakao.sdk.auth.model.OAuthToken
import com.kakao.sdk.common.model.ClientError
import com.kakao.sdk.common.model.ClientErrorCause
import com.kakao.sdk.user.UserApiClient
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject
import kotlin.math.sign

@HiltViewModel
class LoginViewModel @Inject constructor(
    application: Application,
    val signUpUseCase: SignUpUseCase
) : AndroidViewModel(application) {

    val context = application.applicationContext

    companion object {
        const val TAG = "kakao"
    }

    fun loginWithKakao() {
        val callback: (OAuthToken?, Throwable?) -> Unit = { token, error ->
            if (error != null) {
                Log.e(TAG, "카카오계정으로 로그인 실패", error)
            } else if (token != null) {
                Log.i(TAG, "카카오계정으로 로그인 성공 ${token.accessToken}")
                signUp(token.accessToken)
            }
        }
        UserApiClient.instance.loginWithKakaoAccount(context, callback = callback)
    }

    private fun signUp(token: String) {
        viewModelScope.launch {
            signUpUseCase(token)
        }
    }

}