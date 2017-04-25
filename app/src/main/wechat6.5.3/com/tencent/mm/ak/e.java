package com.tencent.mm.ak;

import com.tencent.mm.ak.j.b;
import com.tencent.mm.protocal.c.arf;
import com.tencent.mm.protocal.c.mr;
import com.tencent.mm.sdk.platformtools.be;

@Deprecated
public final class e extends b {
    private mr cTw = new mr();

    public e(String str, long j) {
        super(9);
        this.cTw.moM = new arf().JF(be.ma(str));
        this.cTw.moT.add(Integer.valueOf((int) j));
        this.cTw.eet = 1;
        this.cTG = this.cTw;
    }
}
