package com.tencent.mm.e.b;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.h.c;

public abstract class q extends c {
    private static final int btE = "startTime".hashCode();
    private static final int btF = "endTime".hashCode();
    public static final String[] btd = new String[0];
    private static final int btm = "rowid".hashCode();
    private static final int bxX = "sessionName".hashCode();
    private boolean btw = true;
    private boolean btx = true;
    private boolean bxW = true;
    public long field_endTime;
    public String field_sessionName;
    public long field_startTime;

    public final void b(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (bxX == hashCode) {
                    this.field_sessionName = cursor.getString(i);
                    this.bxW = true;
                } else if (btE == hashCode) {
                    this.field_startTime = cursor.getLong(i);
                } else if (btF == hashCode) {
                    this.field_endTime = cursor.getLong(i);
                } else if (btm == hashCode) {
                    this.nmb = cursor.getLong(i);
                }
            }
        }
    }

    public final ContentValues py() {
        ContentValues contentValues = new ContentValues();
        if (this.bxW) {
            contentValues.put("sessionName", this.field_sessionName);
        }
        if (this.btw) {
            contentValues.put("startTime", Long.valueOf(this.field_startTime));
        }
        if (this.btx) {
            contentValues.put("endTime", Long.valueOf(this.field_endTime));
        }
        if (this.nmb > 0) {
            contentValues.put("rowid", Long.valueOf(this.nmb));
        }
        return contentValues;
    }
}
