package com.tencent.mm.e.b;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.h.c;
import com.tencent.tmassistantsdk.openSDK.OpenSDKTool4Assistant;

public abstract class dg extends c {
    private static final int bWd = OpenSDKTool4Assistant.EXTRA_UIN.hashCode();
    private static final int bWe = "is_reg".hashCode();
    private static final int bWf = "true_name".hashCode();
    private static final int bWg = "card_num".hashCode();
    private static final int bWh = "isDomesticUser".hashCode();
    private static final int bWi = "cre_type".hashCode();
    private static final int bWj = "main_card_bind_serialno".hashCode();
    private static final int bWk = "ftf_pay_url".hashCode();
    private static final int bWl = "switchConfig".hashCode();
    private static final int bWm = "reset_passwd_flag".hashCode();
    private static final int bWn = "find_passwd_url".hashCode();
    private static final int bWo = "is_open_touch".hashCode();
    private static final int bWp = "lct_wording".hashCode();
    private static final int bWq = "lct_url".hashCode();
    public static final String[] btd = new String[0];
    private static final int btm = "rowid".hashCode();
    private boolean bVP = true;
    private boolean bVQ = true;
    private boolean bVR = true;
    private boolean bVS = true;
    private boolean bVT = true;
    private boolean bVU = true;
    private boolean bVV = true;
    private boolean bVW = true;
    private boolean bVX = true;
    private boolean bVY = true;
    private boolean bVZ = true;
    private boolean bWa = true;
    private boolean bWb = true;
    private boolean bWc = true;
    public int field_card_num;
    public int field_cre_type;
    public String field_find_passwd_url;
    public String field_ftf_pay_url;
    public boolean field_isDomesticUser;
    public int field_is_open_touch;
    public int field_is_reg;
    public String field_lct_url;
    public String field_lct_wording;
    public String field_main_card_bind_serialno;
    public String field_reset_passwd_flag;
    public int field_switchConfig;
    public String field_true_name;
    public String field_uin;

    public final void b(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (bWd == hashCode) {
                    this.field_uin = cursor.getString(i);
                    this.bVP = true;
                } else if (bWe == hashCode) {
                    this.field_is_reg = cursor.getInt(i);
                } else if (bWf == hashCode) {
                    this.field_true_name = cursor.getString(i);
                } else if (bWg == hashCode) {
                    this.field_card_num = cursor.getInt(i);
                } else if (bWh == hashCode) {
                    this.field_isDomesticUser = cursor.getInt(i) != 0;
                } else if (bWi == hashCode) {
                    this.field_cre_type = cursor.getInt(i);
                } else if (bWj == hashCode) {
                    this.field_main_card_bind_serialno = cursor.getString(i);
                } else if (bWk == hashCode) {
                    this.field_ftf_pay_url = cursor.getString(i);
                } else if (bWl == hashCode) {
                    this.field_switchConfig = cursor.getInt(i);
                } else if (bWm == hashCode) {
                    this.field_reset_passwd_flag = cursor.getString(i);
                } else if (bWn == hashCode) {
                    this.field_find_passwd_url = cursor.getString(i);
                } else if (bWo == hashCode) {
                    this.field_is_open_touch = cursor.getInt(i);
                } else if (bWp == hashCode) {
                    this.field_lct_wording = cursor.getString(i);
                } else if (bWq == hashCode) {
                    this.field_lct_url = cursor.getString(i);
                } else if (btm == hashCode) {
                    this.nmb = cursor.getLong(i);
                }
            }
        }
    }

    public final ContentValues py() {
        ContentValues contentValues = new ContentValues();
        if (this.bVP) {
            contentValues.put(OpenSDKTool4Assistant.EXTRA_UIN, this.field_uin);
        }
        if (this.bVQ) {
            contentValues.put("is_reg", Integer.valueOf(this.field_is_reg));
        }
        if (this.bVR) {
            contentValues.put("true_name", this.field_true_name);
        }
        if (this.bVS) {
            contentValues.put("card_num", Integer.valueOf(this.field_card_num));
        }
        if (this.bVT) {
            contentValues.put("isDomesticUser", Boolean.valueOf(this.field_isDomesticUser));
        }
        if (this.bVU) {
            contentValues.put("cre_type", Integer.valueOf(this.field_cre_type));
        }
        if (this.bVV) {
            contentValues.put("main_card_bind_serialno", this.field_main_card_bind_serialno);
        }
        if (this.bVW) {
            contentValues.put("ftf_pay_url", this.field_ftf_pay_url);
        }
        if (this.bVX) {
            contentValues.put("switchConfig", Integer.valueOf(this.field_switchConfig));
        }
        if (this.bVY) {
            contentValues.put("reset_passwd_flag", this.field_reset_passwd_flag);
        }
        if (this.bVZ) {
            contentValues.put("find_passwd_url", this.field_find_passwd_url);
        }
        if (this.bWa) {
            contentValues.put("is_open_touch", Integer.valueOf(this.field_is_open_touch));
        }
        if (this.bWb) {
            contentValues.put("lct_wording", this.field_lct_wording);
        }
        if (this.bWc) {
            contentValues.put("lct_url", this.field_lct_url);
        }
        if (this.nmb > 0) {
            contentValues.put("rowid", Long.valueOf(this.nmb));
        }
        return contentValues;
    }
}
