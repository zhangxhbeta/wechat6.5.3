package com.tencent.mm.e.b;

import android.content.ContentValues;
import android.database.Cursor;

public abstract class c extends com.tencent.mm.sdk.h.c {
    private static final int btA = "value".hashCode();
    private static final int btB = "expId".hashCode();
    private static final int btC = "sequence".hashCode();
    private static final int btD = "prioritylevel".hashCode();
    private static final int btE = "startTime".hashCode();
    private static final int btF = "endTime".hashCode();
    private static final int btG = "noReport".hashCode();
    public static final String[] btd = new String[0];
    private static final int btm = "rowid".hashCode();
    private static final int btz = "abtestkey".hashCode();
    private boolean btr = true;
    private boolean bts = true;
    private boolean btt = true;
    private boolean btu = true;
    private boolean btv = true;
    private boolean btw = true;
    private boolean btx = true;
    private boolean bty = true;
    public String field_abtestkey;
    public long field_endTime;
    public String field_expId;
    public boolean field_noReport;
    public int field_prioritylevel;
    public long field_sequence;
    public long field_startTime;
    public String field_value;

    public final void b(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (btz == hashCode) {
                    this.field_abtestkey = cursor.getString(i);
                    this.btr = true;
                } else if (btA == hashCode) {
                    this.field_value = cursor.getString(i);
                } else if (btB == hashCode) {
                    this.field_expId = cursor.getString(i);
                } else if (btC == hashCode) {
                    this.field_sequence = cursor.getLong(i);
                } else if (btD == hashCode) {
                    this.field_prioritylevel = cursor.getInt(i);
                } else if (btE == hashCode) {
                    this.field_startTime = cursor.getLong(i);
                } else if (btF == hashCode) {
                    this.field_endTime = cursor.getLong(i);
                } else if (btG == hashCode) {
                    this.field_noReport = cursor.getInt(i) != 0;
                } else if (btm == hashCode) {
                    this.nmb = cursor.getLong(i);
                }
            }
        }
    }

    public final ContentValues py() {
        ContentValues contentValues = new ContentValues();
        if (this.btr) {
            contentValues.put("abtestkey", this.field_abtestkey);
        }
        if (this.bts) {
            contentValues.put("value", this.field_value);
        }
        if (this.btt) {
            contentValues.put("expId", this.field_expId);
        }
        if (this.btu) {
            contentValues.put("sequence", Long.valueOf(this.field_sequence));
        }
        if (this.btv) {
            contentValues.put("prioritylevel", Integer.valueOf(this.field_prioritylevel));
        }
        if (this.btw) {
            contentValues.put("startTime", Long.valueOf(this.field_startTime));
        }
        if (this.btx) {
            contentValues.put("endTime", Long.valueOf(this.field_endTime));
        }
        if (this.bty) {
            contentValues.put("noReport", Boolean.valueOf(this.field_noReport));
        }
        if (this.nmb > 0) {
            contentValues.put("rowid", Long.valueOf(this.nmb));
        }
        return contentValues;
    }
}
