package com.ticketpro.parking.dao;

import android.database.Cursor;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.ticketpro.model.TicketPicture;
import com.ticketpro.util.Converters;
import io.reactivex.Completable;
import java.lang.Class;
import java.lang.Exception;
import java.lang.Long;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.lang.Void;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.concurrent.Callable;

@SuppressWarnings({"unchecked", "deprecation"})
public final class TicketPicturesDao_Impl implements TicketPicturesDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<TicketPicture> __insertionAdapterOfTicketPicture;

  private final SharedSQLiteStatement __preparedStmtOfRemovePictureByTicketId;

  private final SharedSQLiteStatement __preparedStmtOfRemovePictureById;

  private final SharedSQLiteStatement __preparedStmtOfRemoveAll;

  private final SharedSQLiteStatement __preparedStmtOfUpdateTicket;

  public TicketPicturesDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfTicketPicture = new EntityInsertionAdapter<TicketPicture>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR REPLACE INTO `ticket_pictures` (`s_no`,`picture_id`,`ticket_id`,`citation_number`,`custid`,`picture_date`,`mark_print`,`image_path`,`image_resolution`,`image_size`,`sync_status`,`download_image_url`,`image_name`,`isSelfi`) VALUES (nullif(?, 0),?,?,?,?,?,?,?,?,?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, TicketPicture value) {
        stmt.bindLong(1, value.getS_no());
        stmt.bindLong(2, value.getPictureId());
        stmt.bindLong(3, value.getTicketId());
        stmt.bindLong(4, value.getCitationNumber());
        stmt.bindLong(5, value.getCustId());
        final Long _tmp;
        _tmp = Converters.dateToTimestamp(value.getPictureDate());
        if (_tmp == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindLong(6, _tmp);
        }
        if (value.getMarkPrint() == null) {
          stmt.bindNull(7);
        } else {
          stmt.bindString(7, value.getMarkPrint());
        }
        if (value.getImagePath() == null) {
          stmt.bindNull(8);
        } else {
          stmt.bindString(8, value.getImagePath());
        }
        if (value.getImageResolution() == null) {
          stmt.bindNull(9);
        } else {
          stmt.bindString(9, value.getImageResolution());
        }
        if (value.getImageSize() == null) {
          stmt.bindNull(10);
        } else {
          stmt.bindString(10, value.getImageSize());
        }
        if (value.getSyncStatus() == null) {
          stmt.bindNull(11);
        } else {
          stmt.bindString(11, value.getSyncStatus());
        }
        if (value.getDownloadImageUrl() == null) {
          stmt.bindNull(12);
        } else {
          stmt.bindString(12, value.getDownloadImageUrl());
        }
        if (value.getImageName() == null) {
          stmt.bindNull(13);
        } else {
          stmt.bindString(13, value.getImageName());
        }
        final int _tmp_1;
        _tmp_1 = value.isSelfi() ? 1 : 0;
        stmt.bindLong(14, _tmp_1);
      }
    };
    this.__preparedStmtOfRemovePictureByTicketId = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "Delete from ticket_pictures where ticket_id=?";
        return _query;
      }
    };
    this.__preparedStmtOfRemovePictureById = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "Delete from ticket_pictures where s_no=?";
        return _query;
      }
    };
    this.__preparedStmtOfRemoveAll = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "Delete from ticket_pictures";
        return _query;
      }
    };
    this.__preparedStmtOfUpdateTicket = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "Update ticket_pictures set sync_status=? where citation_number=? AND s_no=?";
        return _query;
      }
    };
  }

  @Override
  public void insertTicketPicture(final TicketPicture... data) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfTicketPicture.insert(data);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public Completable insertTicketPicture(final TicketPicture data) {
    return Completable.fromCallable(new Callable<Void>() {
      @Override
      public Void call() throws Exception {
        __db.beginTransaction();
        try {
          __insertionAdapterOfTicketPicture.insert(data);
          __db.setTransactionSuccessful();
          return null;
        } finally {
          __db.endTransaction();
        }
      }
    });
  }

  @Override
  public void insertTicketPictureList(final List<TicketPicture> TicketPicturesList) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfTicketPicture.insert(TicketPicturesList);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void removePictureByTicketId(final long ticketId) {
    __db.assertNotSuspendingTransaction();
    final SupportSQLiteStatement _stmt = __preparedStmtOfRemovePictureByTicketId.acquire();
    int _argIndex = 1;
    _stmt.bindLong(_argIndex, ticketId);
    __db.beginTransaction();
    try {
      _stmt.executeUpdateDelete();
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
      __preparedStmtOfRemovePictureByTicketId.release(_stmt);
    }
  }

  @Override
  public void removePictureById(final int pictureId) {
    __db.assertNotSuspendingTransaction();
    final SupportSQLiteStatement _stmt = __preparedStmtOfRemovePictureById.acquire();
    int _argIndex = 1;
    _stmt.bindLong(_argIndex, pictureId);
    __db.beginTransaction();
    try {
      _stmt.executeUpdateDelete();
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
      __preparedStmtOfRemovePictureById.release(_stmt);
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
  public void updateTicket(final String citation, final String values, final int sNo) {
    __db.assertNotSuspendingTransaction();
    final SupportSQLiteStatement _stmt = __preparedStmtOfUpdateTicket.acquire();
    int _argIndex = 1;
    if (values == null) {
      _stmt.bindNull(_argIndex);
    } else {
      _stmt.bindString(_argIndex, values);
    }
    _argIndex = 2;
    if (citation == null) {
      _stmt.bindNull(_argIndex);
    } else {
      _stmt.bindString(_argIndex, citation);
    }
    _argIndex = 3;
    _stmt.bindLong(_argIndex, sNo);
    __db.beginTransaction();
    try {
      _stmt.executeUpdateDelete();
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
      __preparedStmtOfUpdateTicket.release(_stmt);
    }
  }

  @Override
  public List<TicketPicture> getTicketPictures(final long ticketId, final long citationNumber) {
    final String _sql = "select * from ticket_pictures where ticket_id=? and citation_number=?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 2);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, ticketId);
    _argIndex = 2;
    _statement.bindLong(_argIndex, citationNumber);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfSNo = CursorUtil.getColumnIndexOrThrow(_cursor, "s_no");
      final int _cursorIndexOfPictureId = CursorUtil.getColumnIndexOrThrow(_cursor, "picture_id");
      final int _cursorIndexOfTicketId = CursorUtil.getColumnIndexOrThrow(_cursor, "ticket_id");
      final int _cursorIndexOfCitationNumber = CursorUtil.getColumnIndexOrThrow(_cursor, "citation_number");
      final int _cursorIndexOfCustId = CursorUtil.getColumnIndexOrThrow(_cursor, "custid");
      final int _cursorIndexOfPictureDate = CursorUtil.getColumnIndexOrThrow(_cursor, "picture_date");
      final int _cursorIndexOfMarkPrint = CursorUtil.getColumnIndexOrThrow(_cursor, "mark_print");
      final int _cursorIndexOfImagePath = CursorUtil.getColumnIndexOrThrow(_cursor, "image_path");
      final int _cursorIndexOfImageResolution = CursorUtil.getColumnIndexOrThrow(_cursor, "image_resolution");
      final int _cursorIndexOfImageSize = CursorUtil.getColumnIndexOrThrow(_cursor, "image_size");
      final int _cursorIndexOfSyncStatus = CursorUtil.getColumnIndexOrThrow(_cursor, "sync_status");
      final int _cursorIndexOfDownloadImageUrl = CursorUtil.getColumnIndexOrThrow(_cursor, "download_image_url");
      final int _cursorIndexOfImageName = CursorUtil.getColumnIndexOrThrow(_cursor, "image_name");
      final int _cursorIndexOfIsSelfi = CursorUtil.getColumnIndexOrThrow(_cursor, "isSelfi");
      final List<TicketPicture> _result = new ArrayList<TicketPicture>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final TicketPicture _item;
        _item = new TicketPicture();
        final int _tmpS_no;
        _tmpS_no = _cursor.getInt(_cursorIndexOfSNo);
        _item.setS_no(_tmpS_no);
        final int _tmpPictureId;
        _tmpPictureId = _cursor.getInt(_cursorIndexOfPictureId);
        _item.setPictureId(_tmpPictureId);
        final long _tmpTicketId;
        _tmpTicketId = _cursor.getLong(_cursorIndexOfTicketId);
        _item.setTicketId(_tmpTicketId);
        final long _tmpCitationNumber;
        _tmpCitationNumber = _cursor.getLong(_cursorIndexOfCitationNumber);
        _item.setCitationNumber(_tmpCitationNumber);
        final int _tmpCustId;
        _tmpCustId = _cursor.getInt(_cursorIndexOfCustId);
        _item.setCustId(_tmpCustId);
        final Date _tmpPictureDate;
        final Long _tmp;
        if (_cursor.isNull(_cursorIndexOfPictureDate)) {
          _tmp = null;
        } else {
          _tmp = _cursor.getLong(_cursorIndexOfPictureDate);
        }
        _tmpPictureDate = Converters.fromTimestamp(_tmp);
        _item.setPictureDate(_tmpPictureDate);
        final String _tmpMarkPrint;
        if (_cursor.isNull(_cursorIndexOfMarkPrint)) {
          _tmpMarkPrint = null;
        } else {
          _tmpMarkPrint = _cursor.getString(_cursorIndexOfMarkPrint);
        }
        _item.setMarkPrint(_tmpMarkPrint);
        final String _tmpImagePath;
        if (_cursor.isNull(_cursorIndexOfImagePath)) {
          _tmpImagePath = null;
        } else {
          _tmpImagePath = _cursor.getString(_cursorIndexOfImagePath);
        }
        _item.setImagePath(_tmpImagePath);
        final String _tmpImageResolution;
        if (_cursor.isNull(_cursorIndexOfImageResolution)) {
          _tmpImageResolution = null;
        } else {
          _tmpImageResolution = _cursor.getString(_cursorIndexOfImageResolution);
        }
        _item.setImageResolution(_tmpImageResolution);
        final String _tmpImageSize;
        if (_cursor.isNull(_cursorIndexOfImageSize)) {
          _tmpImageSize = null;
        } else {
          _tmpImageSize = _cursor.getString(_cursorIndexOfImageSize);
        }
        _item.setImageSize(_tmpImageSize);
        final String _tmpSyncStatus;
        if (_cursor.isNull(_cursorIndexOfSyncStatus)) {
          _tmpSyncStatus = null;
        } else {
          _tmpSyncStatus = _cursor.getString(_cursorIndexOfSyncStatus);
        }
        _item.setSyncStatus(_tmpSyncStatus);
        final String _tmpDownloadImageUrl;
        if (_cursor.isNull(_cursorIndexOfDownloadImageUrl)) {
          _tmpDownloadImageUrl = null;
        } else {
          _tmpDownloadImageUrl = _cursor.getString(_cursorIndexOfDownloadImageUrl);
        }
        _item.setDownloadImageUrl(_tmpDownloadImageUrl);
        final String _tmpImageName;
        if (_cursor.isNull(_cursorIndexOfImageName)) {
          _tmpImageName = null;
        } else {
          _tmpImageName = _cursor.getString(_cursorIndexOfImageName);
        }
        _item.setImageName(_tmpImageName);
        final boolean _tmpIsSelfi;
        final int _tmp_1;
        _tmp_1 = _cursor.getInt(_cursorIndexOfIsSelfi);
        _tmpIsSelfi = _tmp_1 != 0;
        _item.setSelfi(_tmpIsSelfi);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public List<TicketPicture> getTicketPicturesByCitation(final long citationNumber) {
    final String _sql = "select * from ticket_pictures where citation_number=?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, citationNumber);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfSNo = CursorUtil.getColumnIndexOrThrow(_cursor, "s_no");
      final int _cursorIndexOfPictureId = CursorUtil.getColumnIndexOrThrow(_cursor, "picture_id");
      final int _cursorIndexOfTicketId = CursorUtil.getColumnIndexOrThrow(_cursor, "ticket_id");
      final int _cursorIndexOfCitationNumber = CursorUtil.getColumnIndexOrThrow(_cursor, "citation_number");
      final int _cursorIndexOfCustId = CursorUtil.getColumnIndexOrThrow(_cursor, "custid");
      final int _cursorIndexOfPictureDate = CursorUtil.getColumnIndexOrThrow(_cursor, "picture_date");
      final int _cursorIndexOfMarkPrint = CursorUtil.getColumnIndexOrThrow(_cursor, "mark_print");
      final int _cursorIndexOfImagePath = CursorUtil.getColumnIndexOrThrow(_cursor, "image_path");
      final int _cursorIndexOfImageResolution = CursorUtil.getColumnIndexOrThrow(_cursor, "image_resolution");
      final int _cursorIndexOfImageSize = CursorUtil.getColumnIndexOrThrow(_cursor, "image_size");
      final int _cursorIndexOfSyncStatus = CursorUtil.getColumnIndexOrThrow(_cursor, "sync_status");
      final int _cursorIndexOfDownloadImageUrl = CursorUtil.getColumnIndexOrThrow(_cursor, "download_image_url");
      final int _cursorIndexOfImageName = CursorUtil.getColumnIndexOrThrow(_cursor, "image_name");
      final int _cursorIndexOfIsSelfi = CursorUtil.getColumnIndexOrThrow(_cursor, "isSelfi");
      final List<TicketPicture> _result = new ArrayList<TicketPicture>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final TicketPicture _item;
        _item = new TicketPicture();
        final int _tmpS_no;
        _tmpS_no = _cursor.getInt(_cursorIndexOfSNo);
        _item.setS_no(_tmpS_no);
        final int _tmpPictureId;
        _tmpPictureId = _cursor.getInt(_cursorIndexOfPictureId);
        _item.setPictureId(_tmpPictureId);
        final long _tmpTicketId;
        _tmpTicketId = _cursor.getLong(_cursorIndexOfTicketId);
        _item.setTicketId(_tmpTicketId);
        final long _tmpCitationNumber;
        _tmpCitationNumber = _cursor.getLong(_cursorIndexOfCitationNumber);
        _item.setCitationNumber(_tmpCitationNumber);
        final int _tmpCustId;
        _tmpCustId = _cursor.getInt(_cursorIndexOfCustId);
        _item.setCustId(_tmpCustId);
        final Date _tmpPictureDate;
        final Long _tmp;
        if (_cursor.isNull(_cursorIndexOfPictureDate)) {
          _tmp = null;
        } else {
          _tmp = _cursor.getLong(_cursorIndexOfPictureDate);
        }
        _tmpPictureDate = Converters.fromTimestamp(_tmp);
        _item.setPictureDate(_tmpPictureDate);
        final String _tmpMarkPrint;
        if (_cursor.isNull(_cursorIndexOfMarkPrint)) {
          _tmpMarkPrint = null;
        } else {
          _tmpMarkPrint = _cursor.getString(_cursorIndexOfMarkPrint);
        }
        _item.setMarkPrint(_tmpMarkPrint);
        final String _tmpImagePath;
        if (_cursor.isNull(_cursorIndexOfImagePath)) {
          _tmpImagePath = null;
        } else {
          _tmpImagePath = _cursor.getString(_cursorIndexOfImagePath);
        }
        _item.setImagePath(_tmpImagePath);
        final String _tmpImageResolution;
        if (_cursor.isNull(_cursorIndexOfImageResolution)) {
          _tmpImageResolution = null;
        } else {
          _tmpImageResolution = _cursor.getString(_cursorIndexOfImageResolution);
        }
        _item.setImageResolution(_tmpImageResolution);
        final String _tmpImageSize;
        if (_cursor.isNull(_cursorIndexOfImageSize)) {
          _tmpImageSize = null;
        } else {
          _tmpImageSize = _cursor.getString(_cursorIndexOfImageSize);
        }
        _item.setImageSize(_tmpImageSize);
        final String _tmpSyncStatus;
        if (_cursor.isNull(_cursorIndexOfSyncStatus)) {
          _tmpSyncStatus = null;
        } else {
          _tmpSyncStatus = _cursor.getString(_cursorIndexOfSyncStatus);
        }
        _item.setSyncStatus(_tmpSyncStatus);
        final String _tmpDownloadImageUrl;
        if (_cursor.isNull(_cursorIndexOfDownloadImageUrl)) {
          _tmpDownloadImageUrl = null;
        } else {
          _tmpDownloadImageUrl = _cursor.getString(_cursorIndexOfDownloadImageUrl);
        }
        _item.setDownloadImageUrl(_tmpDownloadImageUrl);
        final String _tmpImageName;
        if (_cursor.isNull(_cursorIndexOfImageName)) {
          _tmpImageName = null;
        } else {
          _tmpImageName = _cursor.getString(_cursorIndexOfImageName);
        }
        _item.setImageName(_tmpImageName);
        final boolean _tmpIsSelfi;
        final int _tmp_1;
        _tmp_1 = _cursor.getInt(_cursorIndexOfIsSelfi);
        _tmpIsSelfi = _tmp_1 != 0;
        _item.setSelfi(_tmpIsSelfi);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public TicketPicture getTicketPictureByPrimaryKey(final String ticketPictureId) {
    final String _sql = "select * from ticket_pictures where picture_id=?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (ticketPictureId == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, ticketPictureId);
    }
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfSNo = CursorUtil.getColumnIndexOrThrow(_cursor, "s_no");
      final int _cursorIndexOfPictureId = CursorUtil.getColumnIndexOrThrow(_cursor, "picture_id");
      final int _cursorIndexOfTicketId = CursorUtil.getColumnIndexOrThrow(_cursor, "ticket_id");
      final int _cursorIndexOfCitationNumber = CursorUtil.getColumnIndexOrThrow(_cursor, "citation_number");
      final int _cursorIndexOfCustId = CursorUtil.getColumnIndexOrThrow(_cursor, "custid");
      final int _cursorIndexOfPictureDate = CursorUtil.getColumnIndexOrThrow(_cursor, "picture_date");
      final int _cursorIndexOfMarkPrint = CursorUtil.getColumnIndexOrThrow(_cursor, "mark_print");
      final int _cursorIndexOfImagePath = CursorUtil.getColumnIndexOrThrow(_cursor, "image_path");
      final int _cursorIndexOfImageResolution = CursorUtil.getColumnIndexOrThrow(_cursor, "image_resolution");
      final int _cursorIndexOfImageSize = CursorUtil.getColumnIndexOrThrow(_cursor, "image_size");
      final int _cursorIndexOfSyncStatus = CursorUtil.getColumnIndexOrThrow(_cursor, "sync_status");
      final int _cursorIndexOfDownloadImageUrl = CursorUtil.getColumnIndexOrThrow(_cursor, "download_image_url");
      final int _cursorIndexOfImageName = CursorUtil.getColumnIndexOrThrow(_cursor, "image_name");
      final int _cursorIndexOfIsSelfi = CursorUtil.getColumnIndexOrThrow(_cursor, "isSelfi");
      final TicketPicture _result;
      if(_cursor.moveToFirst()) {
        _result = new TicketPicture();
        final int _tmpS_no;
        _tmpS_no = _cursor.getInt(_cursorIndexOfSNo);
        _result.setS_no(_tmpS_no);
        final int _tmpPictureId;
        _tmpPictureId = _cursor.getInt(_cursorIndexOfPictureId);
        _result.setPictureId(_tmpPictureId);
        final long _tmpTicketId;
        _tmpTicketId = _cursor.getLong(_cursorIndexOfTicketId);
        _result.setTicketId(_tmpTicketId);
        final long _tmpCitationNumber;
        _tmpCitationNumber = _cursor.getLong(_cursorIndexOfCitationNumber);
        _result.setCitationNumber(_tmpCitationNumber);
        final int _tmpCustId;
        _tmpCustId = _cursor.getInt(_cursorIndexOfCustId);
        _result.setCustId(_tmpCustId);
        final Date _tmpPictureDate;
        final Long _tmp;
        if (_cursor.isNull(_cursorIndexOfPictureDate)) {
          _tmp = null;
        } else {
          _tmp = _cursor.getLong(_cursorIndexOfPictureDate);
        }
        _tmpPictureDate = Converters.fromTimestamp(_tmp);
        _result.setPictureDate(_tmpPictureDate);
        final String _tmpMarkPrint;
        if (_cursor.isNull(_cursorIndexOfMarkPrint)) {
          _tmpMarkPrint = null;
        } else {
          _tmpMarkPrint = _cursor.getString(_cursorIndexOfMarkPrint);
        }
        _result.setMarkPrint(_tmpMarkPrint);
        final String _tmpImagePath;
        if (_cursor.isNull(_cursorIndexOfImagePath)) {
          _tmpImagePath = null;
        } else {
          _tmpImagePath = _cursor.getString(_cursorIndexOfImagePath);
        }
        _result.setImagePath(_tmpImagePath);
        final String _tmpImageResolution;
        if (_cursor.isNull(_cursorIndexOfImageResolution)) {
          _tmpImageResolution = null;
        } else {
          _tmpImageResolution = _cursor.getString(_cursorIndexOfImageResolution);
        }
        _result.setImageResolution(_tmpImageResolution);
        final String _tmpImageSize;
        if (_cursor.isNull(_cursorIndexOfImageSize)) {
          _tmpImageSize = null;
        } else {
          _tmpImageSize = _cursor.getString(_cursorIndexOfImageSize);
        }
        _result.setImageSize(_tmpImageSize);
        final String _tmpSyncStatus;
        if (_cursor.isNull(_cursorIndexOfSyncStatus)) {
          _tmpSyncStatus = null;
        } else {
          _tmpSyncStatus = _cursor.getString(_cursorIndexOfSyncStatus);
        }
        _result.setSyncStatus(_tmpSyncStatus);
        final String _tmpDownloadImageUrl;
        if (_cursor.isNull(_cursorIndexOfDownloadImageUrl)) {
          _tmpDownloadImageUrl = null;
        } else {
          _tmpDownloadImageUrl = _cursor.getString(_cursorIndexOfDownloadImageUrl);
        }
        _result.setDownloadImageUrl(_tmpDownloadImageUrl);
        final String _tmpImageName;
        if (_cursor.isNull(_cursorIndexOfImageName)) {
          _tmpImageName = null;
        } else {
          _tmpImageName = _cursor.getString(_cursorIndexOfImageName);
        }
        _result.setImageName(_tmpImageName);
        final boolean _tmpIsSelfi;
        final int _tmp_1;
        _tmp_1 = _cursor.getInt(_cursorIndexOfIsSelfi);
        _tmpIsSelfi = _tmp_1 != 0;
        _result.setSelfi(_tmpIsSelfi);
      } else {
        _result = null;
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public TicketPicture getTicketPictureByPStatus(final long citNumber, final String status) {
    final String _sql = "select * from ticket_pictures where citation_number=? AND sync_status=?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 2);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, citNumber);
    _argIndex = 2;
    if (status == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, status);
    }
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfSNo = CursorUtil.getColumnIndexOrThrow(_cursor, "s_no");
      final int _cursorIndexOfPictureId = CursorUtil.getColumnIndexOrThrow(_cursor, "picture_id");
      final int _cursorIndexOfTicketId = CursorUtil.getColumnIndexOrThrow(_cursor, "ticket_id");
      final int _cursorIndexOfCitationNumber = CursorUtil.getColumnIndexOrThrow(_cursor, "citation_number");
      final int _cursorIndexOfCustId = CursorUtil.getColumnIndexOrThrow(_cursor, "custid");
      final int _cursorIndexOfPictureDate = CursorUtil.getColumnIndexOrThrow(_cursor, "picture_date");
      final int _cursorIndexOfMarkPrint = CursorUtil.getColumnIndexOrThrow(_cursor, "mark_print");
      final int _cursorIndexOfImagePath = CursorUtil.getColumnIndexOrThrow(_cursor, "image_path");
      final int _cursorIndexOfImageResolution = CursorUtil.getColumnIndexOrThrow(_cursor, "image_resolution");
      final int _cursorIndexOfImageSize = CursorUtil.getColumnIndexOrThrow(_cursor, "image_size");
      final int _cursorIndexOfSyncStatus = CursorUtil.getColumnIndexOrThrow(_cursor, "sync_status");
      final int _cursorIndexOfDownloadImageUrl = CursorUtil.getColumnIndexOrThrow(_cursor, "download_image_url");
      final int _cursorIndexOfImageName = CursorUtil.getColumnIndexOrThrow(_cursor, "image_name");
      final int _cursorIndexOfIsSelfi = CursorUtil.getColumnIndexOrThrow(_cursor, "isSelfi");
      final TicketPicture _result;
      if(_cursor.moveToFirst()) {
        _result = new TicketPicture();
        final int _tmpS_no;
        _tmpS_no = _cursor.getInt(_cursorIndexOfSNo);
        _result.setS_no(_tmpS_no);
        final int _tmpPictureId;
        _tmpPictureId = _cursor.getInt(_cursorIndexOfPictureId);
        _result.setPictureId(_tmpPictureId);
        final long _tmpTicketId;
        _tmpTicketId = _cursor.getLong(_cursorIndexOfTicketId);
        _result.setTicketId(_tmpTicketId);
        final long _tmpCitationNumber;
        _tmpCitationNumber = _cursor.getLong(_cursorIndexOfCitationNumber);
        _result.setCitationNumber(_tmpCitationNumber);
        final int _tmpCustId;
        _tmpCustId = _cursor.getInt(_cursorIndexOfCustId);
        _result.setCustId(_tmpCustId);
        final Date _tmpPictureDate;
        final Long _tmp;
        if (_cursor.isNull(_cursorIndexOfPictureDate)) {
          _tmp = null;
        } else {
          _tmp = _cursor.getLong(_cursorIndexOfPictureDate);
        }
        _tmpPictureDate = Converters.fromTimestamp(_tmp);
        _result.setPictureDate(_tmpPictureDate);
        final String _tmpMarkPrint;
        if (_cursor.isNull(_cursorIndexOfMarkPrint)) {
          _tmpMarkPrint = null;
        } else {
          _tmpMarkPrint = _cursor.getString(_cursorIndexOfMarkPrint);
        }
        _result.setMarkPrint(_tmpMarkPrint);
        final String _tmpImagePath;
        if (_cursor.isNull(_cursorIndexOfImagePath)) {
          _tmpImagePath = null;
        } else {
          _tmpImagePath = _cursor.getString(_cursorIndexOfImagePath);
        }
        _result.setImagePath(_tmpImagePath);
        final String _tmpImageResolution;
        if (_cursor.isNull(_cursorIndexOfImageResolution)) {
          _tmpImageResolution = null;
        } else {
          _tmpImageResolution = _cursor.getString(_cursorIndexOfImageResolution);
        }
        _result.setImageResolution(_tmpImageResolution);
        final String _tmpImageSize;
        if (_cursor.isNull(_cursorIndexOfImageSize)) {
          _tmpImageSize = null;
        } else {
          _tmpImageSize = _cursor.getString(_cursorIndexOfImageSize);
        }
        _result.setImageSize(_tmpImageSize);
        final String _tmpSyncStatus;
        if (_cursor.isNull(_cursorIndexOfSyncStatus)) {
          _tmpSyncStatus = null;
        } else {
          _tmpSyncStatus = _cursor.getString(_cursorIndexOfSyncStatus);
        }
        _result.setSyncStatus(_tmpSyncStatus);
        final String _tmpDownloadImageUrl;
        if (_cursor.isNull(_cursorIndexOfDownloadImageUrl)) {
          _tmpDownloadImageUrl = null;
        } else {
          _tmpDownloadImageUrl = _cursor.getString(_cursorIndexOfDownloadImageUrl);
        }
        _result.setDownloadImageUrl(_tmpDownloadImageUrl);
        final String _tmpImageName;
        if (_cursor.isNull(_cursorIndexOfImageName)) {
          _tmpImageName = null;
        } else {
          _tmpImageName = _cursor.getString(_cursorIndexOfImageName);
        }
        _result.setImageName(_tmpImageName);
        final boolean _tmpIsSelfi;
        final int _tmp_1;
        _tmp_1 = _cursor.getInt(_cursorIndexOfIsSelfi);
        _tmpIsSelfi = _tmp_1 != 0;
        _result.setSelfi(_tmpIsSelfi);
      } else {
        _result = null;
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public int getNextPrimaryId() {
    final String _sql = "select max(picture_id) as max_picture_id from ticket_pictures";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _result;
      if(_cursor.moveToFirst()) {
        _result = _cursor.getInt(0);
      } else {
        _result = 0;
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public List<TicketPicture> getTicketPicturePending(final long citation) {
    final String _sql = "select * from ticket_pictures where citation_number=? AND sync_status='P'";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, citation);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfSNo = CursorUtil.getColumnIndexOrThrow(_cursor, "s_no");
      final int _cursorIndexOfPictureId = CursorUtil.getColumnIndexOrThrow(_cursor, "picture_id");
      final int _cursorIndexOfTicketId = CursorUtil.getColumnIndexOrThrow(_cursor, "ticket_id");
      final int _cursorIndexOfCitationNumber = CursorUtil.getColumnIndexOrThrow(_cursor, "citation_number");
      final int _cursorIndexOfCustId = CursorUtil.getColumnIndexOrThrow(_cursor, "custid");
      final int _cursorIndexOfPictureDate = CursorUtil.getColumnIndexOrThrow(_cursor, "picture_date");
      final int _cursorIndexOfMarkPrint = CursorUtil.getColumnIndexOrThrow(_cursor, "mark_print");
      final int _cursorIndexOfImagePath = CursorUtil.getColumnIndexOrThrow(_cursor, "image_path");
      final int _cursorIndexOfImageResolution = CursorUtil.getColumnIndexOrThrow(_cursor, "image_resolution");
      final int _cursorIndexOfImageSize = CursorUtil.getColumnIndexOrThrow(_cursor, "image_size");
      final int _cursorIndexOfSyncStatus = CursorUtil.getColumnIndexOrThrow(_cursor, "sync_status");
      final int _cursorIndexOfDownloadImageUrl = CursorUtil.getColumnIndexOrThrow(_cursor, "download_image_url");
      final int _cursorIndexOfImageName = CursorUtil.getColumnIndexOrThrow(_cursor, "image_name");
      final int _cursorIndexOfIsSelfi = CursorUtil.getColumnIndexOrThrow(_cursor, "isSelfi");
      final List<TicketPicture> _result = new ArrayList<TicketPicture>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final TicketPicture _item;
        _item = new TicketPicture();
        final int _tmpS_no;
        _tmpS_no = _cursor.getInt(_cursorIndexOfSNo);
        _item.setS_no(_tmpS_no);
        final int _tmpPictureId;
        _tmpPictureId = _cursor.getInt(_cursorIndexOfPictureId);
        _item.setPictureId(_tmpPictureId);
        final long _tmpTicketId;
        _tmpTicketId = _cursor.getLong(_cursorIndexOfTicketId);
        _item.setTicketId(_tmpTicketId);
        final long _tmpCitationNumber;
        _tmpCitationNumber = _cursor.getLong(_cursorIndexOfCitationNumber);
        _item.setCitationNumber(_tmpCitationNumber);
        final int _tmpCustId;
        _tmpCustId = _cursor.getInt(_cursorIndexOfCustId);
        _item.setCustId(_tmpCustId);
        final Date _tmpPictureDate;
        final Long _tmp;
        if (_cursor.isNull(_cursorIndexOfPictureDate)) {
          _tmp = null;
        } else {
          _tmp = _cursor.getLong(_cursorIndexOfPictureDate);
        }
        _tmpPictureDate = Converters.fromTimestamp(_tmp);
        _item.setPictureDate(_tmpPictureDate);
        final String _tmpMarkPrint;
        if (_cursor.isNull(_cursorIndexOfMarkPrint)) {
          _tmpMarkPrint = null;
        } else {
          _tmpMarkPrint = _cursor.getString(_cursorIndexOfMarkPrint);
        }
        _item.setMarkPrint(_tmpMarkPrint);
        final String _tmpImagePath;
        if (_cursor.isNull(_cursorIndexOfImagePath)) {
          _tmpImagePath = null;
        } else {
          _tmpImagePath = _cursor.getString(_cursorIndexOfImagePath);
        }
        _item.setImagePath(_tmpImagePath);
        final String _tmpImageResolution;
        if (_cursor.isNull(_cursorIndexOfImageResolution)) {
          _tmpImageResolution = null;
        } else {
          _tmpImageResolution = _cursor.getString(_cursorIndexOfImageResolution);
        }
        _item.setImageResolution(_tmpImageResolution);
        final String _tmpImageSize;
        if (_cursor.isNull(_cursorIndexOfImageSize)) {
          _tmpImageSize = null;
        } else {
          _tmpImageSize = _cursor.getString(_cursorIndexOfImageSize);
        }
        _item.setImageSize(_tmpImageSize);
        final String _tmpSyncStatus;
        if (_cursor.isNull(_cursorIndexOfSyncStatus)) {
          _tmpSyncStatus = null;
        } else {
          _tmpSyncStatus = _cursor.getString(_cursorIndexOfSyncStatus);
        }
        _item.setSyncStatus(_tmpSyncStatus);
        final String _tmpDownloadImageUrl;
        if (_cursor.isNull(_cursorIndexOfDownloadImageUrl)) {
          _tmpDownloadImageUrl = null;
        } else {
          _tmpDownloadImageUrl = _cursor.getString(_cursorIndexOfDownloadImageUrl);
        }
        _item.setDownloadImageUrl(_tmpDownloadImageUrl);
        final String _tmpImageName;
        if (_cursor.isNull(_cursorIndexOfImageName)) {
          _tmpImageName = null;
        } else {
          _tmpImageName = _cursor.getString(_cursorIndexOfImageName);
        }
        _item.setImageName(_tmpImageName);
        final boolean _tmpIsSelfi;
        final int _tmp_1;
        _tmp_1 = _cursor.getInt(_cursorIndexOfIsSelfi);
        _tmpIsSelfi = _tmp_1 != 0;
        _item.setSelfi(_tmpIsSelfi);
        _result.add(_item);
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