package com.sansantek.stepsensor

import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.Service
import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.os.IBinder
import android.os.SystemClock
import android.util.Log
import androidx.core.app.NotificationCompat
import kotlin.concurrent.thread

private const val TAG = "MyService 싸피"
class MyService : Service() {
    var isRunning = true
    override fun onBind(intent: Intent): IBinder? {
        return null
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {

        Log.d(TAG, "onStartCommand: 서비스 시작")
        val manager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        val channel = NotificationChannel("sdfsdfwef","service", NotificationManager.IMPORTANCE_HIGH)
        channel.enableLights(true)
        channel.lightColor = Color.RED
        channel.enableVibration(true)
        manager.createNotificationChannel(channel)

        val builder = NotificationCompat.Builder(this, "sdfsdfwef")
        builder.setSmallIcon(android.R.drawable.ic_menu_search)
        builder.setContentTitle("서비스 가동")
        builder.setContentText("서비스가 가동중입니다.")
        val notification = builder.build()

        // 알림 메시지를 foreground 서비스를 위해 표시한다.
        // targetSdk 28 이상에서는 permission 등록 필요
        startForeground(10, notification) // 서비스 가동시 알림 뜨고, 서비스 종료시 자동으로 사라짐 (종료 전엔 못 없앰)

        // 스레드 운영 // 액티비티를 종료하더라도 서비스는 계속 가동 (별개로 동작)
        isRunning = true
        thread {
            while (isRunning) {
                SystemClock.sleep(500)
                val now = System.currentTimeMillis()
                Log.d("test", "Service : ${now}")
            }
        }

        return super.onStartCommand(intent, flags, startId)

    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "onDestroy: 서비스 종료")
        stopForeground(STOP_FOREGROUND_DETACH)
    }


}