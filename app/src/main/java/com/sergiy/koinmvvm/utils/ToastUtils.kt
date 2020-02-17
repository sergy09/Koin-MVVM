package com.sergiy.koinmvvm.utils

import android.content.Context
import android.widget.Toast.LENGTH_SHORT
import android.widget.Toast.makeText

internal object ToastUtils {

    fun showToast(context: Context, text: String) = makeText(context, text, LENGTH_SHORT).show()

}