package com.tencent.mm.e.b;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.h.c;

public abstract class cc extends c {
    private static final int bJC = "isRead".hashCode();
    private static final int bOY = "msgContentXml".hashCode();
    public static final String[] btd = new String[0];
    private static final int btl = "msgId".hashCode();
    private static final int btm = "rowid".hashCode();
    private boolean bJu = true;
    private boolean bOX = true;
    private boolean bth = true;
    public String field_isRead;
    public String field_msgContentXml;
    public String field_msgId;

    public final void b(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (btl == hashCode) {
                    this.field_msgId = cursor.getString(i);
                    this.bth = true;
                } else if (bOY == hashCode) {
                    this.field_msgContentXml = cursor.getString(i);
                } else if (bJC == hashCode) {
                    this.field_isRead = cursor.getString(i);
                } else if (btm == hashCode) {
                    this.nmb = cursor.getLong(i);
                }
            }
        }
    }

    public final ContentValues py() {
        ContentValues contentValues = new ContentValues();
        if (this.bth) {
            contentValues.put("msgId", this.field_msgId);
        }
        if (this.bOX) {
            contentValues.put("msgContentXml", this.field_msgContentXml);
        }
        if (this.bJu) {
            contentValues.put("isRead", this.field_isRead);
        }
        if (this.nmb > 0) {
            contentValues.put("rowid", Long.valueOf(this.nmb));
        }
        return contentValues;
    }
}
