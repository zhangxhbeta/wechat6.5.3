package com.tencent.mm.e.b;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.h.c;
import com.tencent.mmdb.database.SQLiteDatabase;

public abstract class aq extends c {
    private static final int bEW = "state".hashCode();
    private static final int bGc = "talker".hashCode();
    private static final int bGd = "encryptTalker".hashCode();
    private static final int bGe = "displayName".hashCode();
    private static final int bGf = "lastModifiedTime".hashCode();
    private static final int bGg = "isNew".hashCode();
    private static final int bGh = "addScene".hashCode();
    private static final int bGi = "fmsgSysRowId".hashCode();
    private static final int bGj = "fmsgIsSend".hashCode();
    private static final int bGk = "fmsgType".hashCode();
    private static final int bGl = "fmsgContent".hashCode();
    private static final int bGm = "recvFmsgType".hashCode();
    private static final int bGn = "contentFromUsername".hashCode();
    private static final int bGo = "contentNickname".hashCode();
    private static final int bGp = "contentPhoneNumMD5".hashCode();
    private static final int bGq = "contentFullPhoneNumMD5".hashCode();
    private static final int bGr = "contentVerifyContent".hashCode();
    public static final String[] btd = new String[]{"CREATE INDEX IF NOT EXISTS fmconversation_isnew_Index ON fmessage_conversation(isNew)"};
    private static final int btm = "rowid".hashCode();
    private boolean bEA = true;
    private boolean bFM = true;
    private boolean bFN = true;
    private boolean bFO = true;
    private boolean bFP = true;
    private boolean bFQ = true;
    private boolean bFR = true;
    private boolean bFS = true;
    private boolean bFT = true;
    private boolean bFU = true;
    private boolean bFV = true;
    private boolean bFW = true;
    private boolean bFX = true;
    private boolean bFY = true;
    private boolean bFZ = true;
    private boolean bGa = true;
    private boolean bGb = true;
    public int field_addScene;
    public String field_contentFromUsername;
    public String field_contentFullPhoneNumMD5;
    public String field_contentNickname;
    public String field_contentPhoneNumMD5;
    public String field_contentVerifyContent;
    public String field_displayName;
    public String field_encryptTalker;
    public String field_fmsgContent;
    public int field_fmsgIsSend;
    public long field_fmsgSysRowId;
    public int field_fmsgType;
    public int field_isNew;
    public long field_lastModifiedTime;
    public int field_recvFmsgType;
    public int field_state;
    public String field_talker;

    public final void b(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (bGc == hashCode) {
                    this.field_talker = cursor.getString(i);
                    this.bFM = true;
                } else if (bGd == hashCode) {
                    this.field_encryptTalker = cursor.getString(i);
                } else if (bGe == hashCode) {
                    this.field_displayName = cursor.getString(i);
                } else if (bEW == hashCode) {
                    this.field_state = cursor.getInt(i);
                } else if (bGf == hashCode) {
                    this.field_lastModifiedTime = cursor.getLong(i);
                } else if (bGg == hashCode) {
                    this.field_isNew = cursor.getInt(i);
                } else if (bGh == hashCode) {
                    this.field_addScene = cursor.getInt(i);
                } else if (bGi == hashCode) {
                    this.field_fmsgSysRowId = cursor.getLong(i);
                } else if (bGj == hashCode) {
                    this.field_fmsgIsSend = cursor.getInt(i);
                } else if (bGk == hashCode) {
                    this.field_fmsgType = cursor.getInt(i);
                } else if (bGl == hashCode) {
                    this.field_fmsgContent = cursor.getString(i);
                } else if (bGm == hashCode) {
                    this.field_recvFmsgType = cursor.getInt(i);
                } else if (bGn == hashCode) {
                    this.field_contentFromUsername = cursor.getString(i);
                } else if (bGo == hashCode) {
                    this.field_contentNickname = cursor.getString(i);
                } else if (bGp == hashCode) {
                    this.field_contentPhoneNumMD5 = cursor.getString(i);
                } else if (bGq == hashCode) {
                    this.field_contentFullPhoneNumMD5 = cursor.getString(i);
                } else if (bGr == hashCode) {
                    this.field_contentVerifyContent = cursor.getString(i);
                } else if (btm == hashCode) {
                    this.nmb = cursor.getLong(i);
                }
            }
        }
    }

    public final ContentValues py() {
        ContentValues contentValues = new ContentValues();
        if (this.field_talker == null) {
            this.field_talker = "0";
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
        if (this.field_displayName == null) {
            this.field_displayName = SQLiteDatabase.KeyEmpty;
        }
        if (this.bFO) {
            contentValues.put("displayName", this.field_displayName);
        }
        if (this.bEA) {
            contentValues.put("state", Integer.valueOf(this.field_state));
        }
        if (this.bFP) {
            contentValues.put("lastModifiedTime", Long.valueOf(this.field_lastModifiedTime));
        }
        if (this.bFQ) {
            contentValues.put("isNew", Integer.valueOf(this.field_isNew));
        }
        if (this.bFR) {
            contentValues.put("addScene", Integer.valueOf(this.field_addScene));
        }
        if (this.bFS) {
            contentValues.put("fmsgSysRowId", Long.valueOf(this.field_fmsgSysRowId));
        }
        if (this.bFT) {
            contentValues.put("fmsgIsSend", Integer.valueOf(this.field_fmsgIsSend));
        }
        if (this.bFU) {
            contentValues.put("fmsgType", Integer.valueOf(this.field_fmsgType));
        }
        if (this.field_fmsgContent == null) {
            this.field_fmsgContent = SQLiteDatabase.KeyEmpty;
        }
        if (this.bFV) {
            contentValues.put("fmsgContent", this.field_fmsgContent);
        }
        if (this.bFW) {
            contentValues.put("recvFmsgType", Integer.valueOf(this.field_recvFmsgType));
        }
        if (this.field_contentFromUsername == null) {
            this.field_contentFromUsername = SQLiteDatabase.KeyEmpty;
        }
        if (this.bFX) {
            contentValues.put("contentFromUsername", this.field_contentFromUsername);
        }
        if (this.field_contentNickname == null) {
            this.field_contentNickname = SQLiteDatabase.KeyEmpty;
        }
        if (this.bFY) {
            contentValues.put("contentNickname", this.field_contentNickname);
        }
        if (this.field_contentPhoneNumMD5 == null) {
            this.field_contentPhoneNumMD5 = SQLiteDatabase.KeyEmpty;
        }
        if (this.bFZ) {
            contentValues.put("contentPhoneNumMD5", this.field_contentPhoneNumMD5);
        }
        if (this.field_contentFullPhoneNumMD5 == null) {
            this.field_contentFullPhoneNumMD5 = SQLiteDatabase.KeyEmpty;
        }
        if (this.bGa) {
            contentValues.put("contentFullPhoneNumMD5", this.field_contentFullPhoneNumMD5);
        }
        if (this.field_contentVerifyContent == null) {
            this.field_contentVerifyContent = SQLiteDatabase.KeyEmpty;
        }
        if (this.bGb) {
            contentValues.put("contentVerifyContent", this.field_contentVerifyContent);
        }
        if (this.nmb > 0) {
            contentValues.put("rowid", Long.valueOf(this.nmb));
        }
        return contentValues;
    }
}
