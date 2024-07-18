package com.sansantek.stepsensor.local.dao

import androidx.room.Dao
import androidx.room.Query

@Dao
interface DistanceDao {
    @Query("select * from distance")
    suspend fun getDistance(): Double

}