package com.sansantek.stepsensor.local.dao;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0004\bg\u0018\u00002\u00020\u0001J)\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0005H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\bJ\u0019\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0003H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\fJ\u0019\u0010\r\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0003H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\f\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u000e"}, d2 = {"Lcom/sansantek/stepsensor/local/dao/StepCounterDao;", "", "getStep", "Lcom/sansantek/stepsensor/dto/StepCount;", "year", "", "month", "day", "(IIILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "insertStep", "", "stepCount", "(Lcom/sansantek/stepsensor/dto/StepCount;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateStep", "app_debug"})
@androidx.room.Dao
public abstract interface StepCounterDao {
    
    @androidx.room.Query(value = "select * from StepCounter where day = (:day) and month = (:month) and year = (:year)")
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object getStep(int year, int month, int day, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super com.sansantek.stepsensor.dto.StepCount> $completion);
    
    @androidx.room.Insert
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object insertStep(@org.jetbrains.annotations.NotNull
    com.sansantek.stepsensor.dto.StepCount stepCount, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @androidx.room.Update
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object updateStep(@org.jetbrains.annotations.NotNull
    com.sansantek.stepsensor.dto.StepCount stepCount, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
}