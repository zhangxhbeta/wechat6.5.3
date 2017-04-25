package com.tencent.tmassistantsdk.channel;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.os.Environment;
import android.os.SystemClock;
import java.io.File;
import java.util.ArrayList;

public class DBOption {
    protected static final String CREATE_TABLE_SQL = "CREATE TABLE if not exists channeldata( itemId INTEGER PRIMARY KEY AUTOINCREMENT, itemData BLOB);";
    protected static final int DATEBASE_VERSION = 1;
    protected static final String DB_NAME = ".SystemConfig.db";
    protected static final String QUERY_ALL_SQL = "select * from channeldata";
    protected static final String TABLE_NAME = "channeldata";
    protected String DB_PATH = "";

    public DBOption() {
        Object obj = ("mounted".equals(Environment.getExternalStorageState()) && Environment.getExternalStorageDirectory().canWrite()) ? 1 : null;
        if (obj != null) {
            this.DB_PATH = Environment.getExternalStorageDirectory().getPath() + "/tencent/assistant/";
            File file = new File(this.DB_PATH);
            if (!file.exists()) {
                file.mkdirs();
            }
            this.DB_PATH += DB_NAME;
        }
    }

    public long insert(TMAssistantSDKChannelDataItem tMAssistantSDKChannelDataItem) {
        if (tMAssistantSDKChannelDataItem == null) {
            return -1;
        }
        byte[] buffer = tMAssistantSDKChannelDataItem.getBuffer();
        if (buffer == null) {
            return -1;
        }
        SQLiteDatabase writableDatabase = getWritableDatabase();
        if (writableDatabase == null) {
            return -1;
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("itemData", buffer);
        long insert = writableDatabase.insert(TABLE_NAME, "", contentValues);
        closeDB(writableDatabase);
        return insert;
    }

    public boolean delete(long j) {
        SQLiteDatabase writableDatabase = getWritableDatabase();
        if (writableDatabase == null) {
            return false;
        }
        writableDatabase.delete(TABLE_NAME, "itemId=?", new String[]{String.valueOf(j)});
        closeDB(writableDatabase);
        return true;
    }

    public ArrayList<TMAssistantSDKChannelDataItem> queryAll() {
        ArrayList<TMAssistantSDKChannelDataItem> arrayList = null;
        SQLiteDatabase readableDatabase = getReadableDatabase();
        if (readableDatabase != null) {
            Cursor rawQuery = readableDatabase.rawQuery(QUERY_ALL_SQL, null);
            if (rawQuery != null && rawQuery.moveToFirst()) {
                int columnIndex = rawQuery.getColumnIndex("itemId");
                int columnIndex2 = rawQuery.getColumnIndex("itemData");
                arrayList = new ArrayList();
                do {
                    int i = rawQuery.getInt(columnIndex);
                    TMAssistantSDKChannelDataItem dataItemFromByte = TMAssistantSDKChannelDataItem.getDataItemFromByte(rawQuery.getBlob(columnIndex2));
                    if (dataItemFromByte != null) {
                        dataItemFromByte.mDBIdentity = i;
                        arrayList.add(dataItemFromByte);
                    }
                } while (rawQuery.moveToNext());
                closeDB(readableDatabase);
            }
            rawQuery.close();
            closeDB(readableDatabase);
        }
        return arrayList;
    }

    private SQLiteDatabase getWritableDatabase() {
        SQLiteDatabase sQLiteDatabase = null;
        for (int i = 0; i < 20; i++) {
            try {
                sQLiteDatabase = SQLiteDatabase.openOrCreateDatabase(this.DB_PATH, null);
            } catch (SQLiteException e) {
            }
            if (sQLiteDatabase != null) {
                checkAndCreateTable(sQLiteDatabase);
                break;
            }
            SystemClock.sleep(50);
        }
        return sQLiteDatabase;
    }

    private synchronized SQLiteDatabase getReadableDatabase() {
        SQLiteDatabase sQLiteDatabase = null;
        synchronized (this) {
            if (new File(this.DB_PATH).exists()) {
                for (int i = 0; i < 20; i++) {
                    try {
                        sQLiteDatabase = SQLiteDatabase.openDatabase(this.DB_PATH, null, 1);
                    } catch (SQLiteException e) {
                    }
                    if (sQLiteDatabase != null) {
                        break;
                    }
                    SystemClock.sleep(50);
                }
            }
        }
        return sQLiteDatabase;
    }

    private void closeDB(SQLiteDatabase sQLiteDatabase) {
        if (sQLiteDatabase != null && sQLiteDatabase.isOpen()) {
            try {
                sQLiteDatabase.close();
            } catch (Exception e) {
            }
        }
    }

    private void checkAndCreateTable(SQLiteDatabase sQLiteDatabase) {
        int version = sQLiteDatabase.getVersion();
        if (version != 1) {
            sQLiteDatabase.beginTransaction();
            if (version == 0) {
                try {
                    sQLiteDatabase.execSQL(CREATE_TABLE_SQL);
                } catch (Throwable th) {
                    sQLiteDatabase.endTransaction();
                }
            }
            sQLiteDatabase.setVersion(1);
            sQLiteDatabase.setTransactionSuccessful();
            sQLiteDatabase.endTransaction();
        }
    }
}
