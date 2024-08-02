package com.sansantek.stepsensor.dto;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\t\u0010\u000f\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0010\u001a\u00020\u0005H\u00c6\u0003J\u001d\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005H\u00c6\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u0015\u001a\u00020\u0016H\u00d6\u0001J\t\u0010\u0017\u001a\u00020\u0018H\u00d6\u0001R\u001e\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001e\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e\u00a8\u0006\u0019"}, d2 = {"Lcom/sansantek/stepsensor/dto/Distance;", "", "date", "Lcom/sansantek/stepsensor/date/DateInfo;", "distance", "", "(Lcom/sansantek/stepsensor/date/DateInfo;D)V", "getDate", "()Lcom/sansantek/stepsensor/date/DateInfo;", "setDate", "(Lcom/sansantek/stepsensor/date/DateInfo;)V", "getDistance", "()D", "setDistance", "(D)V", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "app_debug"})
@androidx.room.Entity(tableName = "distance")
public final class Distance {
    @androidx.room.PrimaryKey
    @org.jetbrains.annotations.NotNull
    private com.sansantek.stepsensor.date.DateInfo date;
    @androidx.room.ColumnInfo(name = "distance")
    private double distance;
    
    public Distance(@org.jetbrains.annotations.NotNull
    com.sansantek.stepsensor.date.DateInfo date, double distance) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.sansantek.stepsensor.date.DateInfo getDate() {
        return null;
    }
    
    public final void setDate(@org.jetbrains.annotations.NotNull
    com.sansantek.stepsensor.date.DateInfo p0) {
    }
    
    public final double getDistance() {
        return 0.0;
    }
    
    public final void setDistance(double p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.sansantek.stepsensor.date.DateInfo component1() {
        return null;
    }
    
    public final double component2() {
        return 0.0;
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.sansantek.stepsensor.dto.Distance copy(@org.jetbrains.annotations.NotNull
    com.sansantek.stepsensor.date.DateInfo date, double distance) {
        return null;
    }
    
    @java.lang.Override
    public boolean equals(@org.jetbrains.annotations.Nullable
    java.lang.Object other) {
        return false;
    }
    
    @java.lang.Override
    public int hashCode() {
        return 0;
    }
    
    @java.lang.Override
    @org.jetbrains.annotations.NotNull
    public java.lang.String toString() {
        return null;
    }
}