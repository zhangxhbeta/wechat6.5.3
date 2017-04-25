package com.tencent.mm.e.b;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.h.c;

public abstract class br extends c {
    private static final int bLT = "countryCode".hashCode();
    private static final int bLU = "callTimeCount".hashCode();
    private static final int bLV = "lastCallTime".hashCode();
    public static final String[] btd = new String[0];
    private static final int btm = "rowid".hashCode();
    private boolean bLQ = true;
    private boolean bLR = true;
    private boolean bLS = true;
    public long field_callTimeCount;
    public int field_countryCode;
    public long field_lastCallTime;

    public final void b(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (bLT == hashCode) {
                    this.field_countryCode = cursor.getInt(i);
                    this.bLQ = true;
                } else if (bLU == hashCode) {
                    this.field_callTimeCount = cursor.getLong(i);
                } else if (bLV == hashCode) {
                    this.field_lastCallTime = cursor.getLong(i);
                } else if (btm == hashCode) {
                    this.nmb = cursor.getLong(i);
                }
            }
        }
    }

    public final ContentValues py() {
        ContentValues contentValues = new ContentValues();
        if (this.bLQ) {
            contentValues.put("countryCode", Integer.valueOf(this.field_countryCode));
        }
        if (this.bLR) {
            contentValues.put("callTimeCount", Long.valueOf(this.field_callTimeCount));
        }
        if (this.bLS) {
            contentValues.put("lastCallTime", Long.valueOf(this.field_lastCallTime));
        }
        if (this.nmb > 0) {
            contentValues.put("rowid", Long.valueOf(this.nmb));
        }
        return contentValues;
    }
}
