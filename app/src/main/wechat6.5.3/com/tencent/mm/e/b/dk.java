package com.tencent.mm.e.b;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.h.c;
import com.tencent.tmassistantsdk.downloadservice.DownloadInfo;

public abstract class dk extends c {
    private static final int bAB = "url".hashCode();
    private static final int bGJ = "configId".hashCode();
    private static final int bJA = "expireTime".hashCode();
    private static final int bPW = "contentLength".hashCode();
    private static final int bPX = DownloadInfo.CONTENTTYPE.hashCode();
    private static final int bQq = "packageId".hashCode();
    private static final int bWN = "urlMd5Hashcode".hashCode();
    private static final int bWO = "domain".hashCode();
    private static final int bWP = "localPath".hashCode();
    private static final int bWQ = "isLatestVersion".hashCode();
    private static final int bWR = "accessTime".hashCode();
    private static final int bWS = "cacheType".hashCode();
    private static final int bWT = "protocol".hashCode();
    private static final int bWU = "contentMd5".hashCode();
    public static final String[] btd = new String[]{"CREATE INDEX IF NOT EXISTS WebViewResourceCacheAppIdIndex ON WebViewResourceCache(appId)", "CREATE INDEX IF NOT EXISTS WebViewResourceCacheDomainIndex ON WebViewResourceCache(domain)", "CREATE INDEX IF NOT EXISTS WebViewResourceCachePackageIdIndex ON WebViewResourceCache(packageId)"};
    private static final int btm = "rowid".hashCode();
    private static final int buZ = "appId".hashCode();
    private static final int bun = "createTime".hashCode();
    private static final int bwn = "version".hashCode();
    private boolean bAk = true;
    private boolean bGI = true;
    private boolean bJs = true;
    private boolean bPP = true;
    private boolean bPv = true;
    private boolean bPw = true;
    private boolean bWF = true;
    private boolean bWG = true;
    private boolean bWH = true;
    private boolean bWI = true;
    private boolean bWJ = true;
    private boolean bWK = true;
    private boolean bWL = true;
    private boolean bWM = true;
    private boolean btS = true;
    private boolean buI = true;
    private boolean bwg = true;
    public long field_accessTime;
    public String field_appId;
    public int field_cacheType;
    public String field_configId;
    public long field_contentLength;
    public String field_contentMd5;
    public String field_contentType;
    public long field_createTime;
    public String field_domain;
    public long field_expireTime;
    public boolean field_isLatestVersion;
    public String field_localPath;
    public String field_packageId;
    public int field_protocol;
    public String field_url;
    public int field_urlMd5Hashcode;
    public String field_version;

    public final void b(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (bWN == hashCode) {
                    this.field_urlMd5Hashcode = cursor.getInt(i);
                } else if (bAB == hashCode) {
                    this.field_url = cursor.getString(i);
                } else if (buZ == hashCode) {
                    this.field_appId = cursor.getString(i);
                } else if (bWO == hashCode) {
                    this.field_domain = cursor.getString(i);
                } else if (bwn == hashCode) {
                    this.field_version = cursor.getString(i);
                } else if (bWP == hashCode) {
                    this.field_localPath = cursor.getString(i);
                } else if (bPX == hashCode) {
                    this.field_contentType = cursor.getString(i);
                } else if (bPW == hashCode) {
                    this.field_contentLength = cursor.getLong(i);
                } else if (bWQ == hashCode) {
                    this.field_isLatestVersion = cursor.getInt(i) != 0;
                } else if (bun == hashCode) {
                    this.field_createTime = cursor.getLong(i);
                } else if (bWR == hashCode) {
                    this.field_accessTime = cursor.getLong(i);
                } else if (bJA == hashCode) {
                    this.field_expireTime = cursor.getLong(i);
                } else if (bWS == hashCode) {
                    this.field_cacheType = cursor.getInt(i);
                } else if (bGJ == hashCode) {
                    this.field_configId = cursor.getString(i);
                } else if (bWT == hashCode) {
                    this.field_protocol = cursor.getInt(i);
                } else if (bQq == hashCode) {
                    this.field_packageId = cursor.getString(i);
                } else if (bWU == hashCode) {
                    this.field_contentMd5 = cursor.getString(i);
                } else if (btm == hashCode) {
                    this.nmb = cursor.getLong(i);
                }
            }
        }
    }

    public final ContentValues py() {
        ContentValues contentValues = new ContentValues();
        if (this.bWF) {
            contentValues.put("urlMd5Hashcode", Integer.valueOf(this.field_urlMd5Hashcode));
        }
        if (this.bAk) {
            contentValues.put("url", this.field_url);
        }
        if (this.buI) {
            contentValues.put("appId", this.field_appId);
        }
        if (this.bWG) {
            contentValues.put("domain", this.field_domain);
        }
        if (this.bwg) {
            contentValues.put("version", this.field_version);
        }
        if (this.bWH) {
            contentValues.put("localPath", this.field_localPath);
        }
        if (this.bPw) {
            contentValues.put(DownloadInfo.CONTENTTYPE, this.field_contentType);
        }
        if (this.bPv) {
            contentValues.put("contentLength", Long.valueOf(this.field_contentLength));
        }
        if (this.bWI) {
            contentValues.put("isLatestVersion", Boolean.valueOf(this.field_isLatestVersion));
        }
        if (this.btS) {
            contentValues.put("createTime", Long.valueOf(this.field_createTime));
        }
        if (this.bWJ) {
            contentValues.put("accessTime", Long.valueOf(this.field_accessTime));
        }
        if (this.bJs) {
            contentValues.put("expireTime", Long.valueOf(this.field_expireTime));
        }
        if (this.bWK) {
            contentValues.put("cacheType", Integer.valueOf(this.field_cacheType));
        }
        if (this.bGI) {
            contentValues.put("configId", this.field_configId);
        }
        if (this.bWL) {
            contentValues.put("protocol", Integer.valueOf(this.field_protocol));
        }
        if (this.bPP) {
            contentValues.put("packageId", this.field_packageId);
        }
        if (this.bWM) {
            contentValues.put("contentMd5", this.field_contentMd5);
        }
        if (this.nmb > 0) {
            contentValues.put("rowid", Long.valueOf(this.nmb));
        }
        return contentValues;
    }
}
