package com.tencent.mm.plugin.voiceprint.model;

import com.tencent.mm.model.at.a;
import com.tencent.mm.model.at.b;
import com.tencent.mm.protocal.l.d;
import com.tencent.mm.v.i;

final class c extends i {
    a kom = new a();
    b kon = new b();

    c() {
    }

    public final int getType() {
        return 617;
    }

    public final String getUri() {
        return "/cgi-bin/micromsg-bin/verifyvoiceprintrsa";
    }

    public final d ze() {
        return this.kon;
    }

    protected final com.tencent.mm.protocal.l.c zd() {
        return this.kom;
    }

    public final int Bu() {
        return 1;
    }
}
