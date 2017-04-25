package com.tencent.mm.e.b;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.h.c;

public abstract class dm extends c {
    private static final int bXg = "UserNameHash".hashCode();
    private static final int bXh = "UserName".hashCode();
    private static final int bXi = "NickName".hashCode();
    private static final int bXj = "QuanPin".hashCode();
    private static final int bXk = "BitMask".hashCode();
    private static final int bXl = "BitVal".hashCode();
    private static final int bXm = "Alias".hashCode();
    private static final int bXn = "ExternalInfo".hashCode();
    private static final int bXo = "BrandIconURL".hashCode();
    public static final String[] btd = new String[0];
    private static final int btm = "rowid".hashCode();
    private boolean bWX = true;
    private boolean bWY = true;
    private boolean bWZ = true;
    private boolean bXa = true;
    private boolean bXb = true;
    private boolean bXc = true;
    private boolean bXd = true;
    private boolean bXe = true;
    private boolean bXf = true;
    public String field_Alias;
    public int field_BitMask;
    public int field_BitVal;
    public String field_BrandIconURL;
    public String field_ExternalInfo;
    public String field_NickName;
    public String field_QuanPin;
    public String field_UserName;
    public int field_UserNameHash;

    public final void b(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (bXg == hashCode) {
                    this.field_UserNameHash = cursor.getInt(i);
                    this.bWX = true;
                } else if (bXh == hashCode) {
                    this.field_UserName = cursor.getString(i);
                } else if (bXi == hashCode) {
                    this.field_NickName = cursor.getString(i);
                } else if (bXj == hashCode) {
                    this.field_QuanPin = cursor.getString(i);
                } else if (bXk == hashCode) {
                    this.field_BitMask = cursor.getInt(i);
                } else if (bXl == hashCode) {
                    this.field_BitVal = cursor.getInt(i);
                } else if (bXm == hashCode) {
                    this.field_Alias = cursor.getString(i);
                } else if (bXn == hashCode) {
                    this.field_ExternalInfo = cursor.getString(i);
                } else if (bXo == hashCode) {
                    this.field_BrandIconURL = cursor.getString(i);
                } else if (btm == hashCode) {
                    this.nmb = cursor.getLong(i);
                }
            }
        }
    }

    public final ContentValues py() {
        ContentValues contentValues = new ContentValues();
        if (this.bWX) {
            contentValues.put("UserNameHash", Integer.valueOf(this.field_UserNameHash));
        }
        if (this.bWY) {
            contentValues.put("UserName", this.field_UserName);
        }
        if (this.bWZ) {
            contentValues.put("NickName", this.field_NickName);
        }
        if (this.bXa) {
            contentValues.put("QuanPin", this.field_QuanPin);
        }
        if (this.bXb) {
            contentValues.put("BitMask", Integer.valueOf(this.field_BitMask));
        }
        if (this.bXc) {
            contentValues.put("BitVal", Integer.valueOf(this.field_BitVal));
        }
        if (this.bXd) {
            contentValues.put("Alias", this.field_Alias);
        }
        if (this.bXe) {
            contentValues.put("ExternalInfo", this.field_ExternalInfo);
        }
        if (this.bXf) {
            contentValues.put("BrandIconURL", this.field_BrandIconURL);
        }
        if (this.nmb > 0) {
            contentValues.put("rowid", Long.valueOf(this.nmb));
        }
        return contentValues;
    }
}
