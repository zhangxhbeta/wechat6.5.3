package com.tencent.mm.plugin.voip_cs.b.a;

import com.tencent.mm.plugin.voip.video.h;
import com.tencent.mm.sdk.platformtools.aa;

public final class a {
    private static a kEk;
    public h kve = new h(aa.getContext());

    private a() {
    }

    public static a bei() {
        if (kEk == null) {
            kEk = new a();
        }
        return kEk;
    }

    public static a bej() {
        if (kEk == null) {
            kEk = bei();
        }
        return kEk;
    }

    public final void bek() {
        if (this.kve != null) {
            this.kve.j(2131165830, 0, true);
        }
    }

    public final void aCp() {
        if (this.kve != null) {
            this.kve.stop();
        }
    }

    public final boolean bcI() {
        if (this.kve != null) {
            return this.kve.bdP();
        }
        return true;
    }
}
