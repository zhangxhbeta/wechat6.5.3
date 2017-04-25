package com.tencent.mm.e.b;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.h.c;

public abstract class cy extends c {
    private static final int bEY = "reserved1".hashCode();
    private static final int bEZ = "reserved2".hashCode();
    private static final int bMn = "createtime".hashCode();
    private static final int bTD = "filename".hashCode();
    private static final int bTE = "user".hashCode();
    private static final int bTF = "msgid".hashCode();
    private static final int bTG = "filenowsize".hashCode();
    private static final int bTH = "totallen".hashCode();
    private static final int bTI = "lastmodifytime".hashCode();
    private static final int bTJ = "clientid".hashCode();
    private static final int bTK = "voicelenght".hashCode();
    private static final int bTL = "msglocalid".hashCode();
    private static final int bTM = "human".hashCode();
    private static final int bTN = "voiceformat".hashCode();
    private static final int bTO = "nettimes".hashCode();
    public static final String[] btd = new String[]{"CREATE INDEX IF NOT EXISTS voiceRemindFileNameIndex ON VoiceRemindInfo(filename)"};
    private static final int btm = "rowid".hashCode();
    private static final int bvf = "offset".hashCode();
    private static final int bvg = "status".hashCode();
    private boolean bEC = true;
    private boolean bED = true;
    private boolean bMi = true;
    private boolean bTA = true;
    private boolean bTB = true;
    private boolean bTC = true;
    private boolean bTr = true;
    private boolean bTs = true;
    private boolean bTt = true;
    private boolean bTu = true;
    private boolean bTv = true;
    private boolean bTw = true;
    private boolean bTx = true;
    private boolean bTy = true;
    private boolean bTz = true;
    private boolean buO = true;
    private boolean buP = true;
    public String field_clientid;
    public long field_createtime;
    public String field_filename;
    public int field_filenowsize;
    public String field_human;
    public long field_lastmodifytime;
    public long field_msgid;
    public int field_msglocalid;
    public int field_nettimes;
    public int field_offset;
    public int field_reserved1;
    public String field_reserved2;
    public int field_status;
    public int field_totallen;
    public String field_user;
    public int field_voiceformat;
    public int field_voicelenght;

    public final void b(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (bTD == hashCode) {
                    this.field_filename = cursor.getString(i);
                } else if (bTE == hashCode) {
                    this.field_user = cursor.getString(i);
                } else if (bTF == hashCode) {
                    this.field_msgid = cursor.getLong(i);
                } else if (bvf == hashCode) {
                    this.field_offset = cursor.getInt(i);
                } else if (bTG == hashCode) {
                    this.field_filenowsize = cursor.getInt(i);
                } else if (bTH == hashCode) {
                    this.field_totallen = cursor.getInt(i);
                } else if (bvg == hashCode) {
                    this.field_status = cursor.getInt(i);
                } else if (bMn == hashCode) {
                    this.field_createtime = cursor.getLong(i);
                } else if (bTI == hashCode) {
                    this.field_lastmodifytime = cursor.getLong(i);
                } else if (bTJ == hashCode) {
                    this.field_clientid = cursor.getString(i);
                } else if (bTK == hashCode) {
                    this.field_voicelenght = cursor.getInt(i);
                } else if (bTL == hashCode) {
                    this.field_msglocalid = cursor.getInt(i);
                } else if (bTM == hashCode) {
                    this.field_human = cursor.getString(i);
                } else if (bTN == hashCode) {
                    this.field_voiceformat = cursor.getInt(i);
                } else if (bTO == hashCode) {
                    this.field_nettimes = cursor.getInt(i);
                } else if (bEY == hashCode) {
                    this.field_reserved1 = cursor.getInt(i);
                } else if (bEZ == hashCode) {
                    this.field_reserved2 = cursor.getString(i);
                } else if (btm == hashCode) {
                    this.nmb = cursor.getLong(i);
                }
            }
        }
    }

    public final ContentValues py() {
        ContentValues contentValues = new ContentValues();
        if (this.bTr) {
            contentValues.put("filename", this.field_filename);
        }
        if (this.bTs) {
            contentValues.put("user", this.field_user);
        }
        if (this.bTt) {
            contentValues.put("msgid", Long.valueOf(this.field_msgid));
        }
        if (this.buO) {
            contentValues.put("offset", Integer.valueOf(this.field_offset));
        }
        if (this.bTu) {
            contentValues.put("filenowsize", Integer.valueOf(this.field_filenowsize));
        }
        if (this.bTv) {
            contentValues.put("totallen", Integer.valueOf(this.field_totallen));
        }
        if (this.buP) {
            contentValues.put("status", Integer.valueOf(this.field_status));
        }
        if (this.bMi) {
            contentValues.put("createtime", Long.valueOf(this.field_createtime));
        }
        if (this.bTw) {
            contentValues.put("lastmodifytime", Long.valueOf(this.field_lastmodifytime));
        }
        if (this.bTx) {
            contentValues.put("clientid", this.field_clientid);
        }
        if (this.bTy) {
            contentValues.put("voicelenght", Integer.valueOf(this.field_voicelenght));
        }
        if (this.bTz) {
            contentValues.put("msglocalid", Integer.valueOf(this.field_msglocalid));
        }
        if (this.bTA) {
            contentValues.put("human", this.field_human);
        }
        if (this.bTB) {
            contentValues.put("voiceformat", Integer.valueOf(this.field_voiceformat));
        }
        if (this.bTC) {
            contentValues.put("nettimes", Integer.valueOf(this.field_nettimes));
        }
        if (this.bEC) {
            contentValues.put("reserved1", Integer.valueOf(this.field_reserved1));
        }
        if (this.bED) {
            contentValues.put("reserved2", this.field_reserved2);
        }
        if (this.nmb > 0) {
            contentValues.put("rowid", Long.valueOf(this.nmb));
        }
        return contentValues;
    }
}
