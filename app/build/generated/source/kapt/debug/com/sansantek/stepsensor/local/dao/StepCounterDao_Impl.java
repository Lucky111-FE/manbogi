package com.sansantek.stepsensor.local.dao;

import android.database.Cursor;
import android.os.CancellationSignal;
import androidx.annotation.NonNull;
import androidx.room.CoroutinesRoom;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.sansantek.stepsensor.dto.StepCount;
import java.lang.Class;
import java.lang.Exception;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import kotlin.Unit;
import kotlin.coroutines.Continuation;

@SuppressWarnings({"unchecked", "deprecation"})
public final class StepCounterDao_Impl implements StepCounterDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<StepCount> __insertionAdapterOfStepCount;

  private final EntityDeletionOrUpdateAdapter<StepCount> __updateAdapterOfStepCount;

  public StepCounterDao_Impl(@NonNull final RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfStepCount = new EntityInsertionAdapter<StepCount>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "INSERT OR ABORT INTO `StepCounter` (`year`,`month`,`day`,`stepCount`) VALUES (?,?,?,?)";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final StepCount entity) {
        statement.bindLong(1, entity.getYear());
        statement.bindLong(2, entity.getMonth());
        statement.bindLong(3, entity.getDay());
        statement.bindLong(4, entity.getStepCount());
      }
    };
    this.__updateAdapterOfStepCount = new EntityDeletionOrUpdateAdapter<StepCount>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "UPDATE OR ABORT `StepCounter` SET `year` = ?,`month` = ?,`day` = ?,`stepCount` = ? WHERE `year` = ? AND `month` = ? AND `day` = ?";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final StepCount entity) {
        statement.bindLong(1, entity.getYear());
        statement.bindLong(2, entity.getMonth());
        statement.bindLong(3, entity.getDay());
        statement.bindLong(4, entity.getStepCount());
        statement.bindLong(5, entity.getYear());
        statement.bindLong(6, entity.getMonth());
        statement.bindLong(7, entity.getDay());
      }
    };
  }

  @Override
  public Object insertStep(final StepCount stepCount,
      final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __insertionAdapterOfStepCount.insert(stepCount);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Object updateStep(final StepCount stepCount,
      final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __updateAdapterOfStepCount.handle(stepCount);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Object getStep(final int year, final int month, final int day,
      final Continuation<? super StepCount> $completion) {
    final String _sql = "select * from StepCounter where day = (?) and month = (?) and year = (?)";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 3);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, day);
    _argIndex = 2;
    _statement.bindLong(_argIndex, month);
    _argIndex = 3;
    _statement.bindLong(_argIndex, year);
    final CancellationSignal _cancellationSignal = DBUtil.createCancellationSignal();
    return CoroutinesRoom.execute(__db, false, _cancellationSignal, new Callable<StepCount>() {
      @Override
      @NonNull
      public StepCount call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfYear = CursorUtil.getColumnIndexOrThrow(_cursor, "year");
          final int _cursorIndexOfMonth = CursorUtil.getColumnIndexOrThrow(_cursor, "month");
          final int _cursorIndexOfDay = CursorUtil.getColumnIndexOrThrow(_cursor, "day");
          final int _cursorIndexOfStepCount = CursorUtil.getColumnIndexOrThrow(_cursor, "stepCount");
          final StepCount _result;
          if (_cursor.moveToFirst()) {
            final int _tmpYear;
            _tmpYear = _cursor.getInt(_cursorIndexOfYear);
            final int _tmpMonth;
            _tmpMonth = _cursor.getInt(_cursorIndexOfMonth);
            final int _tmpDay;
            _tmpDay = _cursor.getInt(_cursorIndexOfDay);
            final int _tmpStepCount;
            _tmpStepCount = _cursor.getInt(_cursorIndexOfStepCount);
            _result = new StepCount(_tmpYear,_tmpMonth,_tmpDay,_tmpStepCount);
          } else {
            _result = null;
          }
          return _result;
        } finally {
          _cursor.close();
          _statement.release();
        }
      }
    }, $completion);
  }

  @NonNull
  public static List<Class<?>> getRequiredConverters() {
    return Collections.emptyList();
  }
}
