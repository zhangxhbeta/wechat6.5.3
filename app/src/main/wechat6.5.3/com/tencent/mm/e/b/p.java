package com.tencent.mm.e.b;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.h.c;
import com.tencent.mmdb.database.SQLiteDatabase;

public abstract class p extends c {
    public static final String[] btd = new String[0];
    private static final int btm = "rowid".hashCode();
    private static final int buZ = "appId".hashCode();
    private static final int bxU = "flag".hashCode();
    private static final int bxV = "sortId".hashCode();
    private boolean buI = true;
    private boolean bxS = true;
    private boolean bxT = true;
    public String field_appId;
    public long field_flag;
    public int field_sortId;

    public final void b(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (bxU == hashCode) {
                    this.field_flag = cursor.getLong(i);
                } else if (buZ == hashCode) {
                    this.field_appId = cursor.getString(i);
                } else if (bxV == hashCode) {
                    this.field_sortId = cursor.getInt(i);
                } else if (btm == hashCode) {
                    this.nmb = cursor.getLong(i);
                }
            }
        }
    }

    public final ContentValues py() {
        ContentValues contentValues = new ContentValues();
        if (this.bxS) {
            contentValues.put("flag", Long.valueOf(this.field_flag));
        }
        if (this.field_appId == null) {
            this.field_appId = SQLiteDatabase.KeyEmpty;
        }
        if (this.buI) {
            contentValues.put("appId", this.field_appId);
        }
        if (this.bxT) {
            contentValues.put("sortId", Integer.valueOf(this.field_sortId));
        }
        if (this.nmb > 0) {
            contentValues.put("rowid", Long.valueOf(this.nmb));
        }
        return contentValues;
    }
}
