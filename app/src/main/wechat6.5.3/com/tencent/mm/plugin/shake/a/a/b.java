package com.tencent.mm.plugin.shake.a.a;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.h.c;

public abstract class b extends c {
    private static final int bMn = "createtime".hashCode();
    public static final String[] btd = new String[0];
    private static final int btm = "rowid".hashCode();
    private static final int bxP = "title".hashCode();
    private static final int bzG = "username".hashCode();
    private static final int iNV = "deeplink".hashCode();
    private static final int iNW = "iconurl".hashCode();
    private boolean bMi = true;
    private boolean bxL = true;
    private boolean bzs = true;
    public long field_createtime;
    public String field_deeplink;
    public String field_iconurl;
    public String field_title;
    public String field_username;
    private boolean iNT = true;
    private boolean iNU = true;

    public final void b(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (bzG == hashCode) {
                    this.field_username = cursor.getString(i);
                    this.bzs = true;
                } else if (iNV == hashCode) {
                    this.field_deeplink = cursor.getString(i);
                } else if (bxP == hashCode) {
                    this.field_title = cursor.getString(i);
                } else if (iNW == hashCode) {
                    this.field_iconurl = cursor.getString(i);
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
        if (this.field_username == null) {
            this.field_username = "";
        }
        if (this.bzs) {
            contentValues.put("username", this.field_username);
        }
        if (this.field_deeplink == null) {
            this.field_deeplink = "";
        }
        if (this.iNT) {
            contentValues.put("deeplink", this.field_deeplink);
        }
        if (this.field_title == null) {
            this.field_title = "";
        }
        if (this.bxL) {
            contentValues.put("title", this.field_title);
        }
        if (this.field_iconurl == null) {
            this.field_iconurl = "";
        }
        if (this.iNU) {
            contentValues.put("iconurl", this.field_iconurl);
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
