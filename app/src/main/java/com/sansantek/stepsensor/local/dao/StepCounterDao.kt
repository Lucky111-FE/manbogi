package com.sansantek.stepsensor.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.sansantek.stepsensor.date.DateInfo
import com.sansantek.stepsensor.dto.StepCount

@Dao
interface StepCounterDao {
    @Query("select * from StepCounter where day = (:day) and month = (:month) and year = (:year)")
    suspend fun getStep(year: Int, month: Int, day: Int): StepCount

    @Insert
    suspend fun insertStep(stepCount: StepCount)

    @Update
    suspend fun updateStep(stepCount: StepCount)
}
