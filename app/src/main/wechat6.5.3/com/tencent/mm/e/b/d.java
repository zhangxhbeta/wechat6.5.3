package com.tencent.mm.e.b;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.h.c;
import com.tencent.mmdb.database.SQLiteDatabase;

public abstract class d extends c {
    private static final int btB = "expId".hashCode();
    private static final int btC = "sequence".hashCode();
    private static final int btD = "prioritylevel".hashCode();
    private static final int btE = "startTime".hashCode();
    private static final int btF = "endTime".hashCode();
    private static final int btL = "layerId".hashCode();
    private static final int btM = "business".hashCode();
    private static final int btN = "needReport".hashCode();
    private static final int btO = "rawXML".hashCode();
    public static final String[] btd = new String[0];
    private static final int btm = "rowid".hashCode();
    private boolean btH = true;
    private boolean btI = true;
    private boolean btJ = true;
    private boolean btK = true;
    private boolean btt = true;
    private boolean btu = true;
    private boolean btv = true;
    private boolean btw = true;
    private boolean btx = true;
    public String field_business;
    public long field_endTime;
    public String field_expId;
    public String field_layerId;
    public boolean field_needReport;
    public int field_prioritylevel;
    public String field_rawXML;
    public long field_sequence;
    public long field_startTime;

    public final void b(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (btL == hashCode) {
                    this.field_layerId = cursor.getString(i);
                    this.btH = true;
                } else if (btM == hashCode) {
                    this.field_business = cursor.getString(i);
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
                } else if (btN == hashCode) {
                    this.field_needReport = cursor.getInt(i) != 0;
                } else if (btO == hashCode) {
                    this.field_rawXML = cursor.getString(i);
                } else if (btm == hashCode) {
                    this.nmb = cursor.getLong(i);
                }
            }
        }
    }

    public final ContentValues py() {
        ContentValues contentValues = new ContentValues();
        if (this.btH) {
            contentValues.put("layerId", this.field_layerId);
        }
        if (this.btI) {
            contentValues.put("business", this.field_business);
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
        if (this.btJ) {
            contentValues.put("needReport", Boolean.valueOf(this.field_needReport));
        }
        if (this.field_rawXML == null) {
            this.field_rawXML = SQLiteDatabase.KeyEmpty;
        }
        if (this.btK) {
            contentValues.put("rawXML", this.field_rawXML);
        }
        if (this.nmb > 0) {
            contentValues.put("rowid", Long.valueOf(this.nmb));
        }
        return contentValues;
    }
}
