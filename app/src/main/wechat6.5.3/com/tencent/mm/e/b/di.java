package com.tencent.mm.e.b;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.h.c;

public abstract class di extends c {
    private static final int bGJ = "configId".hashCode();
    private static final int bWA = "configResources".hashCode();
    private static final int bWB = "configCrc32".hashCode();
    private static final int bWC = "isFromXml".hashCode();
    private static final int bWy = "disable".hashCode();
    private static final int bWz = "configUrl".hashCode();
    public static final String[] btd = new String[0];
    private static final int btm = "rowid".hashCode();
    private boolean bGI = true;
    private boolean bWt = true;
    private boolean bWu = true;
    private boolean bWv = true;
    private boolean bWw = true;
    private boolean bWx = true;
    public long field_configCrc32;
    public String field_configId;
    public String field_configResources;
    public String field_configUrl;
    public boolean field_disable;
    public boolean field_isFromXml;

    public final void b(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (bWy == hashCode) {
                    boolean z;
                    if (cursor.getInt(i) != 0) {
                        z = true;
                    } else {
                        z = false;
                    }
                    this.field_disable = z;
                } else if (bGJ == hashCode) {
                    this.field_configId = cursor.getString(i);
                    this.bGI = true;
                } else if (bWz == hashCode) {
                    this.field_configUrl = cursor.getString(i);
                } else if (bWA == hashCode) {
                    this.field_configResources = cursor.getString(i);
                } else if (bWB == hashCode) {
                    this.field_configCrc32 = cursor.getLong(i);
                } else if (bWC == hashCode) {
                    this.field_isFromXml = cursor.getInt(i) != 0;
                } else if (btm == hashCode) {
                    this.nmb = cursor.getLong(i);
                }
            }
        }
    }

    public final ContentValues py() {
        ContentValues contentValues = new ContentValues();
        if (this.bWt) {
            contentValues.put("disable", Boolean.valueOf(this.field_disable));
        }
        if (this.bGI) {
            contentValues.put("configId", this.field_configId);
        }
        if (this.bWu) {
            contentValues.put("configUrl", this.field_configUrl);
        }
        if (this.bWv) {
            contentValues.put("configResources", this.field_configResources);
        }
        if (this.bWw) {
            contentValues.put("configCrc32", Long.valueOf(this.field_configCrc32));
        }
        if (this.bWx) {
            contentValues.put("isFromXml", Boolean.valueOf(this.field_isFromXml));
        }
        if (this.nmb > 0) {
            contentValues.put("rowid", Long.valueOf(this.nmb));
        }
        return contentValues;
    }
}
