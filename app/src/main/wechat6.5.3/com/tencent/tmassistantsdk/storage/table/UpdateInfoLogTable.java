package com.tencent.tmassistantsdk.storage.table;

public class UpdateInfoLogTable extends BaseLogTable {
    private static final String CREATE_TABLE_SQL = "CREATE TABLE if not exists SelfUpdateInfoLogData( _id INTEGER PRIMARY KEY AUTOINCREMENT, logData BLOB );";
    private static final String INSERT_SQL = "INSERT INTO SelfUpdateInfoLogData logData = ?";
    private static final String TABLE_NAME = "SelfUpdateInfoLogData";
    private static UpdateInfoLogTable mInstance = null;

    public static synchronized UpdateInfoLogTable getInstance() {
        UpdateInfoLogTable updateInfoLogTable;
        synchronized (UpdateInfoLogTable.class) {
            if (mInstance == null) {
                mInstance = new UpdateInfoLogTable();
            }
            updateInfoLogTable = mInstance;
        }
        return updateInfoLogTable;
    }

    protected String getTableName() {
        return TABLE_NAME;
    }

    protected String getCreateTableSQL() {
        return CREATE_TABLE_SQL;
    }

    protected String getInsertSQL() {
        return INSERT_SQL;
    }

    protected String[] getAlterSQL(int i) {
        if (i <= 1) {
            return null;
        }
        return new String[]{getCreateTableSQL()};
    }
}
