package com.tencent.mm.e.b;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.h.c;

public abstract class i extends c {
    public static final String[] btd = new String[0];
    private static final int btm = "rowid".hashCode();
    private static final int buZ = "appId".hashCode();
    private static final int bvu = "appIdHashCode".hashCode();
    private static final int bvv = "permByteString".hashCode();
    private boolean buI = true;
    private boolean bvs = true;
    private boolean bvt = true;
    public String field_appId;
    public int field_appIdHashCode;
    public String field_permByteString;

    public final void b(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (bvu == hashCode) {
                    this.field_appIdHashCode = cursor.getInt(i);
                    this.bvs = true;
                } else if (buZ == hashCode) {
                    this.field_appId = cursor.getString(i);
                } else if (bvv == hashCode) {
                    this.field_permByteString = cursor.getString(i);
                } else if (btm == hashCode) {
                    this.nmb = cursor.getLong(i);
                }
            }
        }
    }

    public final ContentValues py() {
        ContentValues contentValues = new ContentValues();
        if (this.bvs) {
            contentValues.put("appIdHashCode", Integer.valueOf(this.field_appIdHashCode));
        }
        if (this.buI) {
            contentValues.put("appId", this.field_appId);
        }
        if (this.bvt) {
            contentValues.put("permByteString", this.field_permByteString);
        }
        if (this.nmb > 0) {
            contentValues.put("rowid", Long.valueOf(this.nmb));
        }
        return contentValues;
    }
}
