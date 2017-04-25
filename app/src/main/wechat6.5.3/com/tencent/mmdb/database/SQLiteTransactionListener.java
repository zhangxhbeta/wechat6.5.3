package com.tencent.mmdb.database;

public interface SQLiteTransactionListener {
    void onBegin();

    void onCommit();

    void onRollback();
}
