package com.tencent.mm.e.b;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.h.c;
import com.tencent.tmassistantsdk.storage.table.DownloadSettingTable.Columns;

public abstract class dl extends c {
    private static final int bWW = "domin".hashCode();
    private static final int btA = Columns.VALUE.hashCode();
    public static final String[] btd = new String[0];
    private static final int btm = "rowid".hashCode();
    private static final int buZ = "appId".hashCode();
    private static final int bvG = "recordId".hashCode();
    private static final int bvr = "key".hashCode();
    private boolean bWV = true;
    private boolean bts = true;
    private boolean buI = true;
    private boolean bvC = true;
    private boolean bvq = true;
    public String field_appId;
    public String field_domin;
    public String field_key;
    public int field_recordId;
    public String field_value;

    public final void b(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (bvG == hashCode) {
                    this.field_recordId = cursor.getInt(i);
                    this.bvC = true;
                } else if (buZ == hashCode) {
                    this.field_appId = cursor.getString(i);
                } else if (bWW == hashCode) {
                    this.field_domin = cursor.getString(i);
                } else if (bvr == hashCode) {
                    this.field_key = cursor.getString(i);
                } else if (btA == hashCode) {
                    this.field_value = cursor.getString(i);
                } else if (btm == hashCode) {
                    this.nmb = cursor.getLong(i);
                }
            }
        }
    }

    public final ContentValues py() {
        ContentValues contentValues = new ContentValues();
        if (this.bvC) {
            contentValues.put("recordId", Integer.valueOf(this.field_recordId));
        }
        if (this.buI) {
            contentValues.put("appId", this.field_appId);
        }
        if (this.bWV) {
            contentValues.put("domin", this.field_domin);
        }
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
