package com.tencent.mm.plugin.aa.a.c;

import com.tencent.mm.model.ak;
import com.tencent.mm.plugin.aa.a.e;
import com.tencent.mm.plugin.aa.a.k;
import com.tencent.mm.plugin.aa.a.l;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.vending.app.a;

public final class d extends a {
    l dtg = new l();
    e dth = new e();

    protected final void onCreate() {
        super.onCreate();
        v.i("MicroMsg.LaunchAAInteractor", "LaunchAAInteractor, onCreate");
        k NA = this.dtg.NA();
        ak.vy().a(1624, NA);
        ak.vy().a(1655, NA);
        com.tencent.mm.plugin.aa.a.d Nw = this.dth.Nw();
        v.i("MicroMsg.AAOperationData", "init");
        ak.vy().a(1698, Nw);
    }

    protected final void onDestroy() {
        super.onDestroy();
        v.i("MicroMsg.LaunchAAInteractor", "LaunchAAInteractor, onDestroy");
        k NA = this.dtg.NA();
        ak.vy().b(1624, NA);
        ak.vy().b(1655, NA);
        com.tencent.mm.plugin.aa.a.d Nw = this.dth.Nw();
        v.i("MicroMsg.AAOperationData", "uninit");
        ak.vy().b(1698, Nw);
    }
}
