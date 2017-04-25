package com.tencent.mm.e.b;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.h.c;

public abstract class cm extends c {
    private static final int bAw = "card_id".hashCode();
    private static final int bPc = "retryCount".hashCode();
    private static final int bRE = "state_flag".hashCode();
    private static final int bRF = "update_time".hashCode();
    private static final int bRG = "seq".hashCode();
    public static final String[] btd = new String[0];
    private static final int btm = "rowid".hashCode();
    private boolean bAf = true;
    private boolean bPa = true;
    private boolean bRB = true;
    private boolean bRC = true;
    private boolean bRD = true;
    public String field_card_id;
    public int field_retryCount;
    public long field_seq;
    public int field_state_flag;
    public long field_update_time;

    public final void b(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (bAw == hashCode) {
                    this.field_card_id = cursor.getString(i);
                    this.bAf = true;
                } else if (bRE == hashCode) {
                    this.field_state_flag = cursor.getInt(i);
                } else if (bRF == hashCode) {
                    this.field_update_time = cursor.getLong(i);
                } else if (bRG == hashCode) {
                    this.field_seq = cursor.getLong(i);
                } else if (bPc == hashCode) {
                    this.field_retryCount = cursor.getInt(i);
                } else if (btm == hashCode) {
                    this.nmb = cursor.getLong(i);
                }
            }
        }
    }

    public final ContentValues py() {
        ContentValues contentValues = new ContentValues();
        if (this.bAf) {
            contentValues.put("card_id", this.field_card_id);
        }
        if (this.bRB) {
            contentValues.put("state_flag", Integer.valueOf(this.field_state_flag));
        }
        if (this.bRC) {
            contentValues.put("update_time", Long.valueOf(this.field_update_time));
        }
        if (this.bRD) {
            contentValues.put("seq", Long.valueOf(this.field_seq));
        }
        if (this.bPa) {
            contentValues.put("retryCount", Integer.valueOf(this.field_retryCount));
        }
        if (this.nmb > 0) {
            contentValues.put("rowid", Long.valueOf(this.nmb));
        }
        return contentValues;
    }
}
