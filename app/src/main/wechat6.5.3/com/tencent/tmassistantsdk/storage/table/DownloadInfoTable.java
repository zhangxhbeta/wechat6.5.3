package com.tencent.tmassistantsdk.storage.table;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.tmassistantsdk.downloadservice.DownloadInfo;
import com.tencent.tmassistantsdk.downloadservice.taskmanager.ServiceDownloadTask;
import com.tencent.tmassistantsdk.storage.helper.AstSDKDBHelper_V2;
import com.tencent.tmassistantsdk.storage.helper.SqliteHelper;
import com.tencent.tmassistantsdk.storage.table.ClientInfoTable.Columns;
import com.tencent.tmassistantsdk.util.TMLog;
import java.util.ArrayList;
import java.util.Iterator;

public class DownloadInfoTable implements ITableBase {
    public static final String CREATE_TABLE_SQL = "CREATE TABLE if not exists downloadInfo( _id INTEGER PRIMARY KEY AUTOINCREMENT, taskId INTEGER , uId TEXT, taskUrl TEXT, finalUrl TEXT, fileName TEXT, contentType TEXT, redirectCnt INTEGER, retryCnt INTEGER, totalBytes INTEGER,status INTEGER,receivedBytes INTEGER,priority INTEGER,netType TEXT,downloadFailedErrCode INTEGER,downloadFailedTime INTEGER,headerParams TEXT);";
    public static final String QUERY_ALL = "select * from downloadInfo";
    public static final String QUERY_DOWNLOADINFO_URL = "select * from downloadInfo where taskUrl = ?";
    public static final String QUERY_UNFINISHED_TASK = "select a.taskUrl,a.status,b.clientId from downloadInfo as a left outer join clientinfo as b on a.taskUrl = b.taskUrl where b.clientId is not null and (a.status = 2 or a.status = 1)";
    public static final String TABLE_NAME = "downloadInfo";
    private static final String TAG = "DownloadInfoTable";

    public String tableName() {
        return TABLE_NAME;
    }

    public String createTableSQL() {
        return CREATE_TABLE_SQL;
    }

    public String[] getAlterSQL(int i, int i2) {
        if (i == 1 && i2 == 2) {
            return new String[]{"alter table downloadInfo add column headerParams TEXT;"};
        }
        return new String[]{"alter table downloadInfo add column netType TEXT;", "alter table downloadInfo add column downloadFailedErrCode INTEGER;", "alter table downloadInfo add column downloadFailedTime INTEGER;"};
    }

    public SqliteHelper getHelper() {
        return AstSDKDBHelper_V2.getInstance();
    }

    public static ArrayList<DownloadInfo> load() {
        Cursor cursor = null;
        ArrayList<DownloadInfo> arrayList = new ArrayList();
        try {
            cursor = AstSDKDBHelper_V2.getInstance().getReadableDatabase().rawQuery(QUERY_ALL, null);
            if (cursor == null || !cursor.moveToFirst()) {
                if (cursor != null) {
                    cursor.close();
                }
                return arrayList;
            }
            do {
                arrayList.add(DownloadInfo.readFromCursor(cursor));
            } while (cursor.moveToNext());
            if (cursor != null) {
                cursor.close();
            }
            return arrayList;
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

    public static void save(ArrayList<DownloadInfo> arrayList) {
        if (arrayList != null) {
            SQLiteDatabase writableDatabase = AstSDKDBHelper_V2.getInstance().getWritableDatabase();
            try {
                writableDatabase.beginTransaction();
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    DownloadInfo downloadInfo = (DownloadInfo) it.next();
                    if (update(downloadInfo, writableDatabase) <= 0) {
                        ContentValues contentValues = new ContentValues();
                        DownloadInfo.writeToContentValues(contentValues, downloadInfo);
                        writableDatabase.insert(TABLE_NAME, null, contentValues);
                    }
                }
                writableDatabase.setTransactionSuccessful();
            } catch (Throwable e) {
                v.a(TAG, e, "", new Object[0]);
            } finally {
                writableDatabase.endTransaction();
            }
        }
    }

    public static void add(DownloadInfo downloadInfo) {
        if (downloadInfo != null) {
            try {
                SQLiteDatabase writableDatabase = AstSDKDBHelper_V2.getInstance().getWritableDatabase();
                if (update(downloadInfo, writableDatabase) <= 0) {
                    ContentValues contentValues = new ContentValues();
                    DownloadInfo.writeToContentValues(contentValues, downloadInfo);
                    writableDatabase.insert(TABLE_NAME, null, contentValues);
                }
            } catch (Throwable e) {
                v.a(TAG, e, "", new Object[0]);
            }
        }
    }

    public static void del(String str) {
        if (str != null && str.length() > 0) {
            try {
                AstSDKDBHelper_V2.getInstance().getWritableDatabase().delete(TABLE_NAME, "taskUrl = ?", new String[]{str});
            } catch (Throwable e) {
                v.a(TAG, e, "", new Object[0]);
            }
        }
    }

    private static int update(DownloadInfo downloadInfo, SQLiteDatabase sQLiteDatabase) {
        if (downloadInfo == null) {
            return -1;
        }
        try {
            ContentValues contentValues = new ContentValues();
            DownloadInfo.writeToContentValues(contentValues, downloadInfo);
            int update = sQLiteDatabase.update(TABLE_NAME, contentValues, "taskUrl = ?", new String[]{downloadInfo.mURL});
            if (update <= 0) {
                return 0;
            }
            return update;
        } catch (Throwable e) {
            v.a(TAG, e, "", new Object[0]);
            return -2;
        }
    }

    public static DownloadInfo query(String str) {
        Cursor rawQuery;
        Throwable e;
        Throwable th;
        DownloadInfo downloadInfo = null;
        if (str != null && str.length() > 0) {
            try {
                rawQuery = AstSDKDBHelper_V2.getInstance().getReadableDatabase().rawQuery(QUERY_DOWNLOADINFO_URL, new String[]{str});
                if (rawQuery != null) {
                    try {
                        if (rawQuery.moveToFirst()) {
                            downloadInfo = DownloadInfo.readFromCursor(rawQuery);
                            if (rawQuery != null) {
                                rawQuery.close();
                            }
                        }
                    } catch (Exception e2) {
                        e = e2;
                        try {
                            v.a(TAG, e, "", new Object[0]);
                            if (rawQuery != null) {
                                rawQuery.close();
                            }
                            return downloadInfo;
                        } catch (Throwable th2) {
                            th = th2;
                            if (rawQuery != null) {
                                rawQuery.close();
                            }
                            throw th;
                        }
                    }
                }
                if (rawQuery != null) {
                    rawQuery.close();
                }
            } catch (Exception e3) {
                e = e3;
                rawQuery = null;
                v.a(TAG, e, "", new Object[0]);
                if (rawQuery != null) {
                    rawQuery.close();
                }
                return downloadInfo;
            } catch (Throwable e4) {
                rawQuery = null;
                th = e4;
                if (rawQuery != null) {
                    rawQuery.close();
                }
                throw th;
            }
        }
        return downloadInfo;
    }

    public static ArrayList<ServiceDownloadTask> query() {
        Cursor cursor = null;
        ArrayList<ServiceDownloadTask> arrayList = new ArrayList();
        try {
            cursor = AstSDKDBHelper_V2.getInstance().getReadableDatabase().rawQuery(QUERY_UNFINISHED_TASK, null);
            if (cursor == null || !cursor.moveToFirst()) {
                if (cursor != null) {
                    cursor.close();
                }
                return arrayList;
            }
            do {
                String string = cursor.getString(cursor.getColumnIndex(Columns.CLIENTID));
                String string2 = cursor.getString(cursor.getColumnIndex("taskUrl"));
                int i = cursor.getInt(cursor.getColumnIndex(DownloadInfo.STATUS));
                ServiceDownloadTask serviceDownloadTask = new ServiceDownloadTask(string, string2);
                serviceDownloadTask.mState = i;
                arrayList.add(serviceDownloadTask);
            } while (cursor.moveToNext());
            if (cursor != null) {
                cursor.close();
            }
            return arrayList;
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

    public void dataMovement(SQLiteDatabase sQLiteDatabase, SQLiteDatabase sQLiteDatabase2) {
        Cursor cursor = null;
        if (sQLiteDatabase2 != null && sQLiteDatabase != null) {
            sQLiteDatabase2.beginTransaction();
            try {
                cursor = sQLiteDatabase.rawQuery(QUERY_ALL, null);
                if (cursor == null || !cursor.moveToFirst()) {
                    if (cursor != null) {
                        cursor.close();
                    }
                    sQLiteDatabase2.setTransactionSuccessful();
                    sQLiteDatabase2.endTransaction();
                }
                TMLog.i(TABLE_NAME, "start move data!");
                do {
                    ContentValues contentValues = new ContentValues();
                    DownloadInfo.writeToContentValues(contentValues, DownloadInfo.readFromSimpleCursor(cursor));
                    sQLiteDatabase2.insert(TABLE_NAME, null, contentValues);
                } while (cursor.moveToNext());
                if (cursor != null) {
                    cursor.close();
                }
                sQLiteDatabase2.setTransactionSuccessful();
                sQLiteDatabase2.endTransaction();
            } catch (Throwable e) {
                v.a(TAG, e, "", new Object[0]);
                TMLog.i(TABLE_NAME, "move data exception!");
                if (cursor != null) {
                    cursor.close();
                }
            } catch (Throwable th) {
                if (cursor != null) {
                    cursor.close();
                }
            }
        }
    }
}
