package com.tencent.mm.e.b;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.h.c;

public abstract class bu extends c {
    private static final int bET = "svrid".hashCode();
    private static final int bGc = "talker".hashCode();
    private static final int bMn = "createtime".hashCode();
    private static final int bMo = "sayhiuser".hashCode();
    private static final int bMp = "sayhicontent".hashCode();
    private static final int bMq = "imgpath".hashCode();
    private static final int bMr = "sayhiencryptuser".hashCode();
    public static final String[] btd = new String[]{"CREATE INDEX IF NOT EXISTS lbsverifymessage_unread_index ON LBSVerifyMessage(status)", "CREATE INDEX IF NOT EXISTS lbsverifymessage_createtimeIndex ON LBSVerifyMessage(createtime)"};
    private static final int btm = "rowid".hashCode();
    private static final int buG = "scene".hashCode();
    private static final int buH = "ticket".hashCode();
    private static final int buq = "type".hashCode();
    private static final int buv = "content".hashCode();
    private static final int bvg = "status".hashCode();
    private static final int bxU = "flag".hashCode();
    private static final int byD = "isSend".hashCode();
    private boolean bEx = true;
    private boolean bFM = true;
    private boolean bMi = true;
    private boolean bMj = true;
    private boolean bMk = true;
    private boolean bMl = true;
    private boolean bMm = true;
    private boolean btV = true;
    private boolean buE = true;
    private boolean buF = true;
    private boolean buP = true;
    private boolean bua = true;
    private boolean bxS = true;
    private boolean byp = true;
    public String field_content;
    public long field_createtime;
    public int field_flag;
    public String field_imgpath;
    public int field_isSend;
    public String field_sayhicontent;
    public String field_sayhiencryptuser;
    public String field_sayhiuser;
    public int field_scene;
    public int field_status;
    public long field_svrid;
    public String field_talker;
    public String field_ticket;
    public int field_type;

    public final void b(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (bET == hashCode) {
                    this.field_svrid = cursor.getLong(i);
                    this.bEx = true;
                } else if (bvg == hashCode) {
                    this.field_status = cursor.getInt(i);
                } else if (buq == hashCode) {
                    this.field_type = cursor.getInt(i);
                } else if (buG == hashCode) {
                    this.field_scene = cursor.getInt(i);
                } else if (bMn == hashCode) {
                    this.field_createtime = cursor.getLong(i);
                } else if (bGc == hashCode) {
                    this.field_talker = cursor.getString(i);
                } else if (buv == hashCode) {
                    this.field_content = cursor.getString(i);
                } else if (bMo == hashCode) {
                    this.field_sayhiuser = cursor.getString(i);
                } else if (bMp == hashCode) {
                    this.field_sayhicontent = cursor.getString(i);
                } else if (bMq == hashCode) {
                    this.field_imgpath = cursor.getString(i);
                } else if (byD == hashCode) {
                    this.field_isSend = cursor.getInt(i);
                } else if (bMr == hashCode) {
                    this.field_sayhiencryptuser = cursor.getString(i);
                } else if (buH == hashCode) {
                    this.field_ticket = cursor.getString(i);
                } else if (bxU == hashCode) {
                    this.field_flag = cursor.getInt(i);
                } else if (btm == hashCode) {
                    this.nmb = cursor.getLong(i);
                }
            }
        }
    }

    public final ContentValues py() {
        ContentValues contentValues = new ContentValues();
        if (this.bEx) {
            contentValues.put("svrid", Long.valueOf(this.field_svrid));
        }
        if (this.buP) {
            contentValues.put("status", Integer.valueOf(this.field_status));
        }
        if (this.btV) {
            contentValues.put("type", Integer.valueOf(this.field_type));
        }
        if (this.buE) {
            contentValues.put("scene", Integer.valueOf(this.field_scene));
        }
        if (this.bMi) {
            contentValues.put("createtime", Long.valueOf(this.field_createtime));
        }
        if (this.bFM) {
            contentValues.put("talker", this.field_talker);
        }
        if (this.bua) {
            contentValues.put("content", this.field_content);
        }
        if (this.bMj) {
            contentValues.put("sayhiuser", this.field_sayhiuser);
        }
        if (this.bMk) {
            contentValues.put("sayhicontent", this.field_sayhicontent);
        }
        if (this.bMl) {
            contentValues.put("imgpath", this.field_imgpath);
        }
        if (this.byp) {
            contentValues.put("isSend", Integer.valueOf(this.field_isSend));
        }
        if (this.bMm) {
            contentValues.put("sayhiencryptuser", this.field_sayhiencryptuser);
        }
        if (this.buF) {
            contentValues.put("ticket", this.field_ticket);
        }
        if (this.bxS) {
            contentValues.put("flag", Integer.valueOf(this.field_flag));
        }
        if (this.nmb > 0) {
            contentValues.put("rowid", Long.valueOf(this.nmb));
        }
        return contentValues;
    }
}
