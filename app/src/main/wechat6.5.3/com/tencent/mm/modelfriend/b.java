package com.tencent.mm.modelfriend;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.modelmsg.WXMediaMessage;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.s;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mmdb.FileUtils;
import com.tencent.mmdb.database.SQLiteDatabase;

public final class b {
    String aGX = SQLiteDatabase.KeyEmpty;
    private String aZy = SQLiteDatabase.KeyEmpty;
    String bCc = SQLiteDatabase.KeyEmpty;
    public int bkU = -1;
    String cGQ = SQLiteDatabase.KeyEmpty;
    long cGR = 0;
    String cGS = SQLiteDatabase.KeyEmpty;
    String cGT = SQLiteDatabase.KeyEmpty;
    String cGU = SQLiteDatabase.KeyEmpty;
    String cGV = SQLiteDatabase.KeyEmpty;
    String cGW = SQLiteDatabase.KeyEmpty;
    String cGX = SQLiteDatabase.KeyEmpty;
    private int cGY = 0;
    public byte[] cGZ;
    public int cHa;
    public String cHb = SQLiteDatabase.KeyEmpty;
    public int cHc = 0;
    public String cHd = SQLiteDatabase.KeyEmpty;
    public String cHe = SQLiteDatabase.KeyEmpty;
    public String cHf = SQLiteDatabase.KeyEmpty;
    int cHg = 0;
    public String cHh = SQLiteDatabase.KeyEmpty;
    int cHi = 0;
    int cHj = 0;
    String cHk = SQLiteDatabase.KeyEmpty;
    public String cHl = SQLiteDatabase.KeyEmpty;
    String cHm = SQLiteDatabase.KeyEmpty;
    int cHn = -1;
    String cHo = SQLiteDatabase.KeyEmpty;
    long cHp = -1;
    int cHq = -1;
    String cHr = SQLiteDatabase.KeyEmpty;
    String cHs = SQLiteDatabase.KeyEmpty;
    String cHt = SQLiteDatabase.KeyEmpty;
    long cHu = 0;
    public int cyA = 0;
    public String cyx = SQLiteDatabase.KeyEmpty;
    private int id = 0;
    public int status = 0;
    public int type = 0;
    public String username = SQLiteDatabase.KeyEmpty;

    public final void b(Cursor cursor) {
        iz(cursor.getString(1));
        this.cGQ = cursor.getString(2);
        this.cGR = cursor.getLong(3);
        this.cGS = cursor.getString(4);
        this.cGT = cursor.getString(5);
        this.cGU = cursor.getString(6);
        this.username = cursor.getString(7);
        this.aGX = cursor.getString(8);
        this.cGV = cursor.getString(9);
        this.cGW = cursor.getString(10);
        this.type = cursor.getInt(11);
        this.cGX = cursor.getString(12);
        this.bCc = cursor.getString(13);
        int i = cursor.getInt(14);
        if (i == 65536) {
            this.status = 0;
        } else {
            this.status = i;
        }
        this.cGY = cursor.getInt(17);
        this.cyx = cursor.getString(15);
        this.cyA = cursor.getInt(18);
        this.cGZ = cursor.getBlob(19);
        if (!be.bl(this.cGZ)) {
            byte[] bArr = this.cGZ;
            try {
                s sVar = new s();
                i = sVar.bg(bArr);
                if (i != 0) {
                    v.e("MicroMsg.AddrUpload", "parse LVBuffer error:" + i);
                } else {
                    this.cHb = sVar.getString();
                    this.cHc = sVar.getInt();
                    this.cHd = sVar.getString();
                    this.cHe = sVar.getString();
                    this.cHf = sVar.getString();
                    this.cHg = sVar.getInt();
                    this.cHh = sVar.getString();
                    this.cHi = sVar.getInt();
                    this.cHj = sVar.getInt();
                    this.cHk = sVar.getString();
                    this.cHl = sVar.getString();
                    this.cHm = sVar.getString();
                    this.cHn = sVar.getInt();
                    this.cHo = sVar.getString();
                    this.cHp = sVar.getLong();
                    this.cHq = sVar.getInt();
                    this.cHr = sVar.getString();
                    this.cHs = sVar.getString();
                    this.cHt = sVar.getString();
                    this.cHu = sVar.getLong();
                }
            } catch (Throwable e) {
                v.a("MicroMsg.AddrUpload", e, SQLiteDatabase.KeyEmpty, new Object[0]);
            }
        }
        this.cHa = cursor.getInt(20);
    }

    public final ContentValues py() {
        ContentValues contentValues = new ContentValues();
        if ((this.bkU & 1) != 0) {
            contentValues.put("id", Integer.valueOf(this.id));
        }
        if ((this.bkU & 2) != 0) {
            contentValues.put("md5", EB());
        }
        if ((this.bkU & 4) != 0) {
            contentValues.put("peopleid", EC());
        }
        if ((this.bkU & 8) != 0) {
            contentValues.put("uploadtime", Long.valueOf(this.cGR));
        }
        if ((this.bkU & 16) != 0) {
            contentValues.put("realname", ED());
        }
        if ((this.bkU & 32) != 0) {
            contentValues.put("realnamepyinitial", EE());
        }
        if ((this.bkU & 64) != 0) {
            contentValues.put("realnamequanpin", EF());
        }
        if ((this.bkU & FileUtils.S_IWUSR) != 0) {
            contentValues.put("username", getUsername());
        }
        if ((this.bkU & FileUtils.S_IRUSR) != 0) {
            contentValues.put("nickname", EG());
        }
        if ((this.bkU & 512) != 0) {
            contentValues.put("nicknamepyinitial", EH());
        }
        if ((this.bkU & 1024) != 0) {
            contentValues.put("nicknamequanpin", EI());
        }
        if ((this.bkU & 2048) != 0) {
            contentValues.put("type", Integer.valueOf(this.type));
        }
        if ((this.bkU & 4096) != 0) {
            contentValues.put("moblie", EJ());
        }
        if ((this.bkU & 8192) != 0) {
            contentValues.put("email", EK());
        }
        if ((this.bkU & 16384) != 0) {
            int i = this.status;
            if (i == 0) {
                contentValues.put("status", Integer.valueOf(65536));
            } else {
                contentValues.put("status", Integer.valueOf(i));
            }
        }
        if ((this.bkU & WXMediaMessage.THUMB_LENGTH_LIMIT) != 0) {
            contentValues.put("reserved1", this.cyx);
        }
        if ((this.bkU & 131072) != 0) {
            contentValues.put("reserved3", Integer.valueOf(this.cGY));
        }
        if ((this.bkU & 262144) != 0) {
            contentValues.put("reserved4", Integer.valueOf(this.cyA));
        }
        if ((this.bkU & 524288) != 0) {
            this.cGZ = EA();
            contentValues.put("lvbuf", this.cGZ);
        }
        if ((this.bkU & 1048576) != 0) {
            contentValues.put("showhead", Integer.valueOf(this.cHa));
        }
        return contentValues;
    }

    private byte[] EA() {
        try {
            s sVar = new s();
            sVar.bsS();
            sVar.Kc(this.cHb);
            sVar.uY(this.cHc);
            sVar.Kc(this.cHd);
            sVar.Kc(this.cHe);
            sVar.Kc(this.cHf);
            sVar.uY(this.cHg);
            sVar.Kc(this.cHh);
            sVar.uY(this.cHi);
            sVar.uY(this.cHj);
            sVar.Kc(this.cHk);
            sVar.Kc(this.cHl);
            sVar.Kc(this.cHm);
            sVar.uY(this.cHn);
            sVar.Kc(this.cHo);
            sVar.dY(this.cHp);
            sVar.uY(this.cHq);
            sVar.Kc(this.cHr);
            sVar.Kc(this.cHs);
            sVar.Kc(this.cHt);
            sVar.dY(this.cHu);
            return sVar.bsT();
        } catch (Throwable e) {
            v.a("MicroMsg.AddrUpload", e, SQLiteDatabase.KeyEmpty, new Object[0]);
            return null;
        }
    }

    public static int iy(String str) {
        long j = 0;
        try {
            j = Long.parseLong(str.substring(0, 8), 16);
        } catch (Throwable e) {
            v.a("MicroMsg.AddrUpload", e, "md5: %s", str);
        }
        return (int) j;
    }

    public final void iz(String str) {
        this.aZy = str;
        this.id = iy(str);
    }

    public final String EB() {
        return this.aZy == null ? SQLiteDatabase.KeyEmpty : this.aZy;
    }

    public final String EC() {
        return this.cGQ == null ? SQLiteDatabase.KeyEmpty : this.cGQ;
    }

    public final String ED() {
        return this.cGS == null ? SQLiteDatabase.KeyEmpty : this.cGS;
    }

    public final String EE() {
        return this.cGT == null ? SQLiteDatabase.KeyEmpty : this.cGT;
    }

    public final String EF() {
        return this.cGU == null ? SQLiteDatabase.KeyEmpty : this.cGU;
    }

    public final String getUsername() {
        return this.username == null ? SQLiteDatabase.KeyEmpty : this.username;
    }

    public final String EG() {
        return this.aGX == null ? SQLiteDatabase.KeyEmpty : this.aGX;
    }

    public final String EH() {
        return this.cGV == null ? SQLiteDatabase.KeyEmpty : this.cGV;
    }

    public final String EI() {
        return this.cGW == null ? SQLiteDatabase.KeyEmpty : this.cGW;
    }

    public final String EJ() {
        return this.cGX == null ? SQLiteDatabase.KeyEmpty : this.cGX;
    }

    public final String EK() {
        return this.bCc == null ? SQLiteDatabase.KeyEmpty : this.bCc;
    }

    public final void EL() {
        this.cGY &= -2;
    }

    public final void EM() {
        this.cGY |= 1;
    }

    public final boolean EN() {
        return (this.cGY & 1) == 0;
    }

    public final int tm() {
        int i = 32;
        if (!be.kS(EE())) {
            i = EE().charAt(0);
        } else if (!be.kS(EF())) {
            i = EF().charAt(0);
        }
        if (i >= 97 && i <= 122) {
            return (char) (i - 32);
        }
        if (i < 65 || i > 90) {
            return 123;
        }
        return i;
    }
}
