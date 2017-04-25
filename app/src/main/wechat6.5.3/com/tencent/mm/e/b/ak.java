package com.tencent.mm.e.b;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.h.c;

public abstract class ak extends c {
    private static final int bES = "md5".hashCode();
    private static final int bEs = "lang".hashCode();
    private static final int bFd = "groupId".hashCode();
    private static final int bFs = "md5_lang".hashCode();
    private static final int bFt = "desc".hashCode();
    private static final int bFu = "click_flag".hashCode();
    private static final int bFv = "download_flag".hashCode();
    public static final String[] btd = new String[0];
    private static final int btm = "rowid".hashCode();
    private boolean bDS = true;
    private boolean bEH = true;
    private boolean bEw = true;
    private boolean bFo = true;
    private boolean bFp = true;
    private boolean bFq = true;
    private boolean bFr = true;
    public int field_click_flag;
    public String field_desc;
    public int field_download_flag;
    public String field_groupId;
    public String field_lang;
    public String field_md5;
    public String field_md5_lang;

    public final void b(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (bFs == hashCode) {
                    this.field_md5_lang = cursor.getString(i);
                    this.bFo = true;
                } else if (bES == hashCode) {
                    this.field_md5 = cursor.getString(i);
                } else if (bEs == hashCode) {
                    this.field_lang = cursor.getString(i);
                } else if (bFt == hashCode) {
                    this.field_desc = cursor.getString(i);
                } else if (bFd == hashCode) {
                    this.field_groupId = cursor.getString(i);
                } else if (bFu == hashCode) {
                    this.field_click_flag = cursor.getInt(i);
                } else if (bFv == hashCode) {
                    this.field_download_flag = cursor.getInt(i);
                } else if (btm == hashCode) {
                    this.nmb = cursor.getLong(i);
                }
            }
        }
    }

    public final ContentValues py() {
        ContentValues contentValues = new ContentValues();
        if (this.bFo) {
            contentValues.put("md5_lang", this.field_md5_lang);
        }
        if (this.bEw) {
            contentValues.put("md5", this.field_md5);
        }
        if (this.bDS) {
            contentValues.put("lang", this.field_lang);
        }
        if (this.bFp) {
            contentValues.put("desc", this.field_desc);
        }
        if (this.field_groupId == null) {
            this.field_groupId = "";
        }
        if (this.bEH) {
            contentValues.put("groupId", this.field_groupId);
        }
        if (this.bFq) {
            contentValues.put("click_flag", Integer.valueOf(this.field_click_flag));
        }
        if (this.bFr) {
            contentValues.put("download_flag", Integer.valueOf(this.field_download_flag));
        }
        if (this.nmb > 0) {
            contentValues.put("rowid", Long.valueOf(this.nmb));
        }
        return contentValues;
    }
}
