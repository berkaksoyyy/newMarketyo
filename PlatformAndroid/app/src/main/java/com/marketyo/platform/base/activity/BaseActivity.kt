package com.marketyo.platform.base.activity


import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.marketyo.platform.R
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class BaseActivity :
    AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)


    }

}
