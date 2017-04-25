package com.tencent.mm.e.b;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.h.c;
import com.tencent.tmassistantsdk.storage.table.DownloadSettingTable.Columns;

public abstract class ct extends c {
    private static final int bSS = "logtime".hashCode();
    private static final int bST = "logsize".hashCode();
    private static final int bSU = "errorcount".hashCode();
    private static final int btA = Columns.VALUE.hashCode();
    public static final String[] btd = new String[]{"CREATE INDEX IF NOT EXISTS snsreport_kv_logtime ON SnsReportKv(logtime)"};
    private static final int btm = "rowid".hashCode();
    private static final int bvf = "offset".hashCode();
    private boolean bSP = true;
    private boolean bSQ = true;
    private boolean bSR = true;
    private boolean bts = true;
    private boolean buO = true;
    public int field_errorcount;
    public int field_logsize;
    public long field_logtime;
    public int field_offset;
    public byte[] field_value;

    public void b(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (bSS == hashCode) {
                    this.field_logtime = cursor.getLong(i);
                } else if (bvf == hashCode) {
                    this.field_offset = cursor.getInt(i);
                } else if (bST == hashCode) {
                    this.field_logsize = cursor.getInt(i);
                } else if (bSU == hashCode) {
                    this.field_errorcount = cursor.getInt(i);
                } else if (btA == hashCode) {
                    this.field_value = cursor.getBlob(i);
                } else if (btm == hashCode) {
                    this.nmb = cursor.getLong(i);
                }
            }
        }
    }

    public final ContentValues py() {
        ContentValues contentValues = new ContentValues();
        if (this.bSP) {
            contentValues.put("logtime", Long.valueOf(this.field_logtime));
        }
        if (this.buO) {
            contentValues.put("offset", Integer.valueOf(this.field_offset));
        }
        if (this.bSQ) {
            contentValues.put("logsize", Integer.valueOf(this.field_logsize));
        }
        if (this.bSR) {
            contentValues.put("errorcount", Integer.valueOf(this.field_errorcount));
        }
        if (this.bts) {
            contentValues.put(Columns.VALUE, this.field_value);
        }
        if (this.nmb > 0) {
            contentValues.put("rowid", Long.valueOf(this.nmb));
        }
        return contentValues;
    }
}
