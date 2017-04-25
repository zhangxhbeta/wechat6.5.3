package com.tencent.mm.e.b;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.h.c;
import com.tencent.mm.sdk.platformtools.s;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mmdb.database.SQLiteDatabase;

public abstract class n extends c {
    public static final String[] btd = new String[]{"CREATE INDEX IF NOT EXISTS appInfo_status_Index ON AppInfo(status)"};
    private static final int btm = "rowid".hashCode();
    private static final int buZ = "appId".hashCode();
    private static final int bvW = "appName".hashCode();
    private static final int bvg = "status".hashCode();
    private static final int bvn = "signature".hashCode();
    private static final int bwQ = "appDiscription".hashCode();
    private static final int bwR = "appIconUrl".hashCode();
    private static final int bwS = "appStoreUrl".hashCode();
    private static final int bwT = "appVersion".hashCode();
    private static final int bwU = "appWatermarkUrl".hashCode();
    private static final int bwV = "packageName".hashCode();
    private static final int bwW = "modifyTime".hashCode();
    private static final int bwX = "appName_en".hashCode();
    private static final int bwY = "appName_tw".hashCode();
    private static final int bwZ = "appName_hk".hashCode();
    private static final int bxa = "appDiscription_en".hashCode();
    private static final int bxb = "appDiscription_tw".hashCode();
    private static final int bxc = "appType".hashCode();
    private static final int bxd = "openId".hashCode();
    private static final int bxe = "authFlag".hashCode();
    private static final int bxf = "appInfoFlag".hashCode();
    private static final int bxg = "lvbuff".hashCode();
    private static final int bxh = "serviceAppType".hashCode();
    private static final int bxi = "serviceAppInfoFlag".hashCode();
    private static final int bxj = "serviceShowFlag".hashCode();
    private static final int bxk = "appSupportContentType".hashCode();
    private static final int bxl = "svrAppSupportContentType".hashCode();
    private boolean buI = true;
    private boolean buP = true;
    private boolean buW = true;
    private boolean bvL = true;
    private boolean bwA = true;
    private boolean bwB = true;
    private boolean bwC = true;
    private boolean bwD = true;
    private boolean bwE = true;
    private boolean bwF = true;
    private boolean bwG = true;
    private boolean bwH = true;
    private boolean bwI = true;
    private boolean bwJ = true;
    public boolean bwK = true;
    private boolean bwL = true;
    private boolean bwM = true;
    private boolean bwN = true;
    private boolean bwO = true;
    private boolean bwP = true;
    private boolean bwu = true;
    private boolean bwv = true;
    private boolean bww = true;
    private boolean bwx = true;
    private boolean bwy = true;
    private boolean bwz = true;
    public String bxA;
    public String bxB;
    public String bxC;
    public int bxD;
    public String bxE;
    private int bxF;
    public String bxG;
    public String bxH;
    public String bxI;
    public int bxJ;
    public String bxm;
    public String bxn;
    public String bxo;
    public int bxp;
    public int bxq;
    public String bxr;
    public String bxs;
    public String bxt;
    public String bxu;
    public String bxv;
    public String bxw;
    public int bxx;
    public String bxy;
    public String bxz;
    public String field_appDiscription;
    public String field_appDiscription_en;
    public String field_appDiscription_tw;
    public String field_appIconUrl;
    public String field_appId;
    public int field_appInfoFlag;
    public String field_appName;
    public String field_appName_en;
    public String field_appName_hk;
    public String field_appName_tw;
    public String field_appStoreUrl;
    public long field_appSupportContentType;
    public String field_appType;
    public int field_appVersion;
    public String field_appWatermarkUrl;
    public int field_authFlag;
    public byte[] field_lvbuff;
    public long field_modifyTime;
    public String field_openId;
    public String field_packageName;
    public int field_serviceAppInfoFlag;
    public int field_serviceAppType;
    public int field_serviceShowFlag;
    public String field_signature;
    public int field_status;
    public long field_svrAppSupportContentType;

    public final void b(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (buZ == hashCode) {
                    this.field_appId = cursor.getString(i);
                    this.buI = true;
                } else if (bvW == hashCode) {
                    this.field_appName = cursor.getString(i);
                } else if (bwQ == hashCode) {
                    this.field_appDiscription = cursor.getString(i);
                } else if (bwR == hashCode) {
                    this.field_appIconUrl = cursor.getString(i);
                } else if (bwS == hashCode) {
                    this.field_appStoreUrl = cursor.getString(i);
                } else if (bwT == hashCode) {
                    this.field_appVersion = cursor.getInt(i);
                } else if (bwU == hashCode) {
                    this.field_appWatermarkUrl = cursor.getString(i);
                } else if (bwV == hashCode) {
                    this.field_packageName = cursor.getString(i);
                } else if (bvg == hashCode) {
                    this.field_status = cursor.getInt(i);
                } else if (bvn == hashCode) {
                    this.field_signature = cursor.getString(i);
                } else if (bwW == hashCode) {
                    this.field_modifyTime = cursor.getLong(i);
                } else if (bwX == hashCode) {
                    this.field_appName_en = cursor.getString(i);
                } else if (bwY == hashCode) {
                    this.field_appName_tw = cursor.getString(i);
                } else if (bwZ == hashCode) {
                    this.field_appName_hk = cursor.getString(i);
                } else if (bxa == hashCode) {
                    this.field_appDiscription_en = cursor.getString(i);
                } else if (bxb == hashCode) {
                    this.field_appDiscription_tw = cursor.getString(i);
                } else if (bxc == hashCode) {
                    this.field_appType = cursor.getString(i);
                } else if (bxd == hashCode) {
                    this.field_openId = cursor.getString(i);
                } else if (bxe == hashCode) {
                    this.field_authFlag = cursor.getInt(i);
                } else if (bxf == hashCode) {
                    this.field_appInfoFlag = cursor.getInt(i);
                } else if (bxg == hashCode) {
                    this.field_lvbuff = cursor.getBlob(i);
                } else if (bxh == hashCode) {
                    this.field_serviceAppType = cursor.getInt(i);
                } else if (bxi == hashCode) {
                    this.field_serviceAppInfoFlag = cursor.getInt(i);
                } else if (bxj == hashCode) {
                    this.field_serviceShowFlag = cursor.getInt(i);
                } else if (bxk == hashCode) {
                    this.field_appSupportContentType = cursor.getLong(i);
                } else if (bxl == hashCode) {
                    this.field_svrAppSupportContentType = cursor.getLong(i);
                } else if (btm == hashCode) {
                    this.nmb = cursor.getLong(i);
                }
            }
            try {
                if (this.field_lvbuff != null && this.field_lvbuff.length != 0) {
                    s sVar = new s();
                    int bg = sVar.bg(this.field_lvbuff);
                    if (bg != 0) {
                        v.e("MicroMsg.SDK.BaseAppInfo", "parse LVBuffer error:" + bg);
                        return;
                    }
                    this.bxm = sVar.getString();
                    this.bxn = sVar.getString();
                    this.bxo = sVar.getString();
                    this.bxp = sVar.getInt();
                    this.bxq = sVar.getInt();
                    this.bxr = sVar.getString();
                    this.bxs = sVar.getString();
                    this.bxt = sVar.getString();
                    this.bxu = sVar.getString();
                    if (!sVar.bsR()) {
                        this.bxv = sVar.getString();
                    }
                    if (!sVar.bsR()) {
                        this.bxw = sVar.getString();
                    }
                    if (!sVar.bsR()) {
                        this.bxx = sVar.getInt();
                    }
                    if (!sVar.bsR()) {
                        this.bxy = sVar.getString();
                    }
                    if (!sVar.bsR()) {
                        this.bxz = sVar.getString();
                    }
                    if (!sVar.bsR()) {
                        this.bxA = sVar.getString();
                    }
                    if (!sVar.bsR()) {
                        this.bxB = sVar.getString();
                    }
                    if (!sVar.bsR()) {
                        this.bxC = sVar.getString();
                    }
                    if (!sVar.bsR()) {
                        this.bxD = sVar.getInt();
                    }
                    if (!sVar.bsR()) {
                        this.bxE = sVar.getString();
                    }
                    if (!sVar.bsR()) {
                        this.bxF = sVar.getInt();
                    }
                    if (!sVar.bsR()) {
                        this.bxG = sVar.getString();
                    }
                    if (!sVar.bsR()) {
                        this.bxH = sVar.getString();
                    }
                    if (!sVar.bsR()) {
                        this.bxI = sVar.getString();
                    }
                    if (!sVar.bsR()) {
                        this.bxJ = sVar.getInt();
                    }
                }
            } catch (Exception e) {
                v.e("MicroMsg.SDK.BaseAppInfo", "get value failed");
            }
        }
    }

    public ContentValues py() {
        try {
            if (this.bwK) {
                s sVar = new s();
                sVar.bsS();
                sVar.Kc(this.bxm);
                sVar.Kc(this.bxn);
                sVar.Kc(this.bxo);
                sVar.uY(this.bxp);
                sVar.uY(this.bxq);
                sVar.Kc(this.bxr);
                sVar.Kc(this.bxs);
                sVar.Kc(this.bxt);
                sVar.Kc(this.bxu);
                sVar.Kc(this.bxv);
                sVar.Kc(this.bxw);
                sVar.uY(this.bxx);
                sVar.Kc(this.bxy);
                sVar.Kc(this.bxz);
                sVar.Kc(this.bxA);
                sVar.Kc(this.bxB);
                sVar.Kc(this.bxC);
                sVar.uY(this.bxD);
                sVar.Kc(this.bxE);
                sVar.uY(this.bxF);
                sVar.Kc(this.bxG);
                sVar.Kc(this.bxH);
                sVar.Kc(this.bxI);
                sVar.uY(this.bxJ);
                this.field_lvbuff = sVar.bsT();
            }
        } catch (Exception e) {
            v.e("MicroMsg.SDK.BaseAppInfo", "get value failed, %s", e.getMessage());
        }
        ContentValues contentValues = new ContentValues();
        if (this.field_appId == null) {
            this.field_appId = SQLiteDatabase.KeyEmpty;
        }
        if (this.buI) {
            contentValues.put("appId", this.field_appId);
        }
        if (this.bvL) {
            contentValues.put("appName", this.field_appName);
        }
        if (this.bwu) {
            contentValues.put("appDiscription", this.field_appDiscription);
        }
        if (this.bwv) {
            contentValues.put("appIconUrl", this.field_appIconUrl);
        }
        if (this.bww) {
            contentValues.put("appStoreUrl", this.field_appStoreUrl);
        }
        if (this.bwx) {
            contentValues.put("appVersion", Integer.valueOf(this.field_appVersion));
        }
        if (this.bwy) {
            contentValues.put("appWatermarkUrl", this.field_appWatermarkUrl);
        }
        if (this.bwz) {
            contentValues.put("packageName", this.field_packageName);
        }
        if (this.buP) {
            contentValues.put("status", Integer.valueOf(this.field_status));
        }
        if (this.buW) {
            contentValues.put("signature", this.field_signature);
        }
        if (this.bwA) {
            contentValues.put("modifyTime", Long.valueOf(this.field_modifyTime));
        }
        if (this.bwB) {
            contentValues.put("appName_en", this.field_appName_en);
        }
        if (this.bwC) {
            contentValues.put("appName_tw", this.field_appName_tw);
        }
        if (this.bwD) {
            contentValues.put("appName_hk", this.field_appName_hk);
        }
        if (this.bwE) {
            contentValues.put("appDiscription_en", this.field_appDiscription_en);
        }
        if (this.bwF) {
            contentValues.put("appDiscription_tw", this.field_appDiscription_tw);
        }
        if (this.bwG) {
            contentValues.put("appType", this.field_appType);
        }
        if (this.bwH) {
            contentValues.put("openId", this.field_openId);
        }
        if (this.bwI) {
            contentValues.put("authFlag", Integer.valueOf(this.field_authFlag));
        }
        if (this.bwJ) {
            contentValues.put("appInfoFlag", Integer.valueOf(this.field_appInfoFlag));
        }
        if (this.bwK) {
            contentValues.put("lvbuff", this.field_lvbuff);
        }
        if (this.bwL) {
            contentValues.put("serviceAppType", Integer.valueOf(this.field_serviceAppType));
        }
        if (this.bwM) {
            contentValues.put("serviceAppInfoFlag", Integer.valueOf(this.field_serviceAppInfoFlag));
        }
        if (this.bwN) {
            contentValues.put("serviceShowFlag", Integer.valueOf(this.field_serviceShowFlag));
        }
        if (this.bwO) {
            contentValues.put("appSupportContentType", Long.valueOf(this.field_appSupportContentType));
        }
        if (this.bwP) {
            contentValues.put("svrAppSupportContentType", Long.valueOf(this.field_svrAppSupportContentType));
        }
        if (this.nmb > 0) {
            contentValues.put("rowid", Long.valueOf(this.nmb));
        }
        return contentValues;
    }

    public final void bC(String str) {
        this.bxm = str;
        this.bwK = true;
    }

    public final void bD(String str) {
        this.bxn = str;
        this.bwK = true;
    }

    public final String pA() {
        return this.bxo;
    }

    public final void bE(String str) {
        this.bxo = str;
        this.bwK = true;
    }

    public final void bF(String str) {
        this.bxr = str;
        this.bwK = true;
    }

    public final void bG(String str) {
        this.bxs = str;
        this.bwK = true;
    }

    public final String pB() {
        return this.bxt;
    }

    public final void bH(String str) {
        this.bxt = str;
        this.bwK = true;
    }

    public final String pC() {
        return this.bxu;
    }

    public final void bI(String str) {
        this.bxu = str;
        this.bwK = true;
    }

    public final void bJ(String str) {
        this.bxv = str;
        this.bwK = true;
    }

    public final void bK(String str) {
        this.bxw = str;
        this.bwK = true;
    }

    public final void cN(int i) {
        this.bxx = i;
        this.bwK = true;
    }

    public final void bL(String str) {
        this.bxy = str;
        this.bwK = true;
    }

    public final void bM(String str) {
        this.bxz = str;
        this.bwK = true;
    }

    public final void bN(String str) {
        this.bxA = str;
        this.bwK = true;
    }

    public final void bO(String str) {
        this.bxB = str;
        this.bwK = true;
    }

    public final void cO(int i) {
        this.bxD = i;
        this.bwK = true;
    }
}
