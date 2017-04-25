package com.tencent.mm.plugin.sns;

import com.tencent.mm.e.a.ob;
import com.tencent.mm.model.ak;
import com.tencent.mm.plugin.sns.e.r;
import com.tencent.mm.sdk.c.b;
import com.tencent.mm.sdk.c.c;
import com.tencent.mm.sdk.platformtools.v;

public final class i extends c<ob> {
    public i() {
        this.nhz = ob.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        if (((ob) bVar) instanceof ob) {
            v.d("MicroMsg.SnsSyncListener", "NetSceneSnsSync");
            ak.vy().a(new r(), 0);
            return true;
        }
        v.f("MicroMsg.SnsSyncListener", "mismatched event");
        return false;
    }
}
