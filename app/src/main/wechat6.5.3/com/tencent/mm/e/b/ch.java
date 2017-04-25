package com.tencent.mm.e.b;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.h.c;

public abstract class ch extends c {
    private static final int bEX = "name".hashCode();
    private static final int bMn = "createtime".hashCode();
    private static final int bQt = "uid".hashCode();
    private static final int bQu = "devicetype".hashCode();
    public static final String[] btd = new String[0];
    private static final int btm = "rowid".hashCode();
    private boolean bEB = true;
    private boolean bMi = true;
    private boolean bQr = true;
    private boolean bQs = true;
    public long field_createtime;
    public String field_devicetype;
    public String field_name;
    public String field_uid;

    public final void b(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (bQt == hashCode) {
                    this.field_uid = cursor.getString(i);
                    this.bQr = true;
                } else if (bEX == hashCode) {
                    this.field_name = cursor.getString(i);
                } else if (bQu == hashCode) {
                    this.field_devicetype = cursor.getString(i);
                } else if (bMn == hashCode) {
                    this.field_createtime = cursor.getLong(i);
                } else if (btm == hashCode) {
                    this.nmb = cursor.getLong(i);
                }
            }
        }
    }

    public final ContentValues py() {
        ContentValues contentValues = new ContentValues();
        if (this.field_uid == null) {
            this.field_uid = "";
        }
        if (this.bQr) {
            contentValues.put("uid", this.field_uid);
        }
        if (this.field_name == null) {
            this.field_name = "";
        }
        if (this.bEB) {
            contentValues.put("name", this.field_name);
        }
        if (this.field_devicetype == null) {
            this.field_devicetype = "";
        }
        if (this.bQs) {
            contentValues.put("devicetype", this.field_devicetype);
        }
        if (this.bMi) {
            contentValues.put("createtime", Long.valueOf(this.field_createtime));
        }
        if (this.nmb > 0) {
            contentValues.put("rowid", Long.valueOf(this.nmb));
        }
        return contentValues;
    }
}
