package com.tencent.mm.plugin.soter.d;

import com.tencent.mm.plugin.soter.c.k;
import com.tencent.mm.sdk.i.e;

public class d extends a {
    private String bgo = null;

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void aYP() {
        /*
        r3 = this;
        r0 = "MicroMsg.SoterProcessGenAuthKey";
        r1 = "hy: start gen auth key process";
        com.tencent.mm.sdk.platformtools.v.i(r0, r1);
        r0 = r3.kdr;
        r0 = (com.tencent.mm.pluginsdk.l.i) r0;
        r1 = r0.bgo;
        r3.bgo = r1;
        r1 = r3.bgo;
        r1 = com.tencent.mm.sdk.platformtools.be.kS(r1);
        if (r1 == 0) goto L_0x0022;
    L_0x0019:
        r1 = "MicroMsg.SoterProcessGenAuthKey";
        r2 = "hy: auth key name not specified";
        com.tencent.mm.sdk.platformtools.v.e(r1, r2);
    L_0x0022:
        r1 = com.tencent.mm.plugin.soter.c.k.aYJ();
        if (r1 == 0) goto L_0x005c;
    L_0x0028:
        r1 = com.tencent.mm.plugin.soter.c.k.aYM();
        if (r1 == 0) goto L_0x0045;
    L_0x002e:
        r1 = com.tencent.mm.pluginsdk.l.e.bol();
        r2 = r1.bgr;
        r2 = com.tencent.mm.sdk.platformtools.be.kS(r2);
        if (r2 != 0) goto L_0x0056;
    L_0x003a:
        r1 = r1.bgs;
        r1 = com.tencent.mm.sdk.platformtools.be.kS(r1);
        if (r1 != 0) goto L_0x0056;
    L_0x0042:
        r1 = 1;
    L_0x0043:
        if (r1 != 0) goto L_0x0058;
    L_0x0045:
        r0 = r0.lES;
        if (r0 == 0) goto L_0x0058;
    L_0x0049:
        r0 = com.tencent.mm.sdk.platformtools.aa.getContext();
        r1 = new com.tencent.mm.plugin.soter.d.d$1;
        r1.<init>(r3);
        com.tencent.mm.pluginsdk.l.f.a(r0, r1);
    L_0x0055:
        return;
    L_0x0056:
        r1 = 0;
        goto L_0x0043;
    L_0x0058:
        r3.aYS();
        goto L_0x0055;
    L_0x005c:
        r0 = "MicroMsg.SoterProcessGenAuthKey";
        r1 = "hy: not support";
        com.tencent.mm.sdk.platformtools.v.w(r0, r1);
        r0 = 3;
        r3.rl(r0);
        goto L_0x0055;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.soter.d.d.aYP():void");
    }

    private void aYS() {
        e.a(new Runnable(this) {
            final /* synthetic */ d kdC;

            {
                this.kdC = r1;
            }

            public final void run() {
                this.kdC.rl(k.Ck(this.kdC.bgo));
            }
        }, d.class.getName());
    }
}
