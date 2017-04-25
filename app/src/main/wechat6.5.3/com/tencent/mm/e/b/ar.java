package com.tencent.mm.e.b;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.h.c;
import com.tencent.mmdb.database.SQLiteDatabase;

public abstract class ar extends c {
    private static final int bGc = "talker".hashCode();
    private static final int bGd = "encryptTalker".hashCode();
    private static final int bGv = "msgContent".hashCode();
    private static final int bGw = "svrId".hashCode();
    private static final int bGx = "chatroomName".hashCode();
    public static final String[] btd = new String[0];
    private static final int btm = "rowid".hashCode();
    private static final int bun = "createTime".hashCode();
    private static final int buq = "type".hashCode();
    private static final int byD = "isSend".hashCode();
    private boolean bFM = true;
    private boolean bFN = true;
    private boolean bGs = true;
    private boolean bGt = true;
    private boolean bGu = true;
    private boolean btS = true;
    private boolean btV = true;
    private boolean byp = true;
    public String field_chatroomName;
    public long field_createTime;
    public String field_encryptTalker;
    public int field_isSend;
    public String field_msgContent;
    public long field_svrId;
    public String field_talker;
    public int field_type;

    public final void b(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (bGv == hashCode) {
                    this.field_msgContent = cursor.getString(i);
                } else if (byD == hashCode) {
                    this.field_isSend = cursor.getInt(i);
                } else if (bGc == hashCode) {
                    this.field_talker = cursor.getString(i);
                } else if (bGd == hashCode) {
                    this.field_encryptTalker = cursor.getString(i);
                } else if (bGw == hashCode) {
                    this.field_svrId = cursor.getLong(i);
                } else if (buq == hashCode) {
                    this.field_type = cursor.getInt(i);
                } else if (bun == hashCode) {
                    this.field_createTime = cursor.getLong(i);
                } else if (bGx == hashCode) {
                    this.field_chatroomName = cursor.getString(i);
                } else if (btm == hashCode) {
                    this.nmb = cursor.getLong(i);
                }
            }
        }
    }

    public final ContentValues py() {
        ContentValues contentValues = new ContentValues();
        if (this.field_msgContent == null) {
            this.field_msgContent = SQLiteDatabase.KeyEmpty;
        }
        if (this.bGs) {
            contentValues.put("msgContent", this.field_msgContent);
        }
        if (this.byp) {
            contentValues.put("isSend", Integer.valueOf(this.field_isSend));
        }
        if (this.field_talker == null) {
            this.field_talker = SQLiteDatabase.KeyEmpty;
        }
        if (this.bFM) {
            contentValues.put("talker", this.field_talker);
        }
        if (this.field_encryptTalker == null) {
            this.field_encryptTalker = SQLiteDatabase.KeyEmpty;
        }
        if (this.bFN) {
            contentValues.put("encryptTalker", this.field_encryptTalker);
        }
        if (this.bGt) {
            contentValues.put("svrId", Long.valueOf(this.field_svrId));
        }
        if (this.btV) {
            contentValues.put("type", Integer.valueOf(this.field_type));
        }
        if (this.btS) {
            contentValues.put("createTime", Long.valueOf(this.field_createTime));
        }
        if (this.field_chatroomName == null) {
            this.field_chatroomName = SQLiteDatabase.KeyEmpty;
        }
        if (this.bGu) {
            contentValues.put("chatroomName", this.field_chatroomName);
        }
        if (this.nmb > 0) {
            contentValues.put("rowid", Long.valueOf(this.nmb));
        }
        return contentValues;
    }
}
