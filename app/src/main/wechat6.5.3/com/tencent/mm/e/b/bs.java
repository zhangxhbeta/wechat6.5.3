package com.tencent.mm.e.b;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.h.c;
import com.tencent.tmassistantsdk.downloadservice.DownloadInfo;

public abstract class bs extends c {
    private static final int bMb = "phonenumber".hashCode();
    private static final int bMc = "calltime".hashCode();
    private static final int bMd = "duration".hashCode();
    private static final int bMe = "addressId".hashCode();
    private static final int bMf = "phoneType".hashCode();
    public static final String[] btd = new String[0];
    private static final int btm = "rowid".hashCode();
    private static final int bvg = DownloadInfo.STATUS.hashCode();
    private boolean bLW = true;
    private boolean bLX = true;
    private boolean bLY = true;
    private boolean bLZ = true;
    private boolean bMa = true;
    private boolean buP = true;
    public long field_addressId;
    public long field_calltime;
    public long field_duration;
    public int field_phoneType;
    public String field_phonenumber;
    public int field_status;

    public final void b(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (bMb == hashCode) {
                    this.field_phonenumber = cursor.getString(i);
                } else if (bMc == hashCode) {
                    this.field_calltime = cursor.getLong(i);
                } else if (bMd == hashCode) {
                    this.field_duration = cursor.getLong(i);
                } else if (bvg == hashCode) {
                    this.field_status = cursor.getInt(i);
                } else if (bMe == hashCode) {
                    this.field_addressId = cursor.getLong(i);
                } else if (bMf == hashCode) {
                    this.field_phoneType = cursor.getInt(i);
                } else if (btm == hashCode) {
                    this.nmb = cursor.getLong(i);
                }
            }
        }
    }

    public final ContentValues py() {
        ContentValues contentValues = new ContentValues();
        if (this.bLW) {
            contentValues.put("phonenumber", this.field_phonenumber);
        }
        if (this.bLX) {
            contentValues.put("calltime", Long.valueOf(this.field_calltime));
        }
        if (this.bLY) {
            contentValues.put("duration", Long.valueOf(this.field_duration));
        }
        if (this.buP) {
            contentValues.put(DownloadInfo.STATUS, Integer.valueOf(this.field_status));
        }
        if (this.bLZ) {
            contentValues.put("addressId", Long.valueOf(this.field_addressId));
        }
        if (this.bMa) {
            contentValues.put("phoneType", Integer.valueOf(this.field_phoneType));
        }
        if (this.nmb > 0) {
            contentValues.put("rowid", Long.valueOf(this.nmb));
        }
        return contentValues;
    }
}
