package com.tencent.mm.plugin.shake.a.a;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.h.c;
import com.tencent.tmassistantsdk.downloadservice.DownloadInfo;
import com.tencent.tmassistantsdk.storage.table.DownloadSettingTable.Columns;

public abstract class a extends c {
    private static final int bET = "svrid".hashCode();
    private static final int bEY = "reserved1".hashCode();
    private static final int bEZ = "reserved2".hashCode();
    private static final int bFa = "reserved3".hashCode();
    private static final int bFt = "desc".hashCode();
    private static final int bHI = "tag".hashCode();
    private static final int bHv = "subtype".hashCode();
    private static final int bMn = "createtime".hashCode();
    public static final String[] btd = new String[0];
    private static final int btm = "rowid".hashCode();
    private static final int buq = Columns.TYPE.hashCode();
    private static final int bvg = DownloadInfo.STATUS.hashCode();
    private static final int bxP = "title".hashCode();
    private static final int iNR = "thumburl".hashCode();
    private static final int iNS = "reservedBuf".hashCode();
    private boolean bEC = true;
    private boolean bED = true;
    private boolean bEE = true;
    private boolean bEx = true;
    private boolean bFp = true;
    private boolean bHt = true;
    private boolean bHz = true;
    private boolean bMi = true;
    private boolean btV = true;
    private boolean buP = true;
    private boolean bxL = true;
    public long field_createtime;
    public String field_desc;
    public String field_reserved1;
    public String field_reserved2;
    public int field_reserved3;
    public byte[] field_reservedBuf;
    public int field_status;
    public int field_subtype;
    public long field_svrid;
    public String field_tag;
    public String field_thumburl;
    public String field_title;
    public int field_type;
    private boolean iNP = true;
    private boolean iNQ = true;

    public final void b(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (bET == hashCode) {
                    this.field_svrid = cursor.getLong(i);
                    this.bEx = true;
                } else if (buq == hashCode) {
                    this.field_type = cursor.getInt(i);
                } else if (bHv == hashCode) {
                    this.field_subtype = cursor.getInt(i);
                } else if (bMn == hashCode) {
                    this.field_createtime = cursor.getLong(i);
                } else if (bHI == hashCode) {
                    this.field_tag = cursor.getString(i);
                } else if (bvg == hashCode) {
                    this.field_status = cursor.getInt(i);
                } else if (bxP == hashCode) {
                    this.field_title = cursor.getString(i);
                } else if (bFt == hashCode) {
                    this.field_desc = cursor.getString(i);
                } else if (iNR == hashCode) {
                    this.field_thumburl = cursor.getString(i);
                } else if (bEY == hashCode) {
                    this.field_reserved1 = cursor.getString(i);
                } else if (bEZ == hashCode) {
                    this.field_reserved2 = cursor.getString(i);
                } else if (bFa == hashCode) {
                    this.field_reserved3 = cursor.getInt(i);
                } else if (iNS == hashCode) {
                    this.field_reservedBuf = cursor.getBlob(i);
                } else if (btm == hashCode) {
                    this.nmb = cursor.getLong(i);
                }
            }
        }
    }

    public final ContentValues py() {
        ContentValues contentValues = new ContentValues();
        if (this.bEx) {
            contentValues.put("svrid", Long.valueOf(this.field_svrid));
        }
        if (this.btV) {
            contentValues.put(Columns.TYPE, Integer.valueOf(this.field_type));
        }
        if (this.bHt) {
            contentValues.put("subtype", Integer.valueOf(this.field_subtype));
        }
        if (this.bMi) {
            contentValues.put("createtime", Long.valueOf(this.field_createtime));
        }
        if (this.bHz) {
            contentValues.put("tag", this.field_tag);
        }
        if (this.buP) {
            contentValues.put(DownloadInfo.STATUS, Integer.valueOf(this.field_status));
        }
        if (this.bxL) {
            contentValues.put("title", this.field_title);
        }
        if (this.bFp) {
            contentValues.put("desc", this.field_desc);
        }
        if (this.iNP) {
            contentValues.put("thumburl", this.field_thumburl);
        }
        if (this.bEC) {
            contentValues.put("reserved1", this.field_reserved1);
        }
        if (this.bED) {
            contentValues.put("reserved2", this.field_reserved2);
        }
        if (this.bEE) {
            contentValues.put("reserved3", Integer.valueOf(this.field_reserved3));
        }
        if (this.iNQ) {
            contentValues.put("reservedBuf", this.field_reservedBuf);
        }
        if (this.nmb > 0) {
            contentValues.put("rowid", Long.valueOf(this.nmb));
        }
        return contentValues;
    }
}
