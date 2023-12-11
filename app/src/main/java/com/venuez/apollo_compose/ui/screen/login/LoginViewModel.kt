package com.venuez.apollo_compose.ui.screen.login

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor():ViewModel() {

    val eLoadOrUserId = MutableStateFlow("")
    val pswd = MutableStateFlow("")


    fun onELoadOrUserIdChange(value:String) {
        eLoadOrUserId.value = value
    }


    fun onPasswordChange(value:String) {
        pswd.value = value
    }

}