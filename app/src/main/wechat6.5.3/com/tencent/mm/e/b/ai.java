package com.tencent.mm.e.b;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.h.c;

public abstract class ai extends c {
    private static final int bDW = "productID".hashCode();
    private static final int bDX = "packIconUrl".hashCode();
    private static final int bDY = "packGrayIconUrl".hashCode();
    private static final int bDZ = "packCoverUrl".hashCode();
    private static final int bEa = "packName".hashCode();
    private static final int bEb = "packDesc".hashCode();
    private static final int bEc = "packAuthInfo".hashCode();
    private static final int bEd = "packPrice".hashCode();
    private static final int bEe = "packType".hashCode();
    private static final int bEf = "packFlag".hashCode();
    private static final int bEg = "packExpire".hashCode();
    private static final int bEh = "packTimeStamp".hashCode();
    private static final int bEi = "packCopyright".hashCode();
    private static final int bEj = "sort".hashCode();
    private static final int bEk = "lastUseTime".hashCode();
    private static final int bEl = "packStatus".hashCode();
    private static final int bEm = "recommand".hashCode();
    private static final int bEn = "sync".hashCode();
    private static final int bEo = "idx".hashCode();
    private static final int bEp = "BigIconUrl".hashCode();
    private static final int bEq = "MutiLanName".hashCode();
    private static final int bEr = "recommandType".hashCode();
    private static final int bEs = "lang".hashCode();
    private static final int bEt = "recommandWord".hashCode();
    private static final int bEu = "buttonType".hashCode();
    private static final int bEv = "count".hashCode();
    public static final String[] btd = new String[0];
    private static final int btm = "rowid".hashCode();
    private static final int buq = "type".hashCode();
    private static final int bvg = "status".hashCode();
    private static final int bxU = "flag".hashCode();
    private boolean bDA = true;
    private boolean bDB = true;
    private boolean bDC = true;
    private boolean bDD = true;
    private boolean bDE = true;
    private boolean bDF = true;
    private boolean bDG = true;
    private boolean bDH = true;
    private boolean bDI = true;
    private boolean bDJ = true;
    private boolean bDK = true;
    private boolean bDL = true;
    private boolean bDM = true;
    private boolean bDN = true;
    private boolean bDO = true;
    private boolean bDP = true;
    private boolean bDQ = true;
    private boolean bDR = true;
    private boolean bDS = true;
    private boolean bDT = true;
    private boolean bDU = true;
    private boolean bDV = true;
    private boolean bDw = true;
    private boolean bDx = true;
    private boolean bDy = true;
    private boolean bDz = true;
    private boolean btV = true;
    private boolean buP = true;
    private boolean bxS = true;
    public String field_BigIconUrl;
    public String field_MutiLanName;
    public int field_buttonType;
    public int field_count;
    public int field_flag;
    public int field_idx;
    public String field_lang;
    public long field_lastUseTime;
    public String field_packAuthInfo;
    public String field_packCopyright;
    public String field_packCoverUrl;
    public String field_packDesc;
    public long field_packExpire;
    public int field_packFlag;
    public String field_packGrayIconUrl;
    public String field_packIconUrl;
    public String field_packName;
    public String field_packPrice;
    public int field_packStatus;
    public long field_packTimeStamp;
    public int field_packType;
    public String field_productID;
    public int field_recommand;
    public int field_recommandType;
    public String field_recommandWord;
    public int field_sort;
    public int field_status;
    public int field_sync;
    public int field_type;

    public final void b(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (bDW == hashCode) {
                    this.field_productID = cursor.getString(i);
                    this.bDw = true;
                } else if (bDX == hashCode) {
                    this.field_packIconUrl = cursor.getString(i);
                } else if (bDY == hashCode) {
                    this.field_packGrayIconUrl = cursor.getString(i);
                } else if (bDZ == hashCode) {
                    this.field_packCoverUrl = cursor.getString(i);
                } else if (bEa == hashCode) {
                    this.field_packName = cursor.getString(i);
                } else if (bEb == hashCode) {
                    this.field_packDesc = cursor.getString(i);
                } else if (bEc == hashCode) {
                    this.field_packAuthInfo = cursor.getString(i);
                } else if (bEd == hashCode) {
                    this.field_packPrice = cursor.getString(i);
                } else if (bEe == hashCode) {
                    this.field_packType = cursor.getInt(i);
                } else if (bEf == hashCode) {
                    this.field_packFlag = cursor.getInt(i);
                } else if (bEg == hashCode) {
                    this.field_packExpire = cursor.getLong(i);
                } else if (bEh == hashCode) {
                    this.field_packTimeStamp = cursor.getLong(i);
                } else if (bEi == hashCode) {
                    this.field_packCopyright = cursor.getString(i);
                } else if (buq == hashCode) {
                    this.field_type = cursor.getInt(i);
                } else if (bvg == hashCode) {
                    this.field_status = cursor.getInt(i);
                } else if (bEj == hashCode) {
                    this.field_sort = cursor.getInt(i);
                } else if (bEk == hashCode) {
                    this.field_lastUseTime = cursor.getLong(i);
                } else if (bEl == hashCode) {
                    this.field_packStatus = cursor.getInt(i);
                } else if (bxU == hashCode) {
                    this.field_flag = cursor.getInt(i);
                } else if (bEm == hashCode) {
                    this.field_recommand = cursor.getInt(i);
                } else if (bEn == hashCode) {
                    this.field_sync = cursor.getInt(i);
                } else if (bEo == hashCode) {
                    this.field_idx = cursor.getInt(i);
                } else if (bEp == hashCode) {
                    this.field_BigIconUrl = cursor.getString(i);
                } else if (bEq == hashCode) {
                    this.field_MutiLanName = cursor.getString(i);
                } else if (bEr == hashCode) {
                    this.field_recommandType = cursor.getInt(i);
                } else if (bEs == hashCode) {
                    this.field_lang = cursor.getString(i);
                } else if (bEt == hashCode) {
                    this.field_recommandWord = cursor.getString(i);
                } else if (bEu == hashCode) {
                    this.field_buttonType = cursor.getInt(i);
                } else if (bEv == hashCode) {
                    this.field_count = cursor.getInt(i);
                } else if (btm == hashCode) {
                    this.nmb = cursor.getLong(i);
                }
            }
        }
    }

    public final ContentValues py() {
        ContentValues contentValues = new ContentValues();
        if (this.bDw) {
            contentValues.put("productID", this.field_productID);
        }
        if (this.bDx) {
            contentValues.put("packIconUrl", this.field_packIconUrl);
        }
        if (this.bDy) {
            contentValues.put("packGrayIconUrl", this.field_packGrayIconUrl);
        }
        if (this.bDz) {
            contentValues.put("packCoverUrl", this.field_packCoverUrl);
        }
        if (this.bDA) {
            contentValues.put("packName", this.field_packName);
        }
        if (this.bDB) {
            contentValues.put("packDesc", this.field_packDesc);
        }
        if (this.bDC) {
            contentValues.put("packAuthInfo", this.field_packAuthInfo);
        }
        if (this.bDD) {
            contentValues.put("packPrice", this.field_packPrice);
        }
        if (this.bDE) {
            contentValues.put("packType", Integer.valueOf(this.field_packType));
        }
        if (this.bDF) {
            contentValues.put("packFlag", Integer.valueOf(this.field_packFlag));
        }
        if (this.bDG) {
            contentValues.put("packExpire", Long.valueOf(this.field_packExpire));
        }
        if (this.bDH) {
            contentValues.put("packTimeStamp", Long.valueOf(this.field_packTimeStamp));
        }
        if (this.bDI) {
            contentValues.put("packCopyright", this.field_packCopyright);
        }
        if (this.btV) {
            contentValues.put("type", Integer.valueOf(this.field_type));
        }
        if (this.buP) {
            contentValues.put("status", Integer.valueOf(this.field_status));
        }
        if (this.bDJ) {
            contentValues.put("sort", Integer.valueOf(this.field_sort));
        }
        if (this.bDK) {
            contentValues.put("lastUseTime", Long.valueOf(this.field_lastUseTime));
        }
        if (this.bDL) {
            contentValues.put("packStatus", Integer.valueOf(this.field_packStatus));
        }
        if (this.bxS) {
            contentValues.put("flag", Integer.valueOf(this.field_flag));
        }
        if (this.bDM) {
            contentValues.put("recommand", Integer.valueOf(this.field_recommand));
        }
        if (this.bDN) {
            contentValues.put("sync", Integer.valueOf(this.field_sync));
        }
        if (this.bDO) {
            contentValues.put("idx", Integer.valueOf(this.field_idx));
        }
        if (this.bDP) {
            contentValues.put("BigIconUrl", this.field_BigIconUrl);
        }
        if (this.bDQ) {
            contentValues.put("MutiLanName", this.field_MutiLanName);
        }
        if (this.bDR) {
            contentValues.put("recommandType", Integer.valueOf(this.field_recommandType));
        }
        if (this.bDS) {
            contentValues.put("lang", this.field_lang);
        }
        if (this.bDT) {
            contentValues.put("recommandWord", this.field_recommandWord);
        }
        if (this.bDU) {
            contentValues.put("buttonType", Integer.valueOf(this.field_buttonType));
        }
        if (this.bDV) {
            contentValues.put("count", Integer.valueOf(this.field_count));
        }
        if (this.nmb > 0) {
            contentValues.put("rowid", Long.valueOf(this.nmb));
        }
        return contentValues;
    }
}
