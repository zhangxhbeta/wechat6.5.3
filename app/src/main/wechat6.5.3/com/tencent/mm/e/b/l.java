package com.tencent.mm.e.b;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.protocal.c.bjc;
import com.tencent.mm.protocal.c.bjf;
import com.tencent.mm.protocal.c.gm;
import com.tencent.mm.sdk.h.c;
import com.tencent.mm.sdk.platformtools.v;
import java.io.IOException;

public abstract class l extends c {
    public static final String[] btd = new String[]{"CREATE INDEX IF NOT EXISTS AppBrandWxaAppInfoBrandIdIndex ON AppBrandWxaAppInfo(brandId)"};
    private static final int btm = "rowid".hashCode();
    private static final int buZ = "appId".hashCode();
    private static final int bvH = "brandId".hashCode();
    private static final int bvV = "appIcon".hashCode();
    private static final int bvW = "appName".hashCode();
    private static final int bvX = "BigHeadImgUrl".hashCode();
    private static final int bvY = "appInfo".hashCode();
    private static final int bvZ = "versionInfo".hashCode();
    private static final int bvn = "signature".hashCode();
    private static final int bvu = "appIdHashCode".hashCode();
    private static final int bwa = "bindInfo".hashCode();
    private static final int bwb = "brandFlag".hashCode();
    private static final int bwc = "AppOpt".hashCode();
    private static final int bwd = "syncAttrVersion".hashCode();
    private static final int bwe = "lastSyncAttrTimeInSecond".hashCode();
    private static final int bwf = "debugEnabled".hashCode();
    private static final int hsM = "roundedSquareIcon".hashCode();
    private boolean buI = true;
    private boolean buW = true;
    private boolean bvD = true;
    private boolean bvK = true;
    private boolean bvL = true;
    private boolean bvM = true;
    private boolean bvN = true;
    private boolean bvO = true;
    private boolean bvP = true;
    private boolean bvQ = true;
    private boolean bvR = true;
    private boolean bvS = true;
    private boolean bvT = true;
    private boolean bvU = true;
    private boolean bvs = true;
    private boolean ene = true;
    public int field_AppOpt;
    public String field_BigHeadImgUrl;
    public String field_appIcon;
    public String field_appId;
    public int field_appIdHashCode;
    public bjc field_appInfo;
    public String field_appName;
    public gm field_bindInfo;
    public int field_brandFlag;
    public String field_brandId;
    public boolean field_debugEnabled;
    public long field_lastSyncAttrTimeInSecond;
    public String field_roundedSquareIcon;
    public String field_signature;
    public String field_syncAttrVersion;
    public bjf field_versionInfo;

    public final void b(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (bvu == hashCode) {
                    this.field_appIdHashCode = cursor.getInt(i);
                    this.bvs = true;
                } else if (buZ == hashCode) {
                    this.field_appId = cursor.getString(i);
                } else if (bvV == hashCode) {
                    this.field_appIcon = cursor.getString(i);
                } else if (bvW == hashCode) {
                    this.field_appName = cursor.getString(i);
                } else if (bvX == hashCode) {
                    this.field_BigHeadImgUrl = cursor.getString(i);
                } else if (bvY == hashCode) {
                    try {
                        r0 = cursor.getBlob(i);
                        if (r0 != null && r0.length > 0) {
                            this.field_appInfo = (bjc) new bjc().az(r0);
                        }
                    } catch (IOException e) {
                        v.e("MicroMsg.SDK.BaseAppBrandWxaAppInfo", e.getMessage());
                    }
                } else if (bvZ == hashCode) {
                    try {
                        r0 = cursor.getBlob(i);
                        if (r0 != null && r0.length > 0) {
                            this.field_versionInfo = (bjf) new bjf().az(r0);
                        }
                    } catch (IOException e2) {
                        v.e("MicroMsg.SDK.BaseAppBrandWxaAppInfo", e2.getMessage());
                    }
                } else if (bwa == hashCode) {
                    try {
                        r0 = cursor.getBlob(i);
                        if (r0 != null && r0.length > 0) {
                            this.field_bindInfo = (gm) new gm().az(r0);
                        }
                    } catch (IOException e22) {
                        v.e("MicroMsg.SDK.BaseAppBrandWxaAppInfo", e22.getMessage());
                    }
                } else if (bvH == hashCode) {
                    this.field_brandId = cursor.getString(i);
                } else if (bwb == hashCode) {
                    this.field_brandFlag = cursor.getInt(i);
                } else if (bvn == hashCode) {
                    this.field_signature = cursor.getString(i);
                } else if (bwc == hashCode) {
                    this.field_AppOpt = cursor.getInt(i);
                } else if (bwd == hashCode) {
                    this.field_syncAttrVersion = cursor.getString(i);
                } else if (bwe == hashCode) {
                    this.field_lastSyncAttrTimeInSecond = cursor.getLong(i);
                } else if (bwf == hashCode) {
                    this.field_debugEnabled = cursor.getInt(i) != 0;
                } else if (hsM == hashCode) {
                    this.field_roundedSquareIcon = cursor.getString(i);
                } else if (btm == hashCode) {
                    this.nmb = cursor.getLong(i);
                }
            }
        }
    }

    public final ContentValues py() {
        ContentValues contentValues = new ContentValues();
        if (this.bvs) {
            contentValues.put("appIdHashCode", Integer.valueOf(this.field_appIdHashCode));
        }
        if (this.buI) {
            contentValues.put("appId", this.field_appId);
        }
        if (this.bvK) {
            contentValues.put("appIcon", this.field_appIcon);
        }
        if (this.bvL) {
            contentValues.put("appName", this.field_appName);
        }
        if (this.bvM) {
            contentValues.put("BigHeadImgUrl", this.field_BigHeadImgUrl);
        }
        if (this.bvN && this.field_appInfo != null) {
            try {
                contentValues.put("appInfo", this.field_appInfo.toByteArray());
            } catch (IOException e) {
                v.e("MicroMsg.SDK.BaseAppBrandWxaAppInfo", e.getMessage());
            }
        }
        if (this.bvO && this.field_versionInfo != null) {
            try {
                contentValues.put("versionInfo", this.field_versionInfo.toByteArray());
            } catch (IOException e2) {
                v.e("MicroMsg.SDK.BaseAppBrandWxaAppInfo", e2.getMessage());
            }
        }
        if (this.bvP && this.field_bindInfo != null) {
            try {
                contentValues.put("bindInfo", this.field_bindInfo.toByteArray());
            } catch (IOException e22) {
                v.e("MicroMsg.SDK.BaseAppBrandWxaAppInfo", e22.getMessage());
            }
        }
        if (this.bvD) {
            contentValues.put("brandId", this.field_brandId);
        }
        if (this.bvQ) {
            contentValues.put("brandFlag", Integer.valueOf(this.field_brandFlag));
        }
        if (this.buW) {
            contentValues.put("signature", this.field_signature);
        }
        if (this.bvR) {
            contentValues.put("AppOpt", Integer.valueOf(this.field_AppOpt));
        }
        if (this.bvS) {
            contentValues.put("syncAttrVersion", this.field_syncAttrVersion);
        }
        if (this.bvT) {
            contentValues.put("lastSyncAttrTimeInSecond", Long.valueOf(this.field_lastSyncAttrTimeInSecond));
        }
        if (this.bvU) {
            contentValues.put("debugEnabled", Boolean.valueOf(this.field_debugEnabled));
        }
        if (this.ene) {
            contentValues.put("roundedSquareIcon", this.field_roundedSquareIcon);
        }
        if (this.nmb > 0) {
            contentValues.put("rowid", Long.valueOf(this.nmb));
        }
        return contentValues;
    }
}
