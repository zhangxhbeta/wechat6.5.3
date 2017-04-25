package com.tencent.mm.e.b;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.h.c;
import com.tencent.mmdb.database.SQLiteDatabase;

public abstract class cn extends c {
    private static final int bGM = "localId".hashCode();
    private static final int bId = "fileName".hashCode();
    private static final int bRM = "fileNameHash".hashCode();
    private static final int bRN = "fileMd5".hashCode();
    private static final int bRO = "fileLength".hashCode();
    private static final int bRP = "fileStatus".hashCode();
    private static final int bRQ = "fileDuration".hashCode();
    public static final String[] btd = new String[]{"CREATE INDEX IF NOT EXISTS file_name_hash_index ON SightDraftInfo(fileNameHash)"};
    private static final int btm = "rowid".hashCode();
    private static final int bun = "createTime".hashCode();
    private boolean bGK = true;
    private boolean bHQ = true;
    private boolean bRH = true;
    private boolean bRI = true;
    private boolean bRJ = true;
    private boolean bRK = true;
    private boolean bRL = true;
    private boolean btS = true;
    public long field_createTime;
    public int field_fileDuration;
    public long field_fileLength;
    public String field_fileMd5;
    public String field_fileName;
    public int field_fileNameHash;
    public int field_fileStatus;
    public int field_localId;

    public final void b(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (bGM == hashCode) {
                    this.field_localId = cursor.getInt(i);
                    this.bGK = true;
                } else if (bId == hashCode) {
                    this.field_fileName = cursor.getString(i);
                } else if (bRM == hashCode) {
                    this.field_fileNameHash = cursor.getInt(i);
                } else if (bRN == hashCode) {
                    this.field_fileMd5 = cursor.getString(i);
                } else if (bRO == hashCode) {
                    this.field_fileLength = cursor.getLong(i);
                } else if (bRP == hashCode) {
                    this.field_fileStatus = cursor.getInt(i);
                } else if (bRQ == hashCode) {
                    this.field_fileDuration = cursor.getInt(i);
                } else if (bun == hashCode) {
                    this.field_createTime = cursor.getLong(i);
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
        if (this.bHQ) {
            contentValues.put("fileName", this.field_fileName);
        }
        if (this.bRH) {
            contentValues.put("fileNameHash", Integer.valueOf(this.field_fileNameHash));
        }
        if (this.field_fileMd5 == null) {
            this.field_fileMd5 = SQLiteDatabase.KeyEmpty;
        }
        if (this.bRI) {
            contentValues.put("fileMd5", this.field_fileMd5);
        }
        if (this.bRJ) {
            contentValues.put("fileLength", Long.valueOf(this.field_fileLength));
        }
        if (this.bRK) {
            contentValues.put("fileStatus", Integer.valueOf(this.field_fileStatus));
        }
        if (this.bRL) {
            contentValues.put("fileDuration", Integer.valueOf(this.field_fileDuration));
        }
        if (this.btS) {
            contentValues.put("createTime", Long.valueOf(this.field_createTime));
        }
        if (this.nmb > 0) {
            contentValues.put("rowid", Long.valueOf(this.nmb));
        }
        return contentValues;
    }
}
