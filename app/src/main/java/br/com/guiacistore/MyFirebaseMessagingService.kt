package br.com.guiacistore

import android.util.Log
import com.google.firebase.iid.FirebaseInstanceId
import com.google.firebase.iid.FirebaseInstanceIdService

/**
 * Created by faro on 9/7/17.
 */

class MyFirebaseMessagingService :  FirebaseInstanceIdService() {

    val token = "token"

    override fun onTokenRefresh() {

        val recenttoken = FirebaseInstanceId.getInstance().token
        Log.d("token",recenttoken)
    }


}
