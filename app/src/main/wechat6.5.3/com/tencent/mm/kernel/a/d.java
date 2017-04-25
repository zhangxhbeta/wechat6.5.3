package com.tencent.mm.kernel.a;

import com.tencent.mm.kernel.g;

public abstract class d implements e {
    public <T extends d> T after(e eVar) {
        g.vx();
        g.vt().uZ().boot().a((e) this, eVar);
        return this;
    }

    public <T extends d> T before(e eVar) {
        g.vx();
        g.vt().uZ().boot().a(eVar, (e) this);
        return this;
    }

    public void alias(Class<? extends e> cls) {
    }

    public String toString() {
        return name();
    }
}
