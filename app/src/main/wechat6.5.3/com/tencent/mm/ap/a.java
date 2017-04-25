package com.tencent.mm.ap;

import com.tencent.mm.model.aq.b;
import com.tencent.mm.protocal.l.c;
import com.tencent.mm.protocal.l.d;
import com.tencent.mm.v.i;

final class a extends i {
    com.tencent.mm.model.aq.a cZS = new com.tencent.mm.model.aq.a();
    b cZT = new b();

    a() {
    }

    public final int getType() {
        return 261;
    }

    public final String getUri() {
        return "/cgi-bin/micromsg-bin/getsoterfingerprintticketrsa";
    }

    public final d ze() {
        return this.cZT;
    }

    protected final c zd() {
        return this.cZS;
    }

    public final int Bu() {
        return 1;
    }
}
