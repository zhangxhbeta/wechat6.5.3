package com.tencent.tmassistantsdk.storage.table;

public class TipsInfoLogTable extends BaseLogTable {
    public static final String CREATE_TABLE_SQL = "CREATE TABLE if not exists TipsInfoLogData( _id INTEGER PRIMARY KEY AUTOINCREMENT, logData BLOB );";
    protected static final String SQL_INSERT = "INSERT INTO TipsInfoLogData logData = ?";
    public static final String TABLE_NAME = "TipsInfoLogData";
    protected static TipsInfoLogTable mInstance = null;

    public static synchronized TipsInfoLogTable getInstance() {
        TipsInfoLogTable tipsInfoLogTable;
        synchronized (TipsInfoLogTable.class) {
            if (mInstance == null) {
                mInstance = new TipsInfoLogTable();
            }
            tipsInfoLogTable = mInstance;
        }
        return tipsInfoLogTable;
    }

    protected String getTableName() {
        return TABLE_NAME;
    }

    protected String getCreateTableSQL() {
        return CREATE_TABLE_SQL;
    }

    protected String getInsertSQL() {
        return SQL_INSERT;
    }

    protected String[] getAlterSQL(int i) {
        if (i <= 1) {
            return null;
        }
        return new String[]{getCreateTableSQL()};
    }
}
