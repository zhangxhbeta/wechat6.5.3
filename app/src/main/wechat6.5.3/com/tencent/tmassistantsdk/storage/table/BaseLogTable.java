package com.tencent.tmassistantsdk.storage.table;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.tmassistantsdk.storage.helper.AstSDKDBHelper_V2;
import com.tencent.tmassistantsdk.storage.helper.SqliteHelper;
import java.util.ArrayList;
import java.util.List;

public abstract class BaseLogTable implements ITableBase {
    private static final String TAG = "BaseLogTable";

    public static class DataWrapper {
        public List<byte[]> dataList;
        public List<Long> idList;
    }

    protected abstract String[] getAlterSQL(int i);

    protected abstract String getCreateTableSQL();

    protected abstract String getInsertSQL();

    protected abstract String getTableName();

    public boolean save(byte[] bArr) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("logData", bArr);
        return getHelper().getWritableDatabase().insert(getTableName(), null, contentValues) > 0;
    }

    public boolean save(List<byte[]> list) {
        String str = true;
        SQLiteDatabase writableDatabase = getHelper().getWritableDatabase();
        try {
            writableDatabase.beginTransaction();
            SQLiteStatement compileStatement = writableDatabase.compileStatement(getInsertSQL());
            for (byte[] bindBlob : list) {
                compileStatement.bindBlob(1, bindBlob);
                compileStatement.executeInsert();
            }
            writableDatabase.setTransactionSuccessful();
            return str;
        } catch (Throwable e) {
            str = TAG;
            v.a(str, e, "", new Object[0]);
            return false;
        } finally {
            writableDatabase.endTransaction();
        }
    }

    public boolean delete(List<Long> list) {
        if (list == null || list.size() <= 0) {
            return false;
        }
        StringBuffer stringBuffer = new StringBuffer("(");
        for (Long append : list) {
            stringBuffer.append(append);
            stringBuffer.append(",");
        }
        if (stringBuffer.length() > 0) {
            stringBuffer.deleteCharAt(stringBuffer.length() - 1);
        }
        stringBuffer.append(")");
        getHelper().getWritableDatabase().delete(getTableName(), "_id in " + stringBuffer, null);
        return true;
    }

    public DataWrapper getDatas(int i) {
        String str;
        Throwable e;
        DataWrapper dataWrapper = new DataWrapper();
        dataWrapper.idList = new ArrayList();
        dataWrapper.dataList = new ArrayList();
        if (i > 0) {
            str = "0," + i;
        } else {
            str = null;
        }
        Cursor query;
        try {
            query = getHelper().getReadableDatabase().query(getTableName(), null, null, null, null, null, "_id asc", str);
            if (query != null) {
                try {
                    if (query.moveToFirst()) {
                        do {
                            dataWrapper.idList.add(Long.valueOf(query.getLong(query.getColumnIndex("_id"))));
                            dataWrapper.dataList.add(query.getBlob(query.getColumnIndex("logData")));
                        } while (query.moveToNext());
                    }
                } catch (Exception e2) {
                    e = e2;
                    try {
                        v.a(TAG, e, "", new Object[0]);
                        if (query != null) {
                            return null;
                        }
                        query.close();
                        return null;
                    } catch (Throwable th) {
                        e = th;
                        if (query != null) {
                            query.close();
                        }
                        throw e;
                    }
                }
            }
            if (query != null) {
                query.close();
            }
            return dataWrapper;
        } catch (Exception e3) {
            e = e3;
            query = null;
            v.a(TAG, e, "", new Object[0]);
            if (query != null) {
                return null;
            }
            query.close();
            return null;
        } catch (Throwable th2) {
            e = th2;
            query = null;
            if (query != null) {
                query.close();
            }
            throw e;
        }
    }

    public String tableName() {
        return getTableName();
    }

    public String createTableSQL() {
        return getCreateTableSQL();
    }

    public String[] getAlterSQL(int i, int i2) {
        return getAlterSQL(i2);
    }

    public SqliteHelper getHelper() {
        return AstSDKDBHelper_V2.getInstance();
    }

    public void dataMovement(SQLiteDatabase sQLiteDatabase, SQLiteDatabase sQLiteDatabase2) {
    }
}
