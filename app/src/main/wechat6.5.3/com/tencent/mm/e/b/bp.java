package com.tencent.mm.e.b;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.h.c;

public abstract class bp extends c {
    private static final int bLI = "wechatUsername".hashCode();
    private static final int bLJ = "systemAddressBookUsername".hashCode();
    private static final int bLK = "contactId".hashCode();
    private static final int bLL = "sortKey".hashCode();
    public static final String[] btd = new String[0];
    private static final int btm = "rowid".hashCode();
    private boolean bLE = true;
    private boolean bLF = true;
    private boolean bLG = true;
    private boolean bLH = true;
    public String field_contactId;
    public String field_sortKey;
    public String field_systemAddressBookUsername;
    public String field_wechatUsername;

    public final void b(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (bLI == hashCode) {
                    this.field_wechatUsername = cursor.getString(i);
                } else if (bLJ == hashCode) {
                    this.field_systemAddressBookUsername = cursor.getString(i);
                } else if (bLK == hashCode) {
                    this.field_contactId = cursor.getString(i);
                } else if (bLL == hashCode) {
                    this.field_sortKey = cursor.getString(i);
                } else if (btm == hashCode) {
                    this.nmb = cursor.getLong(i);
                }
            }
        }
    }

    public final ContentValues py() {
        ContentValues contentValues = new ContentValues();
        if (this.bLE) {
            contentValues.put("wechatUsername", this.field_wechatUsername);
        }
        if (this.bLF) {
            contentValues.put("systemAddressBookUsername", this.field_systemAddressBookUsername);
        }
        if (this.bLG) {
            contentValues.put("contactId", this.field_contactId);
        }
        if (this.bLH) {
            contentValues.put("sortKey", this.field_sortKey);
        }
        if (this.nmb > 0) {
            contentValues.put("rowid", Long.valueOf(this.nmb));
        }
        return contentValues;
    }
}
