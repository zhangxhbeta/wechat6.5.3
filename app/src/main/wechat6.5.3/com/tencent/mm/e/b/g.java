package com.tencent.mm.e.b;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.h.c;

public abstract class g extends c {
    public static final String[] btd = new String[0];
    private static final int btm = "rowid".hashCode();
    private static final int buZ = "appId".hashCode();
    private static final int bun = "createTime".hashCode();
    private static final int buq = "type".hashCode();
    private static final int bva = "sdkVer".hashCode();
    private static final int bvb = "mediaSvrId".hashCode();
    private static final int bvc = "mediaId".hashCode();
    private static final int bvd = "clientAppDataId".hashCode();
    private static final int bve = "totalLen".hashCode();
    private static final int bvf = "offset".hashCode();
    private static final int bvg = "status".hashCode();
    private static final int bvh = "isUpload".hashCode();
    private static final int bvi = "lastModifyTime".hashCode();
    private static final int bvj = "fileFullPath".hashCode();
    private static final int bvk = "msgInfoId".hashCode();
    private static final int bvl = "netTimes".hashCode();
    private static final int bvm = "isUseCdn".hashCode();
    private static final int bvn = "signature".hashCode();
    private static final int bvo = "fakeAeskey".hashCode();
    private static final int bvp = "fakeSignature".hashCode();
    private boolean btS = true;
    private boolean btV = true;
    private boolean buI = true;
    private boolean buJ = true;
    private boolean buK = true;
    private boolean buL = true;
    private boolean buM = true;
    private boolean buN = true;
    private boolean buO = true;
    private boolean buP = true;
    private boolean buQ = true;
    private boolean buR = true;
    private boolean buS = true;
    private boolean buT = true;
    private boolean buU = true;
    private boolean buV = true;
    private boolean buW = true;
    private boolean buX = true;
    private boolean buY = true;
    public String field_appId;
    public String field_clientAppDataId;
    public long field_createTime;
    public String field_fakeAeskey;
    public String field_fakeSignature;
    public String field_fileFullPath;
    public boolean field_isUpload;
    public int field_isUseCdn;
    public long field_lastModifyTime;
    public String field_mediaId;
    public String field_mediaSvrId;
    public long field_msgInfoId;
    public long field_netTimes;
    public long field_offset;
    public long field_sdkVer;
    public String field_signature;
    public long field_status;
    public long field_totalLen;
    public long field_type;

    public final void b(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (buZ == hashCode) {
                    this.field_appId = cursor.getString(i);
                } else if (bva == hashCode) {
                    this.field_sdkVer = cursor.getLong(i);
                } else if (bvb == hashCode) {
                    this.field_mediaSvrId = cursor.getString(i);
                } else if (bvc == hashCode) {
                    this.field_mediaId = cursor.getString(i);
                } else if (bvd == hashCode) {
                    this.field_clientAppDataId = cursor.getString(i);
                } else if (buq == hashCode) {
                    this.field_type = cursor.getLong(i);
                } else if (bve == hashCode) {
                    this.field_totalLen = cursor.getLong(i);
                } else if (bvf == hashCode) {
                    this.field_offset = cursor.getLong(i);
                } else if (bvg == hashCode) {
                    this.field_status = cursor.getLong(i);
                } else if (bvh == hashCode) {
                    this.field_isUpload = cursor.getInt(i) != 0;
                } else if (bun == hashCode) {
                    this.field_createTime = cursor.getLong(i);
                } else if (bvi == hashCode) {
                    this.field_lastModifyTime = cursor.getLong(i);
                } else if (bvj == hashCode) {
                    this.field_fileFullPath = cursor.getString(i);
                } else if (bvk == hashCode) {
                    this.field_msgInfoId = cursor.getLong(i);
                } else if (bvl == hashCode) {
                    this.field_netTimes = cursor.getLong(i);
                } else if (bvm == hashCode) {
                    this.field_isUseCdn = cursor.getInt(i);
                } else if (bvn == hashCode) {
                    this.field_signature = cursor.getString(i);
                } else if (bvo == hashCode) {
                    this.field_fakeAeskey = cursor.getString(i);
                } else if (bvp == hashCode) {
                    this.field_fakeSignature = cursor.getString(i);
                } else if (btm == hashCode) {
                    this.nmb = cursor.getLong(i);
                }
            }
        }
    }

    public final ContentValues py() {
        ContentValues contentValues = new ContentValues();
        if (this.buI) {
            contentValues.put("appId", this.field_appId);
        }
        if (this.buJ) {
            contentValues.put("sdkVer", Long.valueOf(this.field_sdkVer));
        }
        if (this.buK) {
            contentValues.put("mediaSvrId", this.field_mediaSvrId);
        }
        if (this.buL) {
            contentValues.put("mediaId", this.field_mediaId);
        }
        if (this.buM) {
            contentValues.put("clientAppDataId", this.field_clientAppDataId);
        }
        if (this.btV) {
            contentValues.put("type", Long.valueOf(this.field_type));
        }
        if (this.buN) {
            contentValues.put("totalLen", Long.valueOf(this.field_totalLen));
        }
        if (this.buO) {
            contentValues.put("offset", Long.valueOf(this.field_offset));
        }
        if (this.buP) {
            contentValues.put("status", Long.valueOf(this.field_status));
        }
        if (this.buQ) {
            contentValues.put("isUpload", Boolean.valueOf(this.field_isUpload));
        }
        if (this.btS) {
            contentValues.put("createTime", Long.valueOf(this.field_createTime));
        }
        if (this.buR) {
            contentValues.put("lastModifyTime", Long.valueOf(this.field_lastModifyTime));
        }
        if (this.buS) {
            contentValues.put("fileFullPath", this.field_fileFullPath);
        }
        if (this.buT) {
            contentValues.put("msgInfoId", Long.valueOf(this.field_msgInfoId));
        }
        if (this.buU) {
            contentValues.put("netTimes", Long.valueOf(this.field_netTimes));
        }
        if (this.buV) {
            contentValues.put("isUseCdn", Integer.valueOf(this.field_isUseCdn));
        }
        if (this.buW) {
            contentValues.put("signature", this.field_signature);
        }
        if (this.buX) {
            contentValues.put("fakeAeskey", this.field_fakeAeskey);
        }
        if (this.buY) {
            contentValues.put("fakeSignature", this.field_fakeSignature);
        }
        if (this.nmb > 0) {
            contentValues.put("rowid", Long.valueOf(this.nmb));
        }
        return contentValues;
    }
}
