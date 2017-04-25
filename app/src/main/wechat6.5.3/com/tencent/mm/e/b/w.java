package com.tencent.mm.e.b;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.h.c;

public abstract class w extends c {
    public static final String[] btd = new String[0];
    private static final int btm = "rowid".hashCode();
    private static final int bul = "userName".hashCode();
    private static final int bzp = "qyUin".hashCode();
    private static final int bzq = "userUin".hashCode();
    private static final int bzr = "userFlag".hashCode();
    private boolean btQ = true;
    private boolean bzm = true;
    private boolean bzn = true;
    private boolean bzo = true;
    public int field_qyUin;
    public int field_userFlag;
    public String field_userName;
    public int field_userUin;

    public final void b(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (bul == hashCode) {
                    this.field_userName = cursor.getString(i);
                    this.btQ = true;
                } else if (bzp == hashCode) {
                    this.field_qyUin = cursor.getInt(i);
                } else if (bzq == hashCode) {
                    this.field_userUin = cursor.getInt(i);
                } else if (bzr == hashCode) {
                    this.field_userFlag = cursor.getInt(i);
                } else if (btm == hashCode) {
                    this.nmb = cursor.getLong(i);
                }
            }
        }
    }

    public final ContentValues py() {
        ContentValues contentValues = new ContentValues();
        if (this.btQ) {
            contentValues.put("userName", this.field_userName);
        }
        if (this.bzm) {
            contentValues.put("qyUin", Integer.valueOf(this.field_qyUin));
        }
        if (this.bzn) {
            contentValues.put("userUin", Integer.valueOf(this.field_userUin));
        }
        if (this.bzo) {
            contentValues.put("userFlag", Integer.valueOf(this.field_userFlag));
        }
        if (this.nmb > 0) {
            contentValues.put("rowid", Long.valueOf(this.nmb));
        }
        return contentValues;
    }
}
