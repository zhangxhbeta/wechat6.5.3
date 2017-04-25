package com.tencent.mm.e.b;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.h.c;

public abstract class cr extends c {
    private static final int bES = "md5".hashCode();
    private static final int bSD = "newerIds".hashCode();
    private static final int bSE = "bgId".hashCode();
    private static final int bSF = "bgUrl".hashCode();
    private static final int bSG = "older_bgId".hashCode();
    private static final int bSH = "local_flag".hashCode();
    private static final int bSI = "istyle".hashCode();
    private static final int bSJ = "iFlag".hashCode();
    private static final int bSK = "icount".hashCode();
    private static final int bSL = "faultS".hashCode();
    private static final int bSM = "snsBgId".hashCode();
    private static final int bSN = "snsuser".hashCode();
    private static final int bSO = "adsession".hashCode();
    public static final String[] btd = new String[0];
    private static final int btm = "rowid".hashCode();
    private static final int bul = "userName".hashCode();
    private boolean bEw = true;
    private boolean bSA = true;
    private boolean bSB = true;
    private boolean bSC = true;
    private boolean bSr = true;
    private boolean bSs = true;
    private boolean bSt = true;
    private boolean bSu = true;
    private boolean bSv = true;
    private boolean bSw = true;
    private boolean bSx = true;
    private boolean bSy = true;
    private boolean bSz = true;
    private boolean btQ = true;
    public byte[] field_adsession;
    public String field_bgId;
    public String field_bgUrl;
    public byte[] field_faultS;
    public int field_iFlag;
    public int field_icount;
    public int field_istyle;
    public int field_local_flag;
    public String field_md5;
    public String field_newerIds;
    public String field_older_bgId;
    public long field_snsBgId;
    public byte[] field_snsuser;
    public String field_userName;

    public final void b(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (bul == hashCode) {
                    this.field_userName = cursor.getString(i);
                    this.btQ = true;
                } else if (bES == hashCode) {
                    this.field_md5 = cursor.getString(i);
                } else if (bSD == hashCode) {
                    this.field_newerIds = cursor.getString(i);
                } else if (bSE == hashCode) {
                    this.field_bgId = cursor.getString(i);
                } else if (bSF == hashCode) {
                    this.field_bgUrl = cursor.getString(i);
                } else if (bSG == hashCode) {
                    this.field_older_bgId = cursor.getString(i);
                } else if (bSH == hashCode) {
                    this.field_local_flag = cursor.getInt(i);
                } else if (bSI == hashCode) {
                    this.field_istyle = cursor.getInt(i);
                } else if (bSJ == hashCode) {
                    this.field_iFlag = cursor.getInt(i);
                } else if (bSK == hashCode) {
                    this.field_icount = cursor.getInt(i);
                } else if (bSL == hashCode) {
                    this.field_faultS = cursor.getBlob(i);
                } else if (bSM == hashCode) {
                    this.field_snsBgId = cursor.getLong(i);
                } else if (bSN == hashCode) {
                    this.field_snsuser = cursor.getBlob(i);
                } else if (bSO == hashCode) {
                    this.field_adsession = cursor.getBlob(i);
                } else if (btm == hashCode) {
                    this.nmb = cursor.getLong(i);
                }
            }
        }
    }

    public final ContentValues py() {
        ContentValues contentValues = new ContentValues();
        if (this.field_userName == null) {
            this.field_userName = "";
        }
        if (this.btQ) {
            contentValues.put("userName", this.field_userName);
        }
        if (this.bEw) {
            contentValues.put("md5", this.field_md5);
        }
        if (this.bSr) {
            contentValues.put("newerIds", this.field_newerIds);
        }
        if (this.bSs) {
            contentValues.put("bgId", this.field_bgId);
        }
        if (this.bSt) {
            contentValues.put("bgUrl", this.field_bgUrl);
        }
        if (this.bSu) {
            contentValues.put("older_bgId", this.field_older_bgId);
        }
        if (this.bSv) {
            contentValues.put("local_flag", Integer.valueOf(this.field_local_flag));
        }
        if (this.bSw) {
            contentValues.put("istyle", Integer.valueOf(this.field_istyle));
        }
        if (this.bSx) {
            contentValues.put("iFlag", Integer.valueOf(this.field_iFlag));
        }
        if (this.bSy) {
            contentValues.put("icount", Integer.valueOf(this.field_icount));
        }
        if (this.bSz) {
            contentValues.put("faultS", this.field_faultS);
        }
        if (this.bSA) {
            contentValues.put("snsBgId", Long.valueOf(this.field_snsBgId));
        }
        if (this.bSB) {
            contentValues.put("snsuser", this.field_snsuser);
        }
        if (this.bSC) {
            contentValues.put("adsession", this.field_adsession);
        }
        if (this.nmb > 0) {
            contentValues.put("rowid", Long.valueOf(this.nmb));
        }
        return contentValues;
    }
}
