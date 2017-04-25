package com.tencent.mm.plugin.soter.c;

import com.tencent.mm.e.a.gt;
import com.tencent.mm.sdk.c.c;

public final class b extends c<gt> {
    public b() {
        this.nhz = gt.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(com.tencent.mm.sdk.c.b bVar) {
        gt gtVar = (gt) bVar;
        String str = gtVar.bgm.bgo;
        if (k.aYJ()) {
            if (k.aYM()) {
                h Cn = k.Cn(str);
                if (Cn != null) {
                    gtVar.bgn.bgp = Cn.kde;
                } else {
                    gtVar.bgn.bgp = null;
                }
            } else {
                gtVar.bgn.bgp = null;
            }
        }
        return false;
    }
}
