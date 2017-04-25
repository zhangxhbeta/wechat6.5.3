package com.tencent.mm.e.b;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.h.c;
import com.tencent.mmdb.database.SQLiteDatabase;

public abstract class s extends c {
    public static final String[] btd = new String[0];
    private static final int btm = "rowid".hashCode();
    private static final int buv = "content".hashCode();
    private static final int bvg = "status".hashCode();
    private static final int bxU = "flag".hashCode();
    private static final int byA = "atCount".hashCode();
    private static final int byB = "editingMsg".hashCode();
    private static final int byC = "chatType".hashCode();
    private static final int byD = "isSend".hashCode();
    private static final int byE = "msgType".hashCode();
    private static final int byF = "msgCount".hashCode();
    private static final int bys = "bizChatId".hashCode();
    private static final int byt = "brandUserName".hashCode();
    private static final int byu = "unReadCount".hashCode();
    private static final int byv = "newUnReadCount".hashCode();
    private static final int byw = "lastMsgID".hashCode();
    private static final int byx = "lastMsgTime".hashCode();
    private static final int byy = "digest".hashCode();
    private static final int byz = "digestUser".hashCode();
    private boolean buP = true;
    private boolean bua = true;
    private boolean bxS = true;
    private boolean bye = true;
    private boolean byf = true;
    private boolean byg = true;
    private boolean byh = true;
    private boolean byi = true;
    private boolean byj = true;
    private boolean byk = true;
    private boolean byl = true;
    private boolean bym = true;
    private boolean byn = true;
    private boolean byo = true;
    private boolean byp = true;
    private boolean byq = true;
    private boolean byr = true;
    public int field_atCount;
    public long field_bizChatId;
    public String field_brandUserName;
    public int field_chatType;
    public String field_content;
    public String field_digest;
    public String field_digestUser;
    public String field_editingMsg;
    public long field_flag;
    public int field_isSend;
    public long field_lastMsgID;
    public long field_lastMsgTime;
    public int field_msgCount;
    public String field_msgType;
    public int field_newUnReadCount;
    public int field_status;
    public int field_unReadCount;

    public final void b(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (bys == hashCode) {
                    this.field_bizChatId = cursor.getLong(i);
                    this.bye = true;
                } else if (byt == hashCode) {
                    this.field_brandUserName = cursor.getString(i);
                } else if (byu == hashCode) {
                    this.field_unReadCount = cursor.getInt(i);
                } else if (byv == hashCode) {
                    this.field_newUnReadCount = cursor.getInt(i);
                } else if (byw == hashCode) {
                    this.field_lastMsgID = cursor.getLong(i);
                } else if (byx == hashCode) {
                    this.field_lastMsgTime = cursor.getLong(i);
                } else if (buv == hashCode) {
                    this.field_content = cursor.getString(i);
                } else if (byy == hashCode) {
                    this.field_digest = cursor.getString(i);
                } else if (byz == hashCode) {
                    this.field_digestUser = cursor.getString(i);
                } else if (byA == hashCode) {
                    this.field_atCount = cursor.getInt(i);
                } else if (byB == hashCode) {
                    this.field_editingMsg = cursor.getString(i);
                } else if (byC == hashCode) {
                    this.field_chatType = cursor.getInt(i);
                } else if (bvg == hashCode) {
                    this.field_status = cursor.getInt(i);
                } else if (byD == hashCode) {
                    this.field_isSend = cursor.getInt(i);
                } else if (byE == hashCode) {
                    this.field_msgType = cursor.getString(i);
                } else if (byF == hashCode) {
                    this.field_msgCount = cursor.getInt(i);
                } else if (bxU == hashCode) {
                    this.field_flag = cursor.getLong(i);
                } else if (btm == hashCode) {
                    this.nmb = cursor.getLong(i);
                }
            }
        }
    }

    public final ContentValues py() {
        ContentValues contentValues = new ContentValues();
        if (this.bye) {
            contentValues.put("bizChatId", Long.valueOf(this.field_bizChatId));
        }
        if (this.byf) {
            contentValues.put("brandUserName", this.field_brandUserName);
        }
        if (this.byg) {
            contentValues.put("unReadCount", Integer.valueOf(this.field_unReadCount));
        }
        if (this.byh) {
            contentValues.put("newUnReadCount", Integer.valueOf(this.field_newUnReadCount));
        }
        if (this.byi) {
            contentValues.put("lastMsgID", Long.valueOf(this.field_lastMsgID));
        }
        if (this.byj) {
            contentValues.put("lastMsgTime", Long.valueOf(this.field_lastMsgTime));
        }
        if (this.bua) {
            contentValues.put("content", this.field_content);
        }
        if (this.field_digest == null) {
            this.field_digest = SQLiteDatabase.KeyEmpty;
        }
        if (this.byk) {
            contentValues.put("digest", this.field_digest);
        }
        if (this.field_digestUser == null) {
            this.field_digestUser = SQLiteDatabase.KeyEmpty;
        }
        if (this.byl) {
            contentValues.put("digestUser", this.field_digestUser);
        }
        if (this.bym) {
            contentValues.put("atCount", Integer.valueOf(this.field_atCount));
        }
        if (this.byn) {
            contentValues.put("editingMsg", this.field_editingMsg);
        }
        if (this.byo) {
            contentValues.put("chatType", Integer.valueOf(this.field_chatType));
        }
        if (this.buP) {
            contentValues.put("status", Integer.valueOf(this.field_status));
        }
        if (this.byp) {
            contentValues.put("isSend", Integer.valueOf(this.field_isSend));
        }
        if (this.field_msgType == null) {
            this.field_msgType = SQLiteDatabase.KeyEmpty;
        }
        if (this.byq) {
            contentValues.put("msgType", this.field_msgType);
        }
        if (this.byr) {
            contentValues.put("msgCount", Integer.valueOf(this.field_msgCount));
        }
        if (this.bxS) {
            contentValues.put("flag", Long.valueOf(this.field_flag));
        }
        if (this.nmb > 0) {
            contentValues.put("rowid", Long.valueOf(this.nmb));
        }
        return contentValues;
    }
}
