package com.sergiy.koinmvvm.app.common

import androidx.appcompat.app.AppCompatActivity
import com.sergiy.koinmvvm.utils.ToastUtils.showToast

abstract class BaseActivity : AppCompatActivity() {

    fun showError(error: Throwable) = showToast(this, error.message ?: "ERROR")

}