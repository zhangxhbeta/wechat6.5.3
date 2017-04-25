package com.tencent.mm.e.b;

import android.content.ContentValues;
import android.database.Cursor;
import com.samsung.android.sdk.look.smartclip.SlookSmartClipMetaTag;
import com.tencent.mm.sdk.h.c;

public abstract class cg extends c {
    private static final int bAB = SlookSmartClipMetaTag.TAG_TYPE_URL.hashCode();
    private static final int bES = "md5".hashCode();
    private static final int bIe = "filePath".hashCode();
    private static final int bJA = "expireTime".hashCode();
    private static final int bPQ = "urlKey_hashcode".hashCode();
    private static final int bPR = "urlKey".hashCode();
    private static final int bPS = "fileVersion".hashCode();
    private static final int bPT = "networkType".hashCode();
    private static final int bPU = "maxRetryTimes".hashCode();
    private static final int bPV = "retryTimes".hashCode();
    private static final int bPW = "contentLength".hashCode();
    private static final int bPX = "contentType".hashCode();
    private static final int bPY = "groupId1".hashCode();
    private static final int bPZ = "groupId2".hashCode();
    private static final int bQa = "priority".hashCode();
    private static final int bQb = "fileUpdated".hashCode();
    private static final int bQc = "deleted".hashCode();
    private static final int bQd = "resType".hashCode();
    private static final int bQe = "subType".hashCode();
    private static final int bQf = "reportId".hashCode();
    private static final int bQg = "sampleId".hashCode();
    private static final int bQh = "eccSignature".hashCode();
    private static final int bQi = "originalMd5".hashCode();
    private static final int bQj = "fileCompress".hashCode();
    private static final int bQk = "fileEncrypt".hashCode();
    private static final int bQl = "encryptKey".hashCode();
    private static final int bQm = "keyVersion".hashCode();
    private static final int bQn = "EID".hashCode();
    private static final int bQo = "fileSize".hashCode();
    private static final int bQp = "wvCacheType".hashCode();
    private static final int bQq = "packageId".hashCode();
    public static final String[] btd = new String[0];
    private static final int btm = "rowid".hashCode();
    private static final int buZ = "appId".hashCode();
    private static final int bvg = "status".hashCode();
    private boolean bAk = true;
    private boolean bEw = true;
    private boolean bHR = true;
    private boolean bJs = true;
    private boolean bPA = true;
    private boolean bPB = true;
    private boolean bPC = true;
    private boolean bPD = true;
    private boolean bPE = true;
    private boolean bPF = true;
    private boolean bPG = true;
    private boolean bPH = true;
    private boolean bPI = true;
    private boolean bPJ = true;
    private boolean bPK = true;
    private boolean bPL = true;
    private boolean bPM = true;
    private boolean bPN = true;
    private boolean bPO = true;
    private boolean bPP = true;
    private boolean bPp = true;
    private boolean bPq = true;
    private boolean bPr = true;
    private boolean bPs = true;
    private boolean bPt = true;
    private boolean bPu = true;
    private boolean bPv = true;
    private boolean bPw = true;
    private boolean bPx = true;
    private boolean bPy = true;
    private boolean bPz = true;
    private boolean buI = true;
    private boolean buP = true;
    public int field_EID;
    public String field_appId;
    public long field_contentLength;
    public String field_contentType;
    public boolean field_deleted;
    public byte[] field_eccSignature;
    public String field_encryptKey;
    public long field_expireTime;
    public boolean field_fileCompress;
    public boolean field_fileEncrypt;
    public String field_filePath;
    public long field_fileSize;
    public boolean field_fileUpdated;
    public String field_fileVersion;
    public String field_groupId1;
    public String field_groupId2;
    public int field_keyVersion;
    public int field_maxRetryTimes;
    public String field_md5;
    public int field_networkType;
    public String field_originalMd5;
    public String field_packageId;
    public int field_priority;
    public long field_reportId;
    public int field_resType;
    public int field_retryTimes;
    public String field_sampleId;
    public int field_status;
    public int field_subType;
    public String field_url;
    public String field_urlKey;
    public int field_urlKey_hashcode;
    public int field_wvCacheType;

    public final void b(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (bPQ == hashCode) {
                    this.field_urlKey_hashcode = cursor.getInt(i);
                    this.bPp = true;
                } else if (bPR == hashCode) {
                    this.field_urlKey = cursor.getString(i);
                } else if (bAB == hashCode) {
                    this.field_url = cursor.getString(i);
                } else if (bPS == hashCode) {
                    this.field_fileVersion = cursor.getString(i);
                } else if (bPT == hashCode) {
                    this.field_networkType = cursor.getInt(i);
                } else if (bPU == hashCode) {
                    this.field_maxRetryTimes = cursor.getInt(i);
                } else if (bPV == hashCode) {
                    this.field_retryTimes = cursor.getInt(i);
                } else if (bIe == hashCode) {
                    this.field_filePath = cursor.getString(i);
                } else if (bvg == hashCode) {
                    this.field_status = cursor.getInt(i);
                } else if (bPW == hashCode) {
                    this.field_contentLength = cursor.getLong(i);
                } else if (bPX == hashCode) {
                    this.field_contentType = cursor.getString(i);
                } else if (bJA == hashCode) {
                    this.field_expireTime = cursor.getLong(i);
                } else if (bES == hashCode) {
                    this.field_md5 = cursor.getString(i);
                } else if (bPY == hashCode) {
                    this.field_groupId1 = cursor.getString(i);
                } else if (bPZ == hashCode) {
                    this.field_groupId2 = cursor.getString(i);
                } else if (bQa == hashCode) {
                    this.field_priority = cursor.getInt(i);
                } else if (bQb == hashCode) {
                    this.field_fileUpdated = cursor.getInt(i) != 0;
                } else if (bQc == hashCode) {
                    this.field_deleted = cursor.getInt(i) != 0;
                } else if (bQd == hashCode) {
                    this.field_resType = cursor.getInt(i);
                } else if (bQe == hashCode) {
                    this.field_subType = cursor.getInt(i);
                } else if (bQf == hashCode) {
                    this.field_reportId = cursor.getLong(i);
                } else if (bQg == hashCode) {
                    this.field_sampleId = cursor.getString(i);
                } else if (bQh == hashCode) {
                    this.field_eccSignature = cursor.getBlob(i);
                } else if (bQi == hashCode) {
                    this.field_originalMd5 = cursor.getString(i);
                } else if (bQj == hashCode) {
                    this.field_fileCompress = cursor.getInt(i) != 0;
                } else if (bQk == hashCode) {
                    this.field_fileEncrypt = cursor.getInt(i) != 0;
                } else if (bQl == hashCode) {
                    this.field_encryptKey = cursor.getString(i);
                } else if (bQm == hashCode) {
                    this.field_keyVersion = cursor.getInt(i);
                } else if (bQn == hashCode) {
                    this.field_EID = cursor.getInt(i);
                } else if (bQo == hashCode) {
                    this.field_fileSize = cursor.getLong(i);
                } else if (buZ == hashCode) {
                    this.field_appId = cursor.getString(i);
                } else if (bQp == hashCode) {
                    this.field_wvCacheType = cursor.getInt(i);
                } else if (bQq == hashCode) {
                    this.field_packageId = cursor.getString(i);
                } else if (btm == hashCode) {
                    this.nmb = cursor.getLong(i);
                }
            }
        }
    }

    public final ContentValues py() {
        ContentValues contentValues = new ContentValues();
        if (this.bPp) {
            contentValues.put("urlKey_hashcode", Integer.valueOf(this.field_urlKey_hashcode));
        }
        if (this.bPq) {
            contentValues.put("urlKey", this.field_urlKey);
        }
        if (this.bAk) {
            contentValues.put(SlookSmartClipMetaTag.TAG_TYPE_URL, this.field_url);
        }
        if (this.bPr) {
            contentValues.put("fileVersion", this.field_fileVersion);
        }
        if (this.bPs) {
            contentValues.put("networkType", Integer.valueOf(this.field_networkType));
        }
        if (this.bPt) {
            contentValues.put("maxRetryTimes", Integer.valueOf(this.field_maxRetryTimes));
        }
        if (this.bPu) {
            contentValues.put("retryTimes", Integer.valueOf(this.field_retryTimes));
        }
        if (this.bHR) {
            contentValues.put("filePath", this.field_filePath);
        }
        if (this.buP) {
            contentValues.put("status", Integer.valueOf(this.field_status));
        }
        if (this.bPv) {
            contentValues.put("contentLength", Long.valueOf(this.field_contentLength));
        }
        if (this.bPw) {
            contentValues.put("contentType", this.field_contentType);
        }
        if (this.bJs) {
            contentValues.put("expireTime", Long.valueOf(this.field_expireTime));
        }
        if (this.bEw) {
            contentValues.put("md5", this.field_md5);
        }
        if (this.bPx) {
            contentValues.put("groupId1", this.field_groupId1);
        }
        if (this.bPy) {
            contentValues.put("groupId2", this.field_groupId2);
        }
        if (this.bPz) {
            contentValues.put("priority", Integer.valueOf(this.field_priority));
        }
        if (this.bPA) {
            contentValues.put("fileUpdated", Boolean.valueOf(this.field_fileUpdated));
        }
        if (this.bPB) {
            contentValues.put("deleted", Boolean.valueOf(this.field_deleted));
        }
        if (this.bPC) {
            contentValues.put("resType", Integer.valueOf(this.field_resType));
        }
        if (this.bPD) {
            contentValues.put("subType", Integer.valueOf(this.field_subType));
        }
        if (this.bPE) {
            contentValues.put("reportId", Long.valueOf(this.field_reportId));
        }
        if (this.bPF) {
            contentValues.put("sampleId", this.field_sampleId);
        }
        if (this.bPG) {
            contentValues.put("eccSignature", this.field_eccSignature);
        }
        if (this.bPH) {
            contentValues.put("originalMd5", this.field_originalMd5);
        }
        if (this.bPI) {
            contentValues.put("fileCompress", Boolean.valueOf(this.field_fileCompress));
        }
        if (this.bPJ) {
            contentValues.put("fileEncrypt", Boolean.valueOf(this.field_fileEncrypt));
        }
        if (this.bPK) {
            contentValues.put("encryptKey", this.field_encryptKey);
        }
        if (this.bPL) {
            contentValues.put("keyVersion", Integer.valueOf(this.field_keyVersion));
        }
        if (this.bPM) {
            contentValues.put("EID", Integer.valueOf(this.field_EID));
        }
        if (this.bPN) {
            contentValues.put("fileSize", Long.valueOf(this.field_fileSize));
        }
        if (this.buI) {
            contentValues.put("appId", this.field_appId);
        }
        if (this.bPO) {
            contentValues.put("wvCacheType", Integer.valueOf(this.field_wvCacheType));
        }
        if (this.bPP) {
            contentValues.put("packageId", this.field_packageId);
        }
        if (this.nmb > 0) {
            contentValues.put("rowid", Long.valueOf(this.nmb));
        }
        return contentValues;
    }
}
