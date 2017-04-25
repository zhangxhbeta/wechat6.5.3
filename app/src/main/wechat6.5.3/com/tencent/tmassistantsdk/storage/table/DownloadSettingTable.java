package com.tencent.tmassistantsdk.storage.table;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.tmassistantsdk.storage.helper.AstSDKDBHelper_V2;
import com.tencent.tmassistantsdk.storage.helper.SqliteHelper;
import java.util.HashMap;

public class DownloadSettingTable implements ITableBase {
    public static final String CREATE_TABLE_SQL = "CREATE TABLE if not exists settingInfo( _id INTEGER PRIMARY KEY AUTOINCREMENT, settingField TEXT , value TEXT,type TEXT);";
    public static final String QUERY_SQL = "select * from settingInfo";
    public static final String TABLE_NAME = "settingInfo";
    private static final String TAG = "DownloadSettingTable";

    public class Columns {
        public static final String SETTINGFIELD = "settingField";
        public static final String TYPE = "type";
        public static final String VALUE = "value";
    }

    public static void save(String str, String str2, String str3) {
        if (str != null && str2 != null) {
            try {
                SQLiteDatabase writableDatabase = AstSDKDBHelper_V2.getInstance().getWritableDatabase();
                if (update(str, str2, str3, writableDatabase) <= 0) {
                    ContentValues contentValues = new ContentValues();
                    contentValues.put(Columns.SETTINGFIELD, str);
                    contentValues.put(Columns.VALUE, str2);
                    contentValues.put(Columns.TYPE, str3);
                    writableDatabase.insert(TABLE_NAME, null, contentValues);
                }
            } catch (Throwable e) {
                v.a(TAG, e, "", new Object[0]);
            }
        }
    }

    private static int update(String str, String str2, String str3, SQLiteDatabase sQLiteDatabase) {
        if (str == null || str2 == null) {
            return -1;
        }
        try {
            ContentValues contentValues = new ContentValues();
            contentValues.put(Columns.SETTINGFIELD, str);
            contentValues.put(Columns.VALUE, str2);
            contentValues.put(Columns.TYPE, str3);
            int update = sQLiteDatabase.update(TABLE_NAME, contentValues, "settingField = ?", new String[]{str});
            if (update <= 0) {
                return 0;
            }
            return update;
        } catch (Throwable e) {
            v.a(TAG, e, "", new Object[0]);
            return -2;
        }
    }

    public static HashMap<String, String> query() {
        Cursor cursor = null;
        HashMap<String, String> hashMap = new HashMap();
        try {
            cursor = AstSDKDBHelper_V2.getInstance().getReadableDatabase().rawQuery(QUERY_SQL, null);
            if (cursor == null || !cursor.moveToFirst()) {
                if (cursor != null) {
                    cursor.close();
                }
                return hashMap;
            }
            do {
                hashMap.put(cursor.getString(cursor.getColumnIndex(Columns.SETTINGFIELD)), cursor.getString(cursor.getColumnIndex(Columns.VALUE)));
            } while (cursor.moveToNext());
            if (cursor != null) {
                cursor.close();
            }
            return hashMap;
        } catch (Throwable e) {
            v.a(TAG, e, "", new Object[0]);
            if (cursor != null) {
                cursor.close();
            }
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
        }
    }

    public String tableName() {
        return TABLE_NAME;
    }

    public String createTableSQL() {
        return CREATE_TABLE_SQL;
    }

    public String[] getAlterSQL(int i, int i2) {
        return null;
    }

    public SqliteHelper getHelper() {
        return AstSDKDBHelper_V2.getInstance();
    }

    public void dataMovement(SQLiteDatabase sQLiteDatabase, SQLiteDatabase sQLiteDatabase2) {
    }
}
