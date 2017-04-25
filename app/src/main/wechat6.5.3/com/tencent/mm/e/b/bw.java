package com.tencent.mm.e.b;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.h.c;

public abstract class bw extends c {
    private static final int bMO = "loan_jump_url".hashCode();
    private static final int bMP = "red_dot_index".hashCode();
    private static final int bMQ = "is_show_entry".hashCode();
    private static final int bMR = "tips".hashCode();
    private static final int bMS = "is_overdue".hashCode();
    private static final int bMT = "available_otb".hashCode();
    public static final String[] btd = new String[0];
    private static final int btm = "rowid".hashCode();
    private static final int bxP = "title".hashCode();
    private boolean bMI = true;
    private boolean bMJ = true;
    private boolean bMK = true;
    private boolean bML = true;
    private boolean bMM = true;
    private boolean bMN = true;
    private boolean bxL = true;
    public String field_available_otb;
    public int field_is_overdue;
    public int field_is_show_entry;
    public String field_loan_jump_url;
    public int field_red_dot_index;
    public String field_tips;
    public String field_title;

    public final void b(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (bxP == hashCode) {
                    this.field_title = cursor.getString(i);
                    this.bxL = true;
                } else if (bMO == hashCode) {
                    this.field_loan_jump_url = cursor.getString(i);
                } else if (bMP == hashCode) {
                    this.field_red_dot_index = cursor.getInt(i);
                } else if (bMQ == hashCode) {
                    this.field_is_show_entry = cursor.getInt(i);
                } else if (bMR == hashCode) {
                    this.field_tips = cursor.getString(i);
                } else if (bMS == hashCode) {
                    this.field_is_overdue = cursor.getInt(i);
                } else if (bMT == hashCode) {
                    this.field_available_otb = cursor.getString(i);
                } else if (btm == hashCode) {
                    this.nmb = cursor.getLong(i);
                }
            }
        }
    }

    public final ContentValues py() {
        ContentValues contentValues = new ContentValues();
        if (this.bxL) {
            contentValues.put("title", this.field_title);
        }
        if (this.bMI) {
            contentValues.put("loan_jump_url", this.field_loan_jump_url);
        }
        if (this.bMJ) {
            contentValues.put("red_dot_index", Integer.valueOf(this.field_red_dot_index));
        }
        if (this.bMK) {
            contentValues.put("is_show_entry", Integer.valueOf(this.field_is_show_entry));
        }
        if (this.bML) {
            contentValues.put("tips", this.field_tips);
        }
        if (this.bMM) {
            contentValues.put("is_overdue", Integer.valueOf(this.field_is_overdue));
        }
        if (this.bMN) {
            contentValues.put("available_otb", this.field_available_otb);
        }
        if (this.nmb > 0) {
            contentValues.put("rowid", Long.valueOf(this.nmb));
        }
        return contentValues;
    }
}
