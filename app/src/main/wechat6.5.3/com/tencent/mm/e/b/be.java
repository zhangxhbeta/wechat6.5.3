package com.tencent.mm.e.b;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.h.c;
import com.tencent.tmassistantsdk.storage.table.DownloadSettingTable.Columns;

public abstract class be extends c {
    private static final int btA = Columns.VALUE.hashCode();
    public static final String[] btd = new String[0];
    private static final int btm = "rowid".hashCode();
    private static final int bvr = "key".hashCode();
    private boolean bts = true;
    private boolean bvq = true;
    public String field_key;
    public byte[] field_value;

    public final void b(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (bvr == hashCode) {
                    this.field_key = cursor.getString(i);
                    this.bvq = true;
                } else if (btA == hashCode) {
                    this.field_value = cursor.getBlob(i);
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
        if (this.bts) {
            contentValues.put(Columns.VALUE, this.field_value);
        }
        if (this.nmb > 0) {
            contentValues.put("rowid", Long.valueOf(this.nmb));
        }
        return contentValues;
    }
}
