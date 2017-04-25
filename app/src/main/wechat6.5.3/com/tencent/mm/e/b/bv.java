package com.tencent.mm.e.b;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.h.c;

public abstract class bv extends c {
    private static final int bAa = "nickname".hashCode();
    private static final int bEX = "name".hashCode();
    private static final int bLI = "wechatUsername".hashCode();
    private static final int bMA = "wechatId".hashCode();
    private static final int bMB = "linkedInId".hashCode();
    private static final int bMC = "position".hashCode();
    private static final int bMD = "picUrl".hashCode();
    private static final int bME = "wechatSmallHead".hashCode();
    private static final int bMF = "wechatBigHead".hashCode();
    private static final int bMG = "linkedInProfileUrl".hashCode();
    private static final int bMH = "userOpStatus".hashCode();
    public static final String[] btd = new String[0];
    private static final int btm = "rowid".hashCode();
    private static final int bvg = "status".hashCode();
    private boolean bEB = true;
    private boolean bLE = true;
    private boolean bMs = true;
    private boolean bMt = true;
    private boolean bMu = true;
    private boolean bMv = true;
    private boolean bMw = true;
    private boolean bMx = true;
    private boolean bMy = true;
    private boolean bMz = true;
    private boolean buP = true;
    private boolean bzW = true;
    public String field_linkedInId;
    public String field_linkedInProfileUrl;
    public String field_name;
    public String field_nickname;
    public String field_picUrl;
    public String field_position;
    public int field_status;
    public int field_userOpStatus;
    public String field_wechatBigHead;
    public String field_wechatId;
    public String field_wechatSmallHead;
    public String field_wechatUsername;

    public final void b(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (bMA == hashCode) {
                    this.field_wechatId = cursor.getString(i);
                } else if (bMB == hashCode) {
                    this.field_linkedInId = cursor.getString(i);
                } else if (bEX == hashCode) {
                    this.field_name = cursor.getString(i);
                } else if (bMC == hashCode) {
                    this.field_position = cursor.getString(i);
                } else if (bMD == hashCode) {
                    this.field_picUrl = cursor.getString(i);
                } else if (bLI == hashCode) {
                    this.field_wechatUsername = cursor.getString(i);
                } else if (bME == hashCode) {
                    this.field_wechatSmallHead = cursor.getString(i);
                } else if (bMF == hashCode) {
                    this.field_wechatBigHead = cursor.getString(i);
                } else if (bMG == hashCode) {
                    this.field_linkedInProfileUrl = cursor.getString(i);
                } else if (bvg == hashCode) {
                    this.field_status = cursor.getInt(i);
                } else if (bMH == hashCode) {
                    this.field_userOpStatus = cursor.getInt(i);
                } else if (bAa == hashCode) {
                    this.field_nickname = cursor.getString(i);
                } else if (btm == hashCode) {
                    this.nmb = cursor.getLong(i);
                }
            }
        }
    }

    public final ContentValues py() {
        ContentValues contentValues = new ContentValues();
        if (this.bMs) {
            contentValues.put("wechatId", this.field_wechatId);
        }
        if (this.bMt) {
            contentValues.put("linkedInId", this.field_linkedInId);
        }
        if (this.bEB) {
            contentValues.put("name", this.field_name);
        }
        if (this.bMu) {
            contentValues.put("position", this.field_position);
        }
        if (this.bMv) {
            contentValues.put("picUrl", this.field_picUrl);
        }
        if (this.bLE) {
            contentValues.put("wechatUsername", this.field_wechatUsername);
        }
        if (this.bMw) {
            contentValues.put("wechatSmallHead", this.field_wechatSmallHead);
        }
        if (this.bMx) {
            contentValues.put("wechatBigHead", this.field_wechatBigHead);
        }
        if (this.bMy) {
            contentValues.put("linkedInProfileUrl", this.field_linkedInProfileUrl);
        }
        if (this.buP) {
            contentValues.put("status", Integer.valueOf(this.field_status));
        }
        if (this.bMz) {
            contentValues.put("userOpStatus", Integer.valueOf(this.field_userOpStatus));
        }
        if (this.bzW) {
            contentValues.put("nickname", this.field_nickname);
        }
        if (this.nmb > 0) {
            contentValues.put("rowid", Long.valueOf(this.nmb));
        }
        return contentValues;
    }
}
