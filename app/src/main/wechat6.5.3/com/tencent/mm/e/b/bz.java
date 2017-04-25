package com.tencent.mm.e.b;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.h.c;
import com.tencent.tmassistantsdk.downloadservice.DownloadInfo;

public abstract class bz extends c {
    private static final int bNF = "wxGroupId".hashCode();
    private static final int bNJ = "inviteUserName".hashCode();
    private static final int bNN = "memberUuid".hashCode();
    private static final int bNO = "memberId".hashCode();
    public static final String[] btd = new String[0];
    private static final int btm = "rowid".hashCode();
    private static final int bul = "userName".hashCode();
    private static final int bun = "createTime".hashCode();
    private static final int bvg = DownloadInfo.STATUS.hashCode();
    private boolean bND = true;
    private boolean bNL = true;
    private boolean bNM = true;
    private boolean bNz = true;
    private boolean btQ = true;
    private boolean btS = true;
    private boolean buP = true;
    public long field_createTime;
    public String field_inviteUserName;
    public long field_memberId;
    public long field_memberUuid;
    public int field_status;
    public String field_userName;
    public String field_wxGroupId;

    public final void b(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (bNN == hashCode) {
                    this.field_memberUuid = cursor.getLong(i);
                } else if (bNF == hashCode) {
                    this.field_wxGroupId = cursor.getString(i);
                } else if (bul == hashCode) {
                    this.field_userName = cursor.getString(i);
                } else if (bNJ == hashCode) {
                    this.field_inviteUserName = cursor.getString(i);
                } else if (bNO == hashCode) {
                    this.field_memberId = cursor.getLong(i);
                } else if (bvg == hashCode) {
                    this.field_status = cursor.getInt(i);
                } else if (bun == hashCode) {
                    this.field_createTime = cursor.getLong(i);
                } else if (btm == hashCode) {
                    this.nmb = cursor.getLong(i);
                }
            }
        }
    }

    public final ContentValues py() {
        ContentValues contentValues = new ContentValues();
        if (this.bNL) {
            contentValues.put("memberUuid", Long.valueOf(this.field_memberUuid));
        }
        if (this.bNz) {
            contentValues.put("wxGroupId", this.field_wxGroupId);
        }
        if (this.btQ) {
            contentValues.put("userName", this.field_userName);
        }
        if (this.bND) {
            contentValues.put("inviteUserName", this.field_inviteUserName);
        }
        if (this.bNM) {
            contentValues.put("memberId", Long.valueOf(this.field_memberId));
        }
        if (this.buP) {
            contentValues.put(DownloadInfo.STATUS, Integer.valueOf(this.field_status));
        }
        if (this.btS) {
            contentValues.put("createTime", Long.valueOf(this.field_createTime));
        }
        if (this.nmb > 0) {
            contentValues.put("rowid", Long.valueOf(this.nmb));
        }
        return contentValues;
    }
}
