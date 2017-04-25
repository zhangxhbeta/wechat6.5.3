package com.tencent.mm.plugin.soter.c;

import com.tencent.mm.e.a.gu;
import com.tencent.mm.sdk.c.b;
import com.tencent.mm.sdk.c.c;
import com.tencent.mm.sdk.platformtools.v;

public final class a extends c<gu> {
    public a() {
        this.nhz = gu.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        gu guVar = (gu) bVar;
        if (guVar instanceof gu) {
            h aYN = k.aYN();
            if (aYN != null) {
                guVar.bgq.bgr = aYN.bgr;
                guVar.bgq.bgs = Integer.toString(aYN.uid);
            } else {
                v.w("MicroMsg.GetDeviceInfoListener", "hy: no cpu id and uid got");
            }
        }
        return false;
    }
}
