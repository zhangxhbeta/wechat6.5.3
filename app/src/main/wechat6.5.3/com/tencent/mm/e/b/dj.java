package com.tencent.mm.e.b;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.h.c;

public abstract class dj extends c {
    private static final int bJA = "expireTime".hashCode();
    private static final int bWE = "host".hashCode();
    public static final String[] btd = new String[0];
    private static final int btm = "rowid".hashCode();
    private boolean bJs = true;
    private boolean bWD = true;
    public long field_expireTime;
    public String field_host;

    public final void b(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (bWE == hashCode) {
                    this.field_host = cursor.getString(i);
                } else if (bJA == hashCode) {
                    this.field_expireTime = cursor.getLong(i);
                } else if (btm == hashCode) {
                    this.nmb = cursor.getLong(i);
                }
            }
        }
    }

    public final ContentValues py() {
        ContentValues contentValues = new ContentValues();
        if (this.bWD) {
            contentValues.put("host", this.field_host);
        }
        if (this.bJs) {
            contentValues.put("expireTime", Long.valueOf(this.field_expireTime));
        }
        if (this.nmb > 0) {
            contentValues.put("rowid", Long.valueOf(this.nmb));
        }
        return contentValues;
    }
}
