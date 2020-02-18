package com.sergiy.koinmvvm.data_source.api

import android.content.Context
import com.sergiy.koinmvvm.BuildConfig.DEBUG
import okhttp3.Interceptor
import okhttp3.MediaType
import okhttp3.Protocol.HTTP_2
import okhttp3.Response
import okhttp3.ResponseBody.create
import okio.BufferedSource
import okio.Okio
import java.io.IOException
import java.io.InputStream
import java.nio.charset.Charset


class MockInterceptor(private val context: Context) : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        if (DEBUG) {
            val uri = chain.request().url().uri().toString()
            val responseString = when {
                uri.endsWith("channels") -> "GetChannelList.json".readFileFromAssets(context)
                else -> ""
            }

            return chain.proceed(chain.request())
                .newBuilder()
                .code(202)
                .protocol(HTTP_2)
                .message(responseString)
                .body(
                    create(
                        MediaType.parse("application/json"),
                        responseString.toByteArray()
                    )
                )
                .addHeader("content-type", "application/json")
                .build()
        } else {
            //just to be on safe side.
            throw IllegalAccessError(
                "MockInterceptor is only meant for Testing Purposes and " +
                        "bound to be used only with DEBUG mode"
            )
        }
    }

    private fun String.readFileFromAssets(context: Context): String {
        try {
            val input: InputStream = context.assets.open(this)
            val source: BufferedSource = Okio.buffer(Okio.source(input))
            return source.readByteString().string(Charset.forName("utf-8"))
        } catch (e: IOException) {
            e.printStackTrace()
        }
        return ""
    }

}
