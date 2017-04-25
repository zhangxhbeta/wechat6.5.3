package com.tencent.mm.ak;

import com.tencent.mm.ak.j.b;
import com.tencent.mm.protocal.c.arf;
import com.tencent.mm.protocal.c.ml;
import com.tencent.mm.sdk.platformtools.be;

@Deprecated
public final class d extends b {
    private ml cTv = new ml();

    public d(String str, long j) {
        super(8);
        this.cTv.moM = new arf().JF(be.ma(str));
        this.cTv.mcb = j;
        this.cTG = this.cTv;
    }
}
