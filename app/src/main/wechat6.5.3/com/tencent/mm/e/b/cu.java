package com.tencent.mm.e.b;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.h.c;

public abstract class cu extends c {
    private static final int bEv = "count".hashCode();
    private static final int bSY = "tagId".hashCode();
    private static final int bSZ = "tagName".hashCode();
    private static final int bTa = "memberList".hashCode();
    public static final String[] btd = new String[0];
    private static final int btm = "rowid".hashCode();
    private boolean bDV = true;
    private boolean bSV = true;
    private boolean bSW = true;
    private boolean bSX = true;
    public int field_count;
    public String field_memberList;
    public long field_tagId;
    public String field_tagName;

    public void b(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (bSY == hashCode) {
                    this.field_tagId = cursor.getLong(i);
                } else if (bSZ == hashCode) {
                    this.field_tagName = cursor.getString(i);
                } else if (bEv == hashCode) {
                    this.field_count = cursor.getInt(i);
                } else if (bTa == hashCode) {
                    this.field_memberList = cursor.getString(i);
                } else if (btm == hashCode) {
                    this.nmb = cursor.getLong(i);
                }
            }
        }
    }

    public final ContentValues py() {
        ContentValues contentValues = new ContentValues();
        if (this.bSV) {
            contentValues.put("tagId", Long.valueOf(this.field_tagId));
        }
        if (this.field_tagName == null) {
            this.field_tagName = "";
        }
        if (this.bSW) {
            contentValues.put("tagName", this.field_tagName);
        }
        if (this.bDV) {
            contentValues.put("count", Integer.valueOf(this.field_count));
        }
        if (this.field_memberList == null) {
            this.field_memberList = "";
        }
        if (this.bSX) {
            contentValues.put("memberList", this.field_memberList);
        }
        if (this.nmb > 0) {
            contentValues.put("rowid", Long.valueOf(this.nmb));
        }
        return contentValues;
    }
}
