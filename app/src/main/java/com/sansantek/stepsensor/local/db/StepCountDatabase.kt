package com.sansantek.stepsensor.local.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.sansantek.stepsensor.dto.StepCount
import com.sansantek.stepsensor.local.dao.StepCounterDao

@Database(entities = arrayOf(StepCount::class), version = 1)
abstract class StepCountDatabase : RoomDatabase() {
    abstract fun stepCounterDao() : StepCounterDao
}