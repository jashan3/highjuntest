package com.han.highjune.notification

import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.os.Build
import androidx.annotation.RequiresApi
import com.han.highjune.R

class NotificationHandler(private val ctx: Context) {

    private val notificationManager: NotificationManager by lazy {
        ctx.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
    }
    companion object{
        private const val CHANNEL_ID = "com.han.highjune.notification"
        private const val CHANNEL_NAME = "test용 noti"
        private const val CHANNEL_DESCRIBETION = "test용 noti DESCRIBETION"
        private const val NOTIFICATION_ID = 1001
    }


    @RequiresApi(Build.VERSION_CODES.O)
    fun createNotificationChannel() {
        val importance = NotificationManager.IMPORTANCE_HIGH
        val channel = NotificationChannel(CHANNEL_ID, CHANNEL_NAME, importance)

        channel.description = CHANNEL_DESCRIBETION
        channel.enableLights(true)
        channel.lightColor = Color.RED
        channel.enableVibration(true)
        channel.vibrationPattern = longArrayOf(100, 200, 300, 400, 500, 400, 300, 200, 400)
        notificationManager.createNotificationChannel(channel)
    }

    @RequiresApi(Build.VERSION_CODES.O)
    fun showNotification(title:String, body: String, pIntent: PendingIntent) {
        val notification = Notification.Builder(ctx, CHANNEL_ID)
            .setContentTitle(title)
            .setContentText(body)
            .setSmallIcon(R.drawable.ic_notification)
            .setChannelId(CHANNEL_ID)
            .setContentIntent(pIntent)
            .build()

        notification.flags = Notification.FLAG_NO_CLEAR

        notificationManager.notify(NOTIFICATION_ID, notification)
    }
}