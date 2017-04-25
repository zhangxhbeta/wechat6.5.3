package com.tencent.mm.ak;

import com.tencent.mm.ak.j.b;
import com.tencent.mm.protocal.c.aos;
import com.tencent.mm.protocal.c.arf;
import com.tencent.mm.sdk.platformtools.be;

@Deprecated
public final class p extends b {
    private aos cTM = new aos();

    public p(String str, String str2) {
        super(16);
        this.cTM.moM = new arf().JF(be.ma(str));
        this.cTM.mbC = new arf().JF(be.ma(str2));
        this.cTG = this.cTM;
    }
}
