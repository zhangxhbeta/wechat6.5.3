package com.tencent.mm.plugin.d;

import com.tencent.mm.compatible.d.l;
import com.tencent.mm.compatible.util.k;
import com.tencent.mm.kernel.a.d;
import com.tencent.mm.kernel.plugin.ProcessProfile;
import com.tencent.mm.plugin.sight.base.b;
import com.tencent.mm.sdk.platformtools.v;

public final class f extends d {
    public final void execute(ProcessProfile processProfile) {
        int rx = l.rx();
        if ((rx & 1024) != 0) {
            v.i("MicroMsg.SightInitTask", "load wechatsight_v7a, core number: %d", Integer.valueOf(rx >> 12));
            k.b("wechatsight_v7a", getClass().getClassLoader());
            if ((rx >> 12) >= 4) {
                b.iTs = 3;
                b.iTt = 3;
                b.iTu = 544000;
                return;
            }
            b.iTs = 1;
            b.iTt = 1;
            b.iTu = 640000;
            return;
        }
        v.i("MicroMsg.SightInitTask", "load wechatsight");
        k.b("wechatsight", getClass().getClassLoader());
        b.iTs = 1;
        b.iTt = 1;
        b.iTu = 640000;
    }

    public final String name() {
        return "boot-sight-init";
    }
}
