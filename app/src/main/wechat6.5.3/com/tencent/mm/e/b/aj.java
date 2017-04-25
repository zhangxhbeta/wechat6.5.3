package com.tencent.mm.e.b;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.h.c;
import com.tencent.mmdb.database.SQLiteDatabase;

public abstract class aj extends c {
    private static final int bES = "md5".hashCode();
    private static final int bET = "svrid".hashCode();
    private static final int bEU = "catalog".hashCode();
    private static final int bEV = "start".hashCode();
    private static final int bEW = "state".hashCode();
    private static final int bEX = "name".hashCode();
    private static final int bEY = "reserved1".hashCode();
    private static final int bEZ = "reserved2".hashCode();
    private static final int bEk = "lastUseTime".hashCode();
    private static final int bEo = "idx".hashCode();
    private static final int bFa = "reserved3".hashCode();
    private static final int bFb = "reserved4".hashCode();
    private static final int bFc = "app_id".hashCode();
    private static final int bFd = "groupId".hashCode();
    private static final int bFe = "framesInfo".hashCode();
    private static final int bFf = "temp".hashCode();
    private static final int bFg = "needupload".hashCode();
    private static final int bFh = "designerID".hashCode();
    private static final int bFi = "thumbUrl".hashCode();
    private static final int bFj = "cdnUrl".hashCode();
    private static final int bFk = "encrypturl".hashCode();
    private static final int bFl = "aeskey".hashCode();
    private static final int bFm = "width".hashCode();
    private static final int bFn = "height".hashCode();
    public static final String[] btd = new String[]{"CREATE INDEX IF NOT EXISTS emojiGroupIndex ON EmojiInfo(catalog)"};
    private static final int btm = "rowid".hashCode();
    private static final int buq = "type".hashCode();
    private static final int buv = "content".hashCode();
    private static final int bvB = "size".hashCode();
    private static final int bxR = "source".hashCode();
    private boolean bDK = true;
    private boolean bDO = true;
    private boolean bEA = true;
    private boolean bEB = true;
    private boolean bEC = true;
    private boolean bED = true;
    private boolean bEE = true;
    private boolean bEF = true;
    private boolean bEG = true;
    private boolean bEH = true;
    private boolean bEI = true;
    private boolean bEJ = true;
    private boolean bEK = true;
    private boolean bEL = true;
    private boolean bEM = true;
    private boolean bEN = true;
    private boolean bEO = true;
    private boolean bEP = true;
    private boolean bEQ = true;
    private boolean bER = true;
    private boolean bEw = true;
    private boolean bEx = true;
    private boolean bEy = true;
    private boolean bEz = true;
    private boolean btV = true;
    private boolean bua = true;
    private boolean bvy = true;
    private boolean bxN = true;
    public String field_aeskey;
    public String field_app_id;
    public int field_catalog;
    public String field_cdnUrl;
    public String field_content;
    public String field_designerID;
    public String field_encrypturl;
    public String field_framesInfo;
    public String field_groupId;
    public int field_height;
    public int field_idx;
    public long field_lastUseTime;
    public String field_md5;
    public String field_name;
    public int field_needupload;
    public String field_reserved1;
    public String field_reserved2;
    public int field_reserved3;
    public int field_reserved4;
    public int field_size;
    public int field_source;
    public int field_start;
    public int field_state;
    public String field_svrid;
    public int field_temp;
    public String field_thumbUrl;
    public int field_type;
    public int field_width;

    public final void b(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (bES == hashCode) {
                    this.field_md5 = cursor.getString(i);
                    this.bEw = true;
                } else if (bET == hashCode) {
                    this.field_svrid = cursor.getString(i);
                } else if (bEU == hashCode) {
                    this.field_catalog = cursor.getInt(i);
                } else if (buq == hashCode) {
                    this.field_type = cursor.getInt(i);
                } else if (bvB == hashCode) {
                    this.field_size = cursor.getInt(i);
                } else if (bEV == hashCode) {
                    this.field_start = cursor.getInt(i);
                } else if (bEW == hashCode) {
                    this.field_state = cursor.getInt(i);
                } else if (bEX == hashCode) {
                    this.field_name = cursor.getString(i);
                } else if (buv == hashCode) {
                    this.field_content = cursor.getString(i);
                } else if (bEY == hashCode) {
                    this.field_reserved1 = cursor.getString(i);
                } else if (bEZ == hashCode) {
                    this.field_reserved2 = cursor.getString(i);
                } else if (bFa == hashCode) {
                    this.field_reserved3 = cursor.getInt(i);
                } else if (bFb == hashCode) {
                    this.field_reserved4 = cursor.getInt(i);
                } else if (bFc == hashCode) {
                    this.field_app_id = cursor.getString(i);
                } else if (bFd == hashCode) {
                    this.field_groupId = cursor.getString(i);
                } else if (bEk == hashCode) {
                    this.field_lastUseTime = cursor.getLong(i);
                } else if (bFe == hashCode) {
                    this.field_framesInfo = cursor.getString(i);
                } else if (bEo == hashCode) {
                    this.field_idx = cursor.getInt(i);
                } else if (bFf == hashCode) {
                    this.field_temp = cursor.getInt(i);
                } else if (bxR == hashCode) {
                    this.field_source = cursor.getInt(i);
                } else if (bFg == hashCode) {
                    this.field_needupload = cursor.getInt(i);
                } else if (bFh == hashCode) {
                    this.field_designerID = cursor.getString(i);
                } else if (bFi == hashCode) {
                    this.field_thumbUrl = cursor.getString(i);
                } else if (bFj == hashCode) {
                    this.field_cdnUrl = cursor.getString(i);
                } else if (bFk == hashCode) {
                    this.field_encrypturl = cursor.getString(i);
                } else if (bFl == hashCode) {
                    this.field_aeskey = cursor.getString(i);
                } else if (bFm == hashCode) {
                    this.field_width = cursor.getInt(i);
                } else if (bFn == hashCode) {
                    this.field_height = cursor.getInt(i);
                } else if (btm == hashCode) {
                    this.nmb = cursor.getLong(i);
                }
            }
        }
    }

    public final ContentValues py() {
        ContentValues contentValues = new ContentValues();
        if (this.bEw) {
            contentValues.put("md5", this.field_md5);
        }
        if (this.bEx) {
            contentValues.put("svrid", this.field_svrid);
        }
        if (this.bEy) {
            contentValues.put("catalog", Integer.valueOf(this.field_catalog));
        }
        if (this.btV) {
            contentValues.put("type", Integer.valueOf(this.field_type));
        }
        if (this.bvy) {
            contentValues.put("size", Integer.valueOf(this.field_size));
        }
        if (this.bEz) {
            contentValues.put("start", Integer.valueOf(this.field_start));
        }
        if (this.bEA) {
            contentValues.put("state", Integer.valueOf(this.field_state));
        }
        if (this.bEB) {
            contentValues.put("name", this.field_name);
        }
        if (this.bua) {
            contentValues.put("content", this.field_content);
        }
        if (this.bEC) {
            contentValues.put("reserved1", this.field_reserved1);
        }
        if (this.bED) {
            contentValues.put("reserved2", this.field_reserved2);
        }
        if (this.bEE) {
            contentValues.put("reserved3", Integer.valueOf(this.field_reserved3));
        }
        if (this.bEF) {
            contentValues.put("reserved4", Integer.valueOf(this.field_reserved4));
        }
        if (this.bEG) {
            contentValues.put("app_id", this.field_app_id);
        }
        if (this.field_groupId == null) {
            this.field_groupId = SQLiteDatabase.KeyEmpty;
        }
        if (this.bEH) {
            contentValues.put("groupId", this.field_groupId);
        }
        if (this.bDK) {
            contentValues.put("lastUseTime", Long.valueOf(this.field_lastUseTime));
        }
        if (this.field_framesInfo == null) {
            this.field_framesInfo = SQLiteDatabase.KeyEmpty;
        }
        if (this.bEI) {
            contentValues.put("framesInfo", this.field_framesInfo);
        }
        if (this.bDO) {
            contentValues.put("idx", Integer.valueOf(this.field_idx));
        }
        if (this.bEJ) {
            contentValues.put("temp", Integer.valueOf(this.field_temp));
        }
        if (this.bxN) {
            contentValues.put("source", Integer.valueOf(this.field_source));
        }
        if (this.bEK) {
            contentValues.put("needupload", Integer.valueOf(this.field_needupload));
        }
        if (this.bEL) {
            contentValues.put("designerID", this.field_designerID);
        }
        if (this.bEM) {
            contentValues.put("thumbUrl", this.field_thumbUrl);
        }
        if (this.bEN) {
            contentValues.put("cdnUrl", this.field_cdnUrl);
        }
        if (this.bEO) {
            contentValues.put("encrypturl", this.field_encrypturl);
        }
        if (this.bEP) {
            contentValues.put("aeskey", this.field_aeskey);
        }
        if (this.bEQ) {
            contentValues.put("width", Integer.valueOf(this.field_width));
        }
        if (this.bER) {
            contentValues.put("height", Integer.valueOf(this.field_height));
        }
        if (this.nmb > 0) {
            contentValues.put("rowid", Long.valueOf(this.nmb));
        }
        return contentValues;
    }

    public void reset() {
    }
}
