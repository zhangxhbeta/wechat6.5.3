package com.tencent.tmassistantsdk.storage.table;

public class DownloadLogTable extends BaseLogTable {
    public static final String CREATE_TABLE_SQL = "CREATE TABLE if not exists downloadLogData( _id INTEGER PRIMARY KEY AUTOINCREMENT, logData BLOB );";
    protected static final String SQL_INSERT = "INSERT INTO downloadLogData logData = ?";
    public static final String TABLE_NAME = "downloadLogData";
    protected static DownloadLogTable mInstance = null;

    public static synchronized DownloadLogTable getInstance() {
        DownloadLogTable downloadLogTable;
        synchronized (DownloadLogTable.class) {
            if (mInstance == null) {
                mInstance = new DownloadLogTable();
            }
            downloadLogTable = mInstance;
        }
        return downloadLogTable;
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
        return new String[]{getCreateTableSQL()};
    }
}
