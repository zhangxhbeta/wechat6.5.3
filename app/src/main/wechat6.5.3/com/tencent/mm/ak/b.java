package com.tencent.mm.ak;

import com.tencent.mm.protocal.c.arf;
import com.tencent.mm.protocal.c.mf;
import com.tencent.mm.sdk.platformtools.be;

@Deprecated
public final class b extends com.tencent.mm.ak.j.b {
    private mf cTt = new mf();

    public b(String str) {
        super(7);
        this.cTt.moM = new arf().JF(be.ma(str));
        this.cTG = this.cTt;
    }
}
