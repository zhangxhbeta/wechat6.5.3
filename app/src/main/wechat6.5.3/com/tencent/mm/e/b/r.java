package com.tencent.mm.e.b;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.h.c;
import com.tencent.mmdb.database.SQLiteDatabase;

public abstract class r extends c {
    private static final int btE = "startTime".hashCode();
    private static final int btF = "endTime".hashCode();
    public static final String[] btd = new String[0];
    private static final int btm = "rowid".hashCode();
    private static final int byb = "msgDataId".hashCode();
    private static final int byc = "bakchatName".hashCode();
    private static final int byd = "nickName".hashCode();
    private boolean btw = true;
    private boolean btx = true;
    private boolean bxY = true;
    private boolean bxZ = true;
    private boolean bya = true;
    public String field_bakchatName;
    public long field_endTime;
    public String field_msgDataId;
    public String field_nickName;
    public long field_startTime;

    public final void b(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (byb == hashCode) {
                    this.field_msgDataId = cursor.getString(i);
                    this.bxY = true;
                } else if (byc == hashCode) {
                    this.field_bakchatName = cursor.getString(i);
                } else if (btE == hashCode) {
                    this.field_startTime = cursor.getLong(i);
                } else if (btF == hashCode) {
                    this.field_endTime = cursor.getLong(i);
                } else if (byd == hashCode) {
                    this.field_nickName = cursor.getString(i);
                } else if (btm == hashCode) {
                    this.nmb = cursor.getLong(i);
                }
            }
        }
    }

    public final ContentValues py() {
        ContentValues contentValues = new ContentValues();
        if (this.bxY) {
            contentValues.put("msgDataId", this.field_msgDataId);
        }
        if (this.field_bakchatName == null) {
            this.field_bakchatName = SQLiteDatabase.KeyEmpty;
        }
        if (this.bxZ) {
            contentValues.put("bakchatName", this.field_bakchatName);
        }
        if (this.btw) {
            contentValues.put("startTime", Long.valueOf(this.field_startTime));
        }
        if (this.btx) {
            contentValues.put("endTime", Long.valueOf(this.field_endTime));
        }
        if (this.field_nickName == null) {
            this.field_nickName = SQLiteDatabase.KeyEmpty;
        }
        if (this.bya) {
            contentValues.put("nickName", this.field_nickName);
        }
        if (this.nmb > 0) {
            contentValues.put("rowid", Long.valueOf(this.nmb));
        }
        return contentValues;
    }
}
