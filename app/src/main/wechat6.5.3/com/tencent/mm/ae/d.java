package com.tencent.mm.ae;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mmdb.database.SQLiteDatabase;

public final class d {
    int bNt = 0;
    int bbT;
    public int bkU = -2;
    public long bmL;
    private String cLA = SQLiteDatabase.KeyEmpty;
    int cLB;
    public long cLC;
    int cLD;
    public int cLE = 0;
    public String cLF = SQLiteDatabase.KeyEmpty;
    int cLG = 1;
    private boolean cLH;
    private boolean cLI;
    private boolean cLJ;
    private boolean cLK;
    private boolean cLL;
    private boolean cLM;
    private boolean cLN;
    private boolean cLO;
    private boolean cLP;
    private boolean cLQ;
    private boolean cLR;
    private boolean cLS;
    boolean cLT;
    private boolean cLU;
    boolean cLV;
    private boolean cLW;
    private boolean cLX;
    private boolean cLY;
    private boolean cLZ;
    public long cLu;
    public String cLv = SQLiteDatabase.KeyEmpty;
    String cLw = SQLiteDatabase.KeyEmpty;
    public String cLx = SQLiteDatabase.KeyEmpty;
    int cLy;
    int cLz;
    public int cyu;
    public int offset;
    public int status;

    public final void iP(String str) {
        this.cLA = str;
        this.cLX = true;
    }

    public final void dh(int i) {
        this.status = i;
        this.cLQ = true;
    }

    public final void fv(int i) {
        this.cLD = i;
        this.cLR = true;
    }

    public final void fw(int i) {
        this.cLB = i;
        this.cLO = true;
    }

    public final long Gl() {
        return this.cLC;
    }

    public final void af(long j) {
        this.cLC = j;
        this.cLP = true;
    }

    public final long Gm() {
        return this.cLu;
    }

    public final void ag(long j) {
        this.cLu = j;
        this.cLH = true;
    }

    public final long pK() {
        return this.bmL;
    }

    public final void y(long j) {
        if (this.bmL != j) {
            this.cLI = true;
        }
        this.bmL = j;
    }

    public final void setOffset(int i) {
        int i2 = 0;
        if (this.offset != i) {
            this.cLJ = true;
        }
        this.offset = i;
        v.e("MicroMsg.Imgfo", "set offset : %d  id:%d total:%d", Integer.valueOf(i), Long.valueOf(this.cLC), Integer.valueOf(this.cyu));
        if (i >= this.cyu) {
            i2 = 1;
        }
        fA(i2);
    }

    public final void fx(int i) {
        this.cyu = i;
        this.cLK = true;
    }

    public final String Gn() {
        return this.cLv;
    }

    public final void iQ(String str) {
        this.cLv = str;
        this.cLL = true;
    }

    public final void iR(String str) {
        this.cLw = str;
        this.cLM = true;
    }

    public final void iS(String str) {
        this.cLx = str;
        this.cLN = true;
    }

    public final void fy(int i) {
        this.cLE = i;
        this.cLS = true;
    }

    public final void fz(int i) {
        this.cLz = i;
        this.cLZ = true;
    }

    public final boolean Go() {
        return this.cyu != 0 && this.cyu == this.offset;
    }

    public final boolean Gp() {
        return this.cLE > 0;
    }

    public final void iT(String str) {
        if ((this.cLF == null && str != null) || !(this.cLF == null || this.cLF.equals(str))) {
            this.cLU = true;
        }
        this.cLF = str;
    }

    public final void b(Cursor cursor) {
        this.cLu = (long) cursor.getInt(0);
        this.bmL = cursor.getLong(1);
        this.offset = cursor.getInt(2);
        this.cyu = cursor.getInt(3);
        this.cLv = cursor.getString(4);
        this.cLx = cursor.getString(5);
        this.cLB = cursor.getInt(6);
        this.cLC = (long) cursor.getInt(7);
        this.status = cursor.getInt(8);
        this.cLD = cursor.getInt(9);
        this.cLE = cursor.getInt(10);
        this.bbT = cursor.getInt(11);
        this.cLF = cursor.getString(12);
        this.bNt = cursor.getInt(14);
        this.cLG = cursor.getInt(15);
        this.cLA = cursor.getString(16);
        this.cLy = cursor.getInt(17);
        this.cLw = cursor.getString(18);
        this.cLz = cursor.getInt(19);
    }

    public final void fA(int i) {
        if (this.cLG != i) {
            this.cLW = true;
        }
        this.cLG = i;
    }

    public final void fB(int i) {
        this.cLy = i;
        this.cLY = true;
    }

    public final ContentValues py() {
        ContentValues contentValues = new ContentValues();
        if (this.cLH) {
            contentValues.put("id", Long.valueOf(this.cLu));
        }
        if (this.cLI) {
            contentValues.put("msgSvrId", Long.valueOf(this.bmL));
        }
        if (this.cLJ) {
            contentValues.put("offset", Integer.valueOf(this.offset));
        }
        if (this.cLK) {
            contentValues.put("totalLen", Integer.valueOf(this.cyu));
        }
        if (this.cLL) {
            contentValues.put("bigImgPath", this.cLv);
        }
        if (this.cLM) {
            contentValues.put("midImgPath", this.cLw);
        }
        if (this.cLN) {
            contentValues.put("thumbImgPath", this.cLx);
        }
        if (this.cLO) {
            contentValues.put("createtime", Integer.valueOf(this.cLB));
        }
        if (this.cLP) {
            contentValues.put("msglocalid", Long.valueOf(this.cLC));
        }
        if (this.cLQ) {
            contentValues.put("status", Integer.valueOf(this.status));
        }
        if (this.cLR) {
            contentValues.put("nettimes", Integer.valueOf(this.cLD));
        }
        if (this.cLS) {
            contentValues.put("reserved1", Integer.valueOf(this.cLE));
        }
        if (this.cLT) {
            contentValues.put("reserved2", Integer.valueOf(this.bbT));
        }
        if (this.cLU) {
            contentValues.put("reserved3", this.cLF);
        }
        if (this.cLV) {
            contentValues.put("hashdthumb", Integer.valueOf(this.bNt));
        }
        if (this.cLW) {
            contentValues.put("iscomplete", Integer.valueOf(this.offset < this.cyu ? 0 : 1));
        }
        if (this.cLX) {
            contentValues.put("origImgMD5", this.cLA);
        }
        if (this.cLY) {
            contentValues.put("compressType", Integer.valueOf(this.cLy));
        }
        if (this.cLZ) {
            contentValues.put("forwardType", Integer.valueOf(this.cLz));
        }
        return contentValues;
    }

    public final void Gq() {
        this.cLH = false;
        this.cLI = false;
        this.cLJ = false;
        this.cLK = false;
        this.cLL = false;
        this.cLM = false;
        this.cLN = false;
        this.cLO = false;
        this.cLP = false;
        this.cLQ = false;
        this.cLR = false;
        this.cLS = false;
        this.cLT = false;
        this.cLU = false;
        this.cLV = false;
        this.cLW = false;
        this.cLX = false;
        this.cLY = false;
        this.cLZ = false;
    }
}
