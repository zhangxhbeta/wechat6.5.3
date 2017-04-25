package com.tencent.mm.e.b;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.h.c;
import com.tencent.mm.sdk.platformtools.s;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mmdb.database.SQLiteDatabase;

public abstract class ab extends c {
    private static final int bAa = "nickname".hashCode();
    private static final int bBJ = "alias".hashCode();
    private static final int bBK = "conRemark".hashCode();
    private static final int bBL = "domainList".hashCode();
    private static final int bBM = "pyInitial".hashCode();
    private static final int bBN = "quanPin".hashCode();
    private static final int bBO = "showHead".hashCode();
    private static final int bBP = "weiboFlag".hashCode();
    private static final int bBQ = "weiboNickname".hashCode();
    private static final int bBR = "conRemarkPYFull".hashCode();
    private static final int bBS = "conRemarkPYShort".hashCode();
    private static final int bBT = "verifyFlag".hashCode();
    private static final int bBU = "encryptUsername".hashCode();
    private static final int bBV = "chatroomFlag".hashCode();
    private static final int bBW = "deleteFlag".hashCode();
    private static final int bBX = "contactLabelIds".hashCode();
    public static final String[] btd = new String[]{"CREATE INDEX IF NOT EXISTS deleteflag_index ON Contact(deleteFlag)"};
    private static final int btm = "rowid".hashCode();
    private static final int buq = "type".hashCode();
    private static final int bxg = "lvbuff".hashCode();
    private static final int bzG = "username".hashCode();
    private boolean bBA = false;
    private boolean bBB = false;
    private boolean bBC = false;
    private boolean bBD = false;
    private boolean bBE = false;
    private boolean bBF = false;
    private boolean bBG = false;
    private boolean bBH = false;
    private boolean bBI = false;
    public int bBY;
    public int bBZ;
    private boolean bBu = false;
    private boolean bBv = false;
    private boolean bBw = false;
    private boolean bBx = false;
    private boolean bBy = false;
    private boolean bBz = false;
    public String bCa;
    public long bCb;
    public String bCc;
    public int bCd;
    public int bCe;
    public String bCf;
    public String bCg;
    public int bCh;
    public int bCi;
    public String bCj;
    private String bCk;
    private String bCl;
    public String bCm;
    public int bCn;
    public String bCo;
    public String bCp;
    public String bCq;
    public int bCr;
    public int bCs;
    public String bCt;
    public String bCu;
    public String bCv;
    public String bCw;
    public String bCx;
    public String bCy;
    public String bCz;
    public int bbT;
    public String bhT;
    private boolean btV = false;
    private boolean bwK = false;
    private boolean bzW = false;
    private boolean bzs = false;
    private String field_alias;
    public int field_chatroomFlag;
    public String field_conRemark;
    public String field_conRemarkPYFull;
    public String field_conRemarkPYShort;
    public String field_contactLabelIds;
    public int field_deleteFlag;
    public String field_domainList;
    public String field_encryptUsername;
    public byte[] field_lvbuff;
    public String field_nickname;
    private String field_pyInitial;
    private String field_quanPin;
    public int field_showHead;
    public int field_type;
    public String field_username;
    public int field_verifyFlag;
    public int field_weiboFlag;
    public String field_weiboNickname;
    public int uin;

    public void setUsername(String str) {
        this.field_username = str;
        this.bzs = true;
    }

    public final String getUsername() {
        return this.field_username;
    }

    public void bP(String str) {
        this.field_alias = str;
        this.bBu = true;
    }

    public String pD() {
        return this.field_alias;
    }

    public void bQ(String str) {
        this.field_conRemark = str;
        this.bBv = true;
    }

    public void bR(String str) {
        this.field_domainList = str;
        this.bBw = true;
    }

    public void bS(String str) {
        this.field_nickname = str;
        this.bzW = true;
    }

    public void bT(String str) {
        this.field_pyInitial = str;
        this.bBx = true;
    }

    public String pE() {
        return this.field_pyInitial;
    }

    public void bU(String str) {
        this.field_quanPin = str;
        this.bBy = true;
    }

    public String pF() {
        return this.field_quanPin;
    }

    public void cP(int i) {
        this.field_showHead = i;
        this.bBz = true;
    }

    public void setType(int i) {
        this.field_type = i;
        this.btV = true;
    }

    public void cQ(int i) {
        this.field_weiboFlag = i;
        this.bBA = true;
    }

    public void bV(String str) {
        this.field_weiboNickname = str;
        this.bBB = true;
    }

    public void bW(String str) {
        this.field_conRemarkPYFull = str;
        this.bBC = true;
    }

    public void bX(String str) {
        this.field_conRemarkPYShort = str;
        this.bBD = true;
    }

    public void u(byte[] bArr) {
        this.field_lvbuff = bArr;
        this.bwK = true;
    }

    public void cR(int i) {
        this.field_verifyFlag = i;
        this.bBE = true;
    }

    public void bY(String str) {
        this.field_encryptUsername = str;
        this.bBF = true;
    }

    public void cS(int i) {
        this.field_chatroomFlag = i;
        this.bBG = true;
    }

    public void cT(int i) {
        this.field_deleteFlag = i;
        this.bBH = true;
    }

    public void bZ(String str) {
        this.field_contactLabelIds = str;
        this.bBI = true;
    }

    public void b(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (bzG == hashCode) {
                    this.field_username = cursor.getString(i);
                    this.bzs = true;
                } else if (bBJ == hashCode) {
                    this.field_alias = cursor.getString(i);
                } else if (bBK == hashCode) {
                    this.field_conRemark = cursor.getString(i);
                } else if (bBL == hashCode) {
                    this.field_domainList = cursor.getString(i);
                } else if (bAa == hashCode) {
                    this.field_nickname = cursor.getString(i);
                } else if (bBM == hashCode) {
                    this.field_pyInitial = cursor.getString(i);
                } else if (bBN == hashCode) {
                    this.field_quanPin = cursor.getString(i);
                } else if (bBO == hashCode) {
                    this.field_showHead = cursor.getInt(i);
                } else if (buq == hashCode) {
                    this.field_type = cursor.getInt(i);
                } else if (bBP == hashCode) {
                    this.field_weiboFlag = cursor.getInt(i);
                } else if (bBQ == hashCode) {
                    this.field_weiboNickname = cursor.getString(i);
                } else if (bBR == hashCode) {
                    this.field_conRemarkPYFull = cursor.getString(i);
                } else if (bBS == hashCode) {
                    this.field_conRemarkPYShort = cursor.getString(i);
                } else if (bxg == hashCode) {
                    this.field_lvbuff = cursor.getBlob(i);
                } else if (bBT == hashCode) {
                    this.field_verifyFlag = cursor.getInt(i);
                } else if (bBU == hashCode) {
                    this.field_encryptUsername = cursor.getString(i);
                } else if (bBV == hashCode) {
                    this.field_chatroomFlag = cursor.getInt(i);
                } else if (bBW == hashCode) {
                    this.field_deleteFlag = cursor.getInt(i);
                } else if (bBX == hashCode) {
                    this.field_contactLabelIds = cursor.getString(i);
                } else if (btm == hashCode) {
                    this.nmb = cursor.getLong(i);
                }
            }
            pG();
        }
    }

    public final ContentValues py() {
        try {
            if (this.bwK) {
                s sVar = new s();
                sVar.bsS();
                sVar.uY(this.bBY);
                sVar.uY(this.bBZ);
                sVar.Kc(this.bCa);
                sVar.dY(this.bCb);
                sVar.uY(this.uin);
                sVar.Kc(this.bCc);
                sVar.Kc(this.bhT);
                sVar.uY(this.bCd);
                sVar.uY(this.bCe);
                sVar.Kc(this.bCf);
                sVar.Kc(this.bCg);
                sVar.uY(this.bCh);
                sVar.uY(this.bCi);
                sVar.Kc(this.bCj);
                sVar.Kc(this.bCk);
                sVar.Kc(this.bCl);
                sVar.Kc(this.bCm);
                sVar.uY(this.bCn);
                sVar.uY(this.bbT);
                sVar.Kc(this.bCo);
                sVar.uY(this.field_verifyFlag);
                sVar.Kc(this.bCp);
                sVar.Kc(this.bCq);
                sVar.uY(this.bCr);
                sVar.uY(this.bCs);
                sVar.Kc(this.bCt);
                sVar.Kc(this.bCu);
                sVar.Kc(this.bCv);
                sVar.Kc(this.bCw);
                sVar.Kc(this.bCx);
                sVar.Kc(this.bCy);
                sVar.Kc(this.bCz);
                this.field_lvbuff = sVar.bsT();
            }
        } catch (Exception e) {
            v.e("MicroMsg.SDK.BaseContact", "get value failed, %s", e.getMessage());
        }
        ContentValues contentValues = new ContentValues();
        if (this.field_username == null) {
            this.field_username = SQLiteDatabase.KeyEmpty;
        }
        if (this.bzs) {
            contentValues.put("username", this.field_username);
        }
        if (this.field_alias == null) {
            this.field_alias = SQLiteDatabase.KeyEmpty;
        }
        if (this.bBu) {
            contentValues.put("alias", this.field_alias);
        }
        if (this.field_conRemark == null) {
            this.field_conRemark = SQLiteDatabase.KeyEmpty;
        }
        if (this.bBv) {
            contentValues.put("conRemark", this.field_conRemark);
        }
        if (this.field_domainList == null) {
            this.field_domainList = SQLiteDatabase.KeyEmpty;
        }
        if (this.bBw) {
            contentValues.put("domainList", this.field_domainList);
        }
        if (this.field_nickname == null) {
            this.field_nickname = SQLiteDatabase.KeyEmpty;
        }
        if (this.bzW) {
            contentValues.put("nickname", this.field_nickname);
        }
        if (this.field_pyInitial == null) {
            this.field_pyInitial = SQLiteDatabase.KeyEmpty;
        }
        if (this.bBx) {
            contentValues.put("pyInitial", this.field_pyInitial);
        }
        if (this.field_quanPin == null) {
            this.field_quanPin = SQLiteDatabase.KeyEmpty;
        }
        if (this.bBy) {
            contentValues.put("quanPin", this.field_quanPin);
        }
        if (this.bBz) {
            contentValues.put("showHead", Integer.valueOf(this.field_showHead));
        }
        if (this.btV) {
            contentValues.put("type", Integer.valueOf(this.field_type));
        }
        if (this.bBA) {
            contentValues.put("weiboFlag", Integer.valueOf(this.field_weiboFlag));
        }
        if (this.field_weiboNickname == null) {
            this.field_weiboNickname = SQLiteDatabase.KeyEmpty;
        }
        if (this.bBB) {
            contentValues.put("weiboNickname", this.field_weiboNickname);
        }
        if (this.field_conRemarkPYFull == null) {
            this.field_conRemarkPYFull = SQLiteDatabase.KeyEmpty;
        }
        if (this.bBC) {
            contentValues.put("conRemarkPYFull", this.field_conRemarkPYFull);
        }
        if (this.field_conRemarkPYShort == null) {
            this.field_conRemarkPYShort = SQLiteDatabase.KeyEmpty;
        }
        if (this.bBD) {
            contentValues.put("conRemarkPYShort", this.field_conRemarkPYShort);
        }
        if (this.bwK) {
            contentValues.put("lvbuff", this.field_lvbuff);
        }
        if (this.bBE) {
            contentValues.put("verifyFlag", Integer.valueOf(this.field_verifyFlag));
        }
        if (this.field_encryptUsername == null) {
            this.field_encryptUsername = SQLiteDatabase.KeyEmpty;
        }
        if (this.bBF) {
            contentValues.put("encryptUsername", this.field_encryptUsername);
        }
        if (this.bBG) {
            contentValues.put("chatroomFlag", Integer.valueOf(this.field_chatroomFlag));
        }
        if (this.bBH) {
            contentValues.put("deleteFlag", Integer.valueOf(this.field_deleteFlag));
        }
        if (this.field_contactLabelIds == null) {
            this.field_contactLabelIds = SQLiteDatabase.KeyEmpty;
        }
        if (this.bBI) {
            contentValues.put("contactLabelIds", this.field_contactLabelIds);
        }
        if (this.nmb > 0) {
            contentValues.put("rowid", Long.valueOf(this.nmb));
        }
        return contentValues;
    }

    public void cU(int i) {
        this.bBY = i;
        this.bwK = true;
    }

    public void cV(int i) {
        this.bBZ = i;
        this.bwK = true;
    }

    public void ca(String str) {
        this.bCa = str;
        this.bwK = true;
    }

    public void r(long j) {
        this.bCb = j;
        this.bwK = true;
    }

    public void cW(int i) {
        this.uin = i;
        this.bwK = true;
    }

    public void cb(String str) {
        this.bCc = str;
        this.bwK = true;
    }

    public void cc(String str) {
        this.bhT = str;
        this.bwK = true;
    }

    public void cX(int i) {
        this.bCd = i;
        this.bwK = true;
    }

    public void cY(int i) {
        this.bCe = i;
        this.bwK = true;
    }

    public void cd(String str) {
        this.bCf = str;
        this.bwK = true;
    }

    public void ce(String str) {
        this.bCg = str;
        this.bwK = true;
    }

    public void cZ(int i) {
        this.bCh = i;
        this.bwK = true;
    }

    public void da(int i) {
        this.bCi = i;
        this.bwK = true;
    }

    public void cf(String str) {
        this.bCj = str;
        this.bwK = true;
    }

    public String getProvince() {
        return this.bCk;
    }

    public void cg(String str) {
        this.bCk = str;
        this.bwK = true;
    }

    public String getCity() {
        return this.bCl;
    }

    public void ch(String str) {
        this.bCl = str;
        this.bwK = true;
    }

    public void ci(String str) {
        this.bCm = str;
        this.bwK = true;
    }

    public void db(int i) {
        this.bCn = i;
        this.bwK = true;
    }

    public void setSource(int i) {
        this.bbT = i;
        this.bwK = true;
    }

    public void cj(String str) {
        this.bCo = str;
        this.bwK = true;
    }

    public void ck(String str) {
        this.bCp = str;
        this.bwK = true;
    }

    public void cl(String str) {
        this.bCq = str;
        this.bwK = true;
    }

    public void dc(int i) {
        this.bCr = i;
        this.bwK = true;
    }

    public void dd(int i) {
        this.bCs = i;
        this.bwK = true;
    }

    public void cm(String str) {
        this.bCt = str;
        this.bwK = true;
    }

    public void cn(String str) {
        this.bCu = str;
        this.bwK = true;
    }

    public void co(String str) {
        this.bCv = str;
        this.bwK = true;
    }

    public void cp(String str) {
        this.bCw = str;
        this.bwK = true;
    }

    public void cq(String str) {
        this.bCx = str;
        this.bwK = true;
    }

    public void cr(String str) {
        this.bCy = str;
        this.bwK = true;
    }

    public void cs(String str) {
        this.bCz = str;
        this.bwK = true;
    }

    public final void pG() {
        try {
            if (this.field_lvbuff != null && this.field_lvbuff.length != 0) {
                s sVar = new s();
                int bg = sVar.bg(this.field_lvbuff);
                if (bg != 0) {
                    v.e("MicroMsg.SDK.BaseContact", "parse LVBuffer error:" + bg);
                    return;
                }
                this.bBY = sVar.getInt();
                this.bBZ = sVar.getInt();
                this.bCa = sVar.getString();
                this.bCb = sVar.getLong();
                this.uin = sVar.getInt();
                this.bCc = sVar.getString();
                this.bhT = sVar.getString();
                this.bCd = sVar.getInt();
                this.bCe = sVar.getInt();
                this.bCf = sVar.getString();
                this.bCg = sVar.getString();
                this.bCh = sVar.getInt();
                this.bCi = sVar.getInt();
                this.bCj = sVar.getString();
                this.bCk = sVar.getString();
                this.bCl = sVar.getString();
                this.bCm = sVar.getString();
                this.bCn = sVar.getInt();
                this.bbT = sVar.getInt();
                this.bCo = sVar.getString();
                this.field_verifyFlag = sVar.getInt();
                this.bCp = sVar.getString();
                if (!sVar.bsR()) {
                    this.bCq = sVar.getString();
                }
                if (!sVar.bsR()) {
                    this.bCr = sVar.getInt();
                }
                if (!sVar.bsR()) {
                    this.bCs = sVar.getInt();
                }
                if (!sVar.bsR()) {
                    this.bCt = sVar.getString();
                }
                if (!sVar.bsR()) {
                    this.bCu = sVar.getString();
                }
                if (!sVar.bsR()) {
                    this.bCv = sVar.getString();
                }
                if (!sVar.bsR()) {
                    this.bCw = sVar.getString();
                }
                if (!sVar.bsR()) {
                    this.bCx = sVar.getString();
                }
                if (!sVar.bsR()) {
                    this.bCy = sVar.getString();
                }
                if (!sVar.bsR()) {
                    this.bCz = sVar.getString();
                }
            }
        } catch (Exception e) {
            v.e("MicroMsg.SDK.BaseContact", "get value failed");
        }
    }
}
