package br.com.guiacistore

import android.app.Application
import com.onesignal.OneSignal

class CustomAplication : Application() {

    override fun onCreate() {
        super.onCreate()
        // OneSignal Initialization
        OneSignal.startInit(this)
                .inFocusDisplaying(OneSignal.OSInFocusDisplayOption.Notification)
                .unsubscribeWhenNotificationsAreDisabled(true)
                .init()
    }
}