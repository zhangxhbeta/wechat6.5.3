package com.tencent.mm.i;

import android.database.Cursor;
import com.tencent.mm.a.o;
import com.tencent.mm.e.b.ab;
import com.tencent.mm.sdk.modelmsg.WXMediaMessage;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mmdb.FileUtils;
import com.tencent.mmdb.database.SQLiteDatabase;
import java.lang.reflect.Field;

public class a extends ab {
    public static com.tencent.mm.sdk.h.c.a chq;
    private static a chs = null;
    public long chr;
    public int versionCode;

    public interface a {
        String bt(String str);

        String bu(String str);
    }

    static {
        com.tencent.mm.sdk.h.c.a aVar = new com.tencent.mm.sdk.h.c.a();
        aVar.ddU = new Field[19];
        aVar.bXK = new String[20];
        StringBuilder stringBuilder = new StringBuilder();
        aVar.bXK[0] = "username";
        aVar.nmd.put("username", "TEXT default ''  PRIMARY KEY ");
        stringBuilder.append(" username TEXT default ''  PRIMARY KEY ");
        stringBuilder.append(", ");
        aVar.nmc = "username";
        aVar.bXK[1] = "alias";
        aVar.nmd.put("alias", "TEXT default '' ");
        stringBuilder.append(" alias TEXT default '' ");
        stringBuilder.append(", ");
        aVar.bXK[2] = "conRemark";
        aVar.nmd.put("conRemark", "TEXT default '' ");
        stringBuilder.append(" conRemark TEXT default '' ");
        stringBuilder.append(", ");
        aVar.bXK[3] = "domainList";
        aVar.nmd.put("domainList", "TEXT default '' ");
        stringBuilder.append(" domainList TEXT default '' ");
        stringBuilder.append(", ");
        aVar.bXK[4] = "nickname";
        aVar.nmd.put("nickname", "TEXT default '' ");
        stringBuilder.append(" nickname TEXT default '' ");
        stringBuilder.append(", ");
        aVar.bXK[5] = "pyInitial";
        aVar.nmd.put("pyInitial", "TEXT default '' ");
        stringBuilder.append(" pyInitial TEXT default '' ");
        stringBuilder.append(", ");
        aVar.bXK[6] = "quanPin";
        aVar.nmd.put("quanPin", "TEXT default '' ");
        stringBuilder.append(" quanPin TEXT default '' ");
        stringBuilder.append(", ");
        aVar.bXK[7] = "showHead";
        aVar.nmd.put("showHead", "INTEGER default '0' ");
        stringBuilder.append(" showHead INTEGER default '0' ");
        stringBuilder.append(", ");
        aVar.bXK[8] = "type";
        aVar.nmd.put("type", "INTEGER default '0' ");
        stringBuilder.append(" type INTEGER default '0' ");
        stringBuilder.append(", ");
        aVar.bXK[9] = "weiboFlag";
        aVar.nmd.put("weiboFlag", "INTEGER default '0' ");
        stringBuilder.append(" weiboFlag INTEGER default '0' ");
        stringBuilder.append(", ");
        aVar.bXK[10] = "weiboNickname";
        aVar.nmd.put("weiboNickname", "TEXT default '' ");
        stringBuilder.append(" weiboNickname TEXT default '' ");
        stringBuilder.append(", ");
        aVar.bXK[11] = "conRemarkPYFull";
        aVar.nmd.put("conRemarkPYFull", "TEXT default '' ");
        stringBuilder.append(" conRemarkPYFull TEXT default '' ");
        stringBuilder.append(", ");
        aVar.bXK[12] = "conRemarkPYShort";
        aVar.nmd.put("conRemarkPYShort", "TEXT default '' ");
        stringBuilder.append(" conRemarkPYShort TEXT default '' ");
        stringBuilder.append(", ");
        aVar.bXK[13] = "lvbuff";
        aVar.nmd.put("lvbuff", "BLOB");
        stringBuilder.append(" lvbuff BLOB");
        stringBuilder.append(", ");
        aVar.bXK[14] = "verifyFlag";
        aVar.nmd.put("verifyFlag", "INTEGER default '0' ");
        stringBuilder.append(" verifyFlag INTEGER default '0' ");
        stringBuilder.append(", ");
        aVar.bXK[15] = "encryptUsername";
        aVar.nmd.put("encryptUsername", "TEXT default '' ");
        stringBuilder.append(" encryptUsername TEXT default '' ");
        stringBuilder.append(", ");
        aVar.bXK[16] = "chatroomFlag";
        aVar.nmd.put("chatroomFlag", "INTEGER");
        stringBuilder.append(" chatroomFlag INTEGER");
        stringBuilder.append(", ");
        aVar.bXK[17] = "deleteFlag";
        aVar.nmd.put("deleteFlag", "INTEGER default '0' ");
        stringBuilder.append(" deleteFlag INTEGER default '0' ");
        stringBuilder.append(", ");
        aVar.bXK[18] = "contactLabelIds";
        aVar.nmd.put("contactLabelIds", "TEXT default '' ");
        stringBuilder.append(" contactLabelIds TEXT default '' ");
        aVar.bXK[19] = "rowid";
        aVar.nme = stringBuilder.toString();
        chq = aVar;
    }

    public final com.tencent.mm.sdk.h.c.a tl() {
        return chq;
    }

    public a(String str) {
        this();
        if (str == null) {
            str = SQLiteDatabase.KeyEmpty;
        }
        setUsername(str);
    }

    public a() {
        this.versionCode = 0;
        super.setUsername(SQLiteDatabase.KeyEmpty);
        super.bS(SQLiteDatabase.KeyEmpty);
        super.bT(SQLiteDatabase.KeyEmpty);
        super.bU(SQLiteDatabase.KeyEmpty);
        super.bP(SQLiteDatabase.KeyEmpty);
        super.bQ(SQLiteDatabase.KeyEmpty);
        super.bX(SQLiteDatabase.KeyEmpty);
        super.bW(SQLiteDatabase.KeyEmpty);
        super.bR(SQLiteDatabase.KeyEmpty);
        super.cQ(0);
        super.bV(SQLiteDatabase.KeyEmpty);
        super.cP(0);
        super.setType(0);
        super.cR(0);
        super.cS(0);
        super.bZ(SQLiteDatabase.KeyEmpty);
        super.cV(0);
        super.ci(SQLiteDatabase.KeyEmpty);
        super.db(0);
        super.cW(0);
        super.cb(SQLiteDatabase.KeyEmpty);
        super.cc(SQLiteDatabase.KeyEmpty);
        super.cX(0);
        super.cY(0);
        super.cd(SQLiteDatabase.KeyEmpty);
        super.ce(SQLiteDatabase.KeyEmpty);
        super.cZ(1);
        super.cU(0);
        super.da(0);
        super.cf(SQLiteDatabase.KeyEmpty);
        super.cg(SQLiteDatabase.KeyEmpty);
        super.ch(SQLiteDatabase.KeyEmpty);
        super.setSource(0);
        super.ck(SQLiteDatabase.KeyEmpty);
        super.cj(SQLiteDatabase.KeyEmpty);
        super.r(0);
        super.ca(SQLiteDatabase.KeyEmpty);
        super.cl(SQLiteDatabase.KeyEmpty);
        super.dc(0);
        super.co(SQLiteDatabase.KeyEmpty);
        super.cp(SQLiteDatabase.KeyEmpty);
        super.cq(SQLiteDatabase.KeyEmpty);
        this.versionCode = 0;
    }

    public static void a(a aVar) {
        chs = aVar;
    }

    public static String dJ(String str) {
        return chs != null ? chs.bt(str) : null;
    }

    public final int tm() {
        int i = 32;
        if (this.field_conRemarkPYShort != null && !this.field_conRemarkPYShort.equals(SQLiteDatabase.KeyEmpty)) {
            i = this.field_conRemarkPYShort.charAt(0);
        } else if (this.field_conRemarkPYFull != null && !this.field_conRemarkPYFull.equals(SQLiteDatabase.KeyEmpty)) {
            i = this.field_conRemarkPYFull.charAt(0);
        } else if (super.pE() != null && !super.pE().equals(SQLiteDatabase.KeyEmpty)) {
            i = super.pE().charAt(0);
        } else if (super.pF() != null && !super.pF().equals(SQLiteDatabase.KeyEmpty)) {
            i = super.pF().charAt(0);
        } else if (this.field_nickname != null && !this.field_nickname.equals(SQLiteDatabase.KeyEmpty) && isLetter(this.field_nickname.charAt(0))) {
            i = this.field_nickname.charAt(0);
        } else if (!(this.field_username == null || this.field_username.equals(SQLiteDatabase.KeyEmpty) || !isLetter(this.field_username.charAt(0)))) {
            i = this.field_username.charAt(0);
        }
        if (i >= 97 && i <= 122) {
            return (char) (i - 32);
        }
        if (i < 65 || i > 90) {
            return 123;
        }
        return i;
    }

    public final void tn() {
        setType(0);
    }

    public final void to() {
        setType(this.field_type | 4);
    }

    public final void tp() {
        setType(this.field_type | 1);
    }

    public final void tq() {
        v.w("MicroMsg.RContact", "unSetContact!! user:%s oldType:%d [%s]", this.field_username, Integer.valueOf(this.field_type), be.bur());
        setType(this.field_type & -2);
    }

    public final void tr() {
        setType(this.field_type | 8);
    }

    public final void ts() {
        setType(this.field_type & -9);
    }

    public final void tt() {
        setType(this.field_type | 2);
    }

    public final void tu() {
        setType(this.field_type & -3);
    }

    public final void tv() {
        setType(this.field_type & -2049);
    }

    public final void tw() {
        setType(this.field_type | 32);
    }

    public final void tx() {
        setType(this.field_type & -33);
    }

    public final void ty() {
        setType(this.field_type | 64);
    }

    public final void tz() {
        setType(this.field_type & -65);
    }

    public final void tA() {
        setType(this.field_type | 512);
    }

    public final void tB() {
        setType(this.field_type & -513);
    }

    public final void tC() {
        setType(this.field_type | FileUtils.S_IRUSR);
    }

    public final void tD() {
        setType(this.field_type & -257);
    }

    public static int tE() {
        return 1;
    }

    public static int tF() {
        return 8;
    }

    public static int tG() {
        return 16;
    }

    public static int tH() {
        return 32;
    }

    public final boolean tI() {
        return ei(this.field_type);
    }

    public static boolean ei(int i) {
        if ((i & 1) != 0) {
            return true;
        }
        return false;
    }

    public final boolean isHidden() {
        return (this.field_type & 32) != 0;
    }

    public final boolean tJ() {
        return (this.field_type & 4) != 0;
    }

    public final boolean tK() {
        return (this.field_type & 8) != 0;
    }

    public final boolean tL() {
        return (this.field_type & 64) != 0;
    }

    public final boolean tM() {
        return (this.field_type & 512) != 0;
    }

    public final boolean tN() {
        return (this.field_type & 1024) == 0;
    }

    public final boolean tO() {
        return (this.field_type & FileUtils.S_IRUSR) != 0;
    }

    public final boolean tP() {
        return (this.field_type & 2048) != 0;
    }

    public final boolean tQ() {
        return (WXMediaMessage.THUMB_LENGTH_LIMIT & this.field_type) != 0;
    }

    public final void tR() {
        setType(this.field_type | WXMediaMessage.THUMB_LENGTH_LIMIT);
    }

    private static boolean isLetter(char c) {
        return (c >= 'A' && c <= 'Z') || (c >= 'a' && c <= 'z');
    }

    public final int tS() {
        return (int) this.chr;
    }

    public final String pE() {
        return (super.pE() == null || super.pE().length() < 0) ? pF() : super.pE();
    }

    public final String pF() {
        return (super.pF() == null || super.pF().length() < 0) ? this.field_nickname : super.pF();
    }

    public final String pD() {
        String bu = chs != null ? chs.bu(this.field_username) : null;
        return bu == null ? super.pD() : bu;
    }

    public final String tT() {
        String bt = chs != null ? chs.bt(this.field_username) : null;
        if (bt != null) {
            return bt;
        }
        if (this.field_nickname == null || this.field_nickname.length() <= 0) {
            return tV();
        }
        return this.field_nickname;
    }

    public final String tU() {
        if (this.field_conRemark == null || this.field_conRemark.trim().equals(SQLiteDatabase.KeyEmpty)) {
            return tT();
        }
        return this.field_conRemark;
    }

    public final String tV() {
        String pD = pD();
        if (!be.kS(pD)) {
            return pD;
        }
        pD = dK(this.field_username);
        return (pD == null || pD.length() == 0) ? this.field_username : pD;
    }

    public static String dK(String str) {
        if (str == null) {
            return null;
        }
        if (str.toLowerCase().endsWith("@t.qq.com")) {
            return "@" + str.replace("@t.qq.com", SQLiteDatabase.KeyEmpty);
        }
        if (!str.toLowerCase().endsWith("@qqim")) {
            return str;
        }
        str = str.replace("@qqim", SQLiteDatabase.KeyEmpty);
        long longValue = Long.valueOf(str).longValue();
        if (longValue < 0) {
            return new o(longValue).toString();
        }
        return str;
    }

    public final void ej(int i) {
        cS((this.field_chatroomFlag & -2) | (i & 1));
    }

    public final void b(Cursor cursor) {
        super.b(cursor);
        this.chr = this.nmb;
        super.u(null);
    }

    private int tW() {
        int i = this.versionCode + 1;
        this.versionCode = i;
        return i;
    }

    public final void setUsername(String str) {
        if (!be.dC(this.field_username, str)) {
            super.setUsername(str);
            tW();
        }
    }

    public final void bP(String str) {
        if (!be.dC(pD(), str)) {
            super.bP(str);
            tW();
        }
    }

    public final void bQ(String str) {
        if (!be.dC(this.field_conRemark, str)) {
            super.bQ(str);
            tW();
        }
    }

    public final void bR(String str) {
        if (!be.dC(this.field_domainList, str)) {
            super.bR(str);
            tW();
        }
    }

    public final void bS(String str) {
        if (!be.dC(this.field_nickname, str)) {
            super.bS(str);
            tW();
        }
    }

    public final void bT(String str) {
        if (!be.dC(pE(), str)) {
            super.bT(str);
            tW();
        }
    }

    public final void bU(String str) {
        if (!be.dC(pF(), str)) {
            super.bU(str);
            tW();
        }
    }

    public final void cP(int i) {
        if (!be.cX(this.field_showHead, i)) {
            super.cP(i);
            tW();
        }
    }

    public final void setType(int i) {
        if (!be.cX(this.field_type, i)) {
            super.setType(i);
            tW();
        }
    }

    public final void cQ(int i) {
        if (!be.cX(this.field_weiboFlag, i)) {
            super.cQ(i);
            tW();
        }
    }

    public final void bV(String str) {
        if (!be.dC(this.field_weiboNickname, str)) {
            super.bV(str);
            tW();
        }
    }

    public final void bW(String str) {
        if (!be.dC(this.field_conRemarkPYFull, str)) {
            super.bW(str);
            tW();
        }
    }

    public final void bX(String str) {
        if (!be.dC(this.field_conRemarkPYShort, str)) {
            super.bX(str);
            tW();
        }
    }

    public final void u(byte[] bArr) {
        if (!be.isEqual(this.field_lvbuff, bArr)) {
            super.u(bArr);
            tW();
        }
    }

    public final void cR(int i) {
        if (!be.cX(this.field_verifyFlag, i)) {
            super.cR(i);
            tW();
        }
    }

    public final void bY(String str) {
        if (!be.dC(this.field_encryptUsername, str)) {
            super.bY(str);
            tW();
        }
    }

    public final void cS(int i) {
        if (!be.cX(this.field_chatroomFlag, i)) {
            super.cS(i);
            tW();
        }
    }

    public final void cT(int i) {
        if (!be.cX(this.field_deleteFlag, i)) {
            super.cT(i);
            tW();
        }
    }

    public final void bZ(String str) {
        if (!be.dC(this.field_contactLabelIds, str)) {
            super.bZ(str);
            tW();
        }
    }

    public final void cU(int i) {
        if (!be.cX(this.bBY, i)) {
            super.cU(i);
            tW();
        }
    }

    public final void cV(int i) {
        if (!be.cX(this.bBZ, i)) {
            super.cV(i);
            tW();
        }
    }

    public final void ca(String str) {
        if (!be.dC(this.bCa, str)) {
            super.ca(str);
            tW();
        }
    }

    public final void r(long j) {
        if (!be.s(this.bCb, j)) {
            super.r(j);
            tW();
        }
    }

    public final void cW(int i) {
        if (!be.cX(this.uin, i)) {
            super.cW(i);
            tW();
        }
    }

    public final void cb(String str) {
        if (!be.dC(this.bCc, str)) {
            super.cb(str);
            tW();
        }
    }

    public final void cc(String str) {
        if (!be.dC(this.bhT, str)) {
            super.cc(str);
            tW();
        }
    }

    public final void cX(int i) {
        if (!be.cX(this.bCd, i)) {
            super.cX(i);
            tW();
        }
    }

    public final void cY(int i) {
        if (!be.cX(this.bCe, i)) {
            super.cY(i);
            tW();
        }
    }

    public final void cd(String str) {
        if (!be.dC(this.bCf, str)) {
            super.cd(str);
            tW();
        }
    }

    public final void ce(String str) {
        if (!be.dC(this.bCg, str)) {
            super.ce(str);
            tW();
        }
    }

    public final void cZ(int i) {
        if (!be.cX(this.bCh, i)) {
            super.cZ(i);
            tW();
        }
    }

    public final void da(int i) {
        if (!be.cX(this.bCi, i)) {
            super.da(i);
            tW();
        }
    }

    public final void cf(String str) {
        if (!be.dC(this.bCj, str)) {
            super.cf(str);
            tW();
        }
    }

    public void cg(String str) {
        if (!be.dC(getProvince(), str)) {
            super.cg(str);
            tW();
        }
    }

    public void ch(String str) {
        if (!be.dC(getCity(), str)) {
            super.ch(str);
            tW();
        }
    }

    public final void ci(String str) {
        if (!be.dC(this.bCm, str)) {
            super.ci(str);
            tW();
        }
    }

    public final void db(int i) {
        if (!be.cX(this.bCn, i)) {
            super.db(i);
            tW();
        }
    }

    public final void setSource(int i) {
        if (!be.cX(this.bbT, i)) {
            super.setSource(i);
            tW();
        }
    }

    public final void cj(String str) {
        if (!be.dC(this.bCo, str)) {
            super.cj(str);
            tW();
        }
    }

    public final void ck(String str) {
        if (!be.dC(this.bCp, str)) {
            super.ck(str);
            tW();
        }
    }

    public void cl(String str) {
        if (!be.dC(this.bCq, str)) {
            super.cl(str);
            tW();
        }
    }

    public final void dc(int i) {
        if (!be.cX(this.bCr, i)) {
            super.dc(i);
            tW();
        }
    }

    public final void dd(int i) {
        if (!be.cX(this.bCs, i)) {
            super.dd(i);
            tW();
        }
    }

    public final void cm(String str) {
        if (!be.dC(this.bCt, str)) {
            super.cm(str);
            tW();
        }
    }

    public final void cn(String str) {
        if (!be.dC(this.bCu, str)) {
            super.cn(str);
            tW();
        }
    }

    public final void co(String str) {
        if (!be.dC(this.bCv, str)) {
            super.co(str);
            tW();
        }
    }

    public final void cp(String str) {
        if (!be.dC(this.bCw, str)) {
            super.cp(str);
            tW();
        }
    }

    public final void cq(String str) {
        if (!be.dC(this.bCx, str)) {
            super.cq(str);
            tW();
        }
    }

    public final void cr(String str) {
        if (!be.dC(this.bCy, str)) {
            super.cr(str);
            tW();
        }
    }

    public final void cs(String str) {
        if (!be.dC(this.bCz, str)) {
            super.cs(str);
            tW();
        }
    }
}
