package com.tencent.mm.e.b;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.h.c;

public abstract class u extends c {
    public static final String[] btd = new String[0];
    private static final int btm = "rowid".hashCode();
    private static final int byt = "brandUserName".hashCode();
    private static final int bzf = "userId".hashCode();
    private boolean byf = true;
    private boolean bze = true;
    public String field_brandUserName;
    public String field_userId;

    public final void b(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (byt == hashCode) {
                    this.field_brandUserName = cursor.getString(i);
                    this.byf = true;
                } else if (bzf == hashCode) {
                    this.field_userId = cursor.getString(i);
                } else if (btm == hashCode) {
                    this.nmb = cursor.getLong(i);
                }
            }
        }
    }

    public final ContentValues py() {
        ContentValues contentValues = new ContentValues();
        if (this.byf) {
            contentValues.put("brandUserName", this.field_brandUserName);
        }
        if (this.bze) {
            contentValues.put("userId", this.field_userId);
        }
        if (this.nmb > 0) {
            contentValues.put("rowid", Long.valueOf(this.nmb));
        }
        return contentValues;
    }
}
