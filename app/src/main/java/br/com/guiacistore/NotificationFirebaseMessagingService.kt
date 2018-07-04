package br.com.guiacistore

import android.app.NotificationManager
import android.app.PendingIntent
import android.app.PendingIntent.getActivity
import android.content.Context
import android.content.Intent
import android.graphics.BitmapFactory
import android.graphics.Color
import android.media.RingtoneManager
import android.os.Bundle
import android.support.v4.app.NotificationCompat
import br.com.guiacistore.lojas.MainActivity
import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage



/**
 * Created by faro on 9/7/17.
 */

class NotificationFirebaseMessagingService :  FirebaseMessagingService() {


    override fun onMessageReceived(remoteMessage: RemoteMessage?) {


        if (remoteMessage != null) {
            sendNotifications(remoteMessage?.notification?.body, remoteMessage.data)
        }


    }


    private fun sendNotifications(mensagem: String?,dados:Map<String, String> ) {


        val intent = Intent(this, MainActivity::class.java)
        val bundle = Bundle()

        for (key in dados.keys) {
            val valor = dados[key].toString()
            bundle.putString(key, valor)

        }


        intent.putExtras(bundle)

        intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP
        val pendingIntent = getActivity(this, 0, intent, PendingIntent.FLAG_ONE_SHOT)
        val uriSound = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION)
        val notificationCompatBuilder = NotificationCompat.Builder(this)


        notificationCompatBuilder.setSmallIcon(R.mipmap.guiaci)
        notificationCompatBuilder.setContentTitle("ListaDeClientes")
        notificationCompatBuilder.setLargeIcon(BitmapFactory.decodeResource(resources, R.drawable.guiaci))

        notificationCompatBuilder.setContentText(mensagem)
        notificationCompatBuilder.setAutoCancel(true)
        notificationCompatBuilder.setContentIntent(pendingIntent)
        notificationCompatBuilder.setSound(uriSound)


        notificationCompatBuilder.priority = NotificationManager.IMPORTANCE_HIGH
        val notificationManager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        notificationCompatBuilder.setVibrate(longArrayOf(1000, 1000, 1000, 1000, 1000))
        notificationCompatBuilder.setLights(Color.RED, 3000, 3000)

        notificationManager.notify(0, notificationCompatBuilder.build())

    }
}
