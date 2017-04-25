package com.tencent.mm.plugin.soter;

import com.tencent.mm.model.ag;
import com.tencent.mm.plugin.soter.c.a;
import com.tencent.mm.plugin.soter.c.c;
import com.tencent.mm.plugin.soter.c.g;
import com.tencent.mm.plugin.soter.c.j;
import com.tencent.mm.plugin.soter.c.k;
import com.tencent.mm.plugin.soter.d.d;
import com.tencent.mm.plugin.soter.d.e;
import com.tencent.mm.sdk.platformtools.v;
import java.util.HashMap;

public final class b implements ag {
    private static j kcu = new j();
    private static com.tencent.mm.plugin.soter.c.b kcv = new com.tencent.mm.plugin.soter.c.b();
    private static a kcw = new a();
    private static c kcx = new c();
    private static g kcy = new g();
    private static final HashMap<String, com.tencent.mm.plugin.soter.d.a> kcz = new HashMap();

    public static void aYy() {
        v.i("MicroMsg.SubCoreSoter", "SubCoreSoter init");
        c(kcu);
        c(kcv);
        c(kcw);
        c(kcx);
        c(kcy);
        kcz.put("process_gen_ask", new com.tencent.mm.plugin.soter.d.c());
        kcz.put("process_gen_auth_key", new d());
        kcz.put("process_upload_ask_key", new e());
        kcz.put("process_authenticate", new com.tencent.mm.plugin.soter.d.b());
    }

    private static void c(com.tencent.mm.sdk.c.c cVar) {
        if (cVar == null) {
            v.w("MicroMsg.SubCoreSoter", "hy: listener is null or id is invalid");
        } else if (com.tencent.mm.sdk.c.a.nhr.g(cVar)) {
            v.w("MicroMsg.SubCoreSoter", "hy: already has listener");
        } else {
            com.tencent.mm.sdk.c.a.nhr.e(cVar);
        }
    }

    public static HashMap<String, com.tencent.mm.plugin.soter.d.a> aYz() {
        return kcz;
    }

    public final HashMap<Integer, com.tencent.mm.bg.g.c> ti() {
        v.i("MicroMsg.SubCoreSoter", "hy: on SubCoreSoter getBaseDBFactories");
        return null;
    }

    public final void ed(int i) {
        v.i("MicroMsg.SubCoreSoter", "hy: on SubCoreSoter clearPluginData");
    }

    public final void aG(boolean z) {
        v.i("MicroMsg.SubCoreSoter", "hy: on SubCoreSoter onAccountPostReset");
        k.aYO();
    }

    public final void aH(boolean z) {
        v.i("MicroMsg.SubCoreSoter", "hy: on SubCoreSoter onSdcardMount");
    }

    public final void th() {
        v.i("MicroMsg.SubCoreSoter", "hy: on SubCoreSoter onAccountRelease");
    }
}
