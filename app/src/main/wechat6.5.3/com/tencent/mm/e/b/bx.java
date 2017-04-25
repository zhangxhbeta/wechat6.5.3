package com.tencent.mm.e.b;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.h.c;
import com.tencent.mm.sdk.platformtools.s;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mmdb.database.SQLiteDatabase;

public abstract class bx extends c {
    private static final int bGc = "talker".hashCode();
    private static final int bJV = "msgSeq".hashCode();
    private static final int bKX = "lvbuffer".hashCode();
    private static final int bNd = "msgSvrId".hashCode();
    private static final int bNe = "isShowTimer".hashCode();
    private static final int bNf = "imgPath".hashCode();
    private static final int bNg = "reserved".hashCode();
    private static final int bNh = "talkerId".hashCode();
    private static final int bNi = "transContent".hashCode();
    private static final int bNj = "transBrandWording".hashCode();
    private static final int bNk = "bizClientMsgId".hashCode();
    private static final int bNl = "bizChatUserId".hashCode();
    public static final String[] btd = new String[0];
    private static final int btl = "msgId".hashCode();
    private static final int btm = "rowid".hashCode();
    private static final int bun = "createTime".hashCode();
    private static final int buq = "type".hashCode();
    private static final int buv = "content".hashCode();
    private static final int bvg = "status".hashCode();
    private static final int bxU = "flag".hashCode();
    private static final int byD = "isSend".hashCode();
    private static final int bys = "bizChatId".hashCode();
    private boolean bFM = false;
    private boolean bJP = false;
    public boolean bKL = false;
    private boolean bMU = false;
    public boolean bMV = false;
    private boolean bMW = false;
    private boolean bMX = false;
    public boolean bMY = false;
    private boolean bMZ = false;
    private boolean bNa = false;
    private boolean bNb = false;
    public boolean bNc = false;
    public String bNm;
    public int bNn;
    public String bNo;
    public int bNp;
    public int bNq;
    public int bNr;
    public int bNs;
    public int bNt;
    public int bNu;
    public String bNv;
    public String bNw;
    public String bNx;
    public int bNy;
    private boolean btS = false;
    private boolean btV = false;
    private boolean bth = false;
    private boolean buP = false;
    private boolean bua = false;
    private boolean bxS = false;
    private boolean bye = false;
    private boolean byp = false;
    public long field_bizChatId;
    public String field_bizChatUserId;
    private String field_bizClientMsgId;
    public String field_content;
    public long field_createTime;
    public int field_flag;
    public String field_imgPath;
    public int field_isSend;
    public int field_isShowTimer;
    public byte[] field_lvbuffer;
    public long field_msgId;
    public long field_msgSeq;
    public long field_msgSvrId;
    public String field_reserved;
    public int field_status;
    public String field_talker;
    public int field_talkerId;
    public String field_transBrandWording;
    public String field_transContent;
    public int field_type;

    public final void x(long j) {
        this.field_msgId = j;
        this.bth = true;
    }

    public final long pJ() {
        return this.field_msgId;
    }

    public final void y(long j) {
        this.field_msgSvrId = j;
        this.bMU = true;
    }

    public final long pK() {
        return this.field_msgSvrId;
    }

    public final void setType(int i) {
        this.field_type = i;
        this.btV = true;
    }

    public final int getType() {
        return this.field_type;
    }

    public void dh(int i) {
        this.field_status = i;
        this.buP = true;
    }

    public final void di(int i) {
        this.field_isSend = i;
        this.byp = true;
    }

    public final int pL() {
        return this.field_isSend;
    }

    public final void z(long j) {
        this.field_createTime = j;
        this.btS = true;
    }

    public final long pM() {
        return this.field_createTime;
    }

    public final void cH(String str) {
        this.field_talker = str;
        this.bFM = true;
    }

    public final String pN() {
        return this.field_talker;
    }

    public final void setContent(String str) {
        this.field_content = str;
        this.bua = true;
    }

    public final String pO() {
        return this.field_content;
    }

    public final void cI(String str) {
        this.field_imgPath = str;
        this.bMW = true;
    }

    public final String pP() {
        return this.field_imgPath;
    }

    public final void cJ(String str) {
        this.field_reserved = str;
        this.bMX = true;
    }

    public final String pQ() {
        return this.field_reserved;
    }

    public final void cK(String str) {
        this.field_transContent = str;
        this.bMZ = true;
    }

    public final void cL(String str) {
        this.field_bizClientMsgId = str;
        this.bNb = true;
    }

    public final void A(long j) {
        this.field_bizChatId = j;
        this.bye = true;
    }

    public final void B(long j) {
        this.field_msgSeq = j;
        this.bJP = true;
    }

    public final void dr(int i) {
        this.field_flag = i;
        this.bxS = true;
    }

    public void b(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (btl == hashCode) {
                    this.field_msgId = cursor.getLong(i);
                    this.bth = true;
                } else if (bNd == hashCode) {
                    this.field_msgSvrId = cursor.getLong(i);
                } else if (buq == hashCode) {
                    this.field_type = cursor.getInt(i);
                } else if (bvg == hashCode) {
                    this.field_status = cursor.getInt(i);
                } else if (byD == hashCode) {
                    this.field_isSend = cursor.getInt(i);
                } else if (bNe == hashCode) {
                    this.field_isShowTimer = cursor.getInt(i);
                } else if (bun == hashCode) {
                    this.field_createTime = cursor.getLong(i);
                } else if (bGc == hashCode) {
                    this.field_talker = cursor.getString(i);
                } else if (buv == hashCode) {
                    this.field_content = cursor.getString(i);
                } else if (bNf == hashCode) {
                    this.field_imgPath = cursor.getString(i);
                } else if (bNg == hashCode) {
                    this.field_reserved = cursor.getString(i);
                } else if (bKX == hashCode) {
                    this.field_lvbuffer = cursor.getBlob(i);
                } else if (bNh == hashCode) {
                    this.field_talkerId = cursor.getInt(i);
                } else if (bNi == hashCode) {
                    this.field_transContent = cursor.getString(i);
                } else if (bNj == hashCode) {
                    this.field_transBrandWording = cursor.getString(i);
                } else if (bNk == hashCode) {
                    this.field_bizClientMsgId = cursor.getString(i);
                } else if (bys == hashCode) {
                    this.field_bizChatId = cursor.getLong(i);
                } else if (bNl == hashCode) {
                    this.field_bizChatUserId = cursor.getString(i);
                } else if (bJV == hashCode) {
                    this.field_msgSeq = cursor.getLong(i);
                } else if (bxU == hashCode) {
                    this.field_flag = cursor.getInt(i);
                } else if (btm == hashCode) {
                    this.nmb = cursor.getLong(i);
                }
            }
            try {
                if (this.field_lvbuffer != null && this.field_lvbuffer.length != 0) {
                    s sVar = new s();
                    int bg = sVar.bg(this.field_lvbuffer);
                    if (bg != 0) {
                        v.e("MicroMsg.SDK.BaseMsgInfo", "parse LVBuffer error:" + bg);
                        return;
                    }
                    if (!sVar.bsR()) {
                        this.bNm = sVar.getString();
                    }
                    if (!sVar.bsR()) {
                        this.bNn = sVar.getInt();
                    }
                    if (!sVar.bsR()) {
                        this.bNo = sVar.getString();
                    }
                    if (!sVar.bsR()) {
                        this.bNp = sVar.getInt();
                    }
                    if (!sVar.bsR()) {
                        this.bNq = sVar.getInt();
                    }
                    if (!sVar.bsR()) {
                        this.bNr = sVar.getInt();
                    }
                    if (!sVar.bsR()) {
                        this.bNs = sVar.getInt();
                    }
                    if (!sVar.bsR()) {
                        this.bNt = sVar.getInt();
                    }
                    if (!sVar.bsR()) {
                        this.bNu = sVar.getInt();
                    }
                    if (!sVar.bsR()) {
                        this.bNv = sVar.getString();
                    }
                    if (!sVar.bsR()) {
                        this.bNw = sVar.getString();
                    }
                    if (!sVar.bsR()) {
                        this.bNx = sVar.getString();
                    }
                    if (!sVar.bsR()) {
                        this.bNy = sVar.getInt();
                    }
                }
            } catch (Exception e) {
                v.e("MicroMsg.SDK.BaseMsgInfo", "get value failed");
            }
        }
    }

    public ContentValues py() {
        try {
            if (this.bKL) {
                s sVar = new s();
                sVar.bsS();
                sVar.Kc(this.bNm);
                sVar.uY(this.bNn);
                sVar.Kc(this.bNo);
                sVar.uY(this.bNp);
                sVar.uY(this.bNq);
                sVar.uY(this.bNr);
                sVar.uY(this.bNs);
                sVar.uY(this.bNt);
                sVar.uY(this.bNu);
                sVar.Kc(this.bNv);
                sVar.Kc(this.bNw);
                sVar.Kc(this.bNx);
                sVar.uY(this.bNy);
                this.field_lvbuffer = sVar.bsT();
            }
        } catch (Exception e) {
            v.e("MicroMsg.SDK.BaseMsgInfo", "get value failed, %s", e.getMessage());
        }
        ContentValues contentValues = new ContentValues();
        if (this.bth) {
            contentValues.put("msgId", Long.valueOf(this.field_msgId));
        }
        if (this.bMU) {
            contentValues.put("msgSvrId", Long.valueOf(this.field_msgSvrId));
        }
        if (this.btV) {
            contentValues.put("type", Integer.valueOf(this.field_type));
        }
        if (this.buP) {
            contentValues.put("status", Integer.valueOf(this.field_status));
        }
        if (this.byp) {
            contentValues.put("isSend", Integer.valueOf(this.field_isSend));
        }
        if (this.bMV) {
            contentValues.put("isShowTimer", Integer.valueOf(this.field_isShowTimer));
        }
        if (this.btS) {
            contentValues.put("createTime", Long.valueOf(this.field_createTime));
        }
        if (this.bFM) {
            contentValues.put("talker", this.field_talker);
        }
        if (this.field_content == null) {
            this.field_content = SQLiteDatabase.KeyEmpty;
        }
        if (this.bua) {
            contentValues.put("content", this.field_content);
        }
        if (this.bMW) {
            contentValues.put("imgPath", this.field_imgPath);
        }
        if (this.bMX) {
            contentValues.put("reserved", this.field_reserved);
        }
        if (this.bKL) {
            contentValues.put("lvbuffer", this.field_lvbuffer);
        }
        if (this.bMY) {
            contentValues.put("talkerId", Integer.valueOf(this.field_talkerId));
        }
        if (this.field_transContent == null) {
            this.field_transContent = SQLiteDatabase.KeyEmpty;
        }
        if (this.bMZ) {
            contentValues.put("transContent", this.field_transContent);
        }
        if (this.field_transBrandWording == null) {
            this.field_transBrandWording = SQLiteDatabase.KeyEmpty;
        }
        if (this.bNa) {
            contentValues.put("transBrandWording", this.field_transBrandWording);
        }
        if (this.field_bizClientMsgId == null) {
            this.field_bizClientMsgId = SQLiteDatabase.KeyEmpty;
        }
        if (this.bNb) {
            contentValues.put("bizClientMsgId", this.field_bizClientMsgId);
        }
        if (this.bye) {
            contentValues.put("bizChatId", Long.valueOf(this.field_bizChatId));
        }
        if (this.field_bizChatUserId == null) {
            this.field_bizChatUserId = SQLiteDatabase.KeyEmpty;
        }
        if (this.bNc) {
            contentValues.put("bizChatUserId", this.field_bizChatUserId);
        }
        if (this.bJP) {
            contentValues.put("msgSeq", Long.valueOf(this.field_msgSeq));
        }
        if (this.bxS) {
            contentValues.put("flag", Integer.valueOf(this.field_flag));
        }
        if (this.nmb > 0) {
            contentValues.put("rowid", Long.valueOf(this.nmb));
        }
        return contentValues;
    }

    public final void cM(String str) {
        this.bNm = str;
        this.bKL = true;
    }

    public final void ds(int i) {
        this.bNn = i;
        this.bKL = true;
    }

    public final void cN(String str) {
        this.bNo = str;
        this.bKL = true;
    }

    public final void dt(int i) {
        this.bNp = i;
        this.bKL = true;
    }

    public final void du(int i) {
        this.bNq = i;
        this.bKL = true;
    }

    public final void dv(int i) {
        this.bNu = i;
        this.bKL = true;
    }

    public final void cO(String str) {
        this.bNw = str;
        this.bKL = true;
    }

    public final void cP(String str) {
        this.bNx = str;
        this.bKL = true;
    }

    public final void dw(int i) {
        this.bNy = i;
        this.bKL = true;
    }
}
