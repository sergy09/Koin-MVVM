package com.sergiy.koinmvvm.app.common

import android.os.Handler
import android.view.View.GONE
import android.view.View.VISIBLE
import androidx.appcompat.app.AppCompatActivity
import com.sergiy.koinmvvm.app.common.BaseViewModel.Loader
import com.sergiy.koinmvvm.utils.Constants.ONE_SECOND
import com.sergiy.koinmvvm.utils.ToastUtils.showToast
import kotlinx.android.synthetic.main.activity_channels.*

abstract class BaseActivity : AppCompatActivity(), Loader {

    override fun setProgress(isLoading: Boolean) {
        if (isLoading) {
            progressBar?.visibility = VISIBLE
            Handler().postDelayed({
                progressBar?.visibility = GONE
            }, ONE_SECOND)
        }

    }

    fun showError(error: Throwable) = showToast(this, error.message ?: "ERROR")

}