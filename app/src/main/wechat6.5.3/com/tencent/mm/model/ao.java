package com.tencent.mm.model;

import com.tencent.mm.protocal.l.c;
import com.tencent.mm.protocal.l.d;
import com.tencent.mm.protocal.z.a;
import com.tencent.mm.protocal.z.b;
import com.tencent.mm.v.i;

public final class ao extends i {
    private final a csS = new a();
    private final b csT = new b();

    protected final c zd() {
        return this.csS;
    }

    public final d ze() {
        return this.csT;
    }

    public final int getType() {
        return 126;
    }

    public final String getUri() {
        return "/cgi-bin/micromsg-bin/newreg";
    }
}
