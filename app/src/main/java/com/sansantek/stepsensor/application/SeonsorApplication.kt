package com.sansantek.stepsensor.application

import android.app.Application
import com.sansantek.stepsensor.dto.Distance
import com.sansantek.stepsensor.repository.DistanceRepository
import com.sansantek.stepsensor.repository.StepCounterRepository

class SeonsorApplication: Application() {
    override fun onCreate() {
        super.onCreate()
        StepCounterRepository.initialize(this)
//        DistanceRepository.initialize(this)
    }
}