package com.sansantek.stepsensor

import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.Service
import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import android.os.IBinder
import android.util.Log
import android.widget.Toast
import androidx.core.app.NotificationCompat
import androidx.localbroadcastmanager.content.LocalBroadcastManager
import com.sansantek.stepsensor.date.DateInfo
import com.sansantek.stepsensor.dto.StepCount
import com.sansantek.stepsensor.repository.StepCounterRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.time.LocalDate

private const val TAG = "MyService 싸피"

class MyService : Service(), SensorEventListener {
    var isRunning = true

    private var stepCountSensor: Sensor? = null
    private val TYPE = Sensor.TYPE_STEP_DETECTOR //보행 계수기
    private lateinit var sensorManager: SensorManager

    private val repository by lazy {
        StepCounterRepository.get()
    }

    fun getCurrentDateInfo(): DateInfo {
        val currentDate = LocalDate.now()
        val year = currentDate.year
        val month = currentDate.monthValue
        val day = currentDate.dayOfMonth
        return DateInfo(year, month, day)
    }

    override fun onBind(intent: Intent): IBinder? {
        return null
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        sensorManager = getSystemService(Context.SENSOR_SERVICE) as SensorManager
        stepCountSensor = sensorManager.getDefaultSensor(TYPE)
        sensorManager.registerListener(this, stepCountSensor, SensorManager.SENSOR_DELAY_NORMAL)
        if (stepCountSensor == null) {
            Toast.makeText(this, "No Step Detect Sensor!!", Toast.LENGTH_SHORT).show()
        }
        Log.d(TAG, "onStartCommand: 서비스 시작")
        val manager = getSystemService(NotificationManager::class.java) as NotificationManager

        val channel =
            NotificationChannel("sdfsdfwef", "FOREGROUND", NotificationManager.IMPORTANCE_HIGH)
        channel.enableLights(true)
        channel.lightColor = Color.RED
        channel.enableVibration(true)
        manager.createNotificationChannel(channel)

        val builder = NotificationCompat.Builder(this, "sdfsdfwef")
        builder.setSmallIcon(android.R.drawable.ic_menu_search)
        builder.setContentTitle("서비스 가동")
        builder.setContentText("서비스가 가동중입니다.")

        // 알림 메시지를 foreground 서비스를 위해 표시한다.
        // targetSdk 28 이상에서는 permission 등록 필요
        startForeground(1111123, builder.build()) // 서비스 가동시 알림 뜨고, 서비스 종료시 자동으로 사라짐 (종료 전엔 못 없앰)
        Log.d(TAG, "onStartCommand: 서비스 실행")

        return START_NOT_STICKY

    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "onDestroy: 서비스 종료")
        sensorManager.unregisterListener(this)
        stopForeground(STOP_FOREGROUND_DETACH)
    }

    override fun onSensorChanged(p0: SensorEvent?) {
        Log.d(TAG, "onSensorChanged: asdsdfsdf")
        if (p0?.sensor?.type == TYPE) {
            Log.d(TAG, "onSensorChanged: ${p0.values[0]}")
            val today = getCurrentDateInfo()
            var step = StepCount()
            CoroutineScope(Dispatchers.IO).launch {
                val result = repository.getStepCount(today.year, today.month, today.day)
                if (result != null) {
                    Log.d(TAG, "onSensorChanged: result")
                    step = result
                }
                Log.d(TAG, "onSensorChanged: stepcount 확인 $step")
                if (step.stepCount == -1) {
                    val date = getCurrentDateInfo()
                    step.year = date.year
                    step.month = date.month
                    step.day = date.day

                    step.stepCount = 1
                    Log.d(TAG, "onSensorChanged: insert")
                    CoroutineScope(Dispatchers.IO).launch {
                        repository.insertStepCount(step)
                    }
                } else {
                    step.stepCount += 1
                    Log.d(TAG, "onSensorChanged: update")
                    CoroutineScope(Dispatchers.IO).launch {
                        repository.updateStepCount(step)
                    }
                }


                Log.d(TAG, "onSensorChanged: ${step.stepCount}")
                val intent = Intent().apply {
                    setAction("step")
                    putExtra("value", step.stepCount)
                }
                Log.d(TAG, "onSensorChanged: $intent")
                LocalBroadcastManager.getInstance(this@MyService).sendBroadcast(intent)
            }

        }

    }

    override fun onAccuracyChanged(p0: Sensor?, p1: Int) {
    }


}