package com.sansantek.stepsensor.repository;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u0000 \u00152\u00020\u0001:\u0001\u0015B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J)\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\fH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u000fJ\u0019\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\nH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0013J\u0019\u0010\u0014\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\nH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0013R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0016"}, d2 = {"Lcom/sansantek/stepsensor/repository/StepCounterRepository;", "", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "database", "Lcom/sansantek/stepsensor/local/db/StepCountDatabase;", "stepCounterDao", "Lcom/sansantek/stepsensor/local/dao/StepCounterDao;", "getStepCount", "Lcom/sansantek/stepsensor/dto/StepCount;", "year", "", "month", "day", "(IIILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "insertStepCount", "", "stepCount", "(Lcom/sansantek/stepsensor/dto/StepCount;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateStepCount", "Companion", "app_debug"})
public final class StepCounterRepository {
    @org.jetbrains.annotations.NotNull
    private final com.sansantek.stepsensor.local.db.StepCountDatabase database = null;
    @org.jetbrains.annotations.NotNull
    private final com.sansantek.stepsensor.local.dao.StepCounterDao stepCounterDao = null;
    @org.jetbrains.annotations.Nullable
    private static com.sansantek.stepsensor.repository.StepCounterRepository INSTANCE;
    @org.jetbrains.annotations.NotNull
    public static final com.sansantek.stepsensor.repository.StepCounterRepository.Companion Companion = null;
    
    private StepCounterRepository(android.content.Context context) {
        super();
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object getStepCount(int year, int month, int day, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super com.sansantek.stepsensor.dto.StepCount> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object insertStepCount(@org.jetbrains.annotations.NotNull
    com.sansantek.stepsensor.dto.StepCount stepCount, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object updateStepCount(@org.jetbrains.annotations.NotNull
    com.sansantek.stepsensor.dto.StepCount stepCount, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0006\u0010\u0005\u001a\u00020\u0004J\u000e\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tR\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\n"}, d2 = {"Lcom/sansantek/stepsensor/repository/StepCounterRepository$Companion;", "", "()V", "INSTANCE", "Lcom/sansantek/stepsensor/repository/StepCounterRepository;", "get", "initialize", "", "context", "Landroid/content/Context;", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
        
        public final void initialize(@org.jetbrains.annotations.NotNull
        android.content.Context context) {
        }
        
        @org.jetbrains.annotations.NotNull
        public final com.sansantek.stepsensor.repository.StepCounterRepository get() {
            return null;
        }
    }
}