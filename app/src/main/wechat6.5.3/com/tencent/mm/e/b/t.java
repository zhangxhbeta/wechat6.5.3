package com.tencent.mm.e.b;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.h.c;
import com.tencent.mmdb.database.SQLiteDatabase;

public abstract class t extends c {
    public static final String[] btd = new String[0];
    private static final int btm = "rowid".hashCode();
    private static final int byC = "chatType".hashCode();
    private static final int byS = "bizChatLocalId".hashCode();
    private static final int byT = "bizChatServId".hashCode();
    private static final int byU = "headImageUrl".hashCode();
    private static final int byV = "chatName".hashCode();
    private static final int byW = "chatNamePY".hashCode();
    private static final int byX = "chatVersion".hashCode();
    private static final int byY = "needToUpdate".hashCode();
    private static final int byZ = "bitFlag".hashCode();
    private static final int byt = "brandUserName".hashCode();
    private static final int bza = "maxMemberCnt".hashCode();
    private static final int bzb = "ownerUserId".hashCode();
    private static final int bzc = "userList".hashCode();
    private static final int bzd = "addMemberUrl".hashCode();
    private boolean byG = true;
    private boolean byH = true;
    private boolean byI = true;
    private boolean byJ = true;
    private boolean byK = true;
    private boolean byL = true;
    private boolean byM = true;
    private boolean byN = true;
    private boolean byO = true;
    private boolean byP = true;
    private boolean byQ = true;
    private boolean byR = true;
    private boolean byf = true;
    private boolean byo = true;
    public String field_addMemberUrl;
    public int field_bitFlag;
    public long field_bizChatLocalId;
    public String field_bizChatServId;
    public String field_brandUserName;
    public String field_chatName;
    public String field_chatNamePY;
    public int field_chatType;
    public int field_chatVersion;
    public String field_headImageUrl;
    public int field_maxMemberCnt;
    public boolean field_needToUpdate;
    public String field_ownerUserId;
    public String field_userList;

    public final void b(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (byS == hashCode) {
                    this.field_bizChatLocalId = cursor.getLong(i);
                    this.byG = true;
                } else if (byT == hashCode) {
                    this.field_bizChatServId = cursor.getString(i);
                } else if (byt == hashCode) {
                    this.field_brandUserName = cursor.getString(i);
                } else if (byC == hashCode) {
                    this.field_chatType = cursor.getInt(i);
                } else if (byU == hashCode) {
                    this.field_headImageUrl = cursor.getString(i);
                } else if (byV == hashCode) {
                    this.field_chatName = cursor.getString(i);
                } else if (byW == hashCode) {
                    this.field_chatNamePY = cursor.getString(i);
                } else if (byX == hashCode) {
                    this.field_chatVersion = cursor.getInt(i);
                } else if (byY == hashCode) {
                    this.field_needToUpdate = cursor.getInt(i) != 0;
                } else if (byZ == hashCode) {
                    this.field_bitFlag = cursor.getInt(i);
                } else if (bza == hashCode) {
                    this.field_maxMemberCnt = cursor.getInt(i);
                } else if (bzb == hashCode) {
                    this.field_ownerUserId = cursor.getString(i);
                } else if (bzc == hashCode) {
                    this.field_userList = cursor.getString(i);
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
        if (this.byG) {
            contentValues.put("bizChatLocalId", Long.valueOf(this.field_bizChatLocalId));
        }
        if (this.byH) {
            contentValues.put("bizChatServId", this.field_bizChatServId);
        }
        if (this.field_brandUserName == null) {
            this.field_brandUserName = SQLiteDatabase.KeyEmpty;
        }
        if (this.byf) {
            contentValues.put("brandUserName", this.field_brandUserName);
        }
        if (this.byo) {
            contentValues.put("chatType", Integer.valueOf(this.field_chatType));
        }
        if (this.byI) {
            contentValues.put("headImageUrl", this.field_headImageUrl);
        }
        if (this.field_chatName == null) {
            this.field_chatName = SQLiteDatabase.KeyEmpty;
        }
        if (this.byJ) {
            contentValues.put("chatName", this.field_chatName);
        }
        if (this.field_chatNamePY == null) {
            this.field_chatNamePY = SQLiteDatabase.KeyEmpty;
        }
        if (this.byK) {
            contentValues.put("chatNamePY", this.field_chatNamePY);
        }
        if (this.byL) {
            contentValues.put("chatVersion", Integer.valueOf(this.field_chatVersion));
        }
        if (this.byM) {
            contentValues.put("needToUpdate", Boolean.valueOf(this.field_needToUpdate));
        }
        if (this.byN) {
            contentValues.put("bitFlag", Integer.valueOf(this.field_bitFlag));
        }
        if (this.byO) {
            contentValues.put("maxMemberCnt", Integer.valueOf(this.field_maxMemberCnt));
        }
        if (this.byP) {
            contentValues.put("ownerUserId", this.field_ownerUserId);
        }
        if (this.byQ) {
            contentValues.put("userList", this.field_userList);
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
