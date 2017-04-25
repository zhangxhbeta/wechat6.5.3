package com.tencent.mm.plugin.soter.d;

import com.tencent.mm.model.ak;
import com.tencent.mm.plugin.soter.c.f;
import com.tencent.mm.plugin.soter.c.h;
import com.tencent.mm.plugin.soter.c.k;
import com.tencent.mm.pluginsdk.l.j;
import com.tencent.mm.sdk.platformtools.v;

public final class e extends a implements com.tencent.mm.v.e {
    private com.tencent.mm.v.e cii;
    private int type;

    public final void aYP() {
        v.i("MicroMsg.SoterProcessUploadASK", "start upload ask process");
        if (k.aYJ()) {
            try {
                j jVar = (j) this.kdr;
                this.cii = jVar.cii;
                boolean z = jVar.lET;
                h aYN = k.aYN();
                if (aYN != null) {
                    com.tencent.mm.v.k eVar;
                    String str = aYN.bCj;
                    String str2 = aYN.kdf;
                    if (z) {
                        v.i("MicroMsg.SoterProcessUploadASK", "netscene upload ask");
                        eVar = new com.tencent.mm.plugin.soter.c.e(str, str2);
                        this.type = 619;
                        ak.vy().a(this.type, this.cii);
                    } else {
                        v.i("MicroMsg.SoterProcessUploadASK", "netscene upload ask rsa");
                        eVar = new f(str, str2);
                        this.type = 627;
                        ak.vy().a(this.type, this.cii);
                    }
                    ak.vy().a(eVar, 0);
                    rl(0);
                    return;
                }
                rl(4);
                return;
            } catch (Exception e) {
                v.a("MicroMsg.SoterProcessUploadASK", null, "upload ask exception: %s", new Object[]{e.getMessage()});
                rl(-1);
                return;
            }
        }
        v.w("MicroMsg.SoterProcessUploadASK", "not support");
        rl(3);
    }

    public final void a(int i, int i2, String str, com.tencent.mm.v.k kVar) {
        if (this.cii != null) {
            this.cii.a(i, i2, str, kVar);
        }
        ak.vy().b(this.type, this.cii);
    }
}
