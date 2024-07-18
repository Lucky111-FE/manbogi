package com.sansantek.stepsensor.dto

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.sansantek.stepsensor.date.DateInfo

@Entity(tableName = "distance")
data class Distance(@PrimaryKey() var date: DateInfo, @ColumnInfo(name = "distance")var distance: Double)