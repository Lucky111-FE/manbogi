package com.sansantek.stepsensor

import android.Manifest
import android.content.Context
import android.content.Intent
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
import com.sansantek.stepsensor.date.DateInfo
import com.sansantek.stepsensor.dto.StepCount
import com.sansantek.stepsensor.repository.StepCounterRepository
import kotlinx.coroutines.launch
import java.time.LocalDate
import kotlin.math.log

private const val TAG = "MainActivity 싸피"
class MainActivity : AppCompatActivity(), SensorEventListener {
    private lateinit var sensorManager: SensorManager
    private var stepCountSensor: Sensor? = null
    private lateinit var tvStepCount: TextView

    //    private val TYPE = Sensor.TYPE_STEP_DETECTOR //보행 감지기
    private val TYPE = Sensor.TYPE_STEP_DETECTOR //보행 계수기

    private val repository by lazy{
        StepCounterRepository.get()
    }

    fun getCurrentDateInfo(): DateInfo {
        val currentDate = LocalDate.now()
        val year = currentDate.year
        val month = currentDate.monthValue
        val day = currentDate.dayOfMonth
        return DateInfo(year, month, day)
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        lifecycleScope.launch {
            val date = getCurrentDateInfo()
            val result = repository.getStepCount(date.year, date.month, date.day)

            if(result != null){
                tvStepCount.text = "Step Count Sensor : " + result.stepCount.toString()
            }

        }

        tvStepCount = findViewById(R.id.tvStepCount)
        sensorManager = getSystemService(Context.SENSOR_SERVICE) as SensorManager
        stepCountSensor = sensorManager.getDefaultSensor(TYPE)
        if(stepCountSensor == null) {
            Toast.makeText(this, "No Step Detect Sensor!!", Toast.LENGTH_SHORT).show()
        }else{
            if(ContextCompat.checkSelfPermission(this,
                    Manifest.permission.ACTIVITY_RECOGNITION) == PackageManager.PERMISSION_DENIED){
                Toast.makeText(this, "No Permission!!", Toast.LENGTH_SHORT).show()

                //ask for permission
                requestPermissionLauncher.launch(arrayOf(Manifest.permission.ACTIVITY_RECOGNITION))

            }else{
                //권한있는 경우
            }
        }

        val serviceIntent = Intent(this, MyService::class.java)
        startService(serviceIntent)
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
        }else{
            //모두 권한이 있을 경우
        }
    }

    override fun onSensorChanged(p0: SensorEvent?) {
        if(p0?.sensor?.type == TYPE) {
            Log.d(TAG, "onSensorChanged: ${p0.values[0]}")
            val today = getCurrentDateInfo()
            var step = StepCount()
            lifecycleScope.launch {
                val result =repository.getStepCount(today.year, today.month, today.day) 
                if(result != null){
                    Log.d(TAG, "onSensorChanged: result")
                    step =  result  
                }
                Log.d(TAG, "onSensorChanged: stepcount 확인 $step")
                if(step.stepCount == -1){
                    val date = getCurrentDateInfo()
                    step.year = date.year
                    step.month = date.month
                    step.day = date.day

                    step.stepCount = 1
                    Log.d(TAG, "onSensorChanged: insert")
                    repository.insertStepCount(step)
                }
                else{
                    step.stepCount += 1
                    Log.d(TAG, "onSensorChanged: update")
                    repository.updateStepCount(step)
                }
                tvStepCount.text = "Step Count Sensor : " + step.stepCount.toString()
            }

        }

    }

    override fun onAccuracyChanged(p0: Sensor?, p1: Int) {
    }

    override fun onResume() {
        super.onResume()
        var bool = sensorManager.registerListener(this, stepCountSensor, SensorManager.SENSOR_DELAY_NORMAL)
    }

    override fun onPause() {
        super.onPause()
        sensorManager.unregisterListener(this)
    }

}