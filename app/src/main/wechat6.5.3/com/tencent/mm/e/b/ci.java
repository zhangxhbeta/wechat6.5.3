package com.tencent.mm.e.b;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.h.c;

public abstract class ci extends c {
    private static final int bQA = "productId".hashCode();
    private static final int bQB = "xmlContent".hashCode();
    private static final int bQC = "ScanTime".hashCode();
    private static final int bQD = "funcType".hashCode();
    private static final int bQE = "qrcodeUrl".hashCode();
    public static final String[] btd = new String[0];
    private static final int btm = "rowid".hashCode();
    private static final int buG = "scene".hashCode();
    private boolean bQv = true;
    private boolean bQw = true;
    private boolean bQx = true;
    private boolean bQy = true;
    private boolean bQz = true;
    private boolean buE = true;
    public long field_ScanTime;
    public int field_funcType;
    public String field_productId;
    public String field_qrcodeUrl;
    public int field_scene;
    public String field_xmlContent;

    public final void b(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (bQA == hashCode) {
                    this.field_productId = cursor.getString(i);
                    this.bQv = true;
                } else if (bQB == hashCode) {
                    this.field_xmlContent = cursor.getString(i);
                } else if (bQC == hashCode) {
                    this.field_ScanTime = cursor.getLong(i);
                } else if (bQD == hashCode) {
                    this.field_funcType = cursor.getInt(i);
                } else if (bQE == hashCode) {
                    this.field_qrcodeUrl = cursor.getString(i);
                } else if (buG == hashCode) {
                    this.field_scene = cursor.getInt(i);
                } else if (btm == hashCode) {
                    this.nmb = cursor.getLong(i);
                }
            }
        }
    }

    public final ContentValues py() {
        ContentValues contentValues = new ContentValues();
        if (this.bQv) {
            contentValues.put("productId", this.field_productId);
        }
        if (this.bQw) {
            contentValues.put("xmlContent", this.field_xmlContent);
        }
        if (this.bQx) {
            contentValues.put("ScanTime", Long.valueOf(this.field_ScanTime));
        }
        if (this.bQy) {
            contentValues.put("funcType", Integer.valueOf(this.field_funcType));
        }
        if (this.bQz) {
            contentValues.put("qrcodeUrl", this.field_qrcodeUrl);
        }
        if (this.buE) {
            contentValues.put("scene", Integer.valueOf(this.field_scene));
        }
        if (this.nmb > 0) {
            contentValues.put("rowid", Long.valueOf(this.nmb));
        }
        return contentValues;
    }
}
