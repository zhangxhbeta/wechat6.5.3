package com.tencent.mm.plugin.fingerprint;

import com.tencent.mm.bg.g;
import com.tencent.mm.model.ag;
import com.tencent.mm.model.ak;
import com.tencent.mm.plugin.fingerprint.a.b;
import com.tencent.mm.plugin.fingerprint.a.c;
import com.tencent.mm.plugin.fingerprint.a.d;
import com.tencent.mm.plugin.fingerprint.a.f;
import com.tencent.mm.plugin.fingerprint.a.h;
import com.tencent.mm.plugin.fingerprint.a.i;
import com.tencent.mm.plugin.fingerprint.a.m;
import com.tencent.mm.plugin.soter.c.k;
import com.tencent.mm.pluginsdk.j;
import com.tencent.mm.sdk.platformtools.v;
import java.util.HashMap;

public class a implements ag {
    private m fTo = new m();
    private h fTp = new h();
    private i fTq = new i();
    private b fTr = new b();
    private f fTs = new f();
    private c fTt;

    static {
        com.tencent.mm.wallet_core.a.b("FingerprintAuth", com.tencent.mm.plugin.fingerprint.ui.a.class);
    }

    public static a ank() {
        a aVar = (a) ak.yP().fY("plugin.fingerprint");
        if (aVar != null) {
            return aVar;
        }
        v.e("MicroMsg.SubCoreFingerPrint", "not found in MMCore, new one");
        aVar = new a();
        ak.yP().a("plugin.fingerprint", aVar);
        return aVar;
    }

    public final HashMap<Integer, g.c> ti() {
        return null;
    }

    public final void ed(int i) {
    }

    public final void aG(boolean z) {
        j.g jVar = k.gA(false) ? new com.tencent.mm.plugin.fingerprint.a.j() : new d();
        com.tencent.mm.pluginsdk.j.a.lxX = jVar;
        jVar.anv();
        com.tencent.mm.sdk.c.a.nhr.e(this.fTo);
        com.tencent.mm.sdk.c.a.nhr.e(this.fTp);
        com.tencent.mm.sdk.c.a.nhr.e(this.fTq);
        com.tencent.mm.sdk.c.a.nhr.e(this.fTr);
        com.tencent.mm.sdk.c.a.nhr.e(this.fTs);
        if (this.fTt != null) {
            c.abort();
            c.release();
            this.fTt = null;
        }
    }

    public final void aH(boolean z) {
    }

    public final void th() {
        com.tencent.mm.sdk.c.a.nhr.f(this.fTo);
        this.fTp.release();
        com.tencent.mm.sdk.c.a.nhr.f(this.fTp);
        com.tencent.mm.sdk.c.a.nhr.f(this.fTq);
        com.tencent.mm.sdk.c.a.nhr.f(this.fTr);
        com.tencent.mm.sdk.c.a.nhr.f(this.fTs);
        com.tencent.mm.pluginsdk.j.a.lxX = null;
    }

    public static c anl() {
        ak.yW();
        if (com.tencent.mm.model.c.ww() == 0) {
            throw new com.tencent.mm.model.b();
        }
        if (ank().fTt == null) {
            ank().fTt = new c();
        }
        return ank().fTt;
    }
}
