package com.tencent.mm.e.b;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.h.c;

public abstract class ap extends c {
    private static final int bFH = "prodcutID".hashCode();
    private static final int bFI = "totalCount".hashCode();
    private static final int bFJ = "continuCount".hashCode();
    private static final int bFK = "showTipsTime".hashCode();
    private static final int bFL = "setFlagTime".hashCode();
    public static final String[] btd = new String[0];
    private static final int btm = "rowid".hashCode();
    private static final int bwW = "modifyTime".hashCode();
    private static final int bxU = "flag".hashCode();
    private boolean bFC = true;
    private boolean bFD = true;
    private boolean bFE = true;
    private boolean bFF = true;
    private boolean bFG = true;
    private boolean bwA = true;
    private boolean bxS = true;
    public int field_continuCount;
    public int field_flag;
    public long field_modifyTime;
    public String field_prodcutID;
    public long field_setFlagTime;
    public long field_showTipsTime;
    public int field_totalCount;

    public final void b(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (bFH == hashCode) {
                    this.field_prodcutID = cursor.getString(i);
                    this.bFC = true;
                } else if (bFI == hashCode) {
                    this.field_totalCount = cursor.getInt(i);
                } else if (bFJ == hashCode) {
                    this.field_continuCount = cursor.getInt(i);
                } else if (bxU == hashCode) {
                    this.field_flag = cursor.getInt(i);
                } else if (bwW == hashCode) {
                    this.field_modifyTime = cursor.getLong(i);
                } else if (bFK == hashCode) {
                    this.field_showTipsTime = cursor.getLong(i);
                } else if (bFL == hashCode) {
                    this.field_setFlagTime = cursor.getLong(i);
                } else if (btm == hashCode) {
                    this.nmb = cursor.getLong(i);
                }
            }
        }
    }

    public final ContentValues py() {
        ContentValues contentValues = new ContentValues();
        if (this.bFC) {
            contentValues.put("prodcutID", this.field_prodcutID);
        }
        if (this.bFD) {
            contentValues.put("totalCount", Integer.valueOf(this.field_totalCount));
        }
        if (this.bFE) {
            contentValues.put("continuCount", Integer.valueOf(this.field_continuCount));
        }
        if (this.bxS) {
            contentValues.put("flag", Integer.valueOf(this.field_flag));
        }
        if (this.bwA) {
            contentValues.put("modifyTime", Long.valueOf(this.field_modifyTime));
        }
        if (this.bFF) {
            contentValues.put("showTipsTime", Long.valueOf(this.field_showTipsTime));
        }
        if (this.bFG) {
            contentValues.put("setFlagTime", Long.valueOf(this.field_setFlagTime));
        }
        if (this.nmb > 0) {
            contentValues.put("rowid", Long.valueOf(this.nmb));
        }
        return contentValues;
    }
}
