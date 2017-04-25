package com.tencent.mm.e.b;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.h.c;

public abstract class al extends c {
    private static final int bFt = "desc".hashCode();
    private static final int bFx = "groupID".hashCode();
    public static final String[] btd = new String[0];
    private static final int btm = "rowid".hashCode();
    private boolean bFp = true;
    private boolean bFw = true;
    public String field_desc;
    public String field_groupID;

    public final void b(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (bFx == hashCode) {
                    this.field_groupID = cursor.getString(i);
                } else if (bFt == hashCode) {
                    this.field_desc = cursor.getString(i);
                } else if (btm == hashCode) {
                    this.nmb = cursor.getLong(i);
                }
            }
        }
    }

    public final ContentValues py() {
        ContentValues contentValues = new ContentValues();
        if (this.bFw) {
            contentValues.put("groupID", this.field_groupID);
        }
        if (this.bFp) {
            contentValues.put("desc", this.field_desc);
        }
        if (this.nmb > 0) {
            contentValues.put("rowid", Long.valueOf(this.nmb));
        }
        return contentValues;
    }
}
