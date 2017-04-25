package com.tencent.mm.plugin.soter.c;

import com.tencent.mm.e.a.bt;
import com.tencent.mm.sdk.c.b;
import com.tencent.mm.sdk.c.c;
import com.tencent.mm.sdk.platformtools.v;

public final class g extends c<bt> {
    private static String TAG = "MicroMsg.SoterDynamicConfigUpdatedEventListener";

    public g() {
        this.nhz = bt.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        v.i(TAG, "alvinluo dynamic config updated.");
        k.aYO();
        return true;
    }
}
