package com.tencent.mm.e.b;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.h.c;

public abstract class ad extends c {
    private static final int bCH = "labelID".hashCode();
    private static final int bCI = "labelName".hashCode();
    private static final int bCJ = "labelPYFull".hashCode();
    private static final int bCK = "labelPYShort".hashCode();
    private static final int bCL = "isTemporary".hashCode();
    public static final String[] btd = new String[0];
    private static final int btm = "rowid".hashCode();
    private static final int bun = "createTime".hashCode();
    private boolean bCC = true;
    private boolean bCD = true;
    private boolean bCE = true;
    private boolean bCF = true;
    private boolean bCG = true;
    private boolean btS = true;
    public long field_createTime;
    public boolean field_isTemporary;
    public int field_labelID;
    public String field_labelName;
    public String field_labelPYFull;
    public String field_labelPYShort;

    public final void b(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (bCH == hashCode) {
                    this.field_labelID = cursor.getInt(i);
                    this.bCC = true;
                } else if (bCI == hashCode) {
                    this.field_labelName = cursor.getString(i);
                } else if (bCJ == hashCode) {
                    this.field_labelPYFull = cursor.getString(i);
                } else if (bCK == hashCode) {
                    this.field_labelPYShort = cursor.getString(i);
                } else if (bun == hashCode) {
                    this.field_createTime = cursor.getLong(i);
                } else if (bCL == hashCode) {
                    this.field_isTemporary = cursor.getInt(i) != 0;
                } else if (btm == hashCode) {
                    this.nmb = cursor.getLong(i);
                }
            }
        }
    }

    public final ContentValues py() {
        ContentValues contentValues = new ContentValues();
        if (this.bCC) {
            contentValues.put("labelID", Integer.valueOf(this.field_labelID));
        }
        if (this.bCD) {
            contentValues.put("labelName", this.field_labelName);
        }
        if (this.bCE) {
            contentValues.put("labelPYFull", this.field_labelPYFull);
        }
        if (this.bCF) {
            contentValues.put("labelPYShort", this.field_labelPYShort);
        }
        if (this.btS) {
            contentValues.put("createTime", Long.valueOf(this.field_createTime));
        }
        if (this.bCG) {
            contentValues.put("isTemporary", Boolean.valueOf(this.field_isTemporary));
        }
        if (this.nmb > 0) {
            contentValues.put("rowid", Long.valueOf(this.nmb));
        }
        return contentValues;
    }
}
