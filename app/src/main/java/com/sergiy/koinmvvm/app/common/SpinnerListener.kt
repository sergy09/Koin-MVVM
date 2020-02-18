package com.sergiy.koinmvvm.app.common

import android.view.View
import android.widget.AdapterView
import android.widget.AdapterView.OnItemSelectedListener

class SpinnerListener(
    private val onItemSelected: (posistion: Int) -> Unit
) : OnItemSelectedListener {

    override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) =
        onItemSelected(p2)

    override fun onNothingSelected(p0: AdapterView<*>?) {}

}
