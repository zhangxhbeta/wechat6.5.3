package com.tencent.mm.e.b;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.h.c;

public abstract class co extends c {
    private static final int bId = "fileName".hashCode();
    private static final int bMC = "position".hashCode();
    private static final int bRX = "cnValue".hashCode();
    private static final int bRY = "qqValue".hashCode();
    private static final int bRZ = "twValue".hashCode();
    private static final int bSa = "enValue".hashCode();
    private static final int bSb = "thValue".hashCode();
    private static final int bSc = "eggIndex".hashCode();
    public static final String[] btd = new String[0];
    private static final int btm = "rowid".hashCode();
    private static final int bvr = "key".hashCode();
    private static final int bxU = "flag".hashCode();
    private boolean bHQ = true;
    private boolean bMu = true;
    private boolean bRR = true;
    private boolean bRS = true;
    private boolean bRT = true;
    private boolean bRU = true;
    private boolean bRV = true;
    private boolean bRW = true;
    private boolean bvq = true;
    private boolean bxS = true;
    public String field_cnValue;
    public int field_eggIndex;
    public String field_enValue;
    public String field_fileName;
    public int field_flag;
    public String field_key;
    public int field_position;
    public String field_qqValue;
    public String field_thValue;
    public String field_twValue;

    public final void b(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (bvr == hashCode) {
                    this.field_key = cursor.getString(i);
                    this.bvq = true;
                } else if (bRX == hashCode) {
                    this.field_cnValue = cursor.getString(i);
                } else if (bRY == hashCode) {
                    this.field_qqValue = cursor.getString(i);
                } else if (bRZ == hashCode) {
                    this.field_twValue = cursor.getString(i);
                } else if (bSa == hashCode) {
                    this.field_enValue = cursor.getString(i);
                } else if (bSb == hashCode) {
                    this.field_thValue = cursor.getString(i);
                } else if (bId == hashCode) {
                    this.field_fileName = cursor.getString(i);
                } else if (bSc == hashCode) {
                    this.field_eggIndex = cursor.getInt(i);
                } else if (bMC == hashCode) {
                    this.field_position = cursor.getInt(i);
                } else if (bxU == hashCode) {
                    this.field_flag = cursor.getInt(i);
                } else if (btm == hashCode) {
                    this.nmb = cursor.getLong(i);
                }
            }
        }
    }

    public final ContentValues py() {
        ContentValues contentValues = new ContentValues();
        if (this.bvq) {
            contentValues.put("key", this.field_key);
        }
        if (this.bRR) {
            contentValues.put("cnValue", this.field_cnValue);
        }
        if (this.bRS) {
            contentValues.put("qqValue", this.field_qqValue);
        }
        if (this.bRT) {
            contentValues.put("twValue", this.field_twValue);
        }
        if (this.bRU) {
            contentValues.put("enValue", this.field_enValue);
        }
        if (this.bRV) {
            contentValues.put("thValue", this.field_thValue);
        }
        if (this.bHQ) {
            contentValues.put("fileName", this.field_fileName);
        }
        if (this.bRW) {
            contentValues.put("eggIndex", Integer.valueOf(this.field_eggIndex));
        }
        if (this.bMu) {
            contentValues.put("position", Integer.valueOf(this.field_position));
        }
        if (this.bxS) {
            contentValues.put("flag", Integer.valueOf(this.field_flag));
        }
        if (this.nmb > 0) {
            contentValues.put("rowid", Long.valueOf(this.nmb));
        }
        return contentValues;
    }
}
