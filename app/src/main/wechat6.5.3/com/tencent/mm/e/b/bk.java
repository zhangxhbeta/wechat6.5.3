package com.tencent.mm.e.b;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.h.c;
import com.tencent.mm.sdk.platformtools.s;
import com.tencent.mm.sdk.platformtools.v;

public abstract class bk extends c {
    private static final int bAB = "url".hashCode();
    private static final int bIM = "mac".hashCode();
    private static final int bKM = "deviceID".hashCode();
    private static final int bKN = "brandName".hashCode();
    private static final int bKO = "deviceType".hashCode();
    private static final int bKP = "connProto".hashCode();
    private static final int bKQ = "connStrategy".hashCode();
    private static final int bKR = "closeStrategy".hashCode();
    private static final int bKS = "md5Str".hashCode();
    private static final int bKT = "authKey".hashCode();
    private static final int bKU = "sessionKey".hashCode();
    private static final int bKV = "sessionBuf".hashCode();
    private static final int bKW = "authBuf".hashCode();
    private static final int bKX = "lvbuffer".hashCode();
    public static final String[] btd = new String[0];
    private static final int btm = "rowid".hashCode();
    private boolean bAk = true;
    private boolean bIz = true;
    private boolean bKA = true;
    private boolean bKB = true;
    private boolean bKC = true;
    private boolean bKD = true;
    private boolean bKE = true;
    private boolean bKF = true;
    private boolean bKG = true;
    private boolean bKH = true;
    private boolean bKI = true;
    private boolean bKJ = true;
    private boolean bKK = true;
    public boolean bKL = true;
    public int bKY;
    public int bKZ;
    public long bLa;
    private long bLb;
    public String bLc;
    public String bLd;
    public String bLe;
    private int bLf;
    public int bLg;
    public long bLh;
    public String bLi;
    public String bLj;
    private String bLk;
    public String bLl;
    public String category;
    public byte[] field_authBuf;
    public String field_authKey;
    public String field_brandName;
    public int field_closeStrategy;
    public String field_connProto;
    public int field_connStrategy;
    public String field_deviceID;
    public String field_deviceType;
    public byte[] field_lvbuffer;
    public long field_mac;
    public String field_md5Str;
    public byte[] field_sessionBuf;
    public byte[] field_sessionKey;
    public String field_url;
    public String iconUrl;
    public String jumpUrl;

    public final void b(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (bKM == hashCode) {
                    this.field_deviceID = cursor.getString(i);
                    this.bKA = true;
                } else if (bKN == hashCode) {
                    this.field_brandName = cursor.getString(i);
                } else if (bIM == hashCode) {
                    this.field_mac = cursor.getLong(i);
                } else if (bKO == hashCode) {
                    this.field_deviceType = cursor.getString(i);
                } else if (bKP == hashCode) {
                    this.field_connProto = cursor.getString(i);
                } else if (bKQ == hashCode) {
                    this.field_connStrategy = cursor.getInt(i);
                } else if (bKR == hashCode) {
                    this.field_closeStrategy = cursor.getInt(i);
                } else if (bKS == hashCode) {
                    this.field_md5Str = cursor.getString(i);
                } else if (bKT == hashCode) {
                    this.field_authKey = cursor.getString(i);
                } else if (bAB == hashCode) {
                    this.field_url = cursor.getString(i);
                } else if (bKU == hashCode) {
                    this.field_sessionKey = cursor.getBlob(i);
                } else if (bKV == hashCode) {
                    this.field_sessionBuf = cursor.getBlob(i);
                } else if (bKW == hashCode) {
                    this.field_authBuf = cursor.getBlob(i);
                } else if (bKX == hashCode) {
                    this.field_lvbuffer = cursor.getBlob(i);
                } else if (btm == hashCode) {
                    this.nmb = cursor.getLong(i);
                }
            }
            try {
                if (this.field_lvbuffer != null && this.field_lvbuffer.length != 0) {
                    s sVar = new s();
                    int bg = sVar.bg(this.field_lvbuffer);
                    if (bg != 0) {
                        v.e("MicroMsg.SDK.BaseHardDeviceInfo", "parse LVBuffer error:" + bg);
                        return;
                    }
                    if (!sVar.bsR()) {
                        this.bKY = sVar.getInt();
                    }
                    if (!sVar.bsR()) {
                        this.bKZ = sVar.getInt();
                    }
                    if (!sVar.bsR()) {
                        this.bLa = sVar.getLong();
                    }
                    if (!sVar.bsR()) {
                        this.bLb = sVar.getLong();
                    }
                    if (!sVar.bsR()) {
                        this.bLc = sVar.getString();
                    }
                    if (!sVar.bsR()) {
                        this.iconUrl = sVar.getString();
                    }
                    if (!sVar.bsR()) {
                        this.jumpUrl = sVar.getString();
                    }
                    if (!sVar.bsR()) {
                        this.bLd = sVar.getString();
                    }
                    if (!sVar.bsR()) {
                        this.bLe = sVar.getString();
                    }
                    if (!sVar.bsR()) {
                        this.category = sVar.getString();
                    }
                    if (!sVar.bsR()) {
                        this.bLf = sVar.getInt();
                    }
                    if (!sVar.bsR()) {
                        this.bLg = sVar.getInt();
                    }
                    if (!sVar.bsR()) {
                        this.bLh = sVar.getLong();
                    }
                    if (!sVar.bsR()) {
                        this.bLi = sVar.getString();
                    }
                    if (!sVar.bsR()) {
                        this.bLj = sVar.getString();
                    }
                    if (!sVar.bsR()) {
                        this.bLk = sVar.getString();
                    }
                    if (!sVar.bsR()) {
                        this.bLl = sVar.getString();
                    }
                }
            } catch (Exception e) {
                v.e("MicroMsg.SDK.BaseHardDeviceInfo", "get value failed");
            }
        }
    }

    public final ContentValues py() {
        try {
            if (this.bKL) {
                s sVar = new s();
                sVar.bsS();
                sVar.uY(this.bKY);
                sVar.uY(this.bKZ);
                sVar.dY(this.bLa);
                sVar.dY(this.bLb);
                sVar.Kc(this.bLc);
                sVar.Kc(this.iconUrl);
                sVar.Kc(this.jumpUrl);
                sVar.Kc(this.bLd);
                sVar.Kc(this.bLe);
                sVar.Kc(this.category);
                sVar.uY(this.bLf);
                sVar.uY(this.bLg);
                sVar.dY(this.bLh);
                sVar.Kc(this.bLi);
                sVar.Kc(this.bLj);
                sVar.Kc(this.bLk);
                sVar.Kc(this.bLl);
                this.field_lvbuffer = sVar.bsT();
            }
        } catch (Exception e) {
            v.e("MicroMsg.SDK.BaseHardDeviceInfo", "get value failed, %s", new Object[]{e.getMessage()});
        }
        ContentValues contentValues = new ContentValues();
        if (this.bKA) {
            contentValues.put("deviceID", this.field_deviceID);
        }
        if (this.bKB) {
            contentValues.put("brandName", this.field_brandName);
        }
        if (this.bIz) {
            contentValues.put("mac", Long.valueOf(this.field_mac));
        }
        if (this.bKC) {
            contentValues.put("deviceType", this.field_deviceType);
        }
        if (this.bKD) {
            contentValues.put("connProto", this.field_connProto);
        }
        if (this.bKE) {
            contentValues.put("connStrategy", Integer.valueOf(this.field_connStrategy));
        }
        if (this.bKF) {
            contentValues.put("closeStrategy", Integer.valueOf(this.field_closeStrategy));
        }
        if (this.bKG) {
            contentValues.put("md5Str", this.field_md5Str);
        }
        if (this.bKH) {
            contentValues.put("authKey", this.field_authKey);
        }
        if (this.bAk) {
            contentValues.put("url", this.field_url);
        }
        if (this.bKI) {
            contentValues.put("sessionKey", this.field_sessionKey);
        }
        if (this.bKJ) {
            contentValues.put("sessionBuf", this.field_sessionBuf);
        }
        if (this.bKK) {
            contentValues.put("authBuf", this.field_authBuf);
        }
        if (this.bKL) {
            contentValues.put("lvbuffer", this.field_lvbuffer);
        }
        if (this.nmb > 0) {
            contentValues.put("rowid", Long.valueOf(this.nmb));
        }
        return contentValues;
    }

    public final void bP(String str) {
        this.bLc = str;
        this.bKL = true;
    }

    public final void cy(String str) {
        this.iconUrl = str;
        this.bKL = true;
    }

    public final void cz(String str) {
        this.jumpUrl = str;
        this.bKL = true;
    }

    public final void cA(String str) {
        this.bLd = str;
        this.bKL = true;
    }

    public final void cB(String str) {
        this.bLe = str;
        this.bKL = true;
    }

    public final void cC(String str) {
        this.category = str;
        this.bKL = true;
    }

    public final void dp(int i) {
        this.bLf = i;
        this.bKL = true;
    }

    public final void dq(int i) {
        this.bLg = i;
        this.bKL = true;
    }

    public final void w(long j) {
        this.bLh = j;
        this.bKL = true;
    }

    public final void cD(String str) {
        this.bLi = str;
        this.bKL = true;
    }

    public final void cE(String str) {
        this.bLj = str;
        this.bKL = true;
    }

    public final void cF(String str) {
        this.bLk = str;
        this.bKL = true;
    }

    public final void cG(String str) {
        this.bLl = str;
        this.bKL = true;
    }
}
