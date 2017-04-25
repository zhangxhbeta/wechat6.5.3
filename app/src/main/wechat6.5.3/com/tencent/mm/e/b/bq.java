package com.tencent.mm.e.b;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.h.c;

public abstract class bq extends c {
    private static final int bGw = "svrId".hashCode();
    private static final int bJC = "isRead".hashCode();
    private static final int bLO = "pushTime".hashCode();
    private static final int bLP = "descUrl".hashCode();
    public static final String[] btd = new String[0];
    private static final int btm = "rowid".hashCode();
    private static final int buv = "content".hashCode();
    private static final int bxP = "title".hashCode();
    private static final int byE = "msgType".hashCode();
    private boolean bGt = true;
    private boolean bJu = true;
    private boolean bLM = true;
    private boolean bLN = true;
    private boolean bua = true;
    private boolean bxL = true;
    private boolean byq = true;
    public String field_content;
    public String field_descUrl;
    public short field_isRead;
    public int field_msgType;
    public long field_pushTime;
    public long field_svrId;
    public String field_title;

    public final void b(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (bGw == hashCode) {
                    this.field_svrId = cursor.getLong(i);
                    this.bGt = true;
                } else if (bJC == hashCode) {
                    this.field_isRead = cursor.getShort(i);
                } else if (bxP == hashCode) {
                    this.field_title = cursor.getString(i);
                } else if (buv == hashCode) {
                    this.field_content = cursor.getString(i);
                } else if (bLO == hashCode) {
                    this.field_pushTime = cursor.getLong(i);
                } else if (byE == hashCode) {
                    this.field_msgType = cursor.getInt(i);
                } else if (bLP == hashCode) {
                    this.field_descUrl = cursor.getString(i);
                } else if (btm == hashCode) {
                    this.nmb = cursor.getLong(i);
                }
            }
        }
    }

    public final ContentValues py() {
        ContentValues contentValues = new ContentValues();
        if (this.bGt) {
            contentValues.put("svrId", Long.valueOf(this.field_svrId));
        }
        if (this.bJu) {
            contentValues.put("isRead", Short.valueOf(this.field_isRead));
        }
        if (this.bxL) {
            contentValues.put("title", this.field_title);
        }
        if (this.bua) {
            contentValues.put("content", this.field_content);
        }
        if (this.bLM) {
            contentValues.put("pushTime", Long.valueOf(this.field_pushTime));
        }
        if (this.byq) {
            contentValues.put("msgType", Integer.valueOf(this.field_msgType));
        }
        if (this.bLN) {
            contentValues.put("descUrl", this.field_descUrl);
        }
        if (this.nmb > 0) {
            contentValues.put("rowid", Long.valueOf(this.nmb));
        }
        return contentValues;
    }
}
