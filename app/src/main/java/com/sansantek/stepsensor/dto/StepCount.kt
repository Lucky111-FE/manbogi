package com.sansantek.stepsensor.dto

import androidx.room.ColumnInfo
import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.sansantek.stepsensor.date.DateInfo

@Entity(tableName = "StepCounter", primaryKeys = ["year", "month", "day"])
data class StepCount(var year: Int = -1, var month: Int = -1, var day: Int = -1, @ColumnInfo(name = "stepCount")var stepCount: Int = -1)
