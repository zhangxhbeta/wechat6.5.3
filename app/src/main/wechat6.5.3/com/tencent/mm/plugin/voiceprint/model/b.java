package com.tencent.mm.plugin.voiceprint.model;

import com.tencent.mm.model.ar.a;
import com.tencent.mm.protocal.l.c;
import com.tencent.mm.protocal.l.d;
import com.tencent.mm.v.i;

final class b extends i {
    a kok = new a();
    com.tencent.mm.model.ar.b kol = new com.tencent.mm.model.ar.b();

    b() {
    }

    public final int getType() {
        return 618;
    }

    public final String getUri() {
        return "/cgi-bin/micromsg-bin/getvoiceprintticketrsa";
    }

    public final d ze() {
        return this.kol;
    }

    protected final c zd() {
        return this.kok;
    }

    public final int Bu() {
        return 1;
    }
}
