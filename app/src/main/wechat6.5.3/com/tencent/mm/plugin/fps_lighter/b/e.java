package com.tencent.mm.plugin.fps_lighter.b;

import android.os.Build.VERSION;
import android.os.HandlerThread;
import com.tencent.mm.bg.g;
import com.tencent.mm.e.a.et;
import com.tencent.mm.model.ag;
import com.tencent.mm.model.ak;
import com.tencent.mm.sdk.c.b;
import com.tencent.mm.sdk.c.c;
import com.tencent.mm.sdk.platformtools.v;
import java.util.HashMap;

public final class e implements ag {
    private static HandlerThread fVB = new HandlerThread("analyse_thread");
    d fVD;
    c<et> fVE = new c<et>(this) {
        final /* synthetic */ e fVF;

        {
            this.fVF = r2;
            this.nhz = et.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(b bVar) {
            et etVar = (et) bVar;
            if (etVar.bdx.aYt == 1) {
                e eVar = this.fVF;
                int i = etVar.bdx.bdy;
                if (eVar.fVz != null) {
                    c.kP(i);
                }
            }
            return true;
        }
    };
    c fVz = null;

    public final HashMap<Integer, g.c> ti() {
        return null;
    }

    public final void ed(int i) {
    }

    public static e aof() {
        e eVar = (e) ak.yP().fY("plugin.fps_lighter");
        if (eVar != null) {
            return eVar;
        }
        v.e("MicroMsg.SubCoreFPSLighter", "not found in MMCore, new one");
        eVar = new e();
        ak.yP().a("plugin.fps_lighter", eVar);
        return eVar;
    }

    public final void aG(boolean z) {
        int i = VERSION.SDK_INT;
        this.fVE.bsL();
    }

    public final void aH(boolean z) {
    }

    public final void th() {
        v.d("MicroMsg.SubCoreFPSLighter", "[onAccountRelease]");
    }
}
