package com.lantosgyuri.mvrxpractice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.airbnb.mvrx.BaseMvRxActivity

class MainActivity : BaseMvRxActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if(savedInstanceState == null){
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, HelloWorldFragment())
                .replace(R.id.container2, HelloWorldFragment())
                .commit()
        }

        }
    }

