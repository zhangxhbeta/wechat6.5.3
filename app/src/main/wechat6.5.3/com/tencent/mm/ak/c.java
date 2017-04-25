package com.tencent.mm.ak;

import com.tencent.mm.ak.j.b;
import com.tencent.mm.protocal.c.arf;
import com.tencent.mm.protocal.c.mi;
import com.tencent.mm.sdk.platformtools.be;

@Deprecated
public final class c extends b {
    private mi cTu;

    public c(String str) {
        this(str, 0);
    }

    public c(String str, int i) {
        super(4);
        this.cTu = new mi();
        this.cTu.moM = new arf().JF(be.ma(str));
        this.cTu.moO = i;
        this.cTG = this.cTu;
    }
}
