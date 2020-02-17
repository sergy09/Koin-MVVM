package com.sergiy.koinmvvm.app.main

import android.os.Bundle
import com.sergiy.koinmvvm.R
import com.sergiy.koinmvvm.app.common.BaseActivity
import com.sergiy.koinmvvm.app.main.MainNavigator.Screens.CHANNEL_LIST
import kotlinx.android.synthetic.main.activity_main.*
import org.koin.android.scope.currentScope

class MainActivity : BaseActivity() {

    private val navigator: MainNavigator by currentScope.inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        bLaunchTest?.setOnClickListener {
            navigator.navigateTo(this, CHANNEL_LIST)
        }

    }
}
