package com.tencent.mm.plugin.voiceprint.model;

import com.tencent.mm.model.ap.b;
import com.tencent.mm.protocal.l.c;
import com.tencent.mm.protocal.l.d;
import com.tencent.mm.v.i;

final class a extends i {
    com.tencent.mm.model.ap.a koi = new com.tencent.mm.model.ap.a();
    b koj = new b();

    a() {
    }

    public final int getType() {
        return 616;
    }

    public final String getUri() {
        return "/cgi-bin/micromsg-bin/getvoiceprintresourcersa";
    }

    public final d ze() {
        return this.koj;
    }

    protected final c zd() {
        return this.koi;
    }

    public final int Bu() {
        return 1;
    }
}
