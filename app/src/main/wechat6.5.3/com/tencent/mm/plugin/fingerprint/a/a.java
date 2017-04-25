package com.tencent.mm.plugin.fingerprint.a;

import android.content.Context;
import com.tencent.mm.compatible.d.p;
import com.tencent.mm.e.a.bd;
import com.tencent.mm.e.a.jm;
import com.tencent.mm.e.a.jm.b;
import com.tencent.mm.model.ak;
import com.tencent.mm.plugin.wallet_core.b.l;
import com.tencent.mm.plugin.wallet_core.model.k;
import com.tencent.mm.pluginsdk.j.g;
import com.tencent.mm.sdk.platformtools.v;

public abstract class a implements g {
    public final void bI(Context context) {
        v.i("MicroMsg.BaseFingerprintImp", "showFingerPrintEntrance");
        if (k.bga().bgx() && !ann()) {
            v.e("MicroMsg.BaseFingerprintImp", "the fingerprint is open ready, but system has none Finger print ids!");
            bJ(context);
        } else if (k.bga().bgx() && !e.anJ()) {
            v.e("MicroMsg.BaseFingerprintImp", "the fingerprint is open ready, but local data is deleted!");
            bJ(context);
        } else if (p.ceE.ceP != 1) {
            v.e("MicroMsg.BaseFingerprintImp", "hy: device info not support");
        } else if (k.bga().bgx() || !(e.anM() || e.anN())) {
            v.e("MicroMsg.BaseFingerprintImp", "mgr == null or not support FP or has show guide or show HWManager!");
        }
    }

    private void bJ(Context context) {
        v.i("MicroMsg.BaseFingerprintImp", "closeFP");
        final bd bdVar = new bd();
        bdVar.bpT = new Runnable(this) {
            final /* synthetic */ a fTv;

            public final void run() {
                if (bdVar.aYI == null) {
                    return;
                }
                if (bdVar.aYI.aYJ == 0) {
                    v.i("MicroMsg.BaseFingerprintImp", "close finger print success!");
                    if (com.tencent.mm.model.k.xT()) {
                        v.i("MicroMsg.BaseFingerprintImp", "now context is isPayUPay!");
                        return;
                    }
                    v.i("MicroMsg.BaseFingerprintImp", "do bound query, update data");
                    ak.vy().a(new l(null, 1), 0);
                    return;
                }
                v.i("MicroMsg.BaseFingerprintImp", "close finger print failed!");
            }
        };
        com.tencent.mm.sdk.c.a.nhr.a(bdVar, context.getMainLooper());
    }

    public final boolean anm() {
        return e.anJ();
    }

    public final boolean ann() {
        com.tencent.mm.plugin.fingerprint.a.ank();
        com.tencent.mm.plugin.fingerprint.a.anl();
        return c.anr();
    }

    public boolean ano() {
        return false;
    }

    public final void a(jm jmVar, int i, String str) {
        v.i("MicroMsg.BaseFingerprintImp", "hy: onOpenFingerprintAuthFailed");
        if (jmVar != null && jmVar.bjR.bjU != null) {
            jmVar.bjS = new b();
            jmVar.bjS.errCode = i;
            jmVar.bjS.bfs = "";
            jmVar.bjS.bft = "";
            jmVar.bjS.biS = str;
            jmVar.bjR.bjU.run();
        }
    }
}
