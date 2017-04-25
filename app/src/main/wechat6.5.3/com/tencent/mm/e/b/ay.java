package com.tencent.mm.e.b;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.h.c;
import com.tencent.mmdb.database.SQLiteDatabase;

public abstract class ay extends c {
    private static final int bES = "md5".hashCode();
    private static final int bIb = "downloadId".hashCode();
    private static final int bIc = "downloadUrl".hashCode();
    private static final int bId = "fileName".hashCode();
    private static final int bIe = "filePath".hashCode();
    private static final int bIf = "fileType".hashCode();
    private static final int bIg = "autoInstall".hashCode();
    private static final int bIh = "showNotification".hashCode();
    private static final int bIi = "sysDownloadId".hashCode();
    private static final int bIj = "downloaderType".hashCode();
    private static final int bIk = "downloadUrlHashCode".hashCode();
    private static final int bIl = "downloadedSize".hashCode();
    private static final int bIm = "totalSize".hashCode();
    private static final int bIn = "autoDownload".hashCode();
    public static final String[] btd = new String[0];
    private static final int btm = "rowid".hashCode();
    private static final int buZ = "appId".hashCode();
    private static final int bvg = "status".hashCode();
    private static final int bwV = "packageName".hashCode();
    private boolean bEw = true;
    private boolean bHO = true;
    private boolean bHP = true;
    private boolean bHQ = true;
    private boolean bHR = true;
    private boolean bHS = true;
    private boolean bHT = true;
    private boolean bHU = true;
    private boolean bHV = true;
    private boolean bHW = true;
    private boolean bHX = true;
    private boolean bHY = true;
    private boolean bHZ = true;
    private boolean bIa = true;
    private boolean buI = true;
    private boolean buP = true;
    private boolean bwz = true;
    public String field_appId;
    public boolean field_autoDownload;
    public boolean field_autoInstall;
    public long field_downloadId;
    public String field_downloadUrl;
    public int field_downloadUrlHashCode;
    public long field_downloadedSize;
    public int field_downloaderType;
    public String field_fileName;
    public String field_filePath;
    public int field_fileType;
    public String field_md5;
    public String field_packageName;
    public boolean field_showNotification;
    public int field_status;
    public long field_sysDownloadId;
    public long field_totalSize;

    public final void b(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (bIb == hashCode) {
                    this.field_downloadId = cursor.getLong(i);
                    this.bHO = true;
                } else if (bIc == hashCode) {
                    this.field_downloadUrl = cursor.getString(i);
                } else if (bId == hashCode) {
                    this.field_fileName = cursor.getString(i);
                } else if (bIe == hashCode) {
                    this.field_filePath = cursor.getString(i);
                } else if (bIf == hashCode) {
                    this.field_fileType = cursor.getInt(i);
                } else if (bvg == hashCode) {
                    this.field_status = cursor.getInt(i);
                } else if (bES == hashCode) {
                    this.field_md5 = cursor.getString(i);
                } else if (bIg == hashCode) {
                    this.field_autoInstall = cursor.getInt(i) != 0;
                } else if (bIh == hashCode) {
                    this.field_showNotification = cursor.getInt(i) != 0;
                } else if (bIi == hashCode) {
                    this.field_sysDownloadId = cursor.getLong(i);
                } else if (bIj == hashCode) {
                    this.field_downloaderType = cursor.getInt(i);
                } else if (buZ == hashCode) {
                    this.field_appId = cursor.getString(i);
                } else if (bIk == hashCode) {
                    this.field_downloadUrlHashCode = cursor.getInt(i);
                } else if (bwV == hashCode) {
                    this.field_packageName = cursor.getString(i);
                } else if (bIl == hashCode) {
                    this.field_downloadedSize = cursor.getLong(i);
                } else if (bIm == hashCode) {
                    this.field_totalSize = cursor.getLong(i);
                } else if (bIn == hashCode) {
                    this.field_autoDownload = cursor.getInt(i) != 0;
                } else if (btm == hashCode) {
                    this.nmb = cursor.getLong(i);
                }
            }
        }
    }

    public final ContentValues py() {
        ContentValues contentValues = new ContentValues();
        if (this.bHO) {
            contentValues.put("downloadId", Long.valueOf(this.field_downloadId));
        }
        if (this.field_downloadUrl == null) {
            this.field_downloadUrl = SQLiteDatabase.KeyEmpty;
        }
        if (this.bHP) {
            contentValues.put("downloadUrl", this.field_downloadUrl);
        }
        if (this.field_fileName == null) {
            this.field_fileName = SQLiteDatabase.KeyEmpty;
        }
        if (this.bHQ) {
            contentValues.put("fileName", this.field_fileName);
        }
        if (this.field_filePath == null) {
            this.field_filePath = SQLiteDatabase.KeyEmpty;
        }
        if (this.bHR) {
            contentValues.put("filePath", this.field_filePath);
        }
        if (this.bHS) {
            contentValues.put("fileType", Integer.valueOf(this.field_fileType));
        }
        if (this.buP) {
            contentValues.put("status", Integer.valueOf(this.field_status));
        }
        if (this.field_md5 == null) {
            this.field_md5 = SQLiteDatabase.KeyEmpty;
        }
        if (this.bEw) {
            contentValues.put("md5", this.field_md5);
        }
        if (this.bHT) {
            contentValues.put("autoInstall", Boolean.valueOf(this.field_autoInstall));
        }
        if (this.bHU) {
            contentValues.put("showNotification", Boolean.valueOf(this.field_showNotification));
        }
        if (this.bHV) {
            contentValues.put("sysDownloadId", Long.valueOf(this.field_sysDownloadId));
        }
        if (this.bHW) {
            contentValues.put("downloaderType", Integer.valueOf(this.field_downloaderType));
        }
        if (this.field_appId == null) {
            this.field_appId = SQLiteDatabase.KeyEmpty;
        }
        if (this.buI) {
            contentValues.put("appId", this.field_appId);
        }
        if (this.bHX) {
            contentValues.put("downloadUrlHashCode", Integer.valueOf(this.field_downloadUrlHashCode));
        }
        if (this.field_packageName == null) {
            this.field_packageName = SQLiteDatabase.KeyEmpty;
        }
        if (this.bwz) {
            contentValues.put("packageName", this.field_packageName);
        }
        if (this.bHY) {
            contentValues.put("downloadedSize", Long.valueOf(this.field_downloadedSize));
        }
        if (this.bHZ) {
            contentValues.put("totalSize", Long.valueOf(this.field_totalSize));
        }
        if (this.bIa) {
            contentValues.put("autoDownload", Boolean.valueOf(this.field_autoDownload));
        }
        if (this.nmb > 0) {
            contentValues.put("rowid", Long.valueOf(this.nmb));
        }
        return contentValues;
    }
}
