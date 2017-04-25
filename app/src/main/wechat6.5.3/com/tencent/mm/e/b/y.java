package com.tencent.mm.e.b;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.h.c;
import com.tencent.mmdb.database.SQLiteDatabase;

public abstract class y extends c {
    private static final int bAa = "nickname".hashCode();
    private static final int bAb = "kfType".hashCode();
    public static final String[] btd = new String[0];
    private static final int btm = "rowid".hashCode();
    private static final int bvJ = "updateTime".hashCode();
    private static final int bxd = "openId".hashCode();
    private static final int bzY = "brandUsername".hashCode();
    private static final int bzZ = "headImgUrl".hashCode();
    private boolean bvF = true;
    private boolean bwH = true;
    private boolean bzU = true;
    private boolean bzV = true;
    private boolean bzW = true;
    private boolean bzX = true;
    public String field_brandUsername;
    public String field_headImgUrl;
    public int field_kfType;
    public String field_nickname;
    public String field_openId;
    public long field_updateTime;

    public final void b(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (bxd == hashCode) {
                    this.field_openId = cursor.getString(i);
                    this.bwH = true;
                } else if (bzY == hashCode) {
                    this.field_brandUsername = cursor.getString(i);
                } else if (bzZ == hashCode) {
                    this.field_headImgUrl = cursor.getString(i);
                } else if (bAa == hashCode) {
                    this.field_nickname = cursor.getString(i);
                } else if (bAb == hashCode) {
                    this.field_kfType = cursor.getInt(i);
                } else if (bvJ == hashCode) {
                    this.field_updateTime = cursor.getLong(i);
                } else if (btm == hashCode) {
                    this.nmb = cursor.getLong(i);
                }
            }
        }
    }

    public final ContentValues py() {
        ContentValues contentValues = new ContentValues();
        if (this.bwH) {
            contentValues.put("openId", this.field_openId);
        }
        if (this.field_brandUsername == null) {
            this.field_brandUsername = SQLiteDatabase.KeyEmpty;
        }
        if (this.bzU) {
            contentValues.put("brandUsername", this.field_brandUsername);
        }
        if (this.bzV) {
            contentValues.put("headImgUrl", this.field_headImgUrl);
        }
        if (this.bzW) {
            contentValues.put("nickname", this.field_nickname);
        }
        if (this.bzX) {
            contentValues.put("kfType", Integer.valueOf(this.field_kfType));
        }
        if (this.bvF) {
            contentValues.put("updateTime", Long.valueOf(this.field_updateTime));
        }
        if (this.nmb > 0) {
            contentValues.put("rowid", Long.valueOf(this.nmb));
        }
        return contentValues;
    }
}
