package com.tencent.mm.plugin.soter.c;

import com.tencent.mm.model.as.a;
import com.tencent.mm.model.as.b;
import com.tencent.mm.protocal.l.c;
import com.tencent.mm.v.i;

final class d extends i {
    a kdb = new a();
    b kdc = new b();

    d() {
    }

    public final int getType() {
        return 627;
    }

    public final String getUri() {
        return "/cgi-bin/micromsg-bin/updatesoteraskrsa";
    }

    public final com.tencent.mm.protocal.l.d ze() {
        return this.kdc;
    }

    protected final c zd() {
        return this.kdb;
    }

    public final int Bu() {
        return 1;
    }
}
