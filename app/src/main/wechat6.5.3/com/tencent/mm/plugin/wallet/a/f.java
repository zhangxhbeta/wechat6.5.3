package com.tencent.mm.plugin.wallet.a;

import com.tencent.mm.e.a.gg;
import com.tencent.mm.plugin.wallet_core.model.k;
import com.tencent.mm.sdk.c.b;
import com.tencent.mm.sdk.c.c;
import com.tencent.mm.sdk.platformtools.be;

public final class f extends c<gg> {
    public f() {
        this.nhz = gg.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        int i = 0;
        gg ggVar = (gg) bVar;
        if (!(ggVar instanceof gg)) {
            return false;
        }
        ggVar.bfK.bfM = k.bga().bgy();
        String bgB = k.bga().bgB();
        if (be.kS(bgB)) {
            ggVar.bfK.bfL = "";
        } else {
            String str = "";
            while (i < bgB.length() - 1) {
                str = str + "*";
                i++;
            }
            ggVar.bfK.bfL = str + bgB.substring(bgB.length() - 1, bgB.length());
        }
        return true;
    }
}
