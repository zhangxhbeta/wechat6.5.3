package com.tencent.mm.e.b;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.h.c;

public abstract class dd extends c {
    private static final int bVA = "wallet_type".hashCode();
    private static final int bVB = "wallet_name".hashCode();
    private static final int bVC = "wallet_selected".hashCode();
    private static final int bVD = "wallet_balance".hashCode();
    private static final int bVE = "wallet_tpa_country_mask".hashCode();
    private static final int bVz = "wallet_tpa_country".hashCode();
    public static final String[] btd = new String[0];
    private static final int btm = "rowid".hashCode();
    private boolean bVt = true;
    private boolean bVu = true;
    private boolean bVv = true;
    private boolean bVw = true;
    private boolean bVx = true;
    private boolean bVy = true;
    public int field_wallet_balance;
    public String field_wallet_name;
    public int field_wallet_selected;
    public String field_wallet_tpa_country;
    public int field_wallet_tpa_country_mask;
    public int field_wallet_type;

    public final void b(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (bVz == hashCode) {
                    this.field_wallet_tpa_country = cursor.getString(i);
                    this.bVt = true;
                } else if (bVA == hashCode) {
                    this.field_wallet_type = cursor.getInt(i);
                } else if (bVB == hashCode) {
                    this.field_wallet_name = cursor.getString(i);
                } else if (bVC == hashCode) {
                    this.field_wallet_selected = cursor.getInt(i);
                } else if (bVD == hashCode) {
                    this.field_wallet_balance = cursor.getInt(i);
                } else if (bVE == hashCode) {
                    this.field_wallet_tpa_country_mask = cursor.getInt(i);
                } else if (btm == hashCode) {
                    this.nmb = cursor.getLong(i);
                }
            }
        }
    }

    public final ContentValues py() {
        ContentValues contentValues = new ContentValues();
        if (this.bVt) {
            contentValues.put("wallet_tpa_country", this.field_wallet_tpa_country);
        }
        if (this.bVu) {
            contentValues.put("wallet_type", Integer.valueOf(this.field_wallet_type));
        }
        if (this.bVv) {
            contentValues.put("wallet_name", this.field_wallet_name);
        }
        if (this.bVw) {
            contentValues.put("wallet_selected", Integer.valueOf(this.field_wallet_selected));
        }
        if (this.bVx) {
            contentValues.put("wallet_balance", Integer.valueOf(this.field_wallet_balance));
        }
        if (this.bVy) {
            contentValues.put("wallet_tpa_country_mask", Integer.valueOf(this.field_wallet_tpa_country_mask));
        }
        if (this.nmb > 0) {
            contentValues.put("rowid", Long.valueOf(this.nmb));
        }
        return contentValues;
    }
}
