package com.tencent.mm.e.b;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.h.c;

public abstract class bb extends c {
    private static final int bHd = "id".hashCode();
    private static final int bIQ = "protocolNumber".hashCode();
    private static final int bIR = "logContent".hashCode();
    public static final String[] btd = new String[0];
    private static final int btm = "rowid".hashCode();
    private static final int bun = "createTime".hashCode();
    private boolean bGO = true;
    private boolean bIO = true;
    private boolean bIP = true;
    private boolean btS = true;
    public long field_createTime;
    public String field_id;
    public String field_logContent;
    public int field_protocolNumber;

    public final void b(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (bHd == hashCode) {
                    this.field_id = cursor.getString(i);
                    this.bGO = true;
                } else if (bIQ == hashCode) {
                    this.field_protocolNumber = cursor.getInt(i);
                } else if (bIR == hashCode) {
                    this.field_logContent = cursor.getString(i);
                } else if (bun == hashCode) {
                    this.field_createTime = cursor.getLong(i);
                } else if (btm == hashCode) {
                    this.nmb = cursor.getLong(i);
                }
            }
        }
    }

    public final ContentValues py() {
        ContentValues contentValues = new ContentValues();
        if (this.bGO) {
            contentValues.put("id", this.field_id);
        }
        if (this.bIO) {
            contentValues.put("protocolNumber", Integer.valueOf(this.field_protocolNumber));
        }
        if (this.bIP) {
            contentValues.put("logContent", this.field_logContent);
        }
        if (this.btS) {
            contentValues.put("createTime", Long.valueOf(this.field_createTime));
        }
        if (this.nmb > 0) {
            contentValues.put("rowid", Long.valueOf(this.nmb));
        }
        return contentValues;
    }
}
