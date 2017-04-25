package com.tencent.mm.e.b;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.h.c;

public abstract class m extends c {
    private static final int btE = "startTime".hashCode();
    private static final int btF = "endTime".hashCode();
    public static final String[] btd = new String[]{"CREATE INDEX IF NOT EXISTS AppBrandWxaPkgManifestRecordPkgPathIndex ON AppBrandWxaPkgManifestRecord(pkgPath)"};
    private static final int btm = "rowid".hashCode();
    private static final int buZ = "appId".hashCode();
    private static final int bun = "createTime".hashCode();
    private static final int bwn = "version".hashCode();
    private static final int bwo = "versionMd5".hashCode();
    private static final int bwp = "versionState".hashCode();
    private static final int bwq = "pkgPath".hashCode();
    private static final int bwr = "resourceCount".hashCode();
    private static final int bws = "debugType".hashCode();
    private static final int bwt = "downloadURL".hashCode();
    private boolean btS = true;
    private boolean btw = true;
    private boolean btx = true;
    private boolean buI = true;
    private boolean bwg = true;
    private boolean bwh = true;
    private boolean bwi = true;
    private boolean bwj = true;
    private boolean bwk = true;
    private boolean bwl = true;
    private boolean bwm = true;
    public String field_appId;
    public long field_createTime;
    public int field_debugType;
    public String field_downloadURL;
    public long field_endTime;
    public String field_pkgPath;
    public int field_resourceCount;
    public long field_startTime;
    public int field_version;
    public String field_versionMd5;
    public int field_versionState;

    public final void b(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (buZ == hashCode) {
                    this.field_appId = cursor.getString(i);
                } else if (bwn == hashCode) {
                    this.field_version = cursor.getInt(i);
                } else if (bwo == hashCode) {
                    this.field_versionMd5 = cursor.getString(i);
                } else if (bwp == hashCode) {
                    this.field_versionState = cursor.getInt(i);
                } else if (bwq == hashCode) {
                    this.field_pkgPath = cursor.getString(i);
                } else if (bun == hashCode) {
                    this.field_createTime = cursor.getLong(i);
                } else if (bwr == hashCode) {
                    this.field_resourceCount = cursor.getInt(i);
                } else if (bws == hashCode) {
                    this.field_debugType = cursor.getInt(i);
                } else if (bwt == hashCode) {
                    this.field_downloadURL = cursor.getString(i);
                } else if (btE == hashCode) {
                    this.field_startTime = cursor.getLong(i);
                } else if (btF == hashCode) {
                    this.field_endTime = cursor.getLong(i);
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
        if (this.bwg) {
            contentValues.put("version", Integer.valueOf(this.field_version));
        }
        if (this.bwh) {
            contentValues.put("versionMd5", this.field_versionMd5);
        }
        if (this.bwi) {
            contentValues.put("versionState", Integer.valueOf(this.field_versionState));
        }
        if (this.bwj) {
            contentValues.put("pkgPath", this.field_pkgPath);
        }
        if (this.btS) {
            contentValues.put("createTime", Long.valueOf(this.field_createTime));
        }
        if (this.bwk) {
            contentValues.put("resourceCount", Integer.valueOf(this.field_resourceCount));
        }
        if (this.bwl) {
            contentValues.put("debugType", Integer.valueOf(this.field_debugType));
        }
        if (this.bwm) {
            contentValues.put("downloadURL", this.field_downloadURL);
        }
        if (this.btw) {
            contentValues.put("startTime", Long.valueOf(this.field_startTime));
        }
        if (this.btx) {
            contentValues.put("endTime", Long.valueOf(this.field_endTime));
        }
        if (this.nmb > 0) {
            contentValues.put("rowid", Long.valueOf(this.nmb));
        }
        return contentValues;
    }
}
