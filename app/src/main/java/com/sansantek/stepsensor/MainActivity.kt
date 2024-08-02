package com.sansantek.stepsensor

import android.Manifest
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.content.pm.PackageManager
import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.lifecycle.lifecycleScope
import androidx.localbroadcastmanager.content.LocalBroadcastManager
import com.sansantek.stepsensor.date.DateInfo
import com.sansantek.stepsensor.dto.StepCount
import com.sansantek.stepsensor.repository.StepCounterRepository
import kotlinx.coroutines.launch
import java.time.LocalDate
import kotlin.math.log

private const val TAG = "MainActivity 싸피"
class MainActivity : AppCompatActivity() {
    private val tvStepCount: TextView by lazy {
        findViewById(R.id.tvStepCount)
    }
    private val repository by lazy {
        StepCounterRepository.get()
    }

    private val mMessageReceiver = object : BroadcastReceiver() {
        override fun onReceive(p0: Context, intent: Intent) {
            // Get extra data included in the Intent
            Log.d(TAG, "onReceive: $intent")
            val message = intent.getIntExtra("value", -1)
            Log.d(TAG, "Got message: " + message)
            tvStepCount.text = "Step Count Sensor : " + message.toString()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
//        repository.getStepCount()

        LocalBroadcastManager.getInstance(this).registerReceiver(
            mMessageReceiver, IntentFilter("step")
        )

//        tvStepCount = findViewById(R.id.tvStepCount)
        if(ContextCompat.checkSelfPermission(this,
                Manifest.permission.ACTIVITY_RECOGNITION) == PackageManager.PERMISSION_DENIED){
            Toast.makeText(this, "No Permission!!", Toast.LENGTH_SHORT).show()
            //ask for permission
            requestPermissionLauncher.launch(arrayOf(Manifest.permission.ACTIVITY_RECOGNITION))
        }else{
            //권한있는 경우
            val serviceIntent = Intent(this, MyService::class.java)
            startForegroundService(serviceIntent)
        }
    }


    private val requestPermissionLauncher = registerForActivityResult(
        ActivityResultContracts.RequestMultiplePermissions()){
        Log.d(TAG, "requestPermissionLauncher: 건수 : ${it.size}")

        var results = true
        it.values.forEach{
            if(it == false) {
                results = false
                return@forEach
            }
        }

        if(!results){
            Toast.makeText(this@MainActivity, "권한이 필요합니다.", Toast.LENGTH_SHORT).show()
        }
    }

    override fun onResume() {
        super.onResume()
    }

    override fun onPause() {
        super.onPause()
    }

}