package com.tencent.tmassistantsdk.storage.table;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.tmassistantsdk.storage.helper.AstSDKDBHelper_V2;
import com.tencent.tmassistantsdk.storage.helper.SqliteHelper;
import com.tencent.tmassistantsdk.storage.model.ClientInfo;
import java.util.ArrayList;

public class ClientInfoTable implements ITableBase {
    public static final String CREATE_TABLE_SQL = "CREATE TABLE if not exists clientinfo( _id INTEGER PRIMARY KEY AUTOINCREMENT, clientId TEXT , taskId INTEGER, taskUrl TEXT);";
    public static final String QUERY_CLIENTINFO = "select * from clientinfo where clientId = ?";
    public static final String QUERY_CLIENTINFO_ALL = "select * from clientinfo";
    public static final String TABLE_NAME = "clientinfo";
    private static final String TAG = "ClientInfoTable";

    public class Columns {
        public static final String CLIENTID = "clientId";
        public static final String TASKID = "taskId";
        public static final String TASKURL = "taskUrl";
    }

    private static void fillValues(ContentValues contentValues, ClientInfo clientInfo) {
        if (clientInfo != null) {
            contentValues.put(Columns.CLIENTID, clientInfo.clientId);
            contentValues.put("taskId", Integer.valueOf(clientInfo.taskId));
            contentValues.put("taskUrl", clientInfo.taskUrl);
        }
    }

    private static ClientInfo cursor2object(Cursor cursor) {
        ClientInfo clientInfo = new ClientInfo();
        clientInfo.clientId = cursor.getString(cursor.getColumnIndex(Columns.CLIENTID));
        clientInfo.taskId = cursor.getInt(cursor.getColumnIndex("taskId"));
        clientInfo.taskUrl = cursor.getString(cursor.getColumnIndex("taskUrl"));
        return clientInfo;
    }

    public static void save(ClientInfo clientInfo) {
        if (clientInfo != null) {
            try {
                SQLiteDatabase writableDatabase = AstSDKDBHelper_V2.getInstance().getWritableDatabase();
                if (update(clientInfo, writableDatabase) <= 0) {
                    ContentValues contentValues = new ContentValues();
                    fillValues(contentValues, clientInfo);
                    writableDatabase.insert(TABLE_NAME, null, contentValues);
                }
            } catch (Throwable e) {
                v.a(TAG, e, "", new Object[0]);
            }
        }
    }

    public static void save(String str, String str2) {
        ClientInfo clientInfo = new ClientInfo();
        clientInfo.clientId = str;
        clientInfo.taskUrl = str2;
        save(clientInfo);
    }

    private static int update(ClientInfo clientInfo, SQLiteDatabase sQLiteDatabase) {
        if (clientInfo == null) {
            return -1;
        }
        try {
            ContentValues contentValues = new ContentValues();
            fillValues(contentValues, clientInfo);
            int update = sQLiteDatabase.update(TABLE_NAME, contentValues, "clientId = ? and taskUrl = ?", new String[]{clientInfo.clientId, clientInfo.taskUrl});
            if (update <= 0) {
                return 0;
            }
            return update;
        } catch (Throwable e) {
            v.a(TAG, e, "", new Object[0]);
            return -2;
        }
    }

    public static ArrayList<ClientInfo> query(String str) {
        Cursor rawQuery;
        Throwable e;
        if (str != null) {
            ArrayList<ClientInfo> arrayList = new ArrayList();
            SQLiteDatabase readableDatabase = AstSDKDBHelper_V2.getInstance().getReadableDatabase();
            try {
                rawQuery = readableDatabase.rawQuery(QUERY_CLIENTINFO, new String[]{str});
                if (rawQuery != null) {
                    try {
                        if (rawQuery.moveToFirst()) {
                            do {
                                arrayList.add(cursor2object(rawQuery));
                            } while (rawQuery.moveToNext());
                        }
                    } catch (Exception e2) {
                        e = e2;
                        try {
                            v.a(TAG, e, "", new Object[0]);
                            if (rawQuery != null) {
                                rawQuery.close();
                            }
                            return null;
                        } catch (Throwable th) {
                            e = th;
                            if (rawQuery != null) {
                                rawQuery.close();
                            }
                            throw e;
                        }
                    }
                }
                if (rawQuery == null) {
                    return arrayList;
                }
                rawQuery.close();
                return arrayList;
            } catch (Exception e3) {
                e = e3;
                rawQuery = null;
                v.a(TAG, e, "", new Object[0]);
                if (rawQuery != null) {
                    rawQuery.close();
                }
                return null;
            } catch (Throwable th2) {
                e = th2;
                rawQuery = null;
                if (rawQuery != null) {
                    rawQuery.close();
                }
                throw e;
            }
        }
        return null;
    }

    public static void delete(String str, String str2) {
        if (str != null && str2 != null) {
            try {
                AstSDKDBHelper_V2.getInstance().getWritableDatabase().delete(TABLE_NAME, "clientId = ? and taskUrl = ?", new String[]{str, str2});
            } catch (Throwable e) {
                v.a(TAG, e, "", new Object[0]);
            }
        }
    }

    public static void deleteItemsByURL(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                AstSDKDBHelper_V2.getInstance().getWritableDatabase().delete(TABLE_NAME, "taskUrl = ?", new String[]{str});
            } catch (Throwable e) {
                v.a(TAG, e, "", new Object[0]);
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
        Cursor cursor = null;
        if (sQLiteDatabase2 != null && sQLiteDatabase != null) {
            sQLiteDatabase2.beginTransaction();
            try {
                cursor = sQLiteDatabase.rawQuery(QUERY_CLIENTINFO_ALL, null);
                if (cursor == null || !cursor.moveToFirst()) {
                    if (cursor != null) {
                        cursor.close();
                    }
                    sQLiteDatabase2.setTransactionSuccessful();
                    sQLiteDatabase2.endTransaction();
                }
                do {
                    ContentValues contentValues = new ContentValues();
                    fillValues(contentValues, cursor2object(cursor));
                    sQLiteDatabase2.insert(TABLE_NAME, null, contentValues);
                } while (cursor.moveToNext());
                if (cursor != null) {
                    cursor.close();
                }
                sQLiteDatabase2.setTransactionSuccessful();
                sQLiteDatabase2.endTransaction();
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
    }
}
