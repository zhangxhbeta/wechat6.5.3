package com.tencent.mm.e.b;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.h.c;
import com.tencent.mmdb.database.SQLiteDatabase;

public abstract class v extends c {
    public static final String[] btd = new String[0];
    private static final int btm = "rowid".hashCode();
    private static final int bul = "userName".hashCode();
    private static final int byU = "headImageUrl".hashCode();
    private static final int byY = "needToUpdate".hashCode();
    private static final int byZ = "bitFlag".hashCode();
    private static final int byt = "brandUserName".hashCode();
    private static final int bzd = "addMemberUrl".hashCode();
    private static final int bzf = "userId".hashCode();
    private static final int bzj = "userNamePY".hashCode();
    private static final int bzk = "UserVersion".hashCode();
    private static final int bzl = "profileUrl".hashCode();
    private boolean btQ = true;
    private boolean byI = true;
    private boolean byM = true;
    private boolean byN = true;
    private boolean byR = true;
    private boolean byf = true;
    private boolean bze = true;
    private boolean bzg = true;
    private boolean bzh = true;
    private boolean bzi = true;
    public int field_UserVersion;
    public String field_addMemberUrl;
    public int field_bitFlag;
    public String field_brandUserName;
    public String field_headImageUrl;
    public boolean field_needToUpdate;
    public String field_profileUrl;
    public String field_userId;
    public String field_userName;
    public String field_userNamePY;

    public final void b(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (bzf == hashCode) {
                    this.field_userId = cursor.getString(i);
                    this.bze = true;
                } else if (bul == hashCode) {
                    this.field_userName = cursor.getString(i);
                } else if (bzj == hashCode) {
                    this.field_userNamePY = cursor.getString(i);
                } else if (byt == hashCode) {
                    this.field_brandUserName = cursor.getString(i);
                } else if (bzk == hashCode) {
                    this.field_UserVersion = cursor.getInt(i);
                } else if (byY == hashCode) {
                    this.field_needToUpdate = cursor.getInt(i) != 0;
                } else if (byU == hashCode) {
                    this.field_headImageUrl = cursor.getString(i);
                } else if (bzl == hashCode) {
                    this.field_profileUrl = cursor.getString(i);
                } else if (byZ == hashCode) {
                    this.field_bitFlag = cursor.getInt(i);
                } else if (bzd == hashCode) {
                    this.field_addMemberUrl = cursor.getString(i);
                } else if (btm == hashCode) {
                    this.nmb = cursor.getLong(i);
                }
            }
        }
    }

    public final ContentValues py() {
        ContentValues contentValues = new ContentValues();
        if (this.bze) {
            contentValues.put("userId", this.field_userId);
        }
        if (this.field_userName == null) {
            this.field_userName = SQLiteDatabase.KeyEmpty;
        }
        if (this.btQ) {
            contentValues.put("userName", this.field_userName);
        }
        if (this.field_userNamePY == null) {
            this.field_userNamePY = SQLiteDatabase.KeyEmpty;
        }
        if (this.bzg) {
            contentValues.put("userNamePY", this.field_userNamePY);
        }
        if (this.field_brandUserName == null) {
            this.field_brandUserName = SQLiteDatabase.KeyEmpty;
        }
        if (this.byf) {
            contentValues.put("brandUserName", this.field_brandUserName);
        }
        if (this.bzh) {
            contentValues.put("UserVersion", Integer.valueOf(this.field_UserVersion));
        }
        if (this.byM) {
            contentValues.put("needToUpdate", Boolean.valueOf(this.field_needToUpdate));
        }
        if (this.byI) {
            contentValues.put("headImageUrl", this.field_headImageUrl);
        }
        if (this.bzi) {
            contentValues.put("profileUrl", this.field_profileUrl);
        }
        if (this.byN) {
            contentValues.put("bitFlag", Integer.valueOf(this.field_bitFlag));
        }
        if (this.byR) {
            contentValues.put("addMemberUrl", this.field_addMemberUrl);
        }
        if (this.nmb > 0) {
            contentValues.put("rowid", Long.valueOf(this.nmb));
        }
        return contentValues;
    }
}
