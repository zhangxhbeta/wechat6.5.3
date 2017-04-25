package com.tencent.mm.e.b;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.h.c;
import com.tencent.mmdb.database.SQLiteDatabase;

public abstract class x extends c {
    public static final String[] btd = new String[0];
    private static final int btm = "rowid".hashCode();
    private static final int buq = "type".hashCode();
    private static final int bvJ = "updateTime".hashCode();
    private static final int bvg = "status".hashCode();
    private static final int bwb = "brandFlag".hashCode();
    private static final int byZ = "bitFlag".hashCode();
    private static final int bzG = "username".hashCode();
    private static final int bzH = "brandList".hashCode();
    private static final int bzI = "brandListVersion".hashCode();
    private static final int bzJ = "brandListContent".hashCode();
    private static final int bzK = "extInfo".hashCode();
    private static final int bzL = "brandInfo".hashCode();
    private static final int bzM = "brandIconURL".hashCode();
    private static final int bzN = "hadAlert".hashCode();
    private static final int bzO = "acceptType".hashCode();
    private static final int bzP = "enterpriseFather".hashCode();
    private static final int bzQ = "kfWorkerId".hashCode();
    private static final int bzR = "specialType".hashCode();
    private static final int bzS = "attrSyncVersion".hashCode();
    private static final int bzT = "incrementUpdateTime".hashCode();
    private boolean btV = true;
    private boolean buP = true;
    private boolean bvF = true;
    private boolean bvQ = true;
    private boolean byN = true;
    private boolean bzA = true;
    private boolean bzB = true;
    private boolean bzC = true;
    private boolean bzD = true;
    private boolean bzE = true;
    private boolean bzF = true;
    private boolean bzs = true;
    private boolean bzt = true;
    private boolean bzu = true;
    private boolean bzv = true;
    private boolean bzw = true;
    private boolean bzx = true;
    private boolean bzy = true;
    private boolean bzz = true;
    public int field_acceptType;
    public String field_attrSyncVersion;
    public int field_bitFlag;
    public int field_brandFlag;
    public String field_brandIconURL;
    public String field_brandInfo;
    public String field_brandList;
    public String field_brandListContent;
    public String field_brandListVersion;
    public String field_enterpriseFather;
    public String field_extInfo;
    public int field_hadAlert;
    public long field_incrementUpdateTime;
    public String field_kfWorkerId;
    public int field_specialType;
    public int field_status;
    public int field_type;
    public long field_updateTime;
    public String field_username;

    public void b(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (bzG == hashCode) {
                    this.field_username = cursor.getString(i);
                    this.bzs = true;
                } else if (bzH == hashCode) {
                    this.field_brandList = cursor.getString(i);
                } else if (bzI == hashCode) {
                    this.field_brandListVersion = cursor.getString(i);
                } else if (bzJ == hashCode) {
                    this.field_brandListContent = cursor.getString(i);
                } else if (bwb == hashCode) {
                    this.field_brandFlag = cursor.getInt(i);
                } else if (bzK == hashCode) {
                    this.field_extInfo = cursor.getString(i);
                } else if (bzL == hashCode) {
                    this.field_brandInfo = cursor.getString(i);
                } else if (bzM == hashCode) {
                    this.field_brandIconURL = cursor.getString(i);
                } else if (bvJ == hashCode) {
                    this.field_updateTime = cursor.getLong(i);
                } else if (bzN == hashCode) {
                    this.field_hadAlert = cursor.getInt(i);
                } else if (bzO == hashCode) {
                    this.field_acceptType = cursor.getInt(i);
                } else if (buq == hashCode) {
                    this.field_type = cursor.getInt(i);
                } else if (bvg == hashCode) {
                    this.field_status = cursor.getInt(i);
                } else if (bzP == hashCode) {
                    this.field_enterpriseFather = cursor.getString(i);
                } else if (bzQ == hashCode) {
                    this.field_kfWorkerId = cursor.getString(i);
                } else if (bzR == hashCode) {
                    this.field_specialType = cursor.getInt(i);
                } else if (bzS == hashCode) {
                    this.field_attrSyncVersion = cursor.getString(i);
                } else if (bzT == hashCode) {
                    this.field_incrementUpdateTime = cursor.getLong(i);
                } else if (byZ == hashCode) {
                    this.field_bitFlag = cursor.getInt(i);
                } else if (btm == hashCode) {
                    this.nmb = cursor.getLong(i);
                }
            }
        }
    }

    public ContentValues py() {
        ContentValues contentValues = new ContentValues();
        if (this.bzs) {
            contentValues.put("username", this.field_username);
        }
        if (this.field_brandList == null) {
            this.field_brandList = SQLiteDatabase.KeyEmpty;
        }
        if (this.bzt) {
            contentValues.put("brandList", this.field_brandList);
        }
        if (this.bzu) {
            contentValues.put("brandListVersion", this.field_brandListVersion);
        }
        if (this.bzv) {
            contentValues.put("brandListContent", this.field_brandListContent);
        }
        if (this.bvQ) {
            contentValues.put("brandFlag", Integer.valueOf(this.field_brandFlag));
        }
        if (this.bzw) {
            contentValues.put("extInfo", this.field_extInfo);
        }
        if (this.bzx) {
            contentValues.put("brandInfo", this.field_brandInfo);
        }
        if (this.bzy) {
            contentValues.put("brandIconURL", this.field_brandIconURL);
        }
        if (this.bvF) {
            contentValues.put("updateTime", Long.valueOf(this.field_updateTime));
        }
        if (this.bzz) {
            contentValues.put("hadAlert", Integer.valueOf(this.field_hadAlert));
        }
        if (this.bzA) {
            contentValues.put("acceptType", Integer.valueOf(this.field_acceptType));
        }
        if (this.btV) {
            contentValues.put("type", Integer.valueOf(this.field_type));
        }
        if (this.buP) {
            contentValues.put("status", Integer.valueOf(this.field_status));
        }
        if (this.bzB) {
            contentValues.put("enterpriseFather", this.field_enterpriseFather);
        }
        if (this.bzC) {
            contentValues.put("kfWorkerId", this.field_kfWorkerId);
        }
        if (this.bzD) {
            contentValues.put("specialType", Integer.valueOf(this.field_specialType));
        }
        if (this.bzE) {
            contentValues.put("attrSyncVersion", this.field_attrSyncVersion);
        }
        if (this.bzF) {
            contentValues.put("incrementUpdateTime", Long.valueOf(this.field_incrementUpdateTime));
        }
        if (this.byN) {
            contentValues.put("bitFlag", Integer.valueOf(this.field_bitFlag));
        }
        if (this.nmb > 0) {
            contentValues.put("rowid", Long.valueOf(this.nmb));
        }
        return contentValues;
    }
}
