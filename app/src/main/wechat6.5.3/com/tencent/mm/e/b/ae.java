package com.tencent.mm.e.b;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.h.c;

public abstract class ae extends c {
    private static final int bCO = "labelId".hashCode();
    private static final int bCP = "contactName".hashCode();
    public static final String[] btd = new String[0];
    private static final int btm = "rowid".hashCode();
    private boolean bCM;
    private boolean bCN;
    public String field_contactName;
    public String field_labelId;

    public final void b(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (bCO == hashCode) {
                    this.field_labelId = cursor.getString(i);
                } else if (bCP == hashCode) {
                    this.field_contactName = cursor.getString(i);
                } else if (btm == hashCode) {
                    this.nmb = cursor.getLong(i);
                }
            }
        }
    }

    public final ContentValues py() {
        ContentValues contentValues = new ContentValues();
        if (this.bCM) {
            contentValues.put("labelId", this.field_labelId);
        }
        if (this.bCN) {
            contentValues.put("contactName", this.field_contactName);
        }
        if (this.nmb > 0) {
            contentValues.put("rowid", Long.valueOf(this.nmb));
        }
        return contentValues;
    }
}
