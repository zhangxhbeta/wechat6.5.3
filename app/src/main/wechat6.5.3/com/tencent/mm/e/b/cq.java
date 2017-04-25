package com.tencent.mm.e.b;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.h.c;
import com.tencent.tmassistantsdk.storage.table.ClientInfoTable.Columns;
import com.tencent.tmassistantsdk.storage.table.DownloadSettingTable;

public abstract class cq extends c {
    private static final int bGc = "talker".hashCode();
    private static final int bJC = "isRead".hashCode();
    private static final int bSk = "snsID".hashCode();
    private static final int bSl = "parentID".hashCode();
    private static final int bSm = "curActionBuf".hashCode();
    private static final int bSn = "refActionBuf".hashCode();
    private static final int bSo = "commentSvrID".hashCode();
    private static final int bSp = Columns.CLIENTID.hashCode();
    private static final int bSq = "commentflag".hashCode();
    public static final String[] btd = new String[]{"CREATE INDEX IF NOT EXISTS SnsComment_snsID_index ON SnsComment(snsID)", "CREATE INDEX IF NOT EXISTS SnsComment_parentID_index ON SnsComment(parentID)", "CREATE INDEX IF NOT EXISTS SnsComment_isRead_index ON SnsComment(isRead)", "CREATE INDEX IF NOT EXISTS SnsComment_isSend_index ON SnsComment(isSend)"};
    private static final int btm = "rowid".hashCode();
    private static final int bun = "createTime".hashCode();
    private static final int buq = DownloadSettingTable.Columns.TYPE.hashCode();
    private static final int byD = "isSend".hashCode();
    private boolean bFM = true;
    private boolean bJu = true;
    private boolean bSd = true;
    private boolean bSe = true;
    private boolean bSf = true;
    private boolean bSg = true;
    private boolean bSh = true;
    private boolean bSi = true;
    private boolean bSj = true;
    private boolean btS = true;
    private boolean btV = true;
    private boolean byp = true;
    public String field_clientId;
    public long field_commentSvrID;
    public int field_commentflag;
    public int field_createTime;
    public byte[] field_curActionBuf;
    public short field_isRead;
    public boolean field_isSend;
    public long field_parentID;
    public byte[] field_refActionBuf;
    public long field_snsID;
    public String field_talker;
    public int field_type;

    public void b(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (bSk == hashCode) {
                    this.field_snsID = cursor.getLong(i);
                } else if (bSl == hashCode) {
                    this.field_parentID = cursor.getLong(i);
                } else if (bJC == hashCode) {
                    this.field_isRead = cursor.getShort(i);
                } else if (bun == hashCode) {
                    this.field_createTime = cursor.getInt(i);
                } else if (bGc == hashCode) {
                    this.field_talker = cursor.getString(i);
                } else if (buq == hashCode) {
                    this.field_type = cursor.getInt(i);
                } else if (byD == hashCode) {
                    this.field_isSend = cursor.getInt(i) != 0;
                } else if (bSm == hashCode) {
                    this.field_curActionBuf = cursor.getBlob(i);
                } else if (bSn == hashCode) {
                    this.field_refActionBuf = cursor.getBlob(i);
                } else if (bSo == hashCode) {
                    this.field_commentSvrID = cursor.getLong(i);
                } else if (bSp == hashCode) {
                    this.field_clientId = cursor.getString(i);
                } else if (bSq == hashCode) {
                    this.field_commentflag = cursor.getInt(i);
                } else if (btm == hashCode) {
                    this.nmb = cursor.getLong(i);
                }
            }
        }
    }

    public final ContentValues py() {
        ContentValues contentValues = new ContentValues();
        if (this.bSd) {
            contentValues.put("snsID", Long.valueOf(this.field_snsID));
        }
        if (this.bSe) {
            contentValues.put("parentID", Long.valueOf(this.field_parentID));
        }
        if (this.bJu) {
            contentValues.put("isRead", Short.valueOf(this.field_isRead));
        }
        if (this.btS) {
            contentValues.put("createTime", Integer.valueOf(this.field_createTime));
        }
        if (this.bFM) {
            contentValues.put("talker", this.field_talker);
        }
        if (this.btV) {
            contentValues.put(DownloadSettingTable.Columns.TYPE, Integer.valueOf(this.field_type));
        }
        if (this.byp) {
            contentValues.put("isSend", Boolean.valueOf(this.field_isSend));
        }
        if (this.bSf) {
            contentValues.put("curActionBuf", this.field_curActionBuf);
        }
        if (this.bSg) {
            contentValues.put("refActionBuf", this.field_refActionBuf);
        }
        if (this.bSh) {
            contentValues.put("commentSvrID", Long.valueOf(this.field_commentSvrID));
        }
        if (this.bSi) {
            contentValues.put(Columns.CLIENTID, this.field_clientId);
        }
        if (this.bSj) {
            contentValues.put("commentflag", Integer.valueOf(this.field_commentflag));
        }
        if (this.nmb > 0) {
            contentValues.put("rowid", Long.valueOf(this.nmb));
        }
        return contentValues;
    }
}
