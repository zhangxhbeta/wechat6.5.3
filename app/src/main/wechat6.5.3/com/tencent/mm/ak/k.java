package com.tencent.mm.ak;

import com.tencent.mm.ak.j.b;
import com.tencent.mm.protocal.c.aiq;
import com.tencent.mm.protocal.c.arf;
import com.tencent.mm.sdk.platformtools.be;

@Deprecated
public final class k extends b {
    private aiq cTH = new aiq();

    public k(String str, int i) {
        super(20);
        this.cTH.mbC = new arf().JF(be.ma(str));
        this.cTH.eeO = i;
        this.cTG = this.cTH;
    }
}
