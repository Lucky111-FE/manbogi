package com.sansantek.stepsensor;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002B\u0005\u00a2\u0006\u0002\u0010\u0003J\u0006\u0010\u0015\u001a\u00020\u0016J\u001a\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u001a\u001a\u00020\u0005H\u0016J\u0012\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\u0006\u0010\u001d\u001a\u00020\u001eH\u0016J\b\u0010\u001f\u001a\u00020\u0018H\u0016J\u0012\u0010 \u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010!H\u0016J\"\u0010\"\u001a\u00020\u00052\b\u0010\u001d\u001a\u0004\u0018\u00010\u001e2\u0006\u0010#\u001a\u00020\u00052\u0006\u0010$\u001a\u00020\u0005H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082D\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\b\"\u0004\b\t\u0010\nR\u001b\u0010\u000b\u001a\u00020\f8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\r\u0010\u000eR\u000e\u0010\u0011\u001a\u00020\u0012X\u0082.\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006%"}, d2 = {"Lcom/sansantek/stepsensor/MyService;", "Landroid/app/Service;", "Landroid/hardware/SensorEventListener;", "()V", "TYPE", "", "isRunning", "", "()Z", "setRunning", "(Z)V", "repository", "Lcom/sansantek/stepsensor/repository/StepCounterRepository;", "getRepository", "()Lcom/sansantek/stepsensor/repository/StepCounterRepository;", "repository$delegate", "Lkotlin/Lazy;", "sensorManager", "Landroid/hardware/SensorManager;", "stepCountSensor", "Landroid/hardware/Sensor;", "getCurrentDateInfo", "Lcom/sansantek/stepsensor/date/DateInfo;", "onAccuracyChanged", "", "p0", "p1", "onBind", "Landroid/os/IBinder;", "intent", "Landroid/content/Intent;", "onDestroy", "onSensorChanged", "Landroid/hardware/SensorEvent;", "onStartCommand", "flags", "startId", "app_debug"})
public final class MyService extends android.app.Service implements android.hardware.SensorEventListener {
    private boolean isRunning = true;
    @org.jetbrains.annotations.Nullable
    private android.hardware.Sensor stepCountSensor;
    private final int TYPE = android.hardware.Sensor.TYPE_STEP_DETECTOR;
    private android.hardware.SensorManager sensorManager;
    @org.jetbrains.annotations.NotNull
    private final kotlin.Lazy repository$delegate = null;
    
    public MyService() {
        super();
    }
    
    public final boolean isRunning() {
        return false;
    }
    
    public final void setRunning(boolean p0) {
    }
    
    private final com.sansantek.stepsensor.repository.StepCounterRepository getRepository() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.sansantek.stepsensor.date.DateInfo getCurrentDateInfo() {
        return null;
    }
    
    @java.lang.Override
    @org.jetbrains.annotations.Nullable
    public android.os.IBinder onBind(@org.jetbrains.annotations.NotNull
    android.content.Intent intent) {
        return null;
    }
    
    @java.lang.Override
    public int onStartCommand(@org.jetbrains.annotations.Nullable
    android.content.Intent intent, int flags, int startId) {
        return 0;
    }
    
    @java.lang.Override
    public void onDestroy() {
    }
    
    @java.lang.Override
    public void onSensorChanged(@org.jetbrains.annotations.Nullable
    android.hardware.SensorEvent p0) {
    }
    
    @java.lang.Override
    public void onAccuracyChanged(@org.jetbrains.annotations.Nullable
    android.hardware.Sensor p0, int p1) {
    }
}