package com.ticketpro.parking.dao;

import android.database.Cursor;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.ticketpro.parking.dar.model.LunchBreakModel;
import io.reactivex.Completable;
import java.lang.Class;
import java.lang.Exception;
import java.lang.Integer;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.lang.Void;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;

@SuppressWarnings({"unchecked", "deprecation"})
public final class LunchBreakModelDao_Impl implements LunchBreakModelDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<LunchBreakModel> __insertionAdapterOfLunchBreakModel;

  private final SharedSQLiteStatement __preparedStmtOfRemoveAll;

  private final SharedSQLiteStatement __preparedStmtOfRemoveById;

  public LunchBreakModelDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfLunchBreakModel = new EntityInsertionAdapter<LunchBreakModel>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR REPLACE INTO `break_lunch` (`id`,`userId`,`task_id`,`dd_item`,`location_id`,`mileage_id`,`assignment_id`,`equipment_id`,`vdr`,`location`,`disinfecting`,`mileage`,`dar_task_report_id`,`vehicle`,`device_id`,`sub_equipment_id`,`action_id`,`appId`,`starttime`,`endtime`) VALUES (nullif(?, 0),?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, LunchBreakModel value) {
        stmt.bindLong(1, value.getId());
        if (value.getUserId() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getUserId());
        }
        if (value.getTaskId() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getTaskId());
        }
        if (value.getDdItem() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getDdItem());
        }
        if (value.getLocationId() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.getLocationId());
        }
        if (value.getMileageId() == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindString(6, value.getMileageId());
        }
        if (value.getAssignmentId() == null) {
          stmt.bindNull(7);
        } else {
          stmt.bindLong(7, value.getAssignmentId());
        }
        if (value.getEquipmentId() == null) {
          stmt.bindNull(8);
        } else {
          stmt.bindString(8, value.getEquipmentId());
        }
        if (value.getVdr() == null) {
          stmt.bindNull(9);
        } else {
          stmt.bindString(9, value.getVdr());
        }
        if (value.getLocation() == null) {
          stmt.bindNull(10);
        } else {
          stmt.bindString(10, value.getLocation());
        }
        if (value.getDisinfecting() == null) {
          stmt.bindNull(11);
        } else {
          stmt.bindString(11, value.getDisinfecting());
        }
        if (value.getMileage() == null) {
          stmt.bindNull(12);
        } else {
          stmt.bindString(12, value.getMileage());
        }
        if (value.getDarTaskReportId() == null) {
          stmt.bindNull(13);
        } else {
          stmt.bindString(13, value.getDarTaskReportId());
        }
        if (value.getVehicle() == null) {
          stmt.bindNull(14);
        } else {
          stmt.bindString(14, value.getVehicle());
        }
        if (value.getDeviceid() == null) {
          stmt.bindNull(15);
        } else {
          stmt.bindString(15, value.getDeviceid());
        }
        if (value.getSubEquipmentId() == null) {
          stmt.bindNull(16);
        } else {
          stmt.bindString(16, value.getSubEquipmentId());
        }
        if (value.getActionId() == null) {
          stmt.bindNull(17);
        } else {
          stmt.bindString(17, value.getActionId());
        }
        if (value.getAppId() == null) {
          stmt.bindNull(18);
        } else {
          stmt.bindLong(18, value.getAppId());
        }
        if (value.getStarttime() == null) {
          stmt.bindNull(19);
        } else {
          stmt.bindString(19, value.getStarttime());
        }
        if (value.getEndtime() == null) {
          stmt.bindNull(20);
        } else {
          stmt.bindString(20, value.getEndtime());
        }
      }
    };
    this.__preparedStmtOfRemoveAll = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "DELETE from break_lunch";
        return _query;
      }
    };
    this.__preparedStmtOfRemoveById = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "DELETE from break_lunch where appId=?";
        return _query;
      }
    };
  }

  @Override
  public void insertLunchBreakModel(final LunchBreakModel... data) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfLunchBreakModel.insert(data);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public Completable insertLunchBreakModel(final LunchBreakModel data) {
    return Completable.fromCallable(new Callable<Void>() {
      @Override
      public Void call() throws Exception {
        __db.beginTransaction();
        try {
          __insertionAdapterOfLunchBreakModel.insert(data);
          __db.setTransactionSuccessful();
          return null;
        } finally {
          __db.endTransaction();
        }
      }
    });
  }

  @Override
  public void insertLunchBreakModelList(final List<LunchBreakModel> taskForm22500ModelList) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfLunchBreakModel.insert(taskForm22500ModelList);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void removeAll() {
    __db.assertNotSuspendingTransaction();
    final SupportSQLiteStatement _stmt = __preparedStmtOfRemoveAll.acquire();
    __db.beginTransaction();
    try {
      _stmt.executeUpdateDelete();
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
      __preparedStmtOfRemoveAll.release(_stmt);
    }
  }

  @Override
  public void removeById(final int id) {
    __db.assertNotSuspendingTransaction();
    final SupportSQLiteStatement _stmt = __preparedStmtOfRemoveById.acquire();
    int _argIndex = 1;
    _stmt.bindLong(_argIndex, id);
    __db.beginTransaction();
    try {
      _stmt.executeUpdateDelete();
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
      __preparedStmtOfRemoveById.release(_stmt);
    }
  }

  @Override
  public List<LunchBreakModel> getLunchBreakModel() {
    final String _sql = "select * from break_lunch";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
      final int _cursorIndexOfUserId = CursorUtil.getColumnIndexOrThrow(_cursor, "userId");
      final int _cursorIndexOfTaskId = CursorUtil.getColumnIndexOrThrow(_cursor, "task_id");
      final int _cursorIndexOfDdItem = CursorUtil.getColumnIndexOrThrow(_cursor, "dd_item");
      final int _cursorIndexOfLocationId = CursorUtil.getColumnIndexOrThrow(_cursor, "location_id");
      final int _cursorIndexOfMileageId = CursorUtil.getColumnIndexOrThrow(_cursor, "mileage_id");
      final int _cursorIndexOfAssignmentId = CursorUtil.getColumnIndexOrThrow(_cursor, "assignment_id");
      final int _cursorIndexOfEquipmentId = CursorUtil.getColumnIndexOrThrow(_cursor, "equipment_id");
      final int _cursorIndexOfVdr = CursorUtil.getColumnIndexOrThrow(_cursor, "vdr");
      final int _cursorIndexOfLocation = CursorUtil.getColumnIndexOrThrow(_cursor, "location");
      final int _cursorIndexOfDisinfecting = CursorUtil.getColumnIndexOrThrow(_cursor, "disinfecting");
      final int _cursorIndexOfMileage = CursorUtil.getColumnIndexOrThrow(_cursor, "mileage");
      final int _cursorIndexOfDarTaskReportId = CursorUtil.getColumnIndexOrThrow(_cursor, "dar_task_report_id");
      final int _cursorIndexOfVehicle = CursorUtil.getColumnIndexOrThrow(_cursor, "vehicle");
      final int _cursorIndexOfDeviceid = CursorUtil.getColumnIndexOrThrow(_cursor, "device_id");
      final int _cursorIndexOfSubEquipmentId = CursorUtil.getColumnIndexOrThrow(_cursor, "sub_equipment_id");
      final int _cursorIndexOfActionId = CursorUtil.getColumnIndexOrThrow(_cursor, "action_id");
      final int _cursorIndexOfAppId = CursorUtil.getColumnIndexOrThrow(_cursor, "appId");
      final int _cursorIndexOfStarttime = CursorUtil.getColumnIndexOrThrow(_cursor, "starttime");
      final int _cursorIndexOfEndtime = CursorUtil.getColumnIndexOrThrow(_cursor, "endtime");
      final List<LunchBreakModel> _result = new ArrayList<LunchBreakModel>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final LunchBreakModel _item;
        _item = new LunchBreakModel();
        final long _tmpId;
        _tmpId = _cursor.getLong(_cursorIndexOfId);
        _item.setId(_tmpId);
        final String _tmpUserId;
        if (_cursor.isNull(_cursorIndexOfUserId)) {
          _tmpUserId = null;
        } else {
          _tmpUserId = _cursor.getString(_cursorIndexOfUserId);
        }
        _item.setUserId(_tmpUserId);
        final String _tmpTaskId;
        if (_cursor.isNull(_cursorIndexOfTaskId)) {
          _tmpTaskId = null;
        } else {
          _tmpTaskId = _cursor.getString(_cursorIndexOfTaskId);
        }
        _item.setTaskId(_tmpTaskId);
        final String _tmpDdItem;
        if (_cursor.isNull(_cursorIndexOfDdItem)) {
          _tmpDdItem = null;
        } else {
          _tmpDdItem = _cursor.getString(_cursorIndexOfDdItem);
        }
        _item.setDdItem(_tmpDdItem);
        final String _tmpLocationId;
        if (_cursor.isNull(_cursorIndexOfLocationId)) {
          _tmpLocationId = null;
        } else {
          _tmpLocationId = _cursor.getString(_cursorIndexOfLocationId);
        }
        _item.setLocationId(_tmpLocationId);
        final String _tmpMileageId;
        if (_cursor.isNull(_cursorIndexOfMileageId)) {
          _tmpMileageId = null;
        } else {
          _tmpMileageId = _cursor.getString(_cursorIndexOfMileageId);
        }
        _item.setMileageId(_tmpMileageId);
        final Integer _tmpAssignmentId;
        if (_cursor.isNull(_cursorIndexOfAssignmentId)) {
          _tmpAssignmentId = null;
        } else {
          _tmpAssignmentId = _cursor.getInt(_cursorIndexOfAssignmentId);
        }
        _item.setAssignmentId(_tmpAssignmentId);
        final String _tmpEquipmentId;
        if (_cursor.isNull(_cursorIndexOfEquipmentId)) {
          _tmpEquipmentId = null;
        } else {
          _tmpEquipmentId = _cursor.getString(_cursorIndexOfEquipmentId);
        }
        _item.setEquipmentId(_tmpEquipmentId);
        final String _tmpVdr;
        if (_cursor.isNull(_cursorIndexOfVdr)) {
          _tmpVdr = null;
        } else {
          _tmpVdr = _cursor.getString(_cursorIndexOfVdr);
        }
        _item.setVdr(_tmpVdr);
        final String _tmpLocation;
        if (_cursor.isNull(_cursorIndexOfLocation)) {
          _tmpLocation = null;
        } else {
          _tmpLocation = _cursor.getString(_cursorIndexOfLocation);
        }
        _item.setLocation(_tmpLocation);
        final String _tmpDisinfecting;
        if (_cursor.isNull(_cursorIndexOfDisinfecting)) {
          _tmpDisinfecting = null;
        } else {
          _tmpDisinfecting = _cursor.getString(_cursorIndexOfDisinfecting);
        }
        _item.setDisinfecting(_tmpDisinfecting);
        final String _tmpMileage;
        if (_cursor.isNull(_cursorIndexOfMileage)) {
          _tmpMileage = null;
        } else {
          _tmpMileage = _cursor.getString(_cursorIndexOfMileage);
        }
        _item.setMileage(_tmpMileage);
        final String _tmpDarTaskReportId;
        if (_cursor.isNull(_cursorIndexOfDarTaskReportId)) {
          _tmpDarTaskReportId = null;
        } else {
          _tmpDarTaskReportId = _cursor.getString(_cursorIndexOfDarTaskReportId);
        }
        _item.setDarTaskReportId(_tmpDarTaskReportId);
        final String _tmpVehicle;
        if (_cursor.isNull(_cursorIndexOfVehicle)) {
          _tmpVehicle = null;
        } else {
          _tmpVehicle = _cursor.getString(_cursorIndexOfVehicle);
        }
        _item.setVehicle(_tmpVehicle);
        final String _tmpDeviceid;
        if (_cursor.isNull(_cursorIndexOfDeviceid)) {
          _tmpDeviceid = null;
        } else {
          _tmpDeviceid = _cursor.getString(_cursorIndexOfDeviceid);
        }
        _item.setDeviceid(_tmpDeviceid);
        final String _tmpSubEquipmentId;
        if (_cursor.isNull(_cursorIndexOfSubEquipmentId)) {
          _tmpSubEquipmentId = null;
        } else {
          _tmpSubEquipmentId = _cursor.getString(_cursorIndexOfSubEquipmentId);
        }
        _item.setSubEquipmentId(_tmpSubEquipmentId);
        final String _tmpActionId;
        if (_cursor.isNull(_cursorIndexOfActionId)) {
          _tmpActionId = null;
        } else {
          _tmpActionId = _cursor.getString(_cursorIndexOfActionId);
        }
        _item.setActionId(_tmpActionId);
        final Integer _tmpAppId;
        if (_cursor.isNull(_cursorIndexOfAppId)) {
          _tmpAppId = null;
        } else {
          _tmpAppId = _cursor.getInt(_cursorIndexOfAppId);
        }
        _item.setAppId(_tmpAppId);
        final String _tmpStarttime;
        if (_cursor.isNull(_cursorIndexOfStarttime)) {
          _tmpStarttime = null;
        } else {
          _tmpStarttime = _cursor.getString(_cursorIndexOfStarttime);
        }
        _item.setStarttime(_tmpStarttime);
        final String _tmpEndtime;
        if (_cursor.isNull(_cursorIndexOfEndtime)) {
          _tmpEndtime = null;
        } else {
          _tmpEndtime = _cursor.getString(_cursorIndexOfEndtime);
        }
        _item.setEndtime(_tmpEndtime);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public long getNextPrimaryId() {
    final String _sql = "select max(id) as max_id from break_lunch";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final long _result;
      if(_cursor.moveToFirst()) {
        _result = _cursor.getLong(0);
      } else {
        _result = 0;
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  public static List<Class<?>> getRequiredConverters() {
    return Collections.emptyList();
  }
}