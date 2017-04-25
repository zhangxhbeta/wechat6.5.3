package com.tencent.mm.e.b;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.h.c;

public abstract class b extends c {
    public static final String[] btd = new String[0];
    private static final int btj = "insertmsg".hashCode();
    private static final int btm = "rowid".hashCode();
    private static final int btp = "billNo".hashCode();
    private static final int btq = "localMsgId".hashCode();
    private boolean btf = true;
    private boolean btn = true;
    private boolean bto = true;
    public String field_billNo;
    public boolean field_insertmsg;
    public long field_localMsgId;

    public final void b(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (btp == hashCode) {
                    this.field_billNo = cursor.getString(i);
                    this.btn = true;
                } else if (btj == hashCode) {
                    this.field_insertmsg = cursor.getInt(i) != 0;
                } else if (btq == hashCode) {
                    this.field_localMsgId = cursor.getLong(i);
                } else if (btm == hashCode) {
                    this.nmb = cursor.getLong(i);
                }
            }
        }
    }

    public final ContentValues py() {
        ContentValues contentValues = new ContentValues();
        if (this.btn) {
            contentValues.put("billNo", this.field_billNo);
        }
        if (this.btf) {
            contentValues.put("insertmsg", Boolean.valueOf(this.field_insertmsg));
        }
        if (this.bto) {
            contentValues.put("localMsgId", Long.valueOf(this.field_localMsgId));
        }
        if (this.nmb > 0) {
            contentValues.put("rowid", Long.valueOf(this.nmb));
        }
        return contentValues;
    }
}
