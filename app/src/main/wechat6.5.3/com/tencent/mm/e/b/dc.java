package com.tencent.mm.e.b;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.h.c;

public abstract class dc extends c {
    private static final int bVo = "wallet_region".hashCode();
    private static final int bVp = "function_list".hashCode();
    private static final int bVq = "new_list".hashCode();
    private static final int bVr = "banner_list".hashCode();
    private static final int bVs = "type_name_list".hashCode();
    public static final String[] btd = new String[0];
    private static final int btm = "rowid".hashCode();
    private boolean bVj = true;
    private boolean bVk = true;
    private boolean bVl = true;
    private boolean bVm = true;
    private boolean bVn = true;
    public String field_banner_list;
    public String field_function_list;
    public String field_new_list;
    public String field_type_name_list;
    public int field_wallet_region;

    public void b(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (bVo == hashCode) {
                    this.field_wallet_region = cursor.getInt(i);
                    this.bVj = true;
                } else if (bVp == hashCode) {
                    this.field_function_list = cursor.getString(i);
                } else if (bVq == hashCode) {
                    this.field_new_list = cursor.getString(i);
                } else if (bVr == hashCode) {
                    this.field_banner_list = cursor.getString(i);
                } else if (bVs == hashCode) {
                    this.field_type_name_list = cursor.getString(i);
                } else if (btm == hashCode) {
                    this.nmb = cursor.getLong(i);
                }
            }
        }
    }

    public final ContentValues py() {
        ContentValues contentValues = new ContentValues();
        if (this.bVj) {
            contentValues.put("wallet_region", Integer.valueOf(this.field_wallet_region));
        }
        if (this.bVk) {
            contentValues.put("function_list", this.field_function_list);
        }
        if (this.bVl) {
            contentValues.put("new_list", this.field_new_list);
        }
        if (this.bVm) {
            contentValues.put("banner_list", this.field_banner_list);
        }
        if (this.bVn) {
            contentValues.put("type_name_list", this.field_type_name_list);
        }
        if (this.nmb > 0) {
            contentValues.put("rowid", Long.valueOf(this.nmb));
        }
        return contentValues;
    }
}
