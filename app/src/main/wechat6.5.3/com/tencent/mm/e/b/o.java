package com.tencent.mm.e.b;

import android.content.ContentValues;
import android.database.Cursor;
import com.samsung.android.sdk.look.smartclip.SlookSmartClipMetaTag;
import com.tencent.mm.sdk.h.c;

public abstract class o extends c {
    public static final String[] btd = new String[0];
    private static final int btl = "msgId".hashCode();
    private static final int btm = "rowid".hashCode();
    private static final int buZ = "appId".hashCode();
    private static final int buq = "type".hashCode();
    private static final int bxO = "xml".hashCode();
    private static final int bxP = SlookSmartClipMetaTag.TAG_TYPE_TITLE.hashCode();
    private static final int bxQ = "description".hashCode();
    private static final int bxR = "source".hashCode();
    private boolean btV = true;
    private boolean bth = true;
    private boolean buI = true;
    private boolean bxK = true;
    private boolean bxL = true;
    private boolean bxM = true;
    private boolean bxN = true;
    public String field_appId;
    public String field_description;
    public long field_msgId;
    public String field_source;
    public String field_title;
    public int field_type;
    public String field_xml;

    public final void b(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (btl == hashCode) {
                    this.field_msgId = cursor.getLong(i);
                    this.bth = true;
                } else if (bxO == hashCode) {
                    this.field_xml = cursor.getString(i);
                } else if (buZ == hashCode) {
                    this.field_appId = cursor.getString(i);
                } else if (bxP == hashCode) {
                    this.field_title = cursor.getString(i);
                } else if (bxQ == hashCode) {
                    this.field_description = cursor.getString(i);
                } else if (bxR == hashCode) {
                    this.field_source = cursor.getString(i);
                } else if (buq == hashCode) {
                    this.field_type = cursor.getInt(i);
                } else if (btm == hashCode) {
                    this.nmb = cursor.getLong(i);
                }
            }
        }
    }

    public final ContentValues py() {
        ContentValues contentValues = new ContentValues();
        if (this.bth) {
            contentValues.put("msgId", Long.valueOf(this.field_msgId));
        }
        if (this.bxK) {
            contentValues.put("xml", this.field_xml);
        }
        if (this.buI) {
            contentValues.put("appId", this.field_appId);
        }
        if (this.bxL) {
            contentValues.put(SlookSmartClipMetaTag.TAG_TYPE_TITLE, this.field_title);
        }
        if (this.bxM) {
            contentValues.put("description", this.field_description);
        }
        if (this.bxN) {
            contentValues.put("source", this.field_source);
        }
        if (this.btV) {
            contentValues.put("type", Integer.valueOf(this.field_type));
        }
        if (this.nmb > 0) {
            contentValues.put("rowid", Long.valueOf(this.nmb));
        }
        return contentValues;
    }
}
