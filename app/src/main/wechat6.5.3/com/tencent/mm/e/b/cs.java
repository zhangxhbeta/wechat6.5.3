package com.tencent.mm.e.b;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.h.c;
import com.tencent.tmassistantsdk.storage.table.DownloadSettingTable.Columns;

public abstract class cs extends c {
    public static final String[] btd = new String[0];
    private static final int btm = "rowid".hashCode();
    private static final int buk = "snsId".hashCode();
    private static final int bul = "userName".hashCode();
    private static final int bum = "localFlag".hashCode();
    private static final int bun = "createTime".hashCode();
    private static final int buo = "head".hashCode();
    private static final int bup = "localPrivate".hashCode();
    private static final int buq = Columns.TYPE.hashCode();
    private static final int bur = "sourceType".hashCode();
    private static final int bus = "likeFlag".hashCode();
    private static final int but = "pravited".hashCode();
    private static final int buu = "stringSeq".hashCode();
    private static final int buv = "content".hashCode();
    private static final int buw = "attrBuf".hashCode();
    private static final int bux = "postBuf".hashCode();
    private boolean btP = true;
    private boolean btQ = true;
    private boolean btR = true;
    private boolean btS = true;
    private boolean btT = true;
    private boolean btU = true;
    private boolean btV = true;
    private boolean btW = true;
    private boolean btX = true;
    private boolean btY = true;
    private boolean btZ = true;
    private boolean bua = true;
    private boolean bub = true;
    private boolean buc = true;
    public byte[] field_attrBuf;
    public byte[] field_content;
    public int field_createTime;
    public int field_head;
    public int field_likeFlag;
    public int field_localFlag;
    public int field_localPrivate;
    public byte[] field_postBuf;
    public int field_pravited;
    public long field_snsId;
    public int field_sourceType;
    public String field_stringSeq;
    public int field_type;
    public String field_userName;

    public void b(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (buk == hashCode) {
                    this.field_snsId = cursor.getLong(i);
                } else if (bul == hashCode) {
                    this.field_userName = cursor.getString(i);
                } else if (bum == hashCode) {
                    this.field_localFlag = cursor.getInt(i);
                } else if (bun == hashCode) {
                    this.field_createTime = cursor.getInt(i);
                } else if (buo == hashCode) {
                    this.field_head = cursor.getInt(i);
                } else if (bup == hashCode) {
                    this.field_localPrivate = cursor.getInt(i);
                } else if (buq == hashCode) {
                    this.field_type = cursor.getInt(i);
                } else if (bur == hashCode) {
                    this.field_sourceType = cursor.getInt(i);
                } else if (bus == hashCode) {
                    this.field_likeFlag = cursor.getInt(i);
                } else if (but == hashCode) {
                    this.field_pravited = cursor.getInt(i);
                } else if (buu == hashCode) {
                    this.field_stringSeq = cursor.getString(i);
                } else if (buv == hashCode) {
                    this.field_content = cursor.getBlob(i);
                } else if (buw == hashCode) {
                    this.field_attrBuf = cursor.getBlob(i);
                } else if (bux == hashCode) {
                    this.field_postBuf = cursor.getBlob(i);
                } else if (btm == hashCode) {
                    this.nmb = cursor.getLong(i);
                }
            }
        }
    }

    public final ContentValues py() {
        ContentValues contentValues = new ContentValues();
        if (this.btP) {
            contentValues.put("snsId", Long.valueOf(this.field_snsId));
        }
        if (this.btQ) {
            contentValues.put("userName", this.field_userName);
        }
        if (this.btR) {
            contentValues.put("localFlag", Integer.valueOf(this.field_localFlag));
        }
        if (this.btS) {
            contentValues.put("createTime", Integer.valueOf(this.field_createTime));
        }
        if (this.btT) {
            contentValues.put("head", Integer.valueOf(this.field_head));
        }
        if (this.btU) {
            contentValues.put("localPrivate", Integer.valueOf(this.field_localPrivate));
        }
        if (this.btV) {
            contentValues.put(Columns.TYPE, Integer.valueOf(this.field_type));
        }
        if (this.btW) {
            contentValues.put("sourceType", Integer.valueOf(this.field_sourceType));
        }
        if (this.btX) {
            contentValues.put("likeFlag", Integer.valueOf(this.field_likeFlag));
        }
        if (this.btY) {
            contentValues.put("pravited", Integer.valueOf(this.field_pravited));
        }
        if (this.btZ) {
            contentValues.put("stringSeq", this.field_stringSeq);
        }
        if (this.bua) {
            contentValues.put("content", this.field_content);
        }
        if (this.bub) {
            contentValues.put("attrBuf", this.field_attrBuf);
        }
        if (this.buc) {
            contentValues.put("postBuf", this.field_postBuf);
        }
        if (this.nmb > 0) {
            contentValues.put("rowid", Long.valueOf(this.nmb));
        }
        return contentValues;
    }
}
