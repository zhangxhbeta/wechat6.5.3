package com.tencent.mm.e.b;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.h.c;
import com.tencent.mmdb.database.SQLiteDatabase;

public abstract class bh extends c {
    private static final int bEY = "reserved1".hashCode();
    private static final int bEZ = "reserved2".hashCode();
    private static final int bFa = "reserved3".hashCode();
    private static final int bFb = "reserved4".hashCode();
    private static final int bJQ = "originSvrId".hashCode();
    private static final int bJR = "newMsgId".hashCode();
    private static final int bJS = "fromUserName".hashCode();
    private static final int bJT = "toUserName".hashCode();
    private static final int bJU = "msgSource".hashCode();
    private static final int bJV = "msgSeq".hashCode();
    public static final String[] btd = new String[0];
    private static final int btm = "rowid".hashCode();
    private static final int bun = "createTime".hashCode();
    private static final int buv = "content".hashCode();
    private static final int bxU = "flag".hashCode();
    private boolean bEC = true;
    private boolean bED = true;
    private boolean bEE = true;
    private boolean bEF = true;
    private boolean bJK = true;
    private boolean bJL = true;
    private boolean bJM = true;
    private boolean bJN = true;
    private boolean bJO = true;
    private boolean bJP = true;
    private boolean btS = true;
    private boolean bua = true;
    private boolean bxS = true;
    public String field_content;
    public long field_createTime;
    public int field_flag;
    public String field_fromUserName;
    public int field_msgSeq;
    public String field_msgSource;
    public long field_newMsgId;
    public long field_originSvrId;
    public int field_reserved1;
    public long field_reserved2;
    public String field_reserved3;
    public String field_reserved4;
    public String field_toUserName;

    public final void b(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (bJQ == hashCode) {
                    this.field_originSvrId = cursor.getLong(i);
                    this.bJK = true;
                } else if (bJR == hashCode) {
                    this.field_newMsgId = cursor.getLong(i);
                } else if (bJS == hashCode) {
                    this.field_fromUserName = cursor.getString(i);
                } else if (bJT == hashCode) {
                    this.field_toUserName = cursor.getString(i);
                } else if (bun == hashCode) {
                    this.field_createTime = cursor.getLong(i);
                } else if (buv == hashCode) {
                    this.field_content = cursor.getString(i);
                } else if (bJU == hashCode) {
                    this.field_msgSource = cursor.getString(i);
                } else if (bJV == hashCode) {
                    this.field_msgSeq = cursor.getInt(i);
                } else if (bxU == hashCode) {
                    this.field_flag = cursor.getInt(i);
                } else if (bEY == hashCode) {
                    this.field_reserved1 = cursor.getInt(i);
                } else if (bEZ == hashCode) {
                    this.field_reserved2 = cursor.getLong(i);
                } else if (bFa == hashCode) {
                    this.field_reserved3 = cursor.getString(i);
                } else if (bFb == hashCode) {
                    this.field_reserved4 = cursor.getString(i);
                } else if (btm == hashCode) {
                    this.nmb = cursor.getLong(i);
                }
            }
        }
    }

    public final ContentValues py() {
        ContentValues contentValues = new ContentValues();
        if (this.bJK) {
            contentValues.put("originSvrId", Long.valueOf(this.field_originSvrId));
        }
        if (this.bJL) {
            contentValues.put("newMsgId", Long.valueOf(this.field_newMsgId));
        }
        if (this.field_fromUserName == null) {
            this.field_fromUserName = SQLiteDatabase.KeyEmpty;
        }
        if (this.bJM) {
            contentValues.put("fromUserName", this.field_fromUserName);
        }
        if (this.field_toUserName == null) {
            this.field_toUserName = SQLiteDatabase.KeyEmpty;
        }
        if (this.bJN) {
            contentValues.put("toUserName", this.field_toUserName);
        }
        if (this.btS) {
            contentValues.put("createTime", Long.valueOf(this.field_createTime));
        }
        if (this.field_content == null) {
            this.field_content = SQLiteDatabase.KeyEmpty;
        }
        if (this.bua) {
            contentValues.put("content", this.field_content);
        }
        if (this.field_msgSource == null) {
            this.field_msgSource = SQLiteDatabase.KeyEmpty;
        }
        if (this.bJO) {
            contentValues.put("msgSource", this.field_msgSource);
        }
        if (this.bJP) {
            contentValues.put("msgSeq", Integer.valueOf(this.field_msgSeq));
        }
        if (this.bxS) {
            contentValues.put("flag", Integer.valueOf(this.field_flag));
        }
        if (this.bEC) {
            contentValues.put("reserved1", Integer.valueOf(this.field_reserved1));
        }
        if (this.bED) {
            contentValues.put("reserved2", Long.valueOf(this.field_reserved2));
        }
        if (this.field_reserved3 == null) {
            this.field_reserved3 = SQLiteDatabase.KeyEmpty;
        }
        if (this.bEE) {
            contentValues.put("reserved3", this.field_reserved3);
        }
        if (this.field_reserved4 == null) {
            this.field_reserved4 = SQLiteDatabase.KeyEmpty;
        }
        if (this.bEF) {
            contentValues.put("reserved4", this.field_reserved4);
        }
        if (this.nmb > 0) {
            contentValues.put("rowid", Long.valueOf(this.nmb));
        }
        return contentValues;
    }
}
