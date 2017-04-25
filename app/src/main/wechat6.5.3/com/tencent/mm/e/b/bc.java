package com.tencent.mm.e.b;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.protocal.c.bm;
import com.tencent.mm.sdk.h.c;
import com.tencent.mm.sdk.platformtools.v;
import java.io.IOException;

public abstract class bc extends c {
    private static final int bJe = "cgi".hashCode();
    private static final int bJf = "cmdid".hashCode();
    private static final int bJg = "functionmsgid".hashCode();
    private static final int bJh = "preVersion".hashCode();
    private static final int bJi = "retryinterval".hashCode();
    private static final int bJj = "reportid".hashCode();
    private static final int bJk = "successkey".hashCode();
    private static final int bJl = "failkey".hashCode();
    private static final int bJm = "finalfailkey".hashCode();
    private static final int bJn = "custombuff".hashCode();
    private static final int bJo = "addMsg".hashCode();
    private static final int bJp = "needShow".hashCode();
    public static final String[] btd = new String[0];
    private static final int btm = "rowid".hashCode();
    private static final int bvg = "status".hashCode();
    private static final int bwn = "version".hashCode();
    private boolean bIS = true;
    private boolean bIT = true;
    private boolean bIU = true;
    private boolean bIV = true;
    private boolean bIW = true;
    private boolean bIX = true;
    private boolean bIY = true;
    private boolean bIZ = true;
    private boolean bJa = true;
    private boolean bJb = true;
    private boolean bJc = true;
    private boolean bJd = true;
    private boolean buP = true;
    private boolean bwg = true;
    public bm field_addMsg;
    public String field_cgi;
    public int field_cmdid;
    public String field_custombuff;
    public int field_failkey;
    public int field_finalfailkey;
    public String field_functionmsgid;
    public boolean field_needShow;
    public long field_preVersion;
    public int field_reportid;
    public int field_retryinterval;
    public int field_status;
    public int field_successkey;
    public long field_version;

    public final void b(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (bJe == hashCode) {
                    this.field_cgi = cursor.getString(i);
                } else if (bJf == hashCode) {
                    this.field_cmdid = cursor.getInt(i);
                } else if (bJg == hashCode) {
                    this.field_functionmsgid = cursor.getString(i);
                    this.bIU = true;
                } else if (bwn == hashCode) {
                    this.field_version = cursor.getLong(i);
                } else if (bJh == hashCode) {
                    this.field_preVersion = cursor.getLong(i);
                } else if (bJi == hashCode) {
                    this.field_retryinterval = cursor.getInt(i);
                } else if (bJj == hashCode) {
                    this.field_reportid = cursor.getInt(i);
                } else if (bJk == hashCode) {
                    this.field_successkey = cursor.getInt(i);
                } else if (bJl == hashCode) {
                    this.field_failkey = cursor.getInt(i);
                } else if (bJm == hashCode) {
                    this.field_finalfailkey = cursor.getInt(i);
                } else if (bJn == hashCode) {
                    this.field_custombuff = cursor.getString(i);
                } else if (bJo == hashCode) {
                    try {
                        byte[] blob = cursor.getBlob(i);
                        if (blob != null && blob.length > 0) {
                            this.field_addMsg = (bm) new bm().az(blob);
                        }
                    } catch (IOException e) {
                        v.e("MicroMsg.SDK.BaseFunctionMsgItem", e.getMessage());
                    }
                } else if (bvg == hashCode) {
                    this.field_status = cursor.getInt(i);
                } else if (bJp == hashCode) {
                    this.field_needShow = cursor.getInt(i) != 0;
                } else if (btm == hashCode) {
                    this.nmb = cursor.getLong(i);
                }
            }
        }
    }

    public final ContentValues py() {
        ContentValues contentValues = new ContentValues();
        if (this.bIS) {
            contentValues.put("cgi", this.field_cgi);
        }
        if (this.bIT) {
            contentValues.put("cmdid", Integer.valueOf(this.field_cmdid));
        }
        if (this.bIU) {
            contentValues.put("functionmsgid", this.field_functionmsgid);
        }
        if (this.bwg) {
            contentValues.put("version", Long.valueOf(this.field_version));
        }
        if (this.bIV) {
            contentValues.put("preVersion", Long.valueOf(this.field_preVersion));
        }
        if (this.bIW) {
            contentValues.put("retryinterval", Integer.valueOf(this.field_retryinterval));
        }
        if (this.bIX) {
            contentValues.put("reportid", Integer.valueOf(this.field_reportid));
        }
        if (this.bIY) {
            contentValues.put("successkey", Integer.valueOf(this.field_successkey));
        }
        if (this.bIZ) {
            contentValues.put("failkey", Integer.valueOf(this.field_failkey));
        }
        if (this.bJa) {
            contentValues.put("finalfailkey", Integer.valueOf(this.field_finalfailkey));
        }
        if (this.bJb) {
            contentValues.put("custombuff", this.field_custombuff);
        }
        if (this.bJc && this.field_addMsg != null) {
            try {
                contentValues.put("addMsg", this.field_addMsg.toByteArray());
            } catch (IOException e) {
                v.e("MicroMsg.SDK.BaseFunctionMsgItem", e.getMessage());
            }
        }
        if (this.buP) {
            contentValues.put("status", Integer.valueOf(this.field_status));
        }
        if (this.bJd) {
            contentValues.put("needShow", Boolean.valueOf(this.field_needShow));
        }
        if (this.nmb > 0) {
            contentValues.put("rowid", Long.valueOf(this.nmb));
        }
        return contentValues;
    }
}
