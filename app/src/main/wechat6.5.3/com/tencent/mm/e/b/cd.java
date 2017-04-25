package com.tencent.mm.e.b;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.h.c;

public abstract class cd extends c {
    private static final int bPb = "cardUserId".hashCode();
    private static final int bPc = "retryCount".hashCode();
    public static final String[] btd = new String[0];
    private static final int btm = "rowid".hashCode();
    private boolean bOZ = true;
    private boolean bPa = true;
    public String field_cardUserId;
    public int field_retryCount;

    public final void b(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (bPb == hashCode) {
                    this.field_cardUserId = cursor.getString(i);
                    this.bOZ = true;
                } else if (bPc == hashCode) {
                    this.field_retryCount = cursor.getInt(i);
                } else if (btm == hashCode) {
                    this.nmb = cursor.getLong(i);
                }
            }
        }
    }

    public final ContentValues py() {
        ContentValues contentValues = new ContentValues();
        if (this.bOZ) {
            contentValues.put("cardUserId", this.field_cardUserId);
        }
        if (this.bPa) {
            contentValues.put("retryCount", Integer.valueOf(this.field_retryCount));
        }
        if (this.nmb > 0) {
            contentValues.put("rowid", Long.valueOf(this.nmb));
        }
        return contentValues;
    }
}
