package com.tencent.mm.e.b;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.h.c;

public abstract class da extends c {
    private static final int bFt = "desc".hashCode();
    private static final int bMR = "tips".hashCode();
    private static final int bUA = "forbidWord".hashCode();
    private static final int bUB = "bankName".hashCode();
    private static final int bUC = "bankcardType".hashCode();
    private static final int bUD = "bankcardTypeName".hashCode();
    private static final int bUE = "bankcardTag".hashCode();
    private static final int bUF = "bankcardTail".hashCode();
    private static final int bUG = "supportTag".hashCode();
    private static final int bUH = "mobile".hashCode();
    private static final int bUI = "trueName".hashCode();
    private static final int bUJ = "bankPhone".hashCode();
    private static final int bUK = "bizUsername".hashCode();
    private static final int bUL = "onceQuotaKind".hashCode();
    private static final int bUM = "onceQuotaVirtual".hashCode();
    private static final int bUN = "dayQuotaKind".hashCode();
    private static final int bUO = "dayQuotaVirtual".hashCode();
    private static final int bUP = "fetchArriveTime".hashCode();
    private static final int bUQ = "fetchArriveTimeWording".hashCode();
    private static final int bUR = "repay_url".hashCode();
    private static final int bUS = "wxcreditState".hashCode();
    private static final int bUT = "bankcardClientType".hashCode();
    private static final int bUU = "ext_msg".hashCode();
    private static final int bUV = "support_micropay".hashCode();
    private static final int bUW = "arrive_type".hashCode();
    private static final int bUX = "avail_save_wording".hashCode();
    private static final int bUY = "fetch_charge_rate".hashCode();
    private static final int bUZ = "full_fetch_charge_fee".hashCode();
    private static final int bUx = "bindSerial".hashCode();
    private static final int bUy = "cardType".hashCode();
    private static final int bUz = "bankcardState".hashCode();
    private static final int bVa = "fetch_charge_info".hashCode();
    private static final int bVb = "forbid_title".hashCode();
    private static final int bVc = "forbid_url".hashCode();
    public static final String[] btd = new String[0];
    private static final int btm = "rowid".hashCode();
    private boolean bFp = true;
    private boolean bML = true;
    private boolean bTR = true;
    private boolean bTS = true;
    private boolean bTT = true;
    private boolean bTU = true;
    private boolean bTV = true;
    private boolean bTW = true;
    private boolean bTX = true;
    private boolean bTY = true;
    private boolean bTZ = true;
    private boolean bUa = true;
    private boolean bUb = true;
    private boolean bUc = true;
    private boolean bUd = true;
    private boolean bUe = true;
    private boolean bUf = true;
    private boolean bUg = true;
    private boolean bUh = true;
    private boolean bUi = true;
    private boolean bUj = true;
    private boolean bUk = true;
    private boolean bUl = true;
    private boolean bUm = true;
    private boolean bUn = true;
    private boolean bUo = true;
    private boolean bUp = true;
    private boolean bUq = true;
    private boolean bUr = true;
    private boolean bUs = true;
    private boolean bUt = true;
    private boolean bUu = true;
    private boolean bUv = true;
    private boolean bUw = true;
    public String field_arrive_type;
    public String field_avail_save_wording;
    public String field_bankName;
    public String field_bankPhone;
    public int field_bankcardClientType;
    public int field_bankcardState;
    public int field_bankcardTag;
    public String field_bankcardTail;
    public String field_bankcardType;
    public String field_bankcardTypeName;
    public String field_bindSerial;
    public String field_bizUsername;
    public int field_cardType;
    public double field_dayQuotaKind;
    public double field_dayQuotaVirtual;
    public String field_desc;
    public String field_ext_msg;
    public long field_fetchArriveTime;
    public String field_fetchArriveTimeWording;
    public String field_fetch_charge_info;
    public double field_fetch_charge_rate;
    public String field_forbidWord;
    public String field_forbid_title;
    public String field_forbid_url;
    public double field_full_fetch_charge_fee;
    public String field_mobile;
    public double field_onceQuotaKind;
    public double field_onceQuotaVirtual;
    public String field_repay_url;
    public int field_supportTag;
    public boolean field_support_micropay;
    public String field_tips;
    public String field_trueName;
    public int field_wxcreditState;

    public void b(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (bUx == hashCode) {
                    this.field_bindSerial = cursor.getString(i);
                    this.bTR = true;
                } else if (bUy == hashCode) {
                    this.field_cardType = cursor.getInt(i);
                } else if (bUz == hashCode) {
                    this.field_bankcardState = cursor.getInt(i);
                } else if (bUA == hashCode) {
                    this.field_forbidWord = cursor.getString(i);
                } else if (bUB == hashCode) {
                    this.field_bankName = cursor.getString(i);
                } else if (bUC == hashCode) {
                    this.field_bankcardType = cursor.getString(i);
                } else if (bUD == hashCode) {
                    this.field_bankcardTypeName = cursor.getString(i);
                } else if (bUE == hashCode) {
                    this.field_bankcardTag = cursor.getInt(i);
                } else if (bUF == hashCode) {
                    this.field_bankcardTail = cursor.getString(i);
                } else if (bUG == hashCode) {
                    this.field_supportTag = cursor.getInt(i);
                } else if (bUH == hashCode) {
                    this.field_mobile = cursor.getString(i);
                } else if (bUI == hashCode) {
                    this.field_trueName = cursor.getString(i);
                } else if (bFt == hashCode) {
                    this.field_desc = cursor.getString(i);
                } else if (bUJ == hashCode) {
                    this.field_bankPhone = cursor.getString(i);
                } else if (bUK == hashCode) {
                    this.field_bizUsername = cursor.getString(i);
                } else if (bUL == hashCode) {
                    this.field_onceQuotaKind = cursor.getDouble(i);
                } else if (bUM == hashCode) {
                    this.field_onceQuotaVirtual = cursor.getDouble(i);
                } else if (bUN == hashCode) {
                    this.field_dayQuotaKind = cursor.getDouble(i);
                } else if (bUO == hashCode) {
                    this.field_dayQuotaVirtual = cursor.getDouble(i);
                } else if (bUP == hashCode) {
                    this.field_fetchArriveTime = cursor.getLong(i);
                } else if (bUQ == hashCode) {
                    this.field_fetchArriveTimeWording = cursor.getString(i);
                } else if (bUR == hashCode) {
                    this.field_repay_url = cursor.getString(i);
                } else if (bUS == hashCode) {
                    this.field_wxcreditState = cursor.getInt(i);
                } else if (bUT == hashCode) {
                    this.field_bankcardClientType = cursor.getInt(i);
                } else if (bUU == hashCode) {
                    this.field_ext_msg = cursor.getString(i);
                } else if (bUV == hashCode) {
                    this.field_support_micropay = cursor.getInt(i) != 0;
                } else if (bUW == hashCode) {
                    this.field_arrive_type = cursor.getString(i);
                } else if (bUX == hashCode) {
                    this.field_avail_save_wording = cursor.getString(i);
                } else if (bUY == hashCode) {
                    this.field_fetch_charge_rate = cursor.getDouble(i);
                } else if (bUZ == hashCode) {
                    this.field_full_fetch_charge_fee = cursor.getDouble(i);
                } else if (bVa == hashCode) {
                    this.field_fetch_charge_info = cursor.getString(i);
                } else if (bMR == hashCode) {
                    this.field_tips = cursor.getString(i);
                } else if (bVb == hashCode) {
                    this.field_forbid_title = cursor.getString(i);
                } else if (bVc == hashCode) {
                    this.field_forbid_url = cursor.getString(i);
                } else if (btm == hashCode) {
                    this.nmb = cursor.getLong(i);
                }
            }
        }
    }

    public final ContentValues py() {
        ContentValues contentValues = new ContentValues();
        if (this.bTR) {
            contentValues.put("bindSerial", this.field_bindSerial);
        }
        if (this.bTS) {
            contentValues.put("cardType", Integer.valueOf(this.field_cardType));
        }
        if (this.bTT) {
            contentValues.put("bankcardState", Integer.valueOf(this.field_bankcardState));
        }
        if (this.bTU) {
            contentValues.put("forbidWord", this.field_forbidWord);
        }
        if (this.bTV) {
            contentValues.put("bankName", this.field_bankName);
        }
        if (this.bTW) {
            contentValues.put("bankcardType", this.field_bankcardType);
        }
        if (this.bTX) {
            contentValues.put("bankcardTypeName", this.field_bankcardTypeName);
        }
        if (this.bTY) {
            contentValues.put("bankcardTag", Integer.valueOf(this.field_bankcardTag));
        }
        if (this.bTZ) {
            contentValues.put("bankcardTail", this.field_bankcardTail);
        }
        if (this.bUa) {
            contentValues.put("supportTag", Integer.valueOf(this.field_supportTag));
        }
        if (this.bUb) {
            contentValues.put("mobile", this.field_mobile);
        }
        if (this.bUc) {
            contentValues.put("trueName", this.field_trueName);
        }
        if (this.bFp) {
            contentValues.put("desc", this.field_desc);
        }
        if (this.bUd) {
            contentValues.put("bankPhone", this.field_bankPhone);
        }
        if (this.bUe) {
            contentValues.put("bizUsername", this.field_bizUsername);
        }
        if (this.bUf) {
            contentValues.put("onceQuotaKind", Double.valueOf(this.field_onceQuotaKind));
        }
        if (this.bUg) {
            contentValues.put("onceQuotaVirtual", Double.valueOf(this.field_onceQuotaVirtual));
        }
        if (this.bUh) {
            contentValues.put("dayQuotaKind", Double.valueOf(this.field_dayQuotaKind));
        }
        if (this.bUi) {
            contentValues.put("dayQuotaVirtual", Double.valueOf(this.field_dayQuotaVirtual));
        }
        if (this.bUj) {
            contentValues.put("fetchArriveTime", Long.valueOf(this.field_fetchArriveTime));
        }
        if (this.bUk) {
            contentValues.put("fetchArriveTimeWording", this.field_fetchArriveTimeWording);
        }
        if (this.bUl) {
            contentValues.put("repay_url", this.field_repay_url);
        }
        if (this.bUm) {
            contentValues.put("wxcreditState", Integer.valueOf(this.field_wxcreditState));
        }
        if (this.bUn) {
            contentValues.put("bankcardClientType", Integer.valueOf(this.field_bankcardClientType));
        }
        if (this.bUo) {
            contentValues.put("ext_msg", this.field_ext_msg);
        }
        if (this.bUp) {
            contentValues.put("support_micropay", Boolean.valueOf(this.field_support_micropay));
        }
        if (this.bUq) {
            contentValues.put("arrive_type", this.field_arrive_type);
        }
        if (this.bUr) {
            contentValues.put("avail_save_wording", this.field_avail_save_wording);
        }
        if (this.bUs) {
            contentValues.put("fetch_charge_rate", Double.valueOf(this.field_fetch_charge_rate));
        }
        if (this.bUt) {
            contentValues.put("full_fetch_charge_fee", Double.valueOf(this.field_full_fetch_charge_fee));
        }
        if (this.bUu) {
            contentValues.put("fetch_charge_info", this.field_fetch_charge_info);
        }
        if (this.bML) {
            contentValues.put("tips", this.field_tips);
        }
        if (this.bUv) {
            contentValues.put("forbid_title", this.field_forbid_title);
        }
        if (this.bUw) {
            contentValues.put("forbid_url", this.field_forbid_url);
        }
        if (this.nmb > 0) {
            contentValues.put("rowid", Long.valueOf(this.nmb));
        }
        return contentValues;
    }
}
