package com.tencent.mm.e.b;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.h.c;

public abstract class cb extends c {
    private static final int bOU = "sceneFlag".hashCode();
    private static final int bOV = "msgTypeFlag".hashCode();
    private static final int bOW = "msgState".hashCode();
    public static final String[] btd = new String[0];
    private static final int btm = "rowid".hashCode();
    private static final int buZ = "appId".hashCode();
    private static final int bvg = "status".hashCode();
    private static final int bwV = "packageName".hashCode();
    private boolean bOR = true;
    private boolean bOS = true;
    private boolean bOT = true;
    private boolean buI = true;
    private boolean buP = true;
    private boolean bwz = true;
    public String field_appId;
    public int field_msgState;
    public int field_msgTypeFlag;
    public String field_packageName;
    public int field_sceneFlag;
    public int field_status;

    public final void b(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (buZ == hashCode) {
                    this.field_appId = cursor.getString(i);
                    this.buI = true;
                } else if (bwV == hashCode) {
                    this.field_packageName = cursor.getString(i);
                } else if (bvg == hashCode) {
                    this.field_status = cursor.getInt(i);
                } else if (bOU == hashCode) {
                    this.field_sceneFlag = cursor.getInt(i);
                } else if (bOV == hashCode) {
                    this.field_msgTypeFlag = cursor.getInt(i);
                } else if (bOW == hashCode) {
                    this.field_msgState = cursor.getInt(i);
                } else if (btm == hashCode) {
                    this.nmb = cursor.getLong(i);
                }
            }
        }
    }

    public final ContentValues py() {
        ContentValues contentValues = new ContentValues();
        if (this.buI) {
            contentValues.put("appId", this.field_appId);
        }
        if (this.bwz) {
            contentValues.put("packageName", this.field_packageName);
        }
        if (this.buP) {
            contentValues.put("status", Integer.valueOf(this.field_status));
        }
        if (this.bOR) {
            contentValues.put("sceneFlag", Integer.valueOf(this.field_sceneFlag));
        }
        if (this.bOS) {
            contentValues.put("msgTypeFlag", Integer.valueOf(this.field_msgTypeFlag));
        }
        if (this.bOT) {
            contentValues.put("msgState", Integer.valueOf(this.field_msgState));
        }
        if (this.nmb > 0) {
            contentValues.put("rowid", Long.valueOf(this.nmb));
        }
        return contentValues;
    }
}
