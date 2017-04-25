package com.tencent.mm.e.b;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.h.c;

public abstract class by extends c {
    private static final int bEW = "state".hashCode();
    private static final int bFd = "groupId".hashCode();
    private static final int bNF = "wxGroupId".hashCode();
    private static final int bNG = "roomId".hashCode();
    private static final int bNH = "roomKey".hashCode();
    private static final int bNI = "routeId".hashCode();
    private static final int bNJ = "inviteUserName".hashCode();
    private static final int bNK = "memberCount".hashCode();
    public static final String[] btd = new String[0];
    private static final int btm = "rowid".hashCode();
    private static final int bun = "createTime".hashCode();
    private boolean bEA = true;
    private boolean bEH = true;
    private boolean bNA = true;
    private boolean bNB = true;
    private boolean bNC = true;
    private boolean bND = true;
    private boolean bNE = true;
    private boolean bNz = true;
    private boolean btS = true;
    public long field_createTime;
    public String field_groupId;
    public String field_inviteUserName;
    public int field_memberCount;
    public int field_roomId;
    public long field_roomKey;
    public int field_routeId;
    public int field_state;
    public String field_wxGroupId;

    public final void b(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (bNF == hashCode) {
                    this.field_wxGroupId = cursor.getString(i);
                    this.bNz = true;
                } else if (bFd == hashCode) {
                    this.field_groupId = cursor.getString(i);
                } else if (bNG == hashCode) {
                    this.field_roomId = cursor.getInt(i);
                } else if (bNH == hashCode) {
                    this.field_roomKey = cursor.getLong(i);
                } else if (bNI == hashCode) {
                    this.field_routeId = cursor.getInt(i);
                } else if (bNJ == hashCode) {
                    this.field_inviteUserName = cursor.getString(i);
                } else if (bNK == hashCode) {
                    this.field_memberCount = cursor.getInt(i);
                } else if (bun == hashCode) {
                    this.field_createTime = cursor.getLong(i);
                } else if (bEW == hashCode) {
                    this.field_state = cursor.getInt(i);
                } else if (btm == hashCode) {
                    this.nmb = cursor.getLong(i);
                }
            }
        }
    }

    public final ContentValues py() {
        ContentValues contentValues = new ContentValues();
        if (this.bNz) {
            contentValues.put("wxGroupId", this.field_wxGroupId);
        }
        if (this.bEH) {
            contentValues.put("groupId", this.field_groupId);
        }
        if (this.bNA) {
            contentValues.put("roomId", Integer.valueOf(this.field_roomId));
        }
        if (this.bNB) {
            contentValues.put("roomKey", Long.valueOf(this.field_roomKey));
        }
        if (this.bNC) {
            contentValues.put("routeId", Integer.valueOf(this.field_routeId));
        }
        if (this.bND) {
            contentValues.put("inviteUserName", this.field_inviteUserName);
        }
        if (this.bNE) {
            contentValues.put("memberCount", Integer.valueOf(this.field_memberCount));
        }
        if (this.btS) {
            contentValues.put("createTime", Long.valueOf(this.field_createTime));
        }
        if (this.bEA) {
            contentValues.put("state", Integer.valueOf(this.field_state));
        }
        if (this.nmb > 0) {
            contentValues.put("rowid", Long.valueOf(this.nmb));
        }
        return contentValues;
    }
}
