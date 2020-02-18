package com.sergiy.koinmvvm.app.common

import android.content.Intent
import android.os.Bundle
import androidx.annotation.IdRes
import androidx.fragment.app.Fragment

abstract class BaseNavigator {

    protected fun BaseActivity.goToActivity(intent: Intent) {
        startActivity(intent)
        //overridePendingTransition(R.anim.slide_from_right, R.anim.slide_to_left)
    }

    //  protected fun BaseActivity.goToActivity(intent: Intent, bundle: Bundle) {
    //      startActivity(intent, bundle)
    //      overridePendingTransition(android.R.animator.fade_in, android.R.animator.fade_out)
    //  }

    //  protected fun BaseActivity.goToFragment(fragment: Fragment, @IdRes frameLayoutContainer: Int) {
    //      val fragmentManager = supportFragmentManager
    //      val fragmentTransaction = fragmentManager.beginTransaction()
    //      fragmentTransaction.setCustomAnimations(android.R.animator.fade_in, android.R.animator.fade_out)
    //      fragmentTransaction.replace(frameLayoutContainer, fragment)
    //      fragmentTransaction.commit()
    //  }

}
