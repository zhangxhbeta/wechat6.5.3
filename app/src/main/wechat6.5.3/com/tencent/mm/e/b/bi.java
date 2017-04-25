package com.tencent.mm.e.b;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.h.c;

public abstract class bi extends c {
    private static final int bAa = "nickname".hashCode();
    private static final int bKj = "googleid".hashCode();
    private static final int bKk = "googlename".hashCode();
    private static final int bKl = "googlephotourl".hashCode();
    private static final int bKm = "googlegmail".hashCode();
    private static final int bKn = "nicknameqp".hashCode();
    private static final int bKo = "usernamepy".hashCode();
    private static final int bKp = "small_url".hashCode();
    private static final int bKq = "big_url".hashCode();
    private static final int bKr = "ret".hashCode();
    private static final int bKs = "googleitemid".hashCode();
    private static final int bKt = "googlecgistatus".hashCode();
    private static final int bKu = "contecttype".hashCode();
    private static final int bKv = "googlenamepy".hashCode();
    public static final String[] btd = new String[0];
    private static final int btm = "rowid".hashCode();
    private static final int bvg = "status".hashCode();
    private static final int bzG = "username".hashCode();
    private boolean bJW = true;
    private boolean bJX = true;
    private boolean bJY = true;
    private boolean bJZ = true;
    private boolean bKa = true;
    private boolean bKb = true;
    private boolean bKc = true;
    private boolean bKd = true;
    private boolean bKe = true;
    private boolean bKf = true;
    private boolean bKg = true;
    private boolean bKh = true;
    private boolean bKi = true;
    private boolean buP = true;
    private boolean bzW = true;
    private boolean bzs = true;
    public String field_big_url;
    public String field_contecttype;
    public int field_googlecgistatus;
    public String field_googlegmail;
    public String field_googleid;
    public String field_googleitemid;
    public String field_googlename;
    public String field_googlenamepy;
    public String field_googlephotourl;
    public String field_nickname;
    public String field_nicknameqp;
    public int field_ret;
    public String field_small_url;
    public int field_status;
    public String field_username;
    public String field_usernamepy;

    public final void b(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (bKj == hashCode) {
                    this.field_googleid = cursor.getString(i);
                } else if (bKk == hashCode) {
                    this.field_googlename = cursor.getString(i);
                } else if (bKl == hashCode) {
                    this.field_googlephotourl = cursor.getString(i);
                } else if (bKm == hashCode) {
                    this.field_googlegmail = cursor.getString(i);
                } else if (bzG == hashCode) {
                    this.field_username = cursor.getString(i);
                } else if (bAa == hashCode) {
                    this.field_nickname = cursor.getString(i);
                } else if (bKn == hashCode) {
                    this.field_nicknameqp = cursor.getString(i);
                } else if (bKo == hashCode) {
                    this.field_usernamepy = cursor.getString(i);
                } else if (bKp == hashCode) {
                    this.field_small_url = cursor.getString(i);
                } else if (bKq == hashCode) {
                    this.field_big_url = cursor.getString(i);
                } else if (bKr == hashCode) {
                    this.field_ret = cursor.getInt(i);
                } else if (bvg == hashCode) {
                    this.field_status = cursor.getInt(i);
                } else if (bKs == hashCode) {
                    this.field_googleitemid = cursor.getString(i);
                    this.bKf = true;
                } else if (bKt == hashCode) {
                    this.field_googlecgistatus = cursor.getInt(i);
                } else if (bKu == hashCode) {
                    this.field_contecttype = cursor.getString(i);
                } else if (bKv == hashCode) {
                    this.field_googlenamepy = cursor.getString(i);
                } else if (btm == hashCode) {
                    this.nmb = cursor.getLong(i);
                }
            }
        }
    }

    public final ContentValues py() {
        ContentValues contentValues = new ContentValues();
        if (this.bJW) {
            contentValues.put("googleid", this.field_googleid);
        }
        if (this.bJX) {
            contentValues.put("googlename", this.field_googlename);
        }
        if (this.bJY) {
            contentValues.put("googlephotourl", this.field_googlephotourl);
        }
        if (this.bJZ) {
            contentValues.put("googlegmail", this.field_googlegmail);
        }
        if (this.bzs) {
            contentValues.put("username", this.field_username);
        }
        if (this.bzW) {
            contentValues.put("nickname", this.field_nickname);
        }
        if (this.bKa) {
            contentValues.put("nicknameqp", this.field_nicknameqp);
        }
        if (this.bKb) {
            contentValues.put("usernamepy", this.field_usernamepy);
        }
        if (this.bKc) {
            contentValues.put("small_url", this.field_small_url);
        }
        if (this.bKd) {
            contentValues.put("big_url", this.field_big_url);
        }
        if (this.bKe) {
            contentValues.put("ret", Integer.valueOf(this.field_ret));
        }
        if (this.buP) {
            contentValues.put("status", Integer.valueOf(this.field_status));
        }
        if (this.bKf) {
            contentValues.put("googleitemid", this.field_googleitemid);
        }
        if (this.bKg) {
            contentValues.put("googlecgistatus", Integer.valueOf(this.field_googlecgistatus));
        }
        if (this.bKh) {
            contentValues.put("contecttype", this.field_contecttype);
        }
        if (this.bKi) {
            contentValues.put("googlenamepy", this.field_googlenamepy);
        }
        if (this.nmb > 0) {
            contentValues.put("rowid", Long.valueOf(this.nmb));
        }
        return contentValues;
    }
}
