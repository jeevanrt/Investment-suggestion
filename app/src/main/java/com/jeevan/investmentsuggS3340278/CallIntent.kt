package com.jeevan.investmentsuggS3340278

import android.app.Activity
import android.content.Intent

object CallIntent {

    fun callSignIn(context: Activity, closeMe: Boolean) {
        context.startActivity(Intent(context, SignInActivity::class.java))
        if (closeMe)
            context.finish()
    }
}