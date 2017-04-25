package com.tencent.mm.e.b;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.h.c;
import com.tencent.tmassistantsdk.storage.table.DownloadSettingTable.Columns;

public abstract class cj extends c {
    private static final int bAa = "nickname".hashCode();
    private static final int bEY = "reserved1".hashCode();
    private static final int bEZ = "reserved2".hashCode();
    private static final int bFa = "reserved3".hashCode();
    private static final int bFb = "reserved4".hashCode();
    private static final int bKX = "lvbuffer".hashCode();
    private static final int bQQ = "shakeItemID".hashCode();
    private static final int bQR = "province".hashCode();
    private static final int bQS = "city".hashCode();
    private static final int bQT = "distance".hashCode();
    private static final int bQU = "sex".hashCode();
    private static final int bQV = "imgstatus".hashCode();
    private static final int bQW = "hasHDImg".hashCode();
    private static final int bQX = "insertBatch".hashCode();
    private static final int bQY = "regionCode".hashCode();
    private static final int bQZ = "snsFlag".hashCode();
    private static final int bRa = "sns_bgurl".hashCode();
    public static final String[] btd = new String[0];
    private static final int btm = "rowid".hashCode();
    private static final int buq = Columns.TYPE.hashCode();
    private static final int bvn = "signature".hashCode();
    private static final int bzG = "username".hashCode();
    private boolean bEC = true;
    private boolean bED = true;
    private boolean bEE = true;
    private boolean bEF = true;
    private boolean bKL = true;
    private boolean bQF = true;
    private boolean bQG = true;
    private boolean bQH = true;
    private boolean bQI = true;
    private boolean bQJ = true;
    private boolean bQK = true;
    private boolean bQL = true;
    private boolean bQM = true;
    private boolean bQN = true;
    private boolean bQO = true;
    private boolean bQP = true;
    private boolean btV = true;
    private boolean buW = true;
    private boolean bzW = true;
    private boolean bzs = true;
    public String field_city;
    public String field_distance;
    public int field_hasHDImg;
    public int field_imgstatus;
    public int field_insertBatch;
    public byte[] field_lvbuffer;
    public String field_nickname;
    public String field_province;
    public String field_regionCode;
    public int field_reserved1;
    public int field_reserved2;
    public String field_reserved3;
    public String field_reserved4;
    public int field_sex;
    public int field_shakeItemID;
    public String field_signature;
    public int field_snsFlag;
    public String field_sns_bgurl;
    public int field_type;
    public String field_username;

    public final void b(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (bQQ == hashCode) {
                    this.field_shakeItemID = cursor.getInt(i);
                    this.bQF = true;
                } else if (bzG == hashCode) {
                    this.field_username = cursor.getString(i);
                } else if (bAa == hashCode) {
                    this.field_nickname = cursor.getString(i);
                } else if (bQR == hashCode) {
                    this.field_province = cursor.getString(i);
                } else if (bQS == hashCode) {
                    this.field_city = cursor.getString(i);
                } else if (bvn == hashCode) {
                    this.field_signature = cursor.getString(i);
                } else if (bQT == hashCode) {
                    this.field_distance = cursor.getString(i);
                } else if (bQU == hashCode) {
                    this.field_sex = cursor.getInt(i);
                } else if (bQV == hashCode) {
                    this.field_imgstatus = cursor.getInt(i);
                } else if (bQW == hashCode) {
                    this.field_hasHDImg = cursor.getInt(i);
                } else if (bQX == hashCode) {
                    this.field_insertBatch = cursor.getInt(i);
                } else if (bEY == hashCode) {
                    this.field_reserved1 = cursor.getInt(i);
                } else if (bEZ == hashCode) {
                    this.field_reserved2 = cursor.getInt(i);
                } else if (bFa == hashCode) {
                    this.field_reserved3 = cursor.getString(i);
                } else if (bFb == hashCode) {
                    this.field_reserved4 = cursor.getString(i);
                } else if (buq == hashCode) {
                    this.field_type = cursor.getInt(i);
                } else if (bKX == hashCode) {
                    this.field_lvbuffer = cursor.getBlob(i);
                } else if (bQY == hashCode) {
                    this.field_regionCode = cursor.getString(i);
                } else if (bQZ == hashCode) {
                    this.field_snsFlag = cursor.getInt(i);
                } else if (bRa == hashCode) {
                    this.field_sns_bgurl = cursor.getString(i);
                } else if (btm == hashCode) {
                    this.nmb = cursor.getLong(i);
                }
            }
        }
    }

    public ContentValues py() {
        ContentValues contentValues = new ContentValues();
        if (this.bQF) {
            contentValues.put("shakeItemID", Integer.valueOf(this.field_shakeItemID));
        }
        if (this.bzs) {
            contentValues.put("username", this.field_username);
        }
        if (this.bzW) {
            contentValues.put("nickname", this.field_nickname);
        }
        if (this.bQG) {
            contentValues.put("province", this.field_province);
        }
        if (this.bQH) {
            contentValues.put("city", this.field_city);
        }
        if (this.buW) {
            contentValues.put("signature", this.field_signature);
        }
        if (this.bQI) {
            contentValues.put("distance", this.field_distance);
        }
        if (this.bQJ) {
            contentValues.put("sex", Integer.valueOf(this.field_sex));
        }
        if (this.bQK) {
            contentValues.put("imgstatus", Integer.valueOf(this.field_imgstatus));
        }
        if (this.bQL) {
            contentValues.put("hasHDImg", Integer.valueOf(this.field_hasHDImg));
        }
        if (this.bQM) {
            contentValues.put("insertBatch", Integer.valueOf(this.field_insertBatch));
        }
        if (this.bEC) {
            contentValues.put("reserved1", Integer.valueOf(this.field_reserved1));
        }
        if (this.bED) {
            contentValues.put("reserved2", Integer.valueOf(this.field_reserved2));
        }
        if (this.bEE) {
            contentValues.put("reserved3", this.field_reserved3);
        }
        if (this.bEF) {
            contentValues.put("reserved4", this.field_reserved4);
        }
        if (this.btV) {
            contentValues.put(Columns.TYPE, Integer.valueOf(this.field_type));
        }
        if (this.bKL) {
            contentValues.put("lvbuffer", this.field_lvbuffer);
        }
        if (this.bQN) {
            contentValues.put("regionCode", this.field_regionCode);
        }
        if (this.bQO) {
            contentValues.put("snsFlag", Integer.valueOf(this.field_snsFlag));
        }
        if (this.bQP) {
            contentValues.put("sns_bgurl", this.field_sns_bgurl);
        }
        if (this.nmb > 0) {
            contentValues.put("rowid", Long.valueOf(this.nmb));
        }
        return contentValues;
    }
}
