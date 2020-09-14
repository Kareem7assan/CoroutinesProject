package com.aait.coroutinesproject.application

import android.annotation.SuppressLint
import android.app.Application
import android.content.Context

import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class AppController : Application() {



    override fun onCreate() {
        super.onCreate()

    }


    @SuppressLint("CheckResult")
    override fun attachBaseContext(newBase: Context) {
        super.attachBaseContext(newBase)
       //  machineComponent = DaggerMachineComponent.create()
    }




}