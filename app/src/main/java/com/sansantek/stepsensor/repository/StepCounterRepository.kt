package com.sansantek.stepsensor.repository

import android.content.Context
import android.util.Log
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import com.sansantek.stepsensor.date.DateInfo
import com.sansantek.stepsensor.dto.Distance
import com.sansantek.stepsensor.dto.StepCount
import com.sansantek.stepsensor.local.db.StepCountDatabase

private const val TAG = "StepCounterRepository 싸피"

private const val DATABASE_NAME = "StepCounter-database.db"


class StepCounterRepository private constructor(context: Context) {

    private val database : StepCountDatabase = Room.databaseBuilder(
        context.applicationContext,
        StepCountDatabase::class.java,
        DATABASE_NAME
    ).build()

    private val stepCounterDao = database.stepCounterDao()

    suspend fun getStepCount(year: Int, month: Int, day: Int): StepCount{
        return stepCounterDao.getStep(year, month, day)
    }

    suspend fun insertStepCount(stepCount: StepCount){
        stepCounterDao.insertStep(stepCount)
    }

    suspend fun updateStepCount(stepCount: StepCount){
        stepCounterDao.updateStep(stepCount)
    }


    companion object{
        private var INSTANCE : StepCounterRepository? =null

        fun initialize(context: Context){
            if(INSTANCE == null){
                Log.d(TAG, "initialize: 레포지토리 이니셜")
                INSTANCE = StepCounterRepository(context)
            }
        }

        fun get() : StepCounterRepository {
            return INSTANCE ?:
            throw IllegalStateException("StepRepository must be initialized")
        }
    }
}