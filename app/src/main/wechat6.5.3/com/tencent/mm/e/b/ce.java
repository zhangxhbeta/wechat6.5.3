package com.tencent.mm.e.b;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.h.c;
import com.tencent.tmassistantsdk.downloadservice.DownloadInfo;
import com.tencent.tmassistantsdk.storage.table.DownloadSettingTable.Columns;

public abstract class ce extends c {
    private static final int bFj = "cdnUrl".hashCode();
    private static final int bGD = "dataId".hashCode();
    private static final int bGF = "cdnKey".hashCode();
    private static final int bGG = "path".hashCode();
    private static final int bGM = "localId".hashCode();
    private static final int bHk = "toUser".hashCode();
    private static final int bIf = "fileType".hashCode();
    private static final int bPg = "recordLocalId".hashCode();
    private static final int bPh = "isThumb".hashCode();
    private static final int bPi = "errCode".hashCode();
    public static final String[] btd = new String[]{"CREATE INDEX IF NOT EXISTS record_localid_index ON RecordCDNInfo(recordLocalId)"};
    private static final int btm = "rowid".hashCode();
    private static final int buq = Columns.TYPE.hashCode();
    private static final int bvc = "mediaId".hashCode();
    private static final int bve = "totalLen".hashCode();
    private static final int bvf = "offset".hashCode();
    private static final int bvg = DownloadInfo.STATUS.hashCode();
    private boolean bEN = true;
    private boolean bGA = true;
    private boolean bGB = true;
    private boolean bGK = true;
    private boolean bGV = true;
    private boolean bGy = true;
    private boolean bHS = true;
    private boolean bPd = true;
    private boolean bPe = true;
    private boolean bPf = true;
    private boolean btV = true;
    private boolean buL = true;
    private boolean buN = true;
    private boolean buO = true;
    private boolean buP = true;
    public String field_cdnKey;
    public String field_cdnUrl;
    public String field_dataId;
    public int field_errCode;
    public int field_fileType;
    public boolean field_isThumb;
    public int field_localId;
    public String field_mediaId;
    public int field_offset;
    public String field_path;
    public int field_recordLocalId;
    public int field_status;
    public String field_toUser;
    public int field_totalLen;
    public int field_type;

    public final void b(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (bGM == hashCode) {
                    this.field_localId = cursor.getInt(i);
                    this.bGK = true;
                } else if (bPg == hashCode) {
                    this.field_recordLocalId = cursor.getInt(i);
                } else if (bHk == hashCode) {
                    this.field_toUser = cursor.getString(i);
                } else if (bGD == hashCode) {
                    this.field_dataId = cursor.getString(i);
                } else if (bvc == hashCode) {
                    this.field_mediaId = cursor.getString(i);
                } else if (bGG == hashCode) {
                    this.field_path = cursor.getString(i);
                } else if (bFj == hashCode) {
                    this.field_cdnUrl = cursor.getString(i);
                } else if (bGF == hashCode) {
                    this.field_cdnKey = cursor.getString(i);
                } else if (bve == hashCode) {
                    this.field_totalLen = cursor.getInt(i);
                } else if (bPh == hashCode) {
                    this.field_isThumb = cursor.getInt(i) != 0;
                } else if (bvf == hashCode) {
                    this.field_offset = cursor.getInt(i);
                } else if (buq == hashCode) {
                    this.field_type = cursor.getInt(i);
                } else if (bIf == hashCode) {
                    this.field_fileType = cursor.getInt(i);
                } else if (bvg == hashCode) {
                    this.field_status = cursor.getInt(i);
                } else if (bPi == hashCode) {
                    this.field_errCode = cursor.getInt(i);
                } else if (btm == hashCode) {
                    this.nmb = cursor.getLong(i);
                }
            }
        }
    }

    public final ContentValues py() {
        ContentValues contentValues = new ContentValues();
        if (this.bGK) {
            contentValues.put("localId", Integer.valueOf(this.field_localId));
        }
        if (this.bPd) {
            contentValues.put("recordLocalId", Integer.valueOf(this.field_recordLocalId));
        }
        if (this.field_toUser == null) {
            this.field_toUser = "";
        }
        if (this.bGV) {
            contentValues.put("toUser", this.field_toUser);
        }
        if (this.bGy) {
            contentValues.put("dataId", this.field_dataId);
        }
        if (this.buL) {
            contentValues.put("mediaId", this.field_mediaId);
        }
        if (this.bGB) {
            contentValues.put("path", this.field_path);
        }
        if (this.bEN) {
            contentValues.put("cdnUrl", this.field_cdnUrl);
        }
        if (this.bGA) {
            contentValues.put("cdnKey", this.field_cdnKey);
        }
        if (this.buN) {
            contentValues.put("totalLen", Integer.valueOf(this.field_totalLen));
        }
        if (this.bPe) {
            contentValues.put("isThumb", Boolean.valueOf(this.field_isThumb));
        }
        if (this.buO) {
            contentValues.put("offset", Integer.valueOf(this.field_offset));
        }
        if (this.btV) {
            contentValues.put(Columns.TYPE, Integer.valueOf(this.field_type));
        }
        if (this.bHS) {
            contentValues.put("fileType", Integer.valueOf(this.field_fileType));
        }
        if (this.buP) {
            contentValues.put(DownloadInfo.STATUS, Integer.valueOf(this.field_status));
        }
        if (this.bPf) {
            contentValues.put("errCode", Integer.valueOf(this.field_errCode));
        }
        if (this.nmb > 0) {
            contentValues.put("rowid", Long.valueOf(this.nmb));
        }
        return contentValues;
    }
}
