package com.tencent.mm.kernel.a;

import com.tencent.mm.compatible.util.k;
import com.tencent.mm.kernel.g;
import com.tencent.mm.kernel.plugin.ProcessProfile;
import com.tencent.mm.plugin.zero.b;
import com.tencent.mm.vending.h.d;

public abstract class a implements c {
    public void oh() {
        k.b("stlport_shared", b.class.getClassLoader());
    }

    public final void vE() {
        g.vs().uY();
    }

    public final void c(ProcessProfile processProfile) {
        g.vs().a(processProfile);
    }

    public void a(ProcessProfile processProfile, d dVar, com.tencent.mm.vending.g.d.b<Void> bVar) {
        processProfile.boot().a(dVar).a((com.tencent.mm.vending.g.d.b) bVar);
    }
}
