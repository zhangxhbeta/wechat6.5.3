package com.tencent.mm.ak;

import com.tencent.mm.a.e;
import com.tencent.mm.ak.j.b;
import com.tencent.mm.protocal.c.ajj;
import com.tencent.mm.protocal.c.arf;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mmdb.database.SQLiteDatabase;

@Deprecated
public final class n extends b {
    private ajj cTK = new ajj();

    public n(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, int i, String str9, String str10) {
        super(1);
        this.cTK.moM = new arf().JF(be.ma(str));
        this.cTK.mEj = new arf().JF(be.ma(str2));
        this.cTK.mar = 0;
        this.cTK.mJI = new arf().JF(be.ma(str3));
        this.cTK.mJJ = new arf().JF(be.ma(str4));
        this.cTK.eeO = 0;
        byte[] c = e.c(be.ma(str5), 0, -1);
        this.cTK.mJF = new com.tencent.mm.ba.b(c == null ? new byte[0] : c);
        this.cTK.mJE = c == null ? 0 : c.length;
        this.cTK.cHc = 0;
        this.cTK.cHg = 0;
        this.cTK.cHf = be.ma(str6);
        this.cTK.cHe = be.ma(str7);
        this.cTK.cHd = be.ma(str8);
        this.cTK.mau = i;
        this.cTK.mFw = be.ma(str9);
        this.cTK.mJO = 0;
        this.cTK.cHh = be.ma(str10);
        this.cTK.mFy = 0;
        this.cTK.mFx = SQLiteDatabase.KeyEmpty;
        this.cTG = this.cTK;
    }
}
